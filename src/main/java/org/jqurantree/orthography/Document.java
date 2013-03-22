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

import org.jqurantree.core.collections.ArrayIterator;
import org.jqurantree.tanzil.TanzilReader;

/**
 * The top-level class in the orthography model, providing a structured
 * representation of the entire text of the Holy Quran. This class provides
 * static methods to access other elements of the orthography model, including
 * chapters, verses and tokens.
 * 
 * @author Kais Dukes
 */
public class Document {

	private static final String DOCUMENT_NAME = "The Holy Quran";
	private static final Chapter[] chapters;
	static final int CHAPTER_COUNT = 114;
	private static int verseCount = 0;
	private static int tokenCount = 0;

	static {

		// Read the chapters.
		TanzilReader reader = new TanzilReader();
		chapters = reader.readXml();

		// Code coverage.
		new Document();
	}

	private Document() {
	}

	/**
	 * Gets the name of the document.
	 * 
	 * @return "The Holy Quran"
	 */
	public static String getName() {
		return DOCUMENT_NAME;
	}

	/**
	 * Gets the number of the chapters in the document.
	 * 
	 * @return 114, the number chapters in the Holy Quran
	 */
	public static int getChapterCount() {
		return CHAPTER_COUNT;
	}

	/**
	 * Gets the number of verses in the document.
	 * 
	 * @return 6236, the number of verses in the Holy Quran
	 */
	public static int getVerseCount() {

		// If not already cached, then calculate.
		if (verseCount == 0) {

			// Count verses.
			int verseCount = 0;
			for (Chapter chapter : chapters) {
				verseCount += chapter.getVerseCount();
			}
			Document.verseCount = verseCount;
		}

		// Return verse count.
		return verseCount;
	}

	/**
	 * Gets the number of tokens in the document.
	 * 
	 * @return the total number of tokens in the Holy Quran
	 */
	public static int getTokenCount() {

		// If not already cached, then calculate.
		if (tokenCount == 0) {

			// Count tokens.
			int tokenCount = 0;
			for (Chapter chapter : chapters) {
				tokenCount += chapter.getTokenCount();
			}
			Document.tokenCount = tokenCount;
		}

		// Return token count.
		return tokenCount;
	}

	/**
	 * Gets a chapter in the document by chapter number.
	 * 
	 * @param chapterNumber
	 *            the chapter number, between 1 and 114 inclusive
	 * 
	 * @return the specified chapter
	 */
	public static Chapter getChapter(int chapterNumber) {

		// Validate chapter number.
		Location.validateChapterNumber(chapterNumber);

		// Return chapter.
		return chapters[chapterNumber - 1];
	}

	/**
	 * Gets a chapter in the document by {@link Location} reference.
	 * 
	 * @param location
	 *            the chapter's location
	 * 
	 * @return the specified chapter
	 */
	public static Chapter getChapter(Location location) {
		return getChapter(location.getChapterNumber());
	}

	/**
	 * Gets an iterator used to enumerate over all chapters in the document.
	 * 
	 * @return a chapter iterator
	 */
	public static Iterable<Chapter> getChapters() {
		return new ArrayIterator<Chapter>(chapters);
	}

	/**
	 * Gets a verse in the document by chapter and verse number.
	 * 
	 * @param chapterNumber
	 *            the chapter number, between 1 and 114 inclusive
	 * 
	 * @param verseNumber
	 *            the verse number, a positive integer
	 * 
	 * @return the specified verse
	 */
	public static Verse getVerse(int chapterNumber, int verseNumber) {
		return getChapter(chapterNumber).getVerse(verseNumber);
	}

	/**
	 * Gets a verse in the document by {@link Location} reference.
	 * 
	 * @param location
	 *            the verse's location
	 * 
	 * @return the specified verse
	 */
	public static Verse getVerse(Location location) {
		return getVerse(location.getChapterNumber(), location.getVerseNumber());
	}

	/**
	 * Gets an iterator used to enumerate over all verses in the document.
	 * </code>
	 * 
	 * @return a verse iterator
	 */
	public static Iterable<Verse> getVerses() {
		return new DocumentVerseIterator(chapters);
	}

	/**
	 * Gets a token in the document by chapter, verse and token number.
	 * 
	 * @param chapterNumber
	 *            the chapter number, between 1 and 114 inclusive
	 * 
	 * @param verseNumber
	 *            the verse number, a positive integer
	 * 
	 * @param tokenNumber
	 *            the tokenNumber, a positive integer
	 * 
	 * @return the specified token
	 */
	public static Token getToken(int chapterNumber, int verseNumber,
			int tokenNumber) {
		return getChapter(chapterNumber).getVerse(verseNumber).getToken(
				tokenNumber);
	}

	/**
	 * Gets a token in the document by {@link Location} reference.
	 * 
	 * @param location
	 *            the token's location
	 * 
	 * @return the specified token
	 */
	public static Token getToken(Location location) {
		return getToken(location.getChapterNumber(), location.getVerseNumber(),
				location.getTokenNumber());
	}

	/**
	 * Gets an iterator used to enumerate over all tokens in the document.
	 * </code>
	 * 
	 * @return a token iterator
	 */
	public static Iterable<Token> getTokens() {
		return new DocumentTokenIterator(chapters);
	}
}
