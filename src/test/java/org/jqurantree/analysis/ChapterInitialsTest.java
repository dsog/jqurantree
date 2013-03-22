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

package org.jqurantree.analysis;

import static org.junit.Assert.assertEquals;

import org.jqurantree.arabic.ArabicCharacter;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Token;
import org.junit.Test;

public class ChapterInitialsTest {

	@Test
	public void testInitials() {

		// Initiate the Analysis table.
		AnalysisTable table = new AnalysisTable("ChapterNumber", "VerseNumber",
				"Token");
		
		// Check each token in the Quranic text.
		for (Token token : Document.getTokens()) {

			// The token is not what we are looking for if it has a diacritic
			// other than a maddah.
			boolean isValid = true;
			for (ArabicCharacter ch : token) {
				if (!ch.isMaddah() && ch.getDiacriticCount() != 0) {
					isValid = false;
					break;
				}
			}

			// If this token has only maddah for diacritics, then add it to the
			// analysis table.
			if (isValid) {
				table.add(token.getChapterNumber(), token.getVerseNumber(),
						token.toSimpleEncoding());
			}
		}

		// Validate results.
		int[] chapterNumbers = new int[] { 2, 3, 7, 10, 11, 12, 13, 14, 15, 19,
				20, 26, 27, 28, 29, 30, 31, 32, 36, 38, 40, 41, 42, 42, 43, 44,
				45, 46, 50, 68 };
		int[] verseNumbers = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1 };
		int size = verseNumbers.length;
		assertEquals(size, table.getRowCount());
		for (int i = 0; i < size; i++) {
			assertEquals(chapterNumbers[i], table.getValue(i, "ChapterNumber"));
			assertEquals(verseNumbers[i], table.getValue(i, "VerseNumber"));
		}
	}
}
