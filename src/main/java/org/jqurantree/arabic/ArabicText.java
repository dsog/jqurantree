/* Copyright (C) Kais Dukes, 2009.
 * 
 * This file is part of JQuranTree.
 * 
 * JQuranTree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQuranTree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQuranTree. If not, see <http://www.gnu.org/licenses/>.
 */

package org.jqurantree.arabic;

import java.util.Iterator;

import org.jqurantree.arabic.encoding.ArabicEncoder;
import org.jqurantree.arabic.encoding.EncodingFactory;
import org.jqurantree.arabic.encoding.EncodingOptions;
import org.jqurantree.arabic.encoding.EncodingType;
import org.jqurantree.arabic.encoding.buckwalter.BuckwalterDecoder;
import org.jqurantree.arabic.encoding.buckwalter.BuckwalterEncoder;
import org.jqurantree.arabic.encoding.simple.SimpleEncoder;
import org.jqurantree.arabic.encoding.unicode.UnicodeDecoder;
import org.jqurantree.arabic.encoding.unicode.UnicodeEncoder;

/**
 * <code>ArabicText</code> is an immutable sequence of
 * {@link org.jqurantree.arabic.ArabicCharacter ArabicCharacters}. This class is
 * analogous to the Java <code>String</code> class, where a <code>String</code>
 * is an immutable sequence of 2-byte Unicode characters. The character data in
 * <code>ArabicText</code> is stored in a <code>byte[]</code> buffer, with a
 * fixed width for each letter, including its diacritics.
 * <code>ArabicCharacter</code> instances are a view on the buffer. They are
 * created on demand and are garbage collected. See {@link ByteFormat} for
 * details on the internal byte format used.
 * 
 * @author Kais Dukes
 */
public class ArabicText implements Iterable<ArabicCharacter> {

	/**
	 * The <code>byte[]</code> buffer holding the character data.
	 */
	protected final byte[] buffer;

	/**
	 * The offset to the first character in the buffer.
	 */
	protected final int offset;

	/**
	 * The number of characters in the text. Each character is represented by 3
	 * bytes in the buffer.
	 */
	protected final int characterCount;

	ArabicText(byte[] buffer) {
		this(buffer, 0, buffer.length / ByteFormat.CHARACTER_WIDTH);
	}

	ArabicText(String text, EncodingType encodingType) {
		this(EncodingFactory.getDecoder(encodingType).decode(text));
	}

	/**
	 * Used internally to create a new Arabic text instance, when constructing
	 * the orthography model.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer holding the character data
	 * 
	 * @param offset
	 *            the offset of the first character in the buffer
	 * 
	 * @param characterCount
	 *            the number of characters in the text, each character is
	 *            represented by 3 bytes in the buffer
	 */
	protected ArabicText(byte[] buffer, int offset, int characterCount) {
		this.buffer = buffer;
		this.offset = offset;
		this.characterCount = characterCount;
	}

	/**
	 * Creates a new Arabic text instance from Unicode character data.
	 * 
	 * @param text
	 *            a <code>string</code> holding the text, which will be decoded
	 *            from Unicode character data
	 * 
	 * @see UnicodeDecoder
	 */
	public ArabicText(String text) {
		this(text, EncodingType.Unicode);
	}

	/**
	 * Converts Unicode character data into Arabic text.
	 * 
	 * @param text
	 *            a <code>string</code> holding the text, which will be decoded
	 *            from Unicode character data
	 * 
	 * @return a new Arabic text instance
	 * 
	 * @see UnicodeDecoder
	 */
	public static ArabicText fromUnicode(String text) {
		return fromEncoding(text, EncodingType.Unicode);
	}

	/**
	 * Converts Buckwalter transliteration into Arabic text.
	 * 
	 * @param text
	 *            a <code>string</code> holding the text, which will be decoded
	 *            from Buckwalter transliteration
	 * 
	 * @return a new Arabic text instance
	 * 
	 * @see BuckwalterDecoder
	 */
	public static ArabicText fromBuckwalter(String text) {
		return fromEncoding(text, EncodingType.Buckwalter);
	}

