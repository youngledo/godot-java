package org.godot.core;

/**
 * Wrapper for Godot RID (Resource ID) values.
 *
 * <p>
 * Preserves type identity through Java-Godot round-trips. Without this wrapper,
 * {@code get_rid()} returns a Long that gets converted back to an INT Variant
 * instead of an RID Variant, causing type mismatches.
 */
public final class Rid {
	private final long id;

	public Rid(long id) {
		this.id = id;
	}

	public long id() {
		return id;
	}

	@Override
	public String toString() {
		return "Rid(" + id + ")";
	}
}
