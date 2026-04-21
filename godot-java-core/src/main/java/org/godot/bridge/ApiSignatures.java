package org.godot.bridge;

import java.lang.foreign.FunctionDescriptor;
import static java.lang.foreign.ValueLayout.*;
import org.godot.internal.api.ApiIndex;

/**
 * Panama FunctionDescriptor for each Godot GDExtension API function.
 * Auto-generated from gdextension_interface.json by the code generator. DO NOT
 * EDIT.
 */
public final class ApiSignatures {

	private ApiSignatures() {
	}

	public static FunctionDescriptor get(ApiIndex api) {
		switch (api) {
			case GET_GODOT_VERSION :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case GET_GODOT_VERSION2 :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case MEM_ALLOC :
				return FunctionDescriptor.of(ADDRESS, JAVA_LONG);
			case MEM_REALLOC :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case MEM_FREE :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case MEM_ALLOC2 :
				return FunctionDescriptor.of(ADDRESS, JAVA_LONG, JAVA_INT);
			case MEM_REALLOC2 :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG, JAVA_INT);
			case MEM_FREE2 :
				return FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT);
			case PRINT_ERROR :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, JAVA_INT, JAVA_INT);
			case PRINT_ERROR_WITH_MESSAGE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS, JAVA_INT, JAVA_INT);
			case PRINT_WARNING :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, JAVA_INT, JAVA_INT);
			case PRINT_WARNING_WITH_MESSAGE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS, JAVA_INT, JAVA_INT);
			case PRINT_SCRIPT_ERROR :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, JAVA_INT, JAVA_INT);
			case PRINT_SCRIPT_ERROR_WITH_MESSAGE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS, JAVA_INT, JAVA_INT);
			case GET_NATIVE_STRUCT_SIZE :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS);
			case VARIANT_NEW_COPY :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case VARIANT_NEW_NIL :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case VARIANT_DESTROY :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case VARIANT_CALL :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, JAVA_LONG, ADDRESS, ADDRESS);
			case VARIANT_CALL_STATIC :
				return FunctionDescriptor.ofVoid(JAVA_INT, ADDRESS, ADDRESS, JAVA_LONG, ADDRESS, ADDRESS);
			case VARIANT_EVALUATE :
				return FunctionDescriptor.ofVoid(JAVA_INT, ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_SET :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_SET_NAMED :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_SET_KEYED :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_SET_INDEXED :
				return FunctionDescriptor.ofVoid(ADDRESS, JAVA_LONG, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_GET :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_GET_NAMED :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_GET_KEYED :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_GET_INDEXED :
				return FunctionDescriptor.ofVoid(ADDRESS, JAVA_LONG, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_ITER_INIT :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_ITER_NEXT :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_ITER_GET :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_HASH :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS);
			case VARIANT_RECURSIVE_HASH :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, JAVA_LONG);
			case VARIANT_HASH_COMPARE :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS);
			case VARIANT_BOOLEANIZE :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS);
			case VARIANT_DUPLICATE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_INT);
			case VARIANT_STRINGIFY :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case VARIANT_GET_TYPE :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS);
			case VARIANT_HAS_METHOD :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS);
			case VARIANT_HAS_MEMBER :
				return FunctionDescriptor.of(JAVA_INT, JAVA_INT, ADDRESS);
			case VARIANT_HAS_KEY :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS);
			case VARIANT_GET_OBJECT_INSTANCE_ID :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS);
			case VARIANT_GET_TYPE_NAME :
				return FunctionDescriptor.ofVoid(JAVA_INT, ADDRESS);
			case VARIANT_CAN_CONVERT :
				return FunctionDescriptor.of(JAVA_INT, JAVA_INT, JAVA_INT);
			case VARIANT_CAN_CONVERT_STRICT :
				return FunctionDescriptor.of(JAVA_INT, JAVA_INT, JAVA_INT);
			case GET_VARIANT_FROM_TYPE_CONSTRUCTOR :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case GET_VARIANT_TO_TYPE_CONSTRUCTOR :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_GET_PTR_INTERNAL_GETTER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_GET_PTR_OPERATOR_EVALUATOR :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT, JAVA_INT, JAVA_INT);
			case VARIANT_GET_PTR_BUILTIN_METHOD :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT, ADDRESS, JAVA_LONG);
			case VARIANT_GET_PTR_CONSTRUCTOR :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT, JAVA_INT);
			case VARIANT_GET_PTR_DESTRUCTOR :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_CONSTRUCT :
				return FunctionDescriptor.ofVoid(JAVA_INT, ADDRESS, ADDRESS, JAVA_INT, ADDRESS);
			case VARIANT_GET_PTR_SETTER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT, ADDRESS);
			case VARIANT_GET_PTR_GETTER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT, ADDRESS);
			case VARIANT_GET_PTR_INDEXED_SETTER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_GET_PTR_INDEXED_GETTER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_GET_PTR_KEYED_SETTER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_GET_PTR_KEYED_GETTER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_GET_PTR_KEYED_CHECKER :
				return FunctionDescriptor.of(ADDRESS, JAVA_INT);
			case VARIANT_GET_CONSTANT_VALUE :
				return FunctionDescriptor.ofVoid(JAVA_INT, ADDRESS, ADDRESS);
			case VARIANT_GET_PTR_UTILITY_FUNCTION :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_NEW_WITH_LATIN1_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_NEW_WITH_UTF8_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_NEW_WITH_UTF16_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_NEW_WITH_UTF32_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_NEW_WITH_WIDE_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_NEW_WITH_LATIN1_CHARS_AND_LEN :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_NEW_WITH_UTF8_CHARS_AND_LEN :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_NEW_WITH_UTF8_CHARS_AND_LEN2 :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_NEW_WITH_UTF16_CHARS_AND_LEN :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_NEW_WITH_UTF16_CHARS_AND_LEN2 :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG, JAVA_INT);
			case STRING_NEW_WITH_UTF32_CHARS_AND_LEN :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_NEW_WITH_WIDE_CHARS_AND_LEN :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_TO_LATIN1_CHARS :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_TO_UTF8_CHARS :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_TO_UTF16_CHARS :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_TO_UTF32_CHARS :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_TO_WIDE_CHARS :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case STRING_OPERATOR_PLUS_EQ_STRING :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_OPERATOR_PLUS_EQ_CHAR :
				return FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT);
			case STRING_OPERATOR_PLUS_EQ_CSTR :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_OPERATOR_PLUS_EQ_WCSTR :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_OPERATOR_PLUS_EQ_C32STR :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_RESIZE :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, JAVA_LONG);
			case STRING_NAME_NEW_WITH_LATIN1_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_INT);
			case STRING_NAME_NEW_WITH_UTF8_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case STRING_NAME_NEW_WITH_UTF8_CHARS_AND_LEN :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG);
			case XML_PARSER_OPEN_BUFFER :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case FILE_ACCESS_STORE_BUFFER :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, JAVA_LONG);
			case FILE_ACCESS_GET_BUFFER :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, JAVA_LONG);
			case IMAGE_PTRW :
				return FunctionDescriptor.of(ADDRESS, ADDRESS);
			case IMAGE_PTR :
				return FunctionDescriptor.of(ADDRESS, ADDRESS);
			case WORKER_THREAD_POOL_ADD_NATIVE_GROUP_TASK :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, ADDRESS, JAVA_INT, JAVA_INT, JAVA_INT,
						ADDRESS);
			case WORKER_THREAD_POOL_ADD_NATIVE_TASK :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS, ADDRESS, ADDRESS, JAVA_INT, ADDRESS);
			case PACKED_BYTE_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_BYTE_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_FLOAT32_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_FLOAT32_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_FLOAT64_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_FLOAT64_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_INT32_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_INT32_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_INT64_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_INT64_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_STRING_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_STRING_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_VECTOR2_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_VECTOR2_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_VECTOR3_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_VECTOR3_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_VECTOR4_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_VECTOR4_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_COLOR_ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case PACKED_COLOR_ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case ARRAY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case ARRAY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_LONG);
			case ARRAY_REF :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case ARRAY_SET_TYPED :
				return FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT, ADDRESS, ADDRESS);
			case DICTIONARY_OPERATOR_INDEX :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case DICTIONARY_OPERATOR_INDEX_CONST :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case DICTIONARY_SET_TYPED :
				return FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT, ADDRESS, ADDRESS, JAVA_INT, ADDRESS, ADDRESS);
			case OBJECT_METHOD_BIND_CALL :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, JAVA_LONG, ADDRESS, ADDRESS);
			case OBJECT_METHOD_BIND_PTRCALL :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_DESTROY :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case GLOBAL_GET_SINGLETON :
				return FunctionDescriptor.of(ADDRESS, ADDRESS);
			case OBJECT_GET_INSTANCE_BINDING :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_SET_INSTANCE_BINDING :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_FREE_INSTANCE_BINDING :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case OBJECT_SET_INSTANCE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_GET_CLASS_NAME :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_CAST_TO :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_GET_INSTANCE_FROM_ID :
				return FunctionDescriptor.of(ADDRESS, JAVA_LONG);
			case OBJECT_GET_INSTANCE_ID :
				return FunctionDescriptor.of(JAVA_LONG, ADDRESS);
			case OBJECT_HAS_SCRIPT_METHOD :
				return FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS);
			case OBJECT_CALL_SCRIPT_METHOD :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, JAVA_LONG, ADDRESS, ADDRESS);
			case REF_GET_OBJECT :
				return FunctionDescriptor.of(ADDRESS, ADDRESS);
			case REF_SET_OBJECT :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case SCRIPT_INSTANCE_CREATE :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case SCRIPT_INSTANCE_CREATE2 :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case SCRIPT_INSTANCE_CREATE3 :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case PLACEHOLDER_SCRIPT_INSTANCE_CREATE :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case PLACEHOLDER_SCRIPT_INSTANCE_UPDATE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_GET_SCRIPT_INSTANCE :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case OBJECT_SET_SCRIPT_INSTANCE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case CALLABLE_CUSTOM_CREATE :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case CALLABLE_CUSTOM_CREATE2 :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case CALLABLE_CUSTOM_GET_USERDATA :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_CONSTRUCT_OBJECT :
				return FunctionDescriptor.of(ADDRESS, ADDRESS);
			case CLASSDB_CONSTRUCT_OBJECT2 :
				return FunctionDescriptor.of(ADDRESS, ADDRESS);
			case CLASSDB_GET_METHOD_BIND :
				return FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS, JAVA_LONG);
			case CLASSDB_GET_CLASS_TAG :
				return FunctionDescriptor.of(ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS2 :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS3 :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS4 :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS5 :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS_METHOD :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS_VIRTUAL_METHOD :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS_INTEGER_CONSTANT :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS, JAVA_LONG, JAVA_INT);
			case CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY_INDEXED :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS, ADDRESS, JAVA_LONG);
			case CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY_GROUP :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY_SUBGROUP :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS);
			case CLASSDB_REGISTER_EXTENSION_CLASS_SIGNAL :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS, ADDRESS, ADDRESS, JAVA_LONG);
			case CLASSDB_UNREGISTER_EXTENSION_CLASS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case GET_LIBRARY_PATH :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case EDITOR_ADD_PLUGIN :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case EDITOR_REMOVE_PLUGIN :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case EDITOR_HELP_LOAD_XML_FROM_UTF8_CHARS :
				return FunctionDescriptor.ofVoid(ADDRESS);
			case EDITOR_HELP_LOAD_XML_FROM_UTF8_CHARS_AND_LEN :
				return FunctionDescriptor.ofVoid(ADDRESS, JAVA_LONG);
			case EDITOR_REGISTER_GET_CLASSES_USED_CALLBACK :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
			case REGISTER_MAIN_LOOP_CALLBACKS :
				return FunctionDescriptor.ofVoid(ADDRESS, ADDRESS);
		}
		throw new IllegalStateException("Unknown API: " + api);
	}
}
