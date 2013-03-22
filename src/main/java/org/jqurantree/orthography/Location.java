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

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;

/**
 * The location of an element in the orthography model, consisting of a chapter
 * number, verse number and token number. A 1-based numbering scheme is used, so
 * that the first chapter, first verse or first token will have number 1. Each
 * element in the orthography model has a <code>getLocation()</code> accessor
 * which returns a <code>Location</code> object that specifies the current
 * location.
 * 
 * @author Kais Dukes
 */
public class Location {

	private int chapterNumber;
	private int verseNumber;
	private int tokenNumber;

	/**
	 * Creates a new location which references a chapter.
	 * 
	 * @param chapterNumber
	 *            an integer value between 1 and 114 inclusive
	 */
	public Location(int chapterNumber) {
		this(chapterNumber, 0, 0);
	}

	/**
	 * Creates a new location which references a verse within a chapter.
	 * 
	 * @param chapterNumber
	 *            an integer value between 1 and 114 inclusive
	 * 
	 * @param verseNumber
	 *            the number of the verse within the chapter
	 */
	public Location(int chapterNumber, int verseNumber) {
		this(chapterNumber, verseNumber, 0);
	}

	/**
	 * Creates a new location which references a token within a verse.
	 * 
	 * @param chapterNumber
	 *            an integer value between 1 and 114 inclusive
	 * 
	 * @param verseNumber
	 *            the number of the verse within the chapter
	 * 
	 * @param tokenNumber
	 *            the number of the token within the verse
	 */
	public Location(int chapterNumber, int verseNumber, int tokenNumber) {
		validateChapterNumber(chapterNumber);
		this.chapterNumber = chapterNumber;
		this.verseNumber = verseNumber;
		this.tokenNumber = tokenNumber;
	}

	/**
	 * Gets the chapter number.
	 * 
	 * @return an integer value between 1 and 114 inclusive.
	 */
	public int getChapterNumber() {
		return chapterNumber;
	}

	/**
	 * Gets the verse number.
	 * 
	 * @return a positive number if the location references a verse or token;
	 *         zero if the location references a chapter.
	 */
	public int getVerseNumber() {
		return verseNumber;
	}

	/**
	 * Gets the token number.
	 * 
	 * @return a positive number if the location references a token; zero
	 *         otherwise.
	 */
	public int getTokenNumber() {
		return tokenNumber;
	}

	/**
	 * Gets a <code>string</code> representation of the location. For example
	 * (81:3:2) represents chapter 81, verse 3, token 2.
	 * 
	 * @return a string representing the location
	 * 
	 */
	@Override
	public String toString() {

		// Start location.
		StringBuilder text = new StringBuilder();

		// Chapter number.
		text.append('(');
		text.append(chapterNumber);

		// Verse number.
		text.append(':');
		text.append(verseNumber);

		// Token number.
		if (tokenNumber > 0) {
			text.append(':');
			text.append(tokenNumber);
		}
		text.append(')');

		// Return location.
		return text.toString();
	}

	static void validateChapterNumber(int chapterNumber) {

		// Check that the chapter number is from 1 to 114 inclusive.
		if (chapterNumber < 1 || chapterNumber > Document.CHAPTER_COUNT) {
			throw new JQuranTreeException(Errors.INVALID_CHAPTER_NUMBER);
		}
	}
}
