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

package org.jqurantree.arabic.encoding.simple;

import org.jqurantree.arabic.ByteFormat;
import org.jqurantree.arabic.CharacterType;
import org.jqurantree.arabic.DiacriticType;
import org.jqurantree.arabic.encoding.ArabicEncoderBase;

/**
 * Supports encoding {@link org.jqurantree.arabic.ArabicText} into simple
 * encoding. This class is used by the
 * {@link org.jqurantree.arabic.ArabicText#toSimpleEncoding()} method. Simple
 * encoding is an easy to read encoding scheme that shows the name of each
 * letter within Arabic text, together with the names of any attached
 * diacritics. Each character will be seperated by a | sign (vertical bar), with
 * diacritics within a character seperated by a + (plus) sign.
 * 
 * @author Kais Dukes
 */
public class SimpleEncoder extends ArabicEncoderBase {

	/**
	 * Creates a new simple encoder.
	 */
	public SimpleEncoder() {
	}

	protected void encodeCharacter(byte[] buffer, int offset) {

		// Whitespace.
		if (buffer[offset] == ByteFormat.WHITESPACE) {

			text.append("<space>");

		} else {

			// Character type.
			CharacterType characterType = CharacterType.valueOf(buffer[offset]);

			// AlifKhanjareeya
			if (characterType == CharacterType.Alif
					&& ByteFormat.isSingleDiacritic(buffer, offset,
							DiacriticType.AlifKhanjareeya)) {
				text.append("AlifKhanjareeya");
			} else {

				// Character.
				text.append(characterType);

				// Diacritics.
				for (DiacriticType diacriticType : DiacriticType.values) {
					if (ByteFormat.isDiacritic(buffer, offset, diacriticType)) {
						text.append(" + ");
						text.append(diacriticType);
					}
				}
			}
		}
	}

	protected void writeCharacterSeperator() {

		// Seperator.
		text.append(" | ");
	}
}
