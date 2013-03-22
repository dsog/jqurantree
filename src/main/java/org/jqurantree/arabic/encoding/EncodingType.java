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

import org.jqurantree.arabic.encoding.buckwalter.BuckwalterEncoder;
import org.jqurantree.arabic.encoding.simple.SimpleEncoder;
import org.jqurantree.arabic.encoding.unicode.UnicodeEncoder;

/**
 * The <code>EncodingType</code> enumeration specifies which encoding scheme to
 * use when encoding or decoding {@link org.jqurantree.arabic.ArabicText}.
 * 
 * @author Kais Dukes
 */
public enum EncodingType {

	/**
	 * No encoding scheme.
	 */
	None,

	/**
	 * Simple encoding, see {@link SimpleEncoder}.
	 */
	Simple,

	/**
	 * Unicode encoding, see {@link UnicodeEncoder}.
	 */
	Unicode,

	/**
	 * Buckwalter transliteration, see {@link BuckwalterEncoder}.
	 */
	Buckwalter;
}
