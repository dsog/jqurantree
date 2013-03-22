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

import org.jqurantree.arabic.ArabicTextBuilder;
import org.jqurantree.arabic.CharacterType;
import org.jqurantree.arabic.DiacriticType;

/**
 * <code>ArabicDecoderBase</code> is an abstract base class providing a common
 * implementation for {@link org.jqurantree.arabic.ArabicText} decoders. The
 * class supports the
 * {@link org.jqurantree.arabic.ArabicText#fromEncoding(String, EncodingType)}
 * method by implementing table-driven decoding. An {@link EncodingTableBase}
 * instance is used to lookup the mapping for each character in the source text.
 * 
 * @author Kais Dukes
 */
public abstract class ArabicDecoderBase implements ArabicDecoder {

	private final EncodingTableBase encodingTable;
	private final ArabicTextBuilder builder = new ArabicTextBuilder();

	/**
	 * Creates a new decoder using the specified encoding table.
	 * 
	 * @param encodingTable
	 *            the encoding table to use when performing table-driven
	 *            decoding.
	 */
	protected ArabicDecoderBase(EncodingTableBase encodingTable) {
		this.encodingTable = encodingTable;
	}

	public byte[] decode(String text) {

		// Decode each Unicode character.
		int size = text.length();
		for (int i = 0; i < size; i++) {
			decode(text.charAt(i));
		}

		// Return the buffer.
		return builder.toByteArray();
	}

	private void decode(char ch) {

		// Look up character type and diacritic type.
		EncodingTableItem item = encodingTable.getItem(ch);
		if (item != null) {
			CharacterType characterType = item.getCharacterType();
			DiacriticType diacriticType = item.getDiacriticType();

			// Add character.
			if (characterType != null) {
				builder.add(characterType);
			}

			// Add diacritic.
			if (diacriticType != null) {
				builder.add(diacriticType);
			}

		} else {

			// Treat any unknown characters as whitespace.
			builder.addWhitespace();
		}
	}
}