	/**
	 * Decodes a <code>string</code> into Arabic text, according to the
	 * specified encoding scheme.
	 * 
	 * @param text
	 *            the <code>string</code> to decode
	 * 
	 * @param encodingType
	 *            the encoding scheme to use
	 * 
	 * @return a new Arabic text instance
	 */
	public static ArabicText fromEncoding(String text, EncodingType encodingType) {
		return new ArabicText(text, encodingType);
	}

	/**
	 * Converts the Arabic text to Unicode.
	 * 
	 * @return a <code>string</code> representing the Arabic text as Unicode
	 *         character data
	 * 
	 * @see UnicodeEncoder
	 */
	@Override
	public String toString() {
		return toString(EncodingType.Unicode, null);
	}

	/**
	 * Converts the Arabic text to a <code>string</code> according the specified
	 * encoding scheme.
	 * 
	 * @param encodingType
	 *            the encoding scheme to use
	 * 
	 * @return a <code>string</code> representing the Arabic text
	 */
	public String toString(EncodingType encodingType) {
		return toString(encodingType, null);
	}

	/**
	 * Converts the Arabic text to a <code>string</code> according the specified
	 * encoding scheme and encoding options.
	 * 
	 * @param encodingType
	 *            the encoding scheme to use
	 * 
	 * @param options
	 *            the encoding options to use when encoding the text
	 * 
	 * @return a <code>string</code> representing the Arabic text
	 */
	public String toString(EncodingType encodingType, EncodingOptions options) {
		ArabicEncoder encoder = EncodingFactory.getEncoder(encodingType);
		return encoder.encode(buffer, offset, characterCount, options);
	}

	/**
	 * Converts the Arabic text to Unicode.
	 * 
	 * @return a <code>string</code> representing the Arabic text as Unicode
	 *         character data
	 * 
	 * @see UnicodeEncoder
	 */
	public String toUnicode() {
		return toString(EncodingType.Unicode);
	}

	/**
	 * Converts the Arabic text to Buckwalter transliteration.
	 * 
	 * @return a <code>string</code> representing the Arabic text using
	 *         Buckwalter transliteration
	 * 
	 * @see BuckwalterEncoder
	 */
	public String toBuckwalter() {
		return toString(EncodingType.Buckwalter);
	}

	/**
	 * Converts the Arabic text to simple encoding.
	 * 
	 * @return a <code>string</code> representing the Arabic text using simple
	 *         encoding
	 * 
	 * @see SimpleEncoder
	 */
	public String toSimpleEncoding() {
		return toString(EncodingType.Simple);
	}

	/**
	 * Gets the number of characters in the text. Each Arabic letter or Quranic
	 * symbol, including any attached diacritics, counts as a single character.
	 * 
	 * @return the number of characters, a positive integer
	 */
	public int getLength() {
		return characterCount;
	}

	/**
	 * Gets the <code>ArabicCharacter</code> at the specified index. The index
	 * is zero-based, ranging from <code>0</code> to
	 * <code>getLength() - 1</code>, inclusive.
	 * 
	 * @param index
	 *            the zero-based index of the character
	 * @return the <code>ArabicCharacter</code> at the specified index
	 */
	public ArabicCharacter getCharacter(int index) {
		return new ArabicCharacter(buffer, offset + index
				* ByteFormat.CHARACTER_WIDTH);
	}

	/**
	 * Gets the type of <code>ArabicCharacter</code> at the specified index. The
	 * index is zero-based, ranging from <code>0</code> to
	 * <code>getLength() - 1</code>, inclusive.
	 * 
	 * @param index
	 *            the zero-based index of the character
	 * 
	 * @return the type of Arabic letter or Quranic symbol at the specified
	 *         index, such as <i>Alif</i> or <i>Ba</i>
	 */
	public CharacterType getCharacterType(int index) {
		byte value = buffer[offset + index * ByteFormat.CHARACTER_WIDTH];
		return value != ByteFormat.WHITESPACE ? CharacterType.values[value]
				: null;
	}

