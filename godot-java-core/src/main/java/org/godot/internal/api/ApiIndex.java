package org.godot.internal.api;

/**
 * Index of all Godot C API functions. Auto-generated from
 * gdextension_interface.json by the code generator. DO NOT EDIT.
 */
public enum ApiIndex {

	GET_GODOT_VERSION(0), GET_GODOT_VERSION2(1), MEM_ALLOC(2), MEM_REALLOC(3), MEM_FREE(4), MEM_ALLOC2(5), MEM_REALLOC2(
			6), MEM_FREE2(7), PRINT_ERROR(8), PRINT_ERROR_WITH_MESSAGE(9), PRINT_WARNING(
					10), PRINT_WARNING_WITH_MESSAGE(11), PRINT_SCRIPT_ERROR(12), PRINT_SCRIPT_ERROR_WITH_MESSAGE(
							13), GET_NATIVE_STRUCT_SIZE(14), VARIANT_NEW_COPY(15), VARIANT_NEW_NIL(16), VARIANT_DESTROY(
									17), VARIANT_CALL(18), VARIANT_CALL_STATIC(19), VARIANT_EVALUATE(20), VARIANT_SET(
											21), VARIANT_SET_NAMED(22), VARIANT_SET_KEYED(23), VARIANT_SET_INDEXED(
													24), VARIANT_GET(25), VARIANT_GET_NAMED(26), VARIANT_GET_KEYED(
															27), VARIANT_GET_INDEXED(28), VARIANT_ITER_INIT(
																	29), VARIANT_ITER_NEXT(30), VARIANT_ITER_GET(
																			31), VARIANT_HASH(
																					32), VARIANT_RECURSIVE_HASH(
																							33), VARIANT_HASH_COMPARE(
																									34), VARIANT_BOOLEANIZE(
																											35), VARIANT_DUPLICATE(
																													36), VARIANT_STRINGIFY(
																															37), VARIANT_GET_TYPE(
																																	38), VARIANT_HAS_METHOD(
																																			39), VARIANT_HAS_MEMBER(
																																					40), VARIANT_HAS_KEY(
																																							41), VARIANT_GET_OBJECT_INSTANCE_ID(
																																									42), VARIANT_GET_TYPE_NAME(
																																											43), VARIANT_CAN_CONVERT(
																																													44), VARIANT_CAN_CONVERT_STRICT(
																																															45), GET_VARIANT_FROM_TYPE_CONSTRUCTOR(
																																																	46), GET_VARIANT_TO_TYPE_CONSTRUCTOR(
																																																			47), VARIANT_GET_PTR_INTERNAL_GETTER(
																																																					48), VARIANT_GET_PTR_OPERATOR_EVALUATOR(
																																																							49), VARIANT_GET_PTR_BUILTIN_METHOD(
																																																									50), VARIANT_GET_PTR_CONSTRUCTOR(
																																																											51), VARIANT_GET_PTR_DESTRUCTOR(
																																																													52), VARIANT_CONSTRUCT(
																																																															53), VARIANT_GET_PTR_SETTER(
																																																																	54), VARIANT_GET_PTR_GETTER(
																																																																			55), VARIANT_GET_PTR_INDEXED_SETTER(
																																																																					56), VARIANT_GET_PTR_INDEXED_GETTER(
																																																																							57), VARIANT_GET_PTR_KEYED_SETTER(
																																																																									58), VARIANT_GET_PTR_KEYED_GETTER(
																																																																											59), VARIANT_GET_PTR_KEYED_CHECKER(
																																																																													60), VARIANT_GET_CONSTANT_VALUE(
																																																																															61), VARIANT_GET_PTR_UTILITY_FUNCTION(
																																																																																	62), STRING_NEW_WITH_LATIN1_CHARS(
																																																																																			63), STRING_NEW_WITH_UTF8_CHARS(
																																																																																					64), STRING_NEW_WITH_UTF16_CHARS(
																																																																																							65), STRING_NEW_WITH_UTF32_CHARS(
																																																																																									66), STRING_NEW_WITH_WIDE_CHARS(
																																																																																											67), STRING_NEW_WITH_LATIN1_CHARS_AND_LEN(
																																																																																													68), STRING_NEW_WITH_UTF8_CHARS_AND_LEN(
																																																																																															69), STRING_NEW_WITH_UTF8_CHARS_AND_LEN2(
																																																																																																	70), STRING_NEW_WITH_UTF16_CHARS_AND_LEN(
																																																																																																			71), STRING_NEW_WITH_UTF16_CHARS_AND_LEN2(
																																																																																																					72), STRING_NEW_WITH_UTF32_CHARS_AND_LEN(
																																																																																																							73), STRING_NEW_WITH_WIDE_CHARS_AND_LEN(
																																																																																																									74), STRING_TO_LATIN1_CHARS(
																																																																																																											75), STRING_TO_UTF8_CHARS(
																																																																																																													76), STRING_TO_UTF16_CHARS(
																																																																																																															77), STRING_TO_UTF32_CHARS(
																																																																																																																	78), STRING_TO_WIDE_CHARS(
																																																																																																																			79), STRING_OPERATOR_INDEX(
																																																																																																																					80), STRING_OPERATOR_INDEX_CONST(
																																																																																																																							81), STRING_OPERATOR_PLUS_EQ_STRING(
																																																																																																																									82), STRING_OPERATOR_PLUS_EQ_CHAR(
																																																																																																																											83), STRING_OPERATOR_PLUS_EQ_CSTR(
																																																																																																																													84), STRING_OPERATOR_PLUS_EQ_WCSTR(
																																																																																																																															85), STRING_OPERATOR_PLUS_EQ_C32STR(
																																																																																																																																	86), STRING_RESIZE(
																																																																																																																																			87), STRING_NAME_NEW_WITH_LATIN1_CHARS(
																																																																																																																																					88), STRING_NAME_NEW_WITH_UTF8_CHARS(
																																																																																																																																							89), STRING_NAME_NEW_WITH_UTF8_CHARS_AND_LEN(
																																																																																																																																									90), XML_PARSER_OPEN_BUFFER(
																																																																																																																																											91), FILE_ACCESS_STORE_BUFFER(
																																																																																																																																													92), FILE_ACCESS_GET_BUFFER(
																																																																																																																																															93), IMAGE_PTRW(
																																																																																																																																																	94), IMAGE_PTR(
																																																																																																																																																			95), WORKER_THREAD_POOL_ADD_NATIVE_GROUP_TASK(
																																																																																																																																																					96), WORKER_THREAD_POOL_ADD_NATIVE_TASK(
																																																																																																																																																							97), PACKED_BYTE_ARRAY_OPERATOR_INDEX(
																																																																																																																																																									98), PACKED_BYTE_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																											99), PACKED_FLOAT32_ARRAY_OPERATOR_INDEX(
																																																																																																																																																													100), PACKED_FLOAT32_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																															101), PACKED_FLOAT64_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																	102), PACKED_FLOAT64_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																			103), PACKED_INT32_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																					104), PACKED_INT32_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																							105), PACKED_INT64_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																									106), PACKED_INT64_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																											107), PACKED_STRING_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																													108), PACKED_STRING_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																															109), PACKED_VECTOR2_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																																	110), PACKED_VECTOR2_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																																			111), PACKED_VECTOR3_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																																					112), PACKED_VECTOR3_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																																							113), PACKED_VECTOR4_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																																									114), PACKED_VECTOR4_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																																											115), PACKED_COLOR_ARRAY_OPERATOR_INDEX(
																																																																																																																																																																																													116), PACKED_COLOR_ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																																															117), ARRAY_OPERATOR_INDEX(
																																																																																																																																																																																																	118), ARRAY_OPERATOR_INDEX_CONST(
																																																																																																																																																																																																			119), ARRAY_REF(
																																																																																																																																																																																																					120), ARRAY_SET_TYPED(
																																																																																																																																																																																																							121), DICTIONARY_OPERATOR_INDEX(
																																																																																																																																																																																																									122), DICTIONARY_OPERATOR_INDEX_CONST(
																																																																																																																																																																																																											123), DICTIONARY_SET_TYPED(
																																																																																																																																																																																																													124), OBJECT_METHOD_BIND_CALL(
																																																																																																																																																																																																															125), OBJECT_METHOD_BIND_PTRCALL(
																																																																																																																																																																																																																	126), OBJECT_DESTROY(
																																																																																																																																																																																																																			127), GLOBAL_GET_SINGLETON(
																																																																																																																																																																																																																					128), OBJECT_GET_INSTANCE_BINDING(
																																																																																																																																																																																																																							129), OBJECT_SET_INSTANCE_BINDING(
																																																																																																																																																																																																																									130), OBJECT_FREE_INSTANCE_BINDING(
																																																																																																																																																																																																																											131), OBJECT_SET_INSTANCE(
																																																																																																																																																																																																																													132), OBJECT_GET_CLASS_NAME(
																																																																																																																																																																																																																															133), OBJECT_CAST_TO(
																																																																																																																																																																																																																																	134), OBJECT_GET_INSTANCE_FROM_ID(
																																																																																																																																																																																																																																			135), OBJECT_GET_INSTANCE_ID(
																																																																																																																																																																																																																																					136), OBJECT_HAS_SCRIPT_METHOD(
																																																																																																																																																																																																																																							137), OBJECT_CALL_SCRIPT_METHOD(
																																																																																																																																																																																																																																									138), REF_GET_OBJECT(
																																																																																																																																																																																																																																											139), REF_SET_OBJECT(
																																																																																																																																																																																																																																													140), SCRIPT_INSTANCE_CREATE(
																																																																																																																																																																																																																																															141), SCRIPT_INSTANCE_CREATE2(
																																																																																																																																																																																																																																																	142), SCRIPT_INSTANCE_CREATE3(
																																																																																																																																																																																																																																																			143), PLACEHOLDER_SCRIPT_INSTANCE_CREATE(
																																																																																																																																																																																																																																																					144), PLACEHOLDER_SCRIPT_INSTANCE_UPDATE(
																																																																																																																																																																																																																																																							145), OBJECT_GET_SCRIPT_INSTANCE(
																																																																																																																																																																																																																																																									146), OBJECT_SET_SCRIPT_INSTANCE(
																																																																																																																																																																																																																																																											147), CALLABLE_CUSTOM_CREATE(
																																																																																																																																																																																																																																																													148), CALLABLE_CUSTOM_CREATE2(
																																																																																																																																																																																																																																																															149), CALLABLE_CUSTOM_GET_USERDATA(
																																																																																																																																																																																																																																																																	150), CLASSDB_CONSTRUCT_OBJECT(
																																																																																																																																																																																																																																																																			151), CLASSDB_CONSTRUCT_OBJECT2(
																																																																																																																																																																																																																																																																					152), CLASSDB_GET_METHOD_BIND(
																																																																																																																																																																																																																																																																							153), CLASSDB_GET_CLASS_TAG(
																																																																																																																																																																																																																																																																									154), CLASSDB_REGISTER_EXTENSION_CLASS(
																																																																																																																																																																																																																																																																											155), CLASSDB_REGISTER_EXTENSION_CLASS2(
																																																																																																																																																																																																																																																																													156), CLASSDB_REGISTER_EXTENSION_CLASS3(
																																																																																																																																																																																																																																																																															157), CLASSDB_REGISTER_EXTENSION_CLASS4(
																																																																																																																																																																																																																																																																																	158), CLASSDB_REGISTER_EXTENSION_CLASS5(
																																																																																																																																																																																																																																																																																			159), CLASSDB_REGISTER_EXTENSION_CLASS_METHOD(
																																																																																																																																																																																																																																																																																					160), CLASSDB_REGISTER_EXTENSION_CLASS_VIRTUAL_METHOD(
																																																																																																																																																																																																																																																																																							161), CLASSDB_REGISTER_EXTENSION_CLASS_INTEGER_CONSTANT(
																																																																																																																																																																																																																																																																																									162), CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY(
																																																																																																																																																																																																																																																																																											163), CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY_INDEXED(
																																																																																																																																																																																																																																																																																													164), CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY_GROUP(
																																																																																																																																																																																																																																																																																															165), CLASSDB_REGISTER_EXTENSION_CLASS_PROPERTY_SUBGROUP(
																																																																																																																																																																																																																																																																																																	166), CLASSDB_REGISTER_EXTENSION_CLASS_SIGNAL(
																																																																																																																																																																																																																																																																																																			167), CLASSDB_UNREGISTER_EXTENSION_CLASS(
																																																																																																																																																																																																																																																																																																					168), GET_LIBRARY_PATH(
																																																																																																																																																																																																																																																																																																							169), EDITOR_ADD_PLUGIN(
																																																																																																																																																																																																																																																																																																									170), EDITOR_REMOVE_PLUGIN(
																																																																																																																																																																																																																																																																																																											171), EDITOR_HELP_LOAD_XML_FROM_UTF8_CHARS(
																																																																																																																																																																																																																																																																																																													172), EDITOR_HELP_LOAD_XML_FROM_UTF8_CHARS_AND_LEN(
																																																																																																																																																																																																																																																																																																															173), EDITOR_REGISTER_GET_CLASSES_USED_CALLBACK(
																																																																																																																																																																																																																																																																																																																	174), REGISTER_MAIN_LOOP_CALLBACKS(
																																																																																																																																																																																																																																																																																																																			175);

	private final int index;

	ApiIndex(int index) {
		this.index = index;
	}

	public int index() {
		return index;
	}
}
