package org.godot.processor;

/**
 * Converts Markdown text to Godot BBCode format for editor documentation.
 *
 * <p>
 * Handles: bold, italic, code, code blocks, headings, links, lists.
 */
final class DocConverter {

	private DocConverter() {
	}

	/**
	 * Convert Javadoc (Markdown) text to Godot BBCode.
	 */
	static String markdownToBbcode(String markdown) {
		if (markdown == null || markdown.isBlank())
			return "";

		String text = markdown.trim();

		// Code blocks: ```lang\ncode\n``` → [codeblock]code[/codeblock]
		text = text.replaceAll("```\\w*\\n", "[codeblock]\n");
		text = text.replaceAll("```", "[/codeblock]");
		text = text.replaceAll("`([^`]+)`", "[code]$1[/code]");

		// Bold: **text** or __text__ → [b]text[/b]
		text = text.replaceAll("\\*\\*(.+?)\\*\\*", "[b]$1[/b]");
		text = text.replaceAll("__(.+?)__", "[b]$1[/b]");

		// Italic: *text* or _text_ → [i]text[/i]
		text = text.replaceAll("\\*(.+?)\\*", "[i]$1[/i]");
		text = text.replaceAll("_(.+?)_", "[i]$1[/i]");

		// Links: [text](url) → [url=url]text[/url]
		text = text.replaceAll("\\[([^\\]]+)\\]\\(([^)]+)\\)", "[url=$2]$1[/url]");

		// Headings: ### text → [b]text[/b]
		text = text.replaceAll("^#{1,6}\\s+(.+)$", "[b]$1[/b]");

		// Unordered lists: - item or * item → - item (Godot accepts this)
		// Already in a compatible format

		return text.trim();
	}

	/**
	 * Escape text for XML content.
	 */
	static String escapeXml(String text) {
		if (text == null)
			return "";
		return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
	}
}
