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

package org.jqurantree.examples.orthography;

import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Token;

/**
 * In this example, a token in the orthography model is converted to Buckwalter
 * transliteration. Within verse (19:7), the 6th token is selected. Buckwalter
 * transliteration is reversible encoding scheme that uses ASCII characters to
 * represent Arabic text.
 * 
 * @author Kais Dukes
 */
public class BuckwalterExample {

	public static void main() {

		// Get token #6 of verse (19:7).
		Token token = Document.getToken(19, 7, 6);

		// Display the token using Buckwalter transliteration.
		System.out.println(token.toBuckwalter());
	}
}
