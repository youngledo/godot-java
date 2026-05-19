package org.godot.benchmarks;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Benchmarks for dispatch lookup overhead.
 *
 * These benchmarks measure the cost of dispatching method calls through the
 * generated dispatch tables (DispatchAccessor) used by godot-java. No Godot
 * instance is required.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class DispatchBenchmark {

	private Map<String, MethodHandle> methodMap;
	private ConcurrentHashMap<String, MethodHandle> concurrentMethodMap;
	private String[] classNames;
	private MethodHandle targetMethod;
	private int classNameIndex;

	@Setup
	public void setup() throws Throwable {
		// Simulate DispatchAccessor's internal maps with representative class names
		methodMap = new HashMap<>();
		concurrentMethodMap = new ConcurrentHashMap<>();

		classNames = new String[]{"Node3D", "CharacterBody3D", "RigidBody3D", "StaticBody3D", "Area3D",
				"CollisionShape3D", "MeshInstance3D", "Camera3D", "DirectionalLight3D", "OmniLight3D", "SpotLight3D",
				"Sprite3D", "Label3D", "Node", "Node2D", "Sprite2D", "AnimatedSprite2D", "TileMap",
				"ParticleProcessMaterial", "Label", "Button", "LineEdit", "TextureRect", "ColorRect", "Panel",
				"Control", "Viewport", "SubViewport", "Window", "SceneTree", "Engine", "Input", "InputMap",
				"ResourceLoader", "ResourceSaver", "OS", "Geometry2D", "Geometry3D", "PhysicsServer2D",
				"PhysicsServer3D", "RenderingServer",};

		targetMethod = MethodHandles.lookup().findVirtual(DispatchBenchmark.class, "dummyDispatch",
				MethodType.methodType(Object.class, String.class, int.class));

		for (String name : classNames) {
			methodMap.put(name, targetMethod);
			concurrentMethodMap.put(name, targetMethod);
		}

		classNameIndex = 0;
	}

	@SuppressWarnings("unused")
	public Object dummyDispatch(String className, int value) {
		return value;
	}

	/**
	 * HashMap lookup by class name. Simulates Dispatch.getParentClass(),
	 * Dispatch.getMethods(), etc.
	 */
	@Benchmark
	public MethodHandle hashMapLookup() {
		String key = classNames[(classNameIndex++) % classNames.length];
		return methodMap.get(key);
	}

	/**
	 * HashMap lookup for a missing key (negative lookup).
	 */
	@Benchmark
	public MethodHandle hashMapLookupMiss() {
		return methodMap.get("NonExistentClass");
	}

	/**
	 * ConcurrentHashMap lookup. Simulates potential concurrent dispatch scenarios.
	 */
	@Benchmark
	public MethodHandle concurrentHashMapLookup() {
		String key = classNames[(classNameIndex++) % classNames.length];
		return concurrentMethodMap.get(key);
	}

	/**
	 * Switch-based method dispatch. Simulates generated ptrcall dispatch where
	 * method names are dispatched via switch statement.
	 */
	@Benchmark
	public int switchDispatch() {
		String method = classNames[(classNameIndex++) % classNames.length];
		return switchDispatchInternal(method);
	}

	/**
	 * MethodHandle invoke with arguments. Simulates the actual dispatch call after
	 * the method is resolved from the map.
	 */
	@Benchmark
	public Object methodHandleDispatch() throws Throwable {
		String key = classNames[(classNameIndex++) % classNames.length];
		MethodHandle mh = methodMap.get(key);
		return mh.invoke(this, key, 42);
	}

	/**
	 * Full dispatch pipeline: map lookup + MethodHandle invocation. This is the
	 * closest simulation of the real Dispatch.dispatchPtrcall path.
	 */
	@Benchmark
	public Object fullDispatchPipeline() throws Throwable {
		String key = classNames[(classNameIndex++) % classNames.length];
		MethodHandle mh = methodMap.get(key);
		if (mh == null)
			return null;
		return mh.invoke(this, key, 42);
	}

	private int switchDispatchInternal(String method) {
		return switch (method) {
			case "Node3D" -> 1;
			case "CharacterBody3D" -> 2;
			case "RigidBody3D" -> 3;
			case "StaticBody3D" -> 4;
			case "Area3D" -> 5;
			case "CollisionShape3D" -> 6;
			case "MeshInstance3D" -> 7;
			case "Camera3D" -> 8;
			case "DirectionalLight3D" -> 9;
			case "OmniLight3D" -> 10;
			case "SpotLight3D" -> 11;
			case "Sprite3D" -> 12;
			case "Label3D" -> 13;
			case "Node" -> 14;
			case "Node2D" -> 15;
			case "Sprite2D" -> 16;
			case "AnimatedSprite2D" -> 17;
			case "TileMap" -> 18;
			case "Label" -> 19;
			case "Button" -> 20;
			case "LineEdit" -> 21;
			case "TextureRect" -> 22;
			case "ColorRect" -> 23;
			case "Panel" -> 24;
			case "Control" -> 25;
			case "Viewport" -> 26;
			case "SubViewport" -> 27;
			case "Window" -> 28;
			case "SceneTree" -> 29;
			case "Engine" -> 30;
			case "Input" -> 31;
			case "InputMap" -> 32;
			case "ResourceLoader" -> 33;
			case "ResourceSaver" -> 34;
			case "OS" -> 35;
			case "Geometry2D" -> 36;
			case "Geometry3D" -> 37;
			case "PhysicsServer2D" -> 38;
			case "PhysicsServer3D" -> 39;
			case "RenderingServer" -> 40;
			default -> 0;
		};
	}
}
