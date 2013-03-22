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

import org.jqurantree.arabic.encoding.EncodingFactory;
import org.jqurantree.arabic.encoding.EncodingType;

/**
 * An <code>ArabicCharacter</code> is a single letter or Quranic symbol within
 * {@link org.jqurantree.arabic.ArabicText}, including any attached diacritics.
 * Instances of this class are <b>immutable</b> and cannot be changed. The
 * {@link #getType()} method returns the character's type, such as <i>Alif</i>
 * or <i>Ba</i>.
 * <p>
 * Methods including {@link #isFatha()} and {@link #isDamma()} test for the
 * presence of diacritics. The <code>ArabicCharacter</code> can be converted to
 * plain text using the {@link #toString()} or {@link #toString(EncodingType)}
 * methods.
 * 
 * @author Kais Dukes
 */
public class ArabicCharacter {

	private final byte[] buffer;
	private int offset;

	ArabicCharacter(byte[] buffer, int offset) {
		this.buffer = buffer;
		this.offset = offset;
	}

	/**
	 * Gets the {@link CharacterType} of the character, such as <i>Alif</i> or
	 * <i>Ba</i>.
	 * 
	 * @return the character's type, indicating which Arabic letter or Quranic
	 *         symbol the character represents.
	 */
	public CharacterType getType() {
		return CharacterType.valueOf(buffer[offset]);
	}

	/**
	 * Determines if a <i>Fatha</i> is attached.
	 * 
	 * @return <code>true</code> if a <i>Fatha</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isFatha() {
		return ByteFormat.isFatha(buffer, offset);
	}

	/**
	 * Determines if a <i>Damma</i> is attached.
	 * 
	 * @return <code>true</code> if a <i>Damma</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isDamma() {
		return ByteFormat.isDamma(buffer, offset);
	}

	/**
	 * Determines if a <i>Kasra</i> is attached.
	 * 
	 * @return <code>true</code> if a <i>Kasra</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isKasra() {
		return ByteFormat.isKasra(buffer, offset);
	}

	/**
	 * Determines if <i>Fathatan</i> are attached.
	 * 
	 * @return <code>true</code> if <i>Fathatan</i> are attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isFathatan() {
		return ByteFormat.isFathatan(buffer, offset);
	}

	/**
	 * Determines if <i>Dammatan</i> are attached.
	 * 
	 * @return <code>true</code> if <i>Dammatan</i> are attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isDammatan() {
		return ByteFormat.isDammatan(buffer, offset);
	}

	/**
	 * Determines if <i>Kasratan</i> are attached.
	 * 
	 * @return <code>true</code> if <i>Kasratan</i> are attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isKasratan() {
		return ByteFormat.isKasratan(buffer, offset);
	}

	/**
	 * Determines if a <i>Shadda</i> is attached.
	 * 
	 * @return <code>true</code> if a <i>Shadda</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isShadda() {
		return ByteFormat.isShadda(buffer, offset);
	}

	/**
	 * Determines if a <i>Sukun</i> is attached.
	 * 
	 * @return <code>true</code> if a <i>Sukun</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isSukun() {
		return ByteFormat.isSukun(buffer, offset);
	}

	/**
	 * Determines if a <i>Maddah</i> is attached.
	 * 
	 * @return <code>true</code> if a <i>Maddah</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isMaddah() {
		return ByteFormat.isMaddah(buffer, offset);
	}

	/**
	 * Determines if a <i>Hamza</i> is present above the character.
	 * 
	 * @return <code>true</code> if a <i>Hamza</i> is present above the
	 *         character; <code>false</code> otherwise.
	 */
	public boolean isHamzaAbove() {
		return ByteFormat.isHamzaAbove(buffer, offset);
	}

	/**
	 * Determines if a <i>Hamza</i> is present below the character.
	 * 
	 * @return <code>true</code> if a <i>Hamza</i> is present below the
	 *         character; <code>false</code> otherwise.
	 */
	public boolean isHamzaBelow() {
		return ByteFormat.isHamzaBelow(buffer, offset);
	}

	/**
	 * Determines if <i>Hamzat Wasl</i> is attached.
	 * 
	 * @return <code>true</code> if <i>Hamzat Wasl</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isHamzatWasl() {
		return ByteFormat.isHamzatWasl(buffer, offset);
	}

	/**
	 * Determines if <i>Alif Khanjareeya</i> is attached.
	 * 
	 * @return <code>true</code> if <i>Alif Khanjareeya</i> is attached;
	 *         <code>false</code> otherwise.
	 */
	public boolean isAlifKhanjareeya() {
		return ByteFormat.isAlifKhanjareeya(buffer, offset);
	}

	/**
	 * Determines if only a single diacritic is attached.
	 * 
	 * @param diacriticType
	 *            the single diacritic
	 * @return <code>true</code> if the character has only the specified
	 *         diacritic and no others; <code>false</code> otherwise.
	 */
	public boolean isSingleDiacritic(DiacriticType diacriticType) {
		return ByteFormat.isSingleDiacritic(buffer, offset, diacriticType);
	}

	/**
	 * Gets the number of diacritics attached to the character.
	 * 
	 * @return a positive number if the character has any attached diacritics,
	 *         otherwise zero.
	 */
	public int getDiacriticCount() {
		return ByteFormat.getDiacriticCount(buffer, offset);
	}

	/**
	 * Determines if the character is an Arabic letter.
	 * 
	 * @return <code>true</code> if the character is an Arabic letter, and not a
	 *         Quranic symbol; <code>false</code> otherwise.
	 */
	public boolean isLetter() {
		return ByteFormat.isLetter(buffer, offset);
	}

	/**
	 * Converts the character to a <code>string</code> using the default
	 * encoding scheme. For Arabic characters, the default encoding is simple
	 * encoding.
	 * 
	 * @return a string representing the character in the defaulting encoding.
	 */
	@Override
	public String toString() {
		return toString(EncodingType.Simple);
	}

	/**
	 * Converts the character to a <code>string</code> using the specified
	 * encoding type.
	 * 
	 * @return a string representing the character in the specified encoding.
	 */
	public String toString(EncodingType encodingType) {
		return EncodingFactory.getEncoder(encodingType).encode(buffer, offset,
				1, null);
	}

	/**
	 * Converts the character to Unicode.
	 * 
	 * @return a Unicode representation of the <code>ArabicCharacter</code>. A
	 *         <code>string</code> is returned and not a <code>char</code> since
	 *         a single Arabic letter with diacritics is represented by several
	 *         characters in Unicode.
	 */
	public String toUnicode() {
		return toString(EncodingType.Unicode);
	}

	/**
	 * Converts the character to a <code>string</code> using Buckwalter
	 * transliteration.
	 * 
	 * @return a string representing the character in Buckwalter
	 *         transliteration.
	 */
	public String toBuckwalter() {
		return toString(EncodingType.Buckwalter);
	}

	/**
	 * Converts the character to a <code>string</code> using simple encoding.
	 * 
	 * @return a string representing the character in simple encoding.
	 */
	public String toSimpleEncoding() {
		return toString(EncodingType.Simple);
	}
}
