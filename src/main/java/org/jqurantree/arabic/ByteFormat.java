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

/**
 * <code>ByteFormat</code> is a support class which is used to decode the
 * internal byte format of {@link org.jqurantree.arabic.ArabicText}. Internally,
 * Arabic text is represented by a byte buffer, with a fixed width for each
 * letter, including its diacritics. This class is used when accessing the
 * <code>byte[]</code> buffer through <code>ArabicText</code> and
 * <code>ArabicCharacter</code> method calls.
 * <p>
 * Each <code>ArabicCharacter</code> is represented by 3 bytes in the buffer.
 * The first byte encodes the character type. The second and third bytes form a
 * vector of bits. Each diacritic type has a fixed position in the bit vector,
 * and if the bit is set then the diacritic is present. The maximum range of
 * values possible in this encoding scheme would be 256 character types, and
 * combinations of 16 diacritic types. In practice, only 44
 * {@link CharacterType CharacterTypes} and 13 {@link DiacriticType
 * DiacriticTypes} are used.
 * 
 * @author Kais Dukes
 */
public class ByteFormat {

	private ByteFormat() {
	}

	static {

		// Code coverage.
		new ByteFormat();
	}

	/**
	 * The number of bytes representing each <code>ArabicCharacter</code> in the
	 * buffer.
	 */
	public static final int CHARACTER_WIDTH = 3;

	/**
	 * The buffer <code>byte</code> value representing a space delimiter.
	 */
	public static final byte WHITESPACE = -1;

	private static final int[] diacriticOffsets = { 1, 1, 1, 1, 1, 1, 1, 1, 2,
			2, 2, 2, 2 };
	private static final int[] diacriticMasks = { 1, 2, 4, 8, 16, 32, 64, 128,
			1, 2, 4, 8, 16 };

	/**
	 * Sets a diacritic as present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @param diacriticType
	 *            the type of diacritic to set
	 */
	public static void setDiacritic(byte[] buffer, int offset,
			DiacriticType diacriticType) {

		// Convert enum to integer.
		int value = diacriticType.ordinal();

		// Get offset into buffer, based on last character.
		int byteOffset = offset + diacriticOffsets[value];

		// Get bit mask.
		int bitMask = diacriticMasks[value];

		// Set bit.
		buffer[byteOffset] |= bitMask;
	}

	/**
	 * Determines if a diacritic is present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @param diacriticType
	 *            the type of diacritic
	 * 
	 * @return <code>true</code> if the diacritic is present; <code>false</code>
	 *         otherwise
	 */
	public static boolean isDiacritic(byte[] buffer, int offset,
			DiacriticType diacriticType) {

		// Convert enum to integer.
		int value = diacriticType.ordinal();

		// Get offset into buffer, based on last character.
		int byteOffset = offset + diacriticOffsets[value];

		// Get bit mask.
		int bitMask = diacriticMasks[value];

		// Get bit.
		return (buffer[byteOffset] & bitMask) != 0;
	}

	/**
	 * Determines if a <i>Fatha</i> is present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Fatha</i> is present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isFatha(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 1) != 0;
	}

	/**
	 * Determines if a <i>Damma</i> is present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Damma</i> is present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isDamma(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 2) != 0;
	}

	/**
	 * Determines if a <i>Kasra</i> is present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Kasra</i> is present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isKasra(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 4) != 0;
	}

	/**
	 * Determines if <i>Fathatan</i> are present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if <i>Fathatan</i> are present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isFathatan(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 8) != 0;
	}

	/**
	 * Determines if <i>Dammatan</i> are present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if <i>Dammatan</i> are present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isDammatan(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 16) != 0;
	}

	/**
	 * Determines if <i>Kasratan</i> are present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if <i>Kasratan</i> are present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isKasratan(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 32) != 0;
	}

	/**
	 * Determines if a <i>Shadda</i> is present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Shadda</i> is present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isShadda(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 64) != 0;
	}

	/**
	 * Determines if a <i>Sukun</i> is present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Sukun</i> is present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isSukun(byte[] buffer, int offset) {
		return (buffer[offset + 1] & 128) != 0;
	}

	/**
	 * Determines if a <i>Maddah</i> is present.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Maddah</i> is present;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isMaddah(byte[] buffer, int offset) {
		return (buffer[offset + 2] & 1) != 0;
	}

	/**
	 * Determines if a <i>Hamza</i> is present above the character.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Hamza</i> is present above the
	 *         character; <code>false</code> otherwise.
	 */
	public static boolean isHamzaAbove(byte[] buffer, int offset) {
		return (buffer[offset + 2] & 2) != 0;
	}

	/**
	 * Determines if a <i>Hamza</i> is present below the character.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if a <i>Hamza</i> is present below the
	 *         character; <code>false</code> otherwise.
	 */
	public static boolean isHamzaBelow(byte[] buffer, int offset) {
		return (buffer[offset + 2] & 4) != 0;
	}

	/**
	 * Determines if <i>Hamzat Wasl</i> is attached.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if <i>Hamzat Wasl</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isHamzatWasl(byte[] buffer, int offset) {
		return (buffer[offset + 2] & 8) != 0;
	}

	/**
	 * Determines if <i>Alif Khanjareeya</i> is attached.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if <i>Alif Khanjareeya</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isAlifKhanjareeya(byte[] buffer, int offset) {
		return (buffer[offset + 2] & 16) != 0;
	}

	/**
	 * Determines if only a single diacritic is attached.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @param diacriticType
	 *            the single diacritic
	 * @return <code>true</code> if the character has only the specified
	 *         diacritic and no others; <code>false</code> otherwise.
	 */
	public static boolean isSingleDiacritic(byte[] buffer, int offset,
			DiacriticType diacriticType) {

		// Get diacritic offset and bitmask.
		int ordinal = diacriticType.ordinal();
		int diacriticOffset = diacriticOffsets[ordinal];
		int bitMask = diacriticMasks[ordinal];

		// Validate.
		return buffer[offset + diacriticOffset] == bitMask
				&& buffer[offset + 3 - diacriticOffset] == 0;
	}

	/**
	 * Gets the number of diacritics attached to the character.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return a positive number if the character has any attached diacritics,
	 *         otherwise zero.
	 */
	public static int getDiacriticCount(byte[] buffer, int offset) {

		// Initiate.
		int count = 0;

		// Check each diacritic.
		for (int i = 0; i < 13; i++) {
			if ((buffer[offset + diacriticOffsets[i]] & diacriticMasks[i]) != 0) {
				count++;
			}
		}

		// Return diacritic count.
		return count;
	}

	/**
	 * Determines if the character is an Arabic letter.
	 * 
	 * @param buffer
	 *            the <code>byte[]</code> buffer
	 * 
	 * @param offset
	 *            the offset of the character
	 * 
	 * @return <code>true</code> if the character is an Arabic letter, and not a
	 *         Quranic symbol; <code>false</code> otherwise.
	 */
	public static boolean isLetter(byte[] buffer, int offset) {
		return buffer[offset] <= CharacterType.Tatweel.ordinal();
	}
}
