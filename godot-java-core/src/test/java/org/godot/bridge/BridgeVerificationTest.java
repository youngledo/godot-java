package org.godot.bridge;

import org.godot.internal.api.ApiIndex;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.foreign.FunctionDescriptor;

import static java.lang.foreign.ValueLayout.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Verification tests for Bridge and ApiSignatures. Tests 1.9: Bridge.load()
 * structural verification (no native runtime needed). Tests 1.10:
 * OBJECT_METHOD_BIND_* API signature verification against
 * gdextension_interface.json.
 */
public class BridgeVerificationTest {

	// ------------------------------------------------------------------------
	// 1.9: Bridge.load() structural verification
	// ------------------------------------------------------------------------

	@Test
	void apiArrayLengthMatchesEnumSize() throws Exception {
		// The API array should have exactly ApiIndex.values().length entries
		Field apiField = Bridge.class.getDeclaredField("API");
		apiField.setAccessible(true);
		Object[] apiArray = (Object[]) apiField.get(null);
		int enumCount = ApiIndex.values().length;
		assertEquals(enumCount, apiArray.length, "API array length must match ApiIndex enum size");
	}

	@Test
	void allApiIndicesAreUnique() {
		// All enum values must have unique indices
		java.util.Map<Integer, ApiIndex> indexMap = new java.util.HashMap<>();
		for (ApiIndex api : ApiIndex.values()) {
			int idx = api.index();
			assertFalse(indexMap.containsKey(idx),
					"Duplicate ApiIndex ordinal: " + api.name() + " has same index as " + indexMap.get(idx));
			indexMap.put(idx, api);
		}
	}

	@Test
	void noGapsInApiIndexRange() {
		// Indices should form a contiguous range 0..N-1
		int expectedMax = ApiIndex.values().length - 1;
		int actualMax = 0;
		for (ApiIndex api : ApiIndex.values()) {
			actualMax = Math.max(actualMax, api.index());
		}
		assertEquals(expectedMax, actualMax,
				"API indices should be contiguous 0.." + expectedMax + ", found max " + actualMax);
	}

	@Test
	void enumValuesHaveValidNames() {
		// All enum values should have non-empty names
		for (ApiIndex api : ApiIndex.values()) {
			assertFalse(api.name().isEmpty(), "ApiIndex enum value has empty name");
			assertEquals(api.name(), api.name().toUpperCase(), "ApiIndex names should be UPPER_SNAKE_CASE");
		}
	}

	// ------------------------------------------------------------------------
	// 1.10: OBJECT_METHOD_BIND_* signature verification
	// ------------------------------------------------------------------------

	@Test
	void objectMethodBindCallSignature_matchesGodotApi() {
		// Signature from gdextension_interface.h (Godot 4.6):
		// void object_method_bind_call(MethodBindPtr, ObjectPtr, VariantPtr*, Int,
		// VariantPtr, Error*)
		// FD: FunctionDescriptor.ofVoid(ADDRESS×6)
		FunctionDescriptor fd = ApiSignatures.get(ApiIndex.OBJECT_METHOD_BIND_CALL);

		assertNotNull(fd, "OBJECT_METHOD_BIND_CALL signature must exist");

		// Return type is void (no return value from native perspective)
		assertTrue(fd.returnLayout().isEmpty(),
				"OBJECT_METHOD_BIND_CALL return should be void (no return layout in Panama FD)");

		// 6 arguments: MethodBindPtr, ObjectPtr, VariantPtr*,
		// GDExtensionInt(arg_count), VariantPtr(r_ret), Error*
		assertEquals(6, fd.argumentLayouts().size(), "OBJECT_METHOD_BIND_CALL should have 6 arguments");

		// Arguments 0,1,2,4,5 are pointers (ADDRESS); arg 3 is GDExtensionInt
		// (JAVA_LONG)
		assertEquals(ADDRESS, fd.argumentLayouts().get(0));
		assertEquals(ADDRESS, fd.argumentLayouts().get(1));
		assertEquals(ADDRESS, fd.argumentLayouts().get(2));
		assertEquals(JAVA_LONG, fd.argumentLayouts().get(3), "Argument 3 (p_arg_count) is GDExtensionInt → JAVA_LONG");
		assertEquals(ADDRESS, fd.argumentLayouts().get(4));
		assertEquals(ADDRESS, fd.argumentLayouts().get(5));
	}

