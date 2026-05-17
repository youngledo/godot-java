package org.godot.annotation;

import java.lang.annotation.*;

/**
 * Marks a method as an RPC (Remote Procedure Call) endpoint for Godot
 * multiplayer. The annotated method is automatically registered with
 * {@code rpc_config()} during class initialization.
 *
 * <p>
 * Mirrors gdext's {@code #[rpc]} attribute.
 *
 * <p>
 * Example:
 *
 * <pre>
 * &#64;GodotClass(name = "Player", parent = "CharacterBody3D")
 * public class Player extends CharacterBody3D {
 * 	&#64;Rpc(mode = RpcMode.ANY_PEER, callLocal = true)
 * 	public void setPosition(double x, double y, double z) { ... }
 * }
 * </pre>
 *
 * <p>
 * Only valid on methods of {@code Node} subclasses.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Rpc {
	RpcMode mode() default RpcMode.DISABLED;

	TransferMode transfer() default TransferMode.RELIABLE;

	boolean callLocal() default false;

	int channel() default 0;
}
