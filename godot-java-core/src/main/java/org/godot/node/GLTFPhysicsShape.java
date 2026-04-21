package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.collection.GodotDictionary;
import org.godot.math.Vector3;

public class GLTFPhysicsShape extends Resource {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("set_size", 3460891852L), java.util.Map.entry("set_mesh_index", 1286410249L),
			java.util.Map.entry("get_importer_mesh", 3161779525L), java.util.Map.entry("set_shape_type", 83702148L),
			java.util.Map.entry("get_is_trigger", 36873697L), java.util.Map.entry("get_radius", 1740695150L),
			java.util.Map.entry("set_height", 373806689L), java.util.Map.entry("set_radius", 373806689L),
			java.util.Map.entry("from_resource", 3845569786L), java.util.Map.entry("from_dictionary", 2390691823L),
			java.util.Map.entry("to_node", 563689933L), java.util.Map.entry("get_shape_type", 201670096L),
			java.util.Map.entry("get_height", 1740695150L), java.util.Map.entry("set_is_trigger", 2586408642L),
			java.util.Map.entry("to_dictionary", 3102165223L), java.util.Map.entry("set_importer_mesh", 2255166972L),
			java.util.Map.entry("to_resource", 1913542110L), java.util.Map.entry("from_node", 3613751275L),
			java.util.Map.entry("get_size", 3360562783L), java.util.Map.entry("get_mesh_index", 3905245786L));

	GLTFPhysicsShape(MemorySegment nativePointer) {
		super(nativePointer);
	}

	GLTFPhysicsShape(long nativePointer) {
		super(nativePointer);
	}

	public GLTFPhysicsShape from_node(CollisionShape3D shape_node) {
		return (GLTFPhysicsShape) super.call("from_node", new java.lang.Object[]{(java.lang.Object) shape_node});
	}

	public CollisionShape3D to_node(boolean cache_shapes) {
		return (CollisionShape3D) super.call("to_node",
				new java.lang.Object[]{java.lang.Boolean.valueOf(cache_shapes)});
	}

	public GLTFPhysicsShape from_resource(Shape3D shape_resource) {
		return (GLTFPhysicsShape) super.call("from_resource",
				new java.lang.Object[]{(java.lang.Object) shape_resource});
	}

	public Shape3D to_resource(boolean cache_shapes) {
		return (Shape3D) super.call("to_resource", new java.lang.Object[]{java.lang.Boolean.valueOf(cache_shapes)});
	}

	public GLTFPhysicsShape from_dictionary(GodotDictionary dictionary) {
		return (GLTFPhysicsShape) super.call("from_dictionary", new java.lang.Object[]{(java.lang.Object) dictionary});
	}

	public GodotDictionary to_dictionary() {
		return (GodotDictionary) super.call("to_dictionary");
	}

	public String getShape_type() {
		return (String) super.call("get_shape_type", new java.lang.Object[0]);
	}

	public void setShape_type(String value) {
		super.call("set_shape_type", new java.lang.Object[]{(java.lang.Object) value});
	}

	public Vector3 getSize() {
		return (Vector3) super.call("get_size", new java.lang.Object[0]);
	}

	public void setSize(Vector3 value) {
		super.call("set_size", new java.lang.Object[]{(java.lang.Object) value});
	}

	public double getRadius() {
		return (double) super.call("get_radius", new java.lang.Object[0]);
	}

	public void setRadius(double value) {
		super.call("set_radius", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public double getHeight() {
		return (double) super.call("get_height", new java.lang.Object[0]);
	}

	public void setHeight(double value) {
		super.call("set_height", new java.lang.Object[]{java.lang.Double.valueOf(value)});
	}

	public boolean getIs_trigger() {
		return (boolean) super.call("get_is_trigger", new java.lang.Object[0]);
	}

	public void setIs_trigger(boolean value) {
		super.call("set_is_trigger", new java.lang.Object[]{java.lang.Boolean.valueOf(value)});
	}

	public long getMesh_index() {
		return (long) super.call("get_mesh_index", new java.lang.Object[0]);
	}

	public void setMesh_index(long value) {
		super.call("set_mesh_index", new java.lang.Object[]{java.lang.Long.valueOf(value)});
	}

	public ImporterMesh getImporter_mesh() {
		return (ImporterMesh) super.call("get_importer_mesh", new java.lang.Object[0]);
	}

	public void setImporter_mesh(ImporterMesh value) {
		super.call("set_importer_mesh", new java.lang.Object[]{(java.lang.Object) value});
	}
}