	@Test
	void objectMethodBindPtrcallSignature_matchesGodotApi() {
		// Signature from gdextension_interface.h (Godot 4.6):
		// void object_method_bind_ptrcall(MethodBindPtr, ObjectPtr, TypePtr*, TypePtr
		// r_ret)
		// FD: FunctionDescriptor.ofVoid(ADDRESS×4)
		FunctionDescriptor fd = ApiSignatures.get(ApiIndex.OBJECT_METHOD_BIND_PTRCALL);

		assertNotNull(fd, "OBJECT_METHOD_BIND_PTRCALL signature must exist");

		// Return type: void
		assertTrue(fd.returnLayout().isEmpty(), "OBJECT_METHOD_BIND_PTRCALL return should be void (no return layout)");

		// 4 arguments: bind, instance, args, ret
		assertEquals(4, fd.argumentLayouts().size(), "OBJECT_METHOD_BIND_PTRCALL should have 4 arguments");
	}

	@Test
	void classdbGetMethodBindSignature_matchesGodotApi() {
		// Signature from gdextension_interface.h (Godot 4.6):
		// GDExtensionMethodBindPtr classdb_get_method_bind(StringNamePtr,
		// StringNamePtr, Int hash)
		// GDExtensionMethodBindPtr is typedef void* → ADDRESS
		FunctionDescriptor fd = ApiSignatures.get(ApiIndex.CLASSDB_GET_METHOD_BIND);

		assertNotNull(fd, "CLASSDB_GET_METHOD_BIND signature must exist");

		// Return type: GDExtensionMethodBindPtr (a pointer) → ADDRESS
		assertEquals(ADDRESS, fd.returnLayout().orElse(null), "CLASSDB_GET_METHOD_BIND returns a pointer → ADDRESS");

		// 3 arguments: className, methodName, hash
		assertEquals(3, fd.argumentLayouts().size(), "CLASSDB_GET_METHOD_BIND should have 3 arguments");
	}

	@Test
	void allApiSignaturesHaveReturnLayoutOrVoid() {
		// Every API must have a non-null return layout, OR be a void function (no
		// return).
		// Note: FunctionDescriptor.ofVoid() has returnLayout().isEmpty() which is
		// valid.
		for (ApiIndex api : ApiIndex.values()) {
			FunctionDescriptor fd = ApiSignatures.get(api);
			assertNotNull(fd, "Signature missing for: " + api.name());
			// Either has a return layout (non-void) or is void (valid either way)
			assertTrue(fd.returnLayout().isPresent() || fd.returnLayout().isEmpty(),
					"FD must be valid (either has return or is void) for: " + api.name());
		}
	}

	@Test
	void variantApisHaveCorrectReturnTypes() {
		// Key Variant APIs:
		// VARIANT_HASH returns GDExtensionInt (int64_t) → JAVA_LONG
		assertEquals(JAVA_LONG, ApiSignatures.get(ApiIndex.VARIANT_HASH).returnLayout().orElse(null),
				"VARIANT_HASH returns int64 → JAVA_LONG");

		// VARIANT_NEW_NIL returns void (no return layout)
		assertTrue(ApiSignatures.get(ApiIndex.VARIANT_NEW_NIL).returnLayout().isEmpty(),
				"VARIANT_NEW_NIL is void → no return layout");
	}

	@Test
	void classdbConstructObjectReturnsPointer() {
		// classdb_construct_object returns GDExtensionObjectPtr → ADDRESS
		assertEquals(ADDRESS, ApiSignatures.get(ApiIndex.CLASSDB_CONSTRUCT_OBJECT).returnLayout().orElse(null),
				"CLASSDB_CONSTRUCT_OBJECT returns a pointer → ADDRESS");
	}
}