	/**
	 * Gets an iterator which may be used to enumerate through each character in
	 * the text.
	 * 
	 * @return an <code>ArabicCharacter</code> iterator
	 */
	public Iterator<ArabicCharacter> iterator() {
		return new CharacterIterator(buffer, offset, characterCount);
	}

	/**
	 * Gets a new <code>ArabicText</code> instance that is a substring of this
	 * instance. The substring begins at the specified <code>start</code> index,
	 * and ends before the character at the specified <code>end</code> index.
	 * The length of the substring will be <code>end - start</code>.
	 * 
	 * @param start
	 *            the zero-based start index of the substring, inclusive.
	 * @param end
	 *            the zero-based end index of the substring, exclusive.
	 * 
	 * @return the specified substring as Arabic text
	 */
	public ArabicText getSubstring(int start, int end) {
		return new ArabicText(buffer, offset + start
				* ByteFormat.CHARACTER_WIDTH, end - start);
	}

	/**
	 * Gets a new <code>ArabicText</code> instance that is a copy of this
	 * instance excluding any attached diacritics. The number of
	 * <code>ArabicCharacters</code> in both strings will be equal. The returned
	 * string will not have any attached diacritics, so calls to methods such as
	 * {@link ArabicCharacter#isFatha()} will return <code>false</code>.
	 * 
	 * @return a new Arabic text instance without diacritics
	 */
	public ArabicText removeDiacritics() {

		// Create a new buffer.
		byte[] buffer = new byte[characterCount * ByteFormat.CHARACTER_WIDTH];

		// Initiate offsets.
		int offset1 = 0;
		int offset2 = offset;

		// Copy characters.
		for (int i = 0; i < characterCount; i++) {
			buffer[offset1] = this.buffer[offset2];
			offset1 += ByteFormat.CHARACTER_WIDTH;
			offset2 += ByteFormat.CHARACTER_WIDTH;
		}

		// Return text without diacritics.
		return new ArabicText(buffer, 0, characterCount);
	}

	/**
	 * Gets the number of Arabic letters, which is the number of
	 * <code>ArabicCharacters</code> excluding any Quranic symbols. The value
	 * returned will always be less or equal to <code>getLength()</code>.
	 * 
	 * @return the number of Arabic letters in the text
	 */
	public int getLetterCount() {

		// Initiate.
		int count = 0;
		int offset = this.offset;
		for (int i = 0; i < characterCount; i++) {

			// Letter?
			if (ByteFormat.isLetter(buffer, offset)) {
				count++;
			}

			// Increment offset.
			offset += ByteFormat.CHARACTER_WIDTH;
		}

		// Return letter count.
		return count;
	}

	/**
	 * Gets a new <code>ArabicText</code> instance that is a copy of this
	 * instance excluding any Quranic symbols. The returned string will have
	 * only Arabic letters, so that <code>getLetterCount() == getLength()</code>
	 * .
	 * 
	 * @return a new Arabic text instance with ony Arabic letters
	 */
	public ArabicText removeNonLetters() {

		// Default.
		ArabicText text = this;

		// Non letters?
		int letterCount = getLetterCount();
		if (letterCount != characterCount) {

			// Create a new buffer.
			byte[] buffer = new byte[letterCount * ByteFormat.CHARACTER_WIDTH];

			// Initiate offsets.
			int offset1 = 0;
			int offset2 = offset;

			// Copy letters.
			for (int i = 0; i < characterCount; i++) {

				// Letter?
				if (ByteFormat.isLetter(this.buffer, offset2)) {
					buffer[offset1] = this.buffer[offset2];
					offset1 += ByteFormat.CHARACTER_WIDTH;
				}

				// Increment offset.
				offset2 += ByteFormat.CHARACTER_WIDTH;
			}

			// Return text with letters.
			text = new ArabicText(buffer, 0, characterCount);
		}

		// Return text.
		return text;
	}
}
