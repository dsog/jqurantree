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

import org.jqurantree.arabic.encoding.ArabicDecoderBase;

/**
 * Supports decoding Unicode character data into
 * {@link org.jqurantree.arabic.ArabicText}. This class is used by the
 * {@link org.jqurantree.arabic.ArabicText#fromUnicode(String)} method. For
 * details on Unicode encoding, see the {@link UnicodeEncoder} class.
 * 
 * @author Kais Dukes
 */
public class UnicodeDecoder extends ArabicDecoderBase {

	/**
	 * Creates a new Unicode decoder instance.
	 */
	public UnicodeDecoder() {
		super(UnicodeTable.getUnicodeTable());
	}
}
