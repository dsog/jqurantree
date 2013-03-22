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
import static org.junit.Assert.fail;

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;
import org.junit.Test;

public class DocumentTest {

	@Test
	public void testDocumentName() {

		// Test the document name.
		assertEquals("The Holy Quran", Document.getName());
	}

	@Test
	public void testChapterCount() {

		// Test that the total number of chapters is as expected.
		assertEquals(114, Document.getChapterCount());
	}

	@Test
	public void testGetChapter() {

		// Test that we can retrieve chapters by chapter number.
		assertEquals(1, Document.getChapter(1).getChapterNumber());
		assertEquals(30, Document.getChapter(30).getChapterNumber());

		// Test that we can retrieve chapters by location.
		Location location = new Location(114);
		assertEquals(114, Document.getChapter(location).getChapterNumber());
	}

	@Test
	public void testGetVerse() {

		// Test that we can retrieve a verse by location.
		Verse verse = Document.getVerse(new Location(81, 3));
		assertEquals(81, verse.getChapterNumber());
		assertEquals(3, verse.getVerseNumber());
	}

	@Test
	public void testEnumerateChapters() {

		// Test that we can enumerate through each chapter.
		int chapterNumber = 0;
		for (Chapter chapter : Document.getChapters()) {
			assertEquals(++chapterNumber, chapter.getChapterNumber());
		}

		// We should have read 114 chapters.
		assertEquals(114, chapterNumber);
	}

	@Test
	public void testEnumerateVerses() {

		// Test that we can enumerate through all verses.
		int chapterNumber = 0;
		int verseNumber = 0;
		int verseCount = 0;
		for (Verse verse : Document.getVerses()) {

			// New chapter?
			if (verse.getVerseNumber() == 1) {
				assertEquals(++chapterNumber, verse.getChapterNumber());
				verseNumber = 0;
			}

			// Validate verse.
			assertEquals(++verseNumber, verse.getVerseNumber());
			verseCount++;
		}

		// We should have read 114 chapters, and 6236 verses.
		assertEquals(114, chapterNumber);
		assertEquals(6236, verseCount);
		assertEquals(6236, Document.getVerseCount());
	}

	@Test
	public void testEnumerateTokens() {

		// Test that we can enumerate through all tokens.
		int chapterNumber = 0;
		int verseNumber = 0;
		int tokenNumber = 0;
		int tokenCount = 0;
		for (Token token : Document.getTokens()) {

			// New chapter?
			if (token.getVerseNumber() == 1 && token.getTokenNumber() == 1) {
				chapterNumber++;
				verseNumber = 0;
			}

			// New verse?
			if (token.getTokenNumber() == 1) {
				verseNumber++;
				tokenNumber = 0;
			}

			// Validate token.
			assertEquals(chapterNumber, token.getChapterNumber());
			assertEquals(verseNumber, token.getVerseNumber());
			assertEquals(++tokenNumber, token.getTokenNumber());
			tokenCount++;
		}

		// We should have read 114 chapters, and 77430 tokens.
		assertEquals(114, chapterNumber);
		assertEquals(77430, tokenCount);
		assertEquals(77430, Document.getTokenCount());
	}

	@Test
	public void testGetInvalidChapter() {

		// Get invalid chapter.
		try {
			Document.getChapter(0);
			fail();
		} catch (JQuranTreeException exception) {
			assertEquals(Errors.INVALID_CHAPTER_NUMBER, exception.getMessage());
		}
	}

	@Test
	public void testGetInvalidLocation() {

		// Get invalid location.
		try {
			Document.getChapter(115);
			fail();
		} catch (JQuranTreeException exception) {
			assertEquals(Errors.INVALID_CHAPTER_NUMBER, exception.getMessage());
		}
	}
}
