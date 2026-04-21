package org.godot.node;

import org.godot.Godot;
import org.godot.core.Callable;
import org.godot.collection.GodotArray;
import org.godot.bridge.Bridge;
import org.godot.core.GodotStringName;
import org.godot.internal.api.ApiIndex;
import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all Godot scene nodes. Wraps the native Godot Node object and
 * provides the standard Node API.
 *
 * <pre>{@code
 * public class MyNode extends Node {
 * 	protected void _ready() {
 * 		Godot.log("Node ready!");
 * 	}
 * }
 * }</pre>
 */
public class Node extends Godot {

	/**
	 * Godot class name for method bind lookup.
	 */
	private static final String GODOT_CLASS_NAME = "Node";

	private static final java.util.Map<String, Long> METHOD_HASHES = java.util.Map.of("set_name", 3304788590L,
			"get_name", 2002593661L, "add_child", 3863233950L, "remove_child", 1078189570L, "get_children", 873284517L,
			"get_node", 2734337346L);

	/**
	 * Node name (for debugging).
	 */
	protected String name;

	// ------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------

	/**
	 * Create a Node wrapper for an existing native node.
	 */
	protected Node(long nativeObject) {
		super(nativeObject);
	}

	protected Node(java.lang.foreign.MemorySegment nativePtr) {
		super(nativePtr);
	}

	/**
	 * Create a new Node wrapper with no native object. Used by createInstanceFunc.
	 */
	public Node() {
		super(0);
	}

	/**
	 * Create a new native Godot Node and return a wrapper for it. Use this when you
	 * need to programmatically create nodes from Java.
	 */
	public static Node create() {
		GodotStringName nodeClass = GodotStringName.fromJavaString("Node");
		MemorySegment nativePtr = Bridge.callPtr(ApiIndex.CLASSDB_CONSTRUCT_OBJECT, nodeClass.segment());
		return new Node(nativePtr);
	}

	// ------------------------------------------------------------------------
	// Node lifecycle
	// ------------------------------------------------------------------------

	/**
	 * Wrap an existing native Godot object as a Node instance.
	 */
	private static Node wrapNativeNode(Godot godot) {
		// Create a bare Node wrapper with the native object pointer
		return new Node(godot.getPtr());
	}

	/**
	 * Create a Node wrapper for an existing native pointer. Use this to wrap
	 * objects constructed via ClassDB.
	 */
	public static Node fromNativePointer(long nativePtr) {
		if (nativePtr == 0)
			return null;
		return new Node(nativePtr);
	}

	/**
	 * Called when the node enters the scene tree. Override in subclasses to perform
	 * initialization.
	 */
	public void _ready() {
	}

	/**
	 * Called every frame. Override to add per-frame logic.
	 *
	 * @param delta
	 *            Time since last frame in seconds
	 */
	public void _process(double delta) {
	}

	/**
	 * Called every physics frame. Override for physics logic.
	 *
	 * @param delta
	 *            Time since last physics frame in seconds
	 */
	public void _physicsProcess(double delta) {
	}

	// ------------------------------------------------------------------------
	// Scene tree navigation
	// ------------------------------------------------------------------------

	/**
	 * Get a child node by path (e.g., "Sprite2D" or "Player/HealthBar").
	 *
	 * @param path
	 *            Node path relative to this node
	 * @return Child node, or null if not found
	 */
	public Node getNode(String path) {
		if (!isValid())
			return null;
		Object result = call("get_node", path);
		if (result instanceof Godot) {
			return wrapNativeNode((Godot) result);
		}
		return null;
	}

	/**
	 * Get all child nodes.
	 *
	 * @return List of direct children
	 */
	public List<Node> getChildren() {
		if (!isValid())
			return new ArrayList<>();
		Object result = call("get_children");
		if (result instanceof GodotArray array) {
			List<Node> children = new ArrayList<>();
			for (int i = 0; i < array.size(); i++) {
				Object elem = array.get(i);
				if (elem instanceof Godot godot) {
					children.add(wrapNativeNode(godot));
				}
			}
			return children;
		}
		return new ArrayList<>();
	}

	/**
	 * Add a child node.
	 *
	 * @param child
	 *            The node to add
	 */
	public void addChild(Node child) {
		if (!isValid() || child == null)
			return;
		call("add_child", child);
	}

	/**
	 * Remove a child node.
	 *
	 * @param child
	 *            The node to remove
	 */
	public void removeChild(Node child) {
		if (!isValid() || child == null)
			return;
		call("remove_child", child);
	}

	/**
	 * Get the node's name.
	 */
	public String getName() {
		if (!isValid())
			return name;
		var result = call("get_name");
		if (result instanceof String s) {
			name = s;
			return s;
		}
		return name;
	}

	/**
	 * Set the node's name.
	 */
	public void setName(String name) {
		this.name = name;
		if (isValid()) {
			call("set_name", name);
		}
	}

	// ------------------------------------------------------------------------
	// Signal / connection
	// ------------------------------------------------------------------------

	/**
	 * Connect a signal to a callable.
	 *
	 * @param signal
	 *            Name of the signal (e.g., "pressed")
	 * @param callable
	 *            Callable to invoke
	 * @param flags
	 *            Connection flags (e.g., CONNECT_DEFERRED)
	 * @return true if connected
	 */
	@Override
	public boolean connect(String signal, Callable callable, int flags) {
		return super.connect(signal, callable, flags);
	}

	// ------------------------------------------------------------------------
	// Lifecycle callbacks (called from native side)
	// ------------------------------------------------------------------------

	/**
	 * Called by Godot when the node enters the scene tree. Forwards to _ready()
	 * which subclasses override.
	 */
	void _onEnterTree() {
		_ready();
	}

	/**
	 * Called by Godot on every frame. Forwards to _process() which subclasses
	 * override.
	 */
	void _onProcess(double delta) {
		_process(delta);
	}

	/**
	 * Called by Godot on every physics frame. Forwards to _physicsProcess() which
	 * subclasses override.
	 */
	void _onPhysicsProcess(double delta) {
		_physicsProcess(delta);
	}

	@Override
	public String toString() {
		String n = name != null ? name : "unnamed";
		return "Node[" + n + "@" + Long.toHexString(nativeObject) + "]";
	}

	@Override
	protected String getGodotClassName() {
		return "Node";
	}
}
