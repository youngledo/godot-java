package org.godot.node;

import java.lang.foreign.MemorySegment;
import java.util.Map;
import org.godot.core.RefCounted;

public class Crypto extends RefCounted {
	private static final Map<String, Long> METHOD_HASHES = java.util.Map.ofEntries(
			java.util.Map.entry("hmac_digest", 2368951203L),
			java.util.Map.entry("generate_self_signed_certificate", 492266173L),
			java.util.Map.entry("constant_time_compare", 1024142237L), java.util.Map.entry("generate_rsa", 1237515462L),
			java.util.Map.entry("generate_random_bytes", 47165747L), java.util.Map.entry("encrypt", 2361793670L),
			java.util.Map.entry("sign", 1673662703L), java.util.Map.entry("verify", 2805902225L),
			java.util.Map.entry("decrypt", 2361793670L));

	Crypto(MemorySegment nativePointer) {
		super(nativePointer);
	}

	Crypto(long nativePointer) {
		super(nativePointer);
	}

	public byte[] generate_random_bytes(long size) {
		return (byte[]) super.call("generate_random_bytes", new java.lang.Object[]{java.lang.Long.valueOf(size)});
	}

	public CryptoKey generate_rsa(long size) {
		return (CryptoKey) super.call("generate_rsa", new java.lang.Object[]{java.lang.Long.valueOf(size)});
	}

	public X509Certificate generate_self_signed_certificate(CryptoKey key, String issuer_name, String not_before,
			String not_after) {
		return (X509Certificate) super.call("generate_self_signed_certificate",
				new java.lang.Object[]{(java.lang.Object) key, (java.lang.Object) issuer_name,
						(java.lang.Object) not_before, (java.lang.Object) not_after});
	}

	public byte[] sign(int hash_type, byte[] hash, CryptoKey key) {
		return (byte[]) super.call("sign", new java.lang.Object[]{java.lang.Integer.valueOf(hash_type),
				(java.lang.Object) hash, (java.lang.Object) key});
	}

	public boolean verify(int hash_type, byte[] hash, byte[] signature, CryptoKey key) {
		return (boolean) super.call("verify", new java.lang.Object[]{java.lang.Integer.valueOf(hash_type),
				(java.lang.Object) hash, (java.lang.Object) signature, (java.lang.Object) key});
	}

	public byte[] encrypt(CryptoKey key, byte[] plaintext) {
		return (byte[]) super.call("encrypt",
				new java.lang.Object[]{(java.lang.Object) key, (java.lang.Object) plaintext});
	}

	public byte[] decrypt(CryptoKey key, byte[] ciphertext) {
		return (byte[]) super.call("decrypt",
				new java.lang.Object[]{(java.lang.Object) key, (java.lang.Object) ciphertext});
	}

	public byte[] hmac_digest(int hash_type, byte[] key, byte[] msg) {
		return (byte[]) super.call("hmac_digest", new java.lang.Object[]{java.lang.Integer.valueOf(hash_type),
				(java.lang.Object) key, (java.lang.Object) msg});
	}

	public boolean constant_time_compare(byte[] trusted, byte[] received) {
		return (boolean) super.call("constant_time_compare",
				new java.lang.Object[]{(java.lang.Object) trusted, (java.lang.Object) received});
	}
}
