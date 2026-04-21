package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Vector2;

public class VisualShader extends Shader {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("get_node_list", 2370592410L), java.util.Map.entry("remove_node", 844050912L),
			java.util.Map.entry("get_node_position", 2175036082L), java.util.Map.entry("get_node", 3784670312L),
			java.util.Map.entry("remove_varying", 83702148L), java.util.Map.entry("has_varying", 3927539163L),
			java.util.Map.entry("set_node_position", 2726660721L),
			java.util.Map.entry("attach_node_to_frame", 2479945279L),
			java.util.Map.entry("disconnect_nodes", 2268060358L), java.util.Map.entry("set_graph_offset", 743155724L),
			java.util.Map.entry("get_valid_node_id", 629467342L),
			java.util.Map.entry("connect_nodes_forced", 2268060358L), java.util.Map.entry("add_node", 1560769431L),
			java.util.Map.entry("replace_node", 3144735253L), java.util.Map.entry("add_varying", 2084110726L),
			java.util.Map.entry("connect_nodes", 3081049573L), java.util.Map.entry("get_node_connections", 1441964831L),
			java.util.Map.entry("is_node_connection", 3922381898L),
			java.util.Map.entry("get_graph_offset", 3341600327L), java.util.Map.entry("can_connect_nodes", 3922381898L),
			java.util.Map.entry("detach_node_from_frame", 844050912L), java.util.Map.entry("set_mode", 3978014962L));

	VisualShader(MemorySegment nativePointer) {
		super(nativePointer);
	}

	VisualShader(long nativePointer) {
		super(nativePointer);
	}

	public void add_node(int type, VisualShaderNode node, Vector2 position, long id) {
		super.call("add_node", new java.lang.Object[]{java.lang.Integer.valueOf(type), (java.lang.Object) node,
				(java.lang.Object) position, java.lang.Long.valueOf(id)});
	}

	public VisualShaderNode get_node(int type, long id) {
		return (VisualShaderNode) super.call("get_node",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(id)});
	}

	public void set_node_position(int type, long id, Vector2 position) {
		super.call("set_node_position", new java.lang.Object[]{java.lang.Integer.valueOf(type),
				java.lang.Long.valueOf(id), (java.lang.Object) position});
	}

	public Vector2 get_node_position(int type, long id) {
		return (Vector2) super.call("get_node_position",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(id)});
	}

	public int[] get_node_list(int type) {
		return (int[]) super.call("get_node_list", new java.lang.Object[]{java.lang.Integer.valueOf(type)});
	}

	public int get_valid_node_id(int type) {
		return (int) super.call("get_valid_node_id", new java.lang.Object[]{java.lang.Integer.valueOf(type)});
	}

	public void remove_node(int type, long id) {
		super.call("remove_node", new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(id)});
	}

	public void replace_node(int type, long id, String new_class) {
		super.call("replace_node", new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(id),
				(java.lang.Object) new_class});
	}

	public boolean is_node_connection(int type, long from_node, long from_port, long to_node, long to_port) {
		return (boolean) super.call("is_node_connection",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(from_node),
						java.lang.Long.valueOf(from_port), java.lang.Long.valueOf(to_node),
						java.lang.Long.valueOf(to_port)});
	}

	public boolean can_connect_nodes(int type, long from_node, long from_port, long to_node, long to_port) {
		return (boolean) super.call("can_connect_nodes",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(from_node),
						java.lang.Long.valueOf(from_port), java.lang.Long.valueOf(to_node),
						java.lang.Long.valueOf(to_port)});
	}

	public int connect_nodes(int type, long from_node, long from_port, long to_node, long to_port) {
		return (int) super.call("connect_nodes",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(from_node),
						java.lang.Long.valueOf(from_port), java.lang.Long.valueOf(to_node),
						java.lang.Long.valueOf(to_port)});
	}

	public void disconnect_nodes(int type, long from_node, long from_port, long to_node, long to_port) {
		super.call("disconnect_nodes",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(from_node),
						java.lang.Long.valueOf(from_port), java.lang.Long.valueOf(to_node),
						java.lang.Long.valueOf(to_port)});
	}

	public void connect_nodes_forced(int type, long from_node, long from_port, long to_node, long to_port) {
		super.call("connect_nodes_forced",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(from_node),
						java.lang.Long.valueOf(from_port), java.lang.Long.valueOf(to_node),
						java.lang.Long.valueOf(to_port)});
	}

	public GodotDictionary[] get_node_connections(int type) {
		return (GodotDictionary[]) super.call("get_node_connections",
				new java.lang.Object[]{java.lang.Integer.valueOf(type)});
	}

	public void attach_node_to_frame(int type, long id, long frame) {
		super.call("attach_node_to_frame", new java.lang.Object[]{java.lang.Integer.valueOf(type),
				java.lang.Long.valueOf(id), java.lang.Long.valueOf(frame)});
	}

	public void detach_node_from_frame(int type, long id) {
		super.call("detach_node_from_frame",
				new java.lang.Object[]{java.lang.Integer.valueOf(type), java.lang.Long.valueOf(id)});
	}

	public void add_varying(String name, int mode, int type) {
		super.call("add_varying", new java.lang.Object[]{(java.lang.Object) name, java.lang.Integer.valueOf(mode),
				java.lang.Integer.valueOf(type)});
	}

	public void remove_varying(String name) {
		super.call("remove_varying", new java.lang.Object[]{(java.lang.Object) name});
	}

	public boolean has_varying(String name) {
		return (boolean) super.call("has_varying", new java.lang.Object[]{(java.lang.Object) name});
	}

	public Vector2 getGraph_offset() {
		return (Vector2) super.call("get_graph_offset", new java.lang.Object[0]);
	}

	public void setGraph_offset(Vector2 value) {
		super.call("set_graph_offset", new java.lang.Object[]{(java.lang.Object) value});
	}
}
