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

package org.jqurantree.arabic.encoding;

import java.util.HashMap;
import java.util.Map;

import org.jqurantree.arabic.CharacterType;
import org.jqurantree.arabic.DiacriticType;
import org.jqurantree.arabic.encoding.unicode.UnicodeType;

/**
 * <code>EncodingTableBase</code> provides a common implementation for tables
 * used by table-driven encoders and decoders of
 * {@link org.jqurantree.arabic.ArabicText}.
 * 
 * @author Kais Dukes
 */
public abstract class EncodingTableBase {

	private final Map<Character, EncodingTableItem> unicodeMap = new HashMap<Character, EncodingTableItem>();
	private final char[] characterList = new char[CharacterType.values.length];
	private final char[] unicodeList = new char[UnicodeType.values().length];

	/**
	 * Creates a new encoding table instance.
	 */
	protected EncodingTableBase() {
	}

	/**
	 * Gets an item in the table by Unicode character.
	 * 
	 * @param unicode
	 *            the Unicode character
	 * 
	 * @return the encoding table item
	 */
	public EncodingTableItem getItem(char unicode) {
		return unicodeMap.get(unicode);
	}

	/**
	 * Gets an output character in the table by Arabic character type.
	 * 
	 * @param characterType
	 *            the type of Arabic character
	 * 
	 * @return the output character in the table
	 */
	public char getCharacter(CharacterType characterType) {
		return characterList[characterType.ordinal()];
	}

	/**
	 * Gets an output character in the table by Unicode character type.
	 * 
	 * @param unicodeType
	 *            the type of Unicode character
	 * 
	 * @return the output character in the table
	 */
	public char getCharacter(UnicodeType unicodeType) {
		return unicodeList[unicodeType.ordinal()];
	}

	/**
	 * Adds an Arabic character to the table.
	 * 
	 * @param unicodeType
	 *            the type of Unicode character
	 * 
	 * @param ch
	 *            the output character
	 * 
	 * @param characterType
	 *            the type of Arabic character
	 */
	protected void addItem(UnicodeType unicodeType, char ch,
			CharacterType characterType) {
		addItem(unicodeType, ch, characterType, null);
	}

	/**
	 * Adds a diacritic to the table.
	 * 
	 * @param unicodeType
	 *            the type of Unicode character
	 * 
	 * @param ch
	 *            the output character
	 * 
	 * @param diacriticType
	 *            the type of diacritic
	 */
	protected void addItem(UnicodeType unicodeType, char ch,
			DiacriticType diacriticType) {
		addItem(unicodeType, ch, null, diacriticType);
	}

	/**
	 * Adds an Arabic character with an attached diacritic to the table.
	 * 
	 * @param unicodeType
	 *            the type of Unicode character
	 * 
	 * @param ch
	 *            the output character
	 * 
	 * @param characterType
	 *            the type of Arabic character
	 * 
	 * @param diacriticType
	 *            the type of diacritic
	 */
	protected void addItem(UnicodeType unicodeType, char ch,
			CharacterType characterType, DiacriticType diacriticType) {

		// Create the item that will be added to the table.
		EncodingTableItem item = new EncodingTableItem(characterType,
				diacriticType);

		// Unicode --> item
		unicodeMap.put(ch, item);

		// Character type --> Unicode
		if (characterType != null && diacriticType == null) {
			characterList[characterType.ordinal()] = ch;
		}

		// Unicode type --> Unicode
		unicodeList[unicodeType.ordinal()] = ch;
	}
}
