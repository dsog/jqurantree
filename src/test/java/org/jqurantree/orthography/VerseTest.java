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

package org.jqurantree.orthography;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VerseTest {

	@Test
	public void testLocation() {

		// Test location.
		Location location = Document.getVerse(82, 3).getLocation();
		assertEquals(82, location.getChapterNumber());
		assertEquals(3, location.getVerseNumber());
	}

	@Test
	public void testTokenCount() {

		// Count verses.
		assertEquals(4, Document.getVerse(1, 5).getTokenCount());
		assertEquals(74, Document.getVerse(2, 102).getTokenCount());
		assertEquals(2, Document.getVerse(81, 16).getTokenCount());
	}

	@Test
	public void testText() {

		// (1:1) Bismillahi Arahmani Raheem
		String actualText = Document.getVerse(1, 1).toString();
		assertEquals("(1:1) bisomi {ll~ahi {lr~aHoma`ni {lr~aHiymi", actualText);
	}

	@Test
	public void testEnumerateTokens() {

		// Test that we can enumerate through each token for verse (91:8).
		Verse verse = Document.getVerse(91, 8);
		int tokenNumber = 0;
		for (Token token : verse.getTokens()) {
			assertEquals(91, token.getChapterNumber());
			assertEquals(8, token.getVerseNumber());
			assertEquals(++tokenNumber, token.getTokenNumber());
		}

		// We should have read 3 tokens.
		assertEquals(3, tokenNumber);
	}
}
