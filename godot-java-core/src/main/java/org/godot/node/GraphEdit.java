package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Rect2;
import org.godot.math.Vector2;

public class GraphEdit extends Control {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_type_names", 4155329257L),
			java.util.Map.entry("detach_graph_element_from_frame", 3304788590L),
			java.util.Map.entry("get_element_frame", 988084372L), java.util.Map.entry("is_minimap_enabled", 36873697L),
			java.util.Map.entry("clear_connections", 3218959716L),
			java.util.Map.entry("add_valid_right_disconnect_type", 1286410249L),
			java.util.Map.entry("remove_valid_left_disconnect_type", 1286410249L),
			java.util.Map.entry("set_snapping_enabled", 2586408642L),
			java.util.Map.entry("set_right_disconnects", 2586408642L),
			java.util.Map.entry("attach_graph_element_to_frame", 3740211285L),
			java.util.Map.entry("add_valid_connection_type", 3937882851L),
			java.util.Map.entry("get_grid_pattern", 1286127528L),
			java.util.Map.entry("get_snapping_distance", 3905245786L),
			java.util.Map.entry("get_type_names", 3102165223L), java.util.Map.entry("is_showing_menu", 36873697L),
			java.util.Map.entry("set_show_menu", 2586408642L), java.util.Map.entry("set_panning_scheme", 18893313L),
			java.util.Map.entry("get_connection_line", 3932192302L),
			java.util.Map.entry("set_show_grid_buttons", 2586408642L),
			java.util.Map.entry("set_show_zoom_label", 2586408642L),
			java.util.Map.entry("set_grid_pattern", 1074098205L), java.util.Map.entry("connect_node", 1376144231L),
			java.util.Map.entry("get_connection_list", 3995934104L),
			java.util.Map.entry("remove_valid_connection_type", 3937882851L),
			java.util.Map.entry("get_panning_scheme", 549924446L),
			java.util.Map.entry("add_valid_left_disconnect_type", 1286410249L),
			java.util.Map.entry("get_closest_connection_at_point", 453879819L),
			java.util.Map.entry("get_connections_intersecting_with_rect", 2709748719L),
			java.util.Map.entry("set_connection_lines_curvature", 373806689L),
			java.util.Map.entry("remove_valid_right_disconnect_type", 1286410249L),
			java.util.Map.entry("get_attached_nodes_of_frame", 689397652L),
			java.util.Map.entry("is_showing_minimap_button", 36873697L),
			java.util.Map.entry("get_menu_hbox", 3590609951L), java.util.Map.entry("get_zoom_min", 1740695150L),
			java.util.Map.entry("set_show_arrange_button", 2586408642L),
			java.util.Map.entry("get_minimap_size", 3341600327L),
			java.util.Map.entry("get_connection_lines_curvature", 1740695150L),
			java.util.Map.entry("get_zoom_step", 1740695150L),
			java.util.Map.entry("set_connection_activity", 1141899943L),
			java.util.Map.entry("get_connection_lines_thickness", 1740695150L),
			java.util.Map.entry("is_showing_arrange_button", 36873697L),
			java.util.Map.entry("set_zoom_step", 373806689L), java.util.Map.entry("is_showing_zoom_buttons", 36873697L),
			java.util.Map.entry("force_connection_drag_end", 3218959716L), java.util.Map.entry("get_zoom", 1740695150L),
			java.util.Map.entry("set_minimap_enabled", 2586408642L),
			java.util.Map.entry("get_connection_list_from_node", 3147814860L),
			java.util.Map.entry("set_zoom_min", 373806689L),
			java.util.Map.entry("is_valid_connection_type", 2522259332L),
			java.util.Map.entry("is_showing_grid_buttons", 36873697L),
			java.util.Map.entry("is_node_connected", 4216241294L),
			java.util.Map.entry("is_showing_zoom_label", 36873697L),
			java.util.Map.entry("disconnect_node", 1933654315L), java.util.Map.entry("set_zoom_max", 373806689L),
			java.util.Map.entry("get_zoom_max", 1740695150L), java.util.Map.entry("set_snapping_distance", 1286410249L),
			java.util.Map.entry("set_show_minimap_button", 2586408642L),
			java.util.Map.entry("set_connections", 381264803L), java.util.Map.entry("is_showing_grid", 36873697L),
			java.util.Map.entry("set_connection_lines_antialiased", 2586408642L),
			java.util.Map.entry("set_selected", 1078189570L), java.util.Map.entry("get_connection_count", 861718734L),
			java.util.Map.entry("set_connection_lines_thickness", 373806689L),
			java.util.Map.entry("get_minimap_opacity", 1740695150L),
			java.util.Map.entry("is_snapping_enabled", 36873697L),
			java.util.Map.entry("set_show_zoom_buttons", 2586408642L),
			java.util.Map.entry("set_minimap_size", 743155724L), java.util.Map.entry("set_scroll_offset", 743155724L),
			java.util.Map.entry("set_show_grid", 2586408642L), java.util.Map.entry("set_zoom", 373806689L),
			java.util.Map.entry("is_connection_lines_antialiased", 36873697L),
			java.util.Map.entry("is_right_disconnects_enabled", 36873697L),
			java.util.Map.entry("get_scroll_offset", 3341600327L),
			java.util.Map.entry("set_minimap_opacity", 373806689L), java.util.Map.entry("arrange_nodes", 3218959716L));

	GraphEdit(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GraphEdit(long nativePointer) {
		super(nativePointer);
	}

	public int connect_node(String from_node, long from_port, String to_node, long to_port, boolean keep_alive) {
		return (int) super.call("connect_node",
				new java.lang.Object[]{(java.lang.Object) from_node, java.lang.Long.valueOf(from_port),
						(java.lang.Object) to_node, java.lang.Long.valueOf(to_port),
						java.lang.Boolean.valueOf(keep_alive)});
	}

	public boolean is_node_connected(String from_node, long from_port, String to_node, long to_port) {
		return (boolean) super.call("is_node_connected", new java.lang.Object[]{(java.lang.Object) from_node,
				java.lang.Long.valueOf(from_port), (java.lang.Object) to_node, java.lang.Long.valueOf(to_port)});
	}

	public void disconnect_node(String from_node, long from_port, String to_node, long to_port) {
		super.call("disconnect_node", new java.lang.Object[]{(java.lang.Object) from_node,
				java.lang.Long.valueOf(from_port), (java.lang.Object) to_node, java.lang.Long.valueOf(to_port)});
	}

	public void set_connection_activity(String from_node, long from_port, String to_node, long to_port, double amount) {
		super.call("set_connection_activity",
				new java.lang.Object[]{(java.lang.Object) from_node, java.lang.Long.valueOf(from_port),
						(java.lang.Object) to_node, java.lang.Long.valueOf(to_port), java.lang.Double.valueOf(amount)});
	}

	public int get_connection_count(String from_node, long from_port) {
		return (int) super.call("get_connection_count",
				new java.lang.Object[]{(java.lang.Object) from_node, java.lang.Long.valueOf(from_port)});
	}

	public GodotDictionary get_closest_connection_at_point(Vector2 point, double max_distance) {
		return (GodotDictionary) super.call("get_closest_connection_at_point",
				new java.lang.Object[]{(java.lang.Object) point, java.lang.Double.valueOf(max_distance)});
	}

	public GodotDictionary[] get_connection_list_from_node(String node) {
		return (GodotDictionary[]) super.call("get_connection_list_from_node",
				new java.lang.Object[]{(java.lang.Object) node});
	}

	public GodotDictionary[] get_connections_intersecting_with_rect(Rect2 rect) {
		return (GodotDictionary[]) super.call("get_connections_intersecting_with_rect",
				new java.lang.Object[]{(java.lang.Object) rect});
	}

	public void clear_connections() {
		super.call("clear_connections");
	}

	public void force_connection_drag_end() {
		super.call("force_connection_drag_end");
	}

	public void add_valid_right_disconnect_type(long type) {
		super.call("add_valid_right_disconnect_type", new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}

	public void remove_valid_right_disconnect_type(long type) {
		super.call("remove_valid_right_disconnect_type", new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}

	public void add_valid_left_disconnect_type(long type) {
		super.call("add_valid_left_disconnect_type", new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}

	public void remove_valid_left_disconnect_type(long type) {
		super.call("remove_valid_left_disconnect_type", new java.lang.Object[]{java.lang.Long.valueOf(type)});
	}

	public void add_valid_connection_type(long from_type, long to_type) {
		super.call("add_valid_connection_type",
				new java.lang.Object[]{java.lang.Long.valueOf(from_type), java.lang.Long.valueOf(to_type)});
	}

	public void remove_valid_connection_type(long from_type, long to_type) {
		super.call("remove_valid_connection_type",
				new java.lang.Object[]{java.lang.Long.valueOf(from_type), java.lang.Long.valueOf(to_type)});
	}

	public boolean is_valid_connection_type(long from_type, long to_type) {
		return (boolean) super.call("is_valid_connection_type",
				new java.lang.Object[]{java.lang.Long.valueOf(from_type), java.lang.Long.valueOf(to_type)});
	}

	public double[][] get_connection_line(Vector2 from_node, Vector2 to_node) {
		return (double[][]) super.call("get_connection_line",
				new java.lang.Object[]{(java.lang.Object) from_node, (java.lang.Object) to_node});
	}

	public void attach_graph_element_to_frame(String element, String frame) {
		super.call("attach_graph_element_to_frame",
				new java.lang.Object[]{(java.lang.Object) element, (java.lang.Object) frame});
	}

	public void detach_graph_element_from_frame(String element) {
		super.call("detach_graph_element_from_frame", new java.lang.Object[]{(java.lang.Object) element});
	}

	public GraphFrame get_element_frame(String element) {
		return (GraphFrame) super.call("get_element_frame", new java.lang.Object[]{(java.lang.Object) element});
	}

	public String[] get_attached_nodes_of_frame(String frame) {
		return (String[]) super.call("get_attached_nodes_of_frame", new java.lang.Object[]{(java.lang.Object) frame});
	}

	public boolean is_showing_grid() {
		return (boolean) super.call("is_showing_grid");
	}

	public boolean is_snapping_enabled() {
		return (boolean) super.call("is_snapping_enabled");
	}

	public boolean is_connection_lines_antialiased() {
		return (boolean) super.call("is_connection_lines_antialiased");
	}

	public boolean is_minimap_enabled() {
		return (boolean) super.call("is_minimap_enabled");
	}

	public boolean is_showing_menu() {
		return (boolean) super.call("is_showing_menu");
	}

	public boolean is_showing_zoom_label() {
		return (boolean) super.call("is_showing_zoom_label");
	}

	public boolean is_showing_grid_buttons() {
		return (boolean) super.call("is_showing_grid_buttons");
	}

	public boolean is_showing_zoom_buttons() {
		return (boolean) super.call("is_showing_zoom_buttons");
	}

	public boolean is_showing_minimap_button() {
		return (boolean) super.call("is_showing_minimap_button");
	}

	public boolean is_showing_arrange_button() {
		return (boolean) super.call("is_showing_arrange_button");
	}

	public boolean is_right_disconnects_enabled() {
		return (boolean) super.call("is_right_disconnects_enabled");
	}

	public void arrange_nodes() {
		super.call("arrange_nodes");
	}

	public Vector2 getScroll_offset() {
		return (Vector2) super.call("get_scroll_offset", new java.lang.Object[0]);
	}

	public void setScroll_offset(Vector2 value) {
		super.call("set_scroll_offset", new java.lang.Object[]{(java.lang.Object) value});
	}

	public boolean isShow_grid() {
		return (boolean) super.call("is_showing_grid", new java.lang.Object[0]);
	}

	public void setShow_grid(boolean value) {
		super.call("set_show_grid", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getGrid_pattern() {
		return (long) super.call("get_grid_pattern", new java.lang.Object[0]);
	}

	public void setGrid_pattern(long value) {
		super.call("set_grid_pattern", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isSnapping_enabled() {
		return (boolean) super.call("is_snapping_enabled", new java.lang.Object[0]);
	}

	public void setSnapping_enabled(boolean value) {
		super.call("set_snapping_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getSnapping_distance() {
		return (long) super.call("get_snapping_distance", new java.lang.Object[0]);
	}

	public void setSnapping_distance(long value) {
		super.call("set_snapping_distance", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public long getPanning_scheme() {
		return (long) super.call("get_panning_scheme", new java.lang.Object[0]);
	}

	public void setPanning_scheme(long value) {
		super.call("set_panning_scheme", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public boolean isRight_disconnects() {
		return (boolean) super.call("is_right_disconnects_enabled", new java.lang.Object[0]);
	}

	public void setRight_disconnects(boolean value) {
		super.call("set_right_disconnects", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Object getType_names() {
		return (Object) super.call("get_type_names", new java.lang.Object[0]);
	}

	public void setType_names(Object value) {
		super.call("set_type_names", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getConnection_lines_curvature() {
		return (double) super.call("get_connection_lines_curvature", new java.lang.Object[0]);
	}

	public void setConnection_lines_curvature(double value) {
		super.call("set_connection_lines_curvature", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getConnection_lines_thickness() {
		return (double) super.call("get_connection_lines_thickness", new java.lang.Object[0]);
	}

	public void setConnection_lines_thickness(double value) {
		super.call("set_connection_lines_thickness", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isConnection_lines_antialiased() {
		return (boolean) super.call("is_connection_lines_antialiased", new java.lang.Object[0]);
	}

	public void setConnection_lines_antialiased(boolean value) {
		super.call("set_connection_lines_antialiased", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Object[] getConnections() {
		return (Object[]) super.call("get_connection_list", new java.lang.Object[0]);
	}

	public void setConnections(Object[] value) {
		super.call("set_connections", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getZoom() {
		return (double) super.call("get_zoom", new java.lang.Object[0]);
	}

	public void setZoom(double value) {
		super.call("set_zoom", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getZoom_min() {
		return (double) super.call("get_zoom_min", new java.lang.Object[0]);
	}

	public void setZoom_min(double value) {
		super.call("set_zoom_min", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getZoom_max() {
		return (double) super.call("get_zoom_max", new java.lang.Object[0]);
	}

	public void setZoom_max(double value) {
		super.call("set_zoom_max", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getZoom_step() {
		return (double) super.call("get_zoom_step", new java.lang.Object[0]);
	}

	public void setZoom_step(double value) {
		super.call("set_zoom_step", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isMinimap_enabled() {
		return (boolean) super.call("is_minimap_enabled", new java.lang.Object[0]);
	}

	public void setMinimap_enabled(boolean value) {
		super.call("set_minimap_enabled", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public Vector2 getMinimap_size() {
		return (Vector2) super.call("get_minimap_size", new java.lang.Object[0]);
	}

	public void setMinimap_size(Vector2 value) {
		super.call("set_minimap_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getMinimap_opacity() {
		return (double) super.call("get_minimap_opacity", new java.lang.Object[0]);
	}

	public void setMinimap_opacity(double value) {
		super.call("set_minimap_opacity", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean isShow_menu() {
		return (boolean) super.call("is_showing_menu", new java.lang.Object[0]);
	}

	public void setShow_menu(boolean value) {
		super.call("set_show_menu", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShow_zoom_label() {
		return (boolean) super.call("is_showing_zoom_label", new java.lang.Object[0]);
	}

	public void setShow_zoom_label(boolean value) {
		super.call("set_show_zoom_label", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShow_zoom_buttons() {
		return (boolean) super.call("is_showing_zoom_buttons", new java.lang.Object[0]);
	}

	public void setShow_zoom_buttons(boolean value) {
		super.call("set_show_zoom_buttons", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShow_grid_buttons() {
		return (boolean) super.call("is_showing_grid_buttons", new java.lang.Object[0]);
	}

	public void setShow_grid_buttons(boolean value) {
		super.call("set_show_grid_buttons", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShow_minimap_button() {
		return (boolean) super.call("is_showing_minimap_button", new java.lang.Object[0]);
	}

	public void setShow_minimap_button(boolean value) {
		super.call("set_show_minimap_button", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public boolean isShow_arrange_button() {
		return (boolean) super.call("is_showing_arrange_button", new java.lang.Object[0]);
	}

	public void setShow_arrange_button(boolean value) {
		super.call("set_show_arrange_button", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}
}
