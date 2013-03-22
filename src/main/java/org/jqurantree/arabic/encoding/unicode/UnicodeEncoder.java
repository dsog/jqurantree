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

package org.jqurantree.arabic.encoding.unicode;

import org.jqurantree.arabic.encoding.ArabicEncoderBase;

/**
 * Supports encoding {@link org.jqurantree.arabic.ArabicText} into Unicode
 * character data. This class is used by the
 * {@link org.jqurantree.arabic.ArabicText#toUnicode()} method.
 * <p>
 * Unicode is supported to allow the Tanzil XML representation of the Quran to
 * be loaded into the orthography model. Since the Unicode encoder need only
 * support the Uthmani Script, it is sufficient to handle only the characters
 * found within the XML document. Unicode encoding is performed using table
 * lookup. A single {@link org.jqurantree.arabic.ArabicCharacter} may be encoded
 * as several Unicode characters, one for the Arabic letter or Quranic symbol,
 * and the others for any attached diacritics.
 * 
 * @author Kais Dukes
 */
public class UnicodeEncoder extends ArabicEncoderBase {

	/**
	 * Creates a new Unicode encoder.
	 */
	public UnicodeEncoder() {
		super(UnicodeTable.getUnicodeTable());
	}
}
