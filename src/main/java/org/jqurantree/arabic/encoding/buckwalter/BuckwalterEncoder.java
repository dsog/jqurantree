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

package org.jqurantree.arabic.encoding.buckwalter;

import org.jqurantree.arabic.encoding.ArabicEncoderBase;

/**
 * Supports encoding {@link org.jqurantree.arabic.ArabicText} into Buckwalter
 * transliteration. This class is used by the
 * {@link org.jqurantree.arabic.ArabicText#toBuckwalter()} method.
 * <p>
 * Buckwalter transliteration uses ASCII characters to represent Arabic
 * orthography. As there is a one-to-one correspondence with Unicode, the
 * encoding scheme is reversible. JQuranTree uses a superset of Buckwalter
 * transliteration. There are 4 non-arabic characters in the original encoding
 * scheme with are not found in the Quranic text: P (Peh), J (Tcheh), V (Veh)
 * and G (Gaf). The combination character <i>Alif + Maddah</i> (|) is also not
 * used in Tanzil XML. These characters are not implemented by this encoder.
 * Likewise, 14 Quranic symbols do not feature in the original scheme. The
 * encoder assigns these to ASCII punctuation marks.
 * 
 * @author Kais Dukes
 */
public class BuckwalterEncoder extends ArabicEncoderBase {

	/**
	 * Creates a new Buckwalter encoder.
	 */
	public BuckwalterEncoder() {
		super(BuckwalterTable.getBuckwalterTable());
	}
}
