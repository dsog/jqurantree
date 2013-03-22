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

import java.util.Iterator;

import org.jqurantree.arabic.ArabicText;
import org.jqurantree.core.collections.ArrayIterator;
import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;

/**
 * One of the 114 chapters in the Holy Quran, with a unique chapter name and
 * number. Each chapter (<i>sura</i> in Arabic) is divided into a sequence of
 * {@link Verse Verses}.
 * 
 * @author Kais Dukes
 */
public class Chapter implements Iterable<Verse> {

	private final Location location;
	private final ArabicText name;
	private final ArabicText bismillah;
	final Verse[] verses;
	private int tokenCount;

	/**
	 * Creates a new chapter, used by JQuranTree when constructing the
	 * orthography model.
	 * 
	 * @param chapterNumber
	 *            the chapter's number, between 1 and 114 inclusive
	 * 
	 * @param name
	 *            the chapter's name
	 * 
	 * @param bismillah
	 *            the <i>bismillah</i> phrase preceding the chapter's verses if
	 *            present; <code>null</code> otherwise
	 * 
	 * @param verses
	 *            an array holding the chapter's verses
	 */
	public Chapter(int chapterNumber, ArabicText name, ArabicText bismillah,
			Verse[] verses) {
		location = new Location(chapterNumber);
		this.name = name;
		this.verses = verses;
		this.bismillah = bismillah;
	}

	/**
	 * Gets the chapter number.
	 * 
	 * @return the chapter number, between 1 and 114 inclusive
	 */
	public int getChapterNumber() {
		return location.getChapterNumber();
	}

	/**
	 * Gets the chapter's location.
	 * 
	 * @return a location referencing the chapter
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Gets the name of the chapter as <code>ArabicText</code>.
	 * 
	 * @return the chapter's name
	 */
	public ArabicText getName() {
		return name;
	}

	/**
	 * Gets the <i>bismillah</i> phrase preceding the chapter's verses.
	 * 
	 * @return the <i>bismillah</i> phrase preceding the chapter's verses if
	 *         present; <code>null</code> otherwise
	 */
	public ArabicText getBismillah() {
		return bismillah;
	}

	/**
	 * Gets a verse in the chapter by verse number.
	 * 
	 * @param verseNumber
	 *            the verse number, a positive integer
	 * 
	 * @return the specified verse
	 */
	public Verse getVerse(int verseNumber) {

		// Check that the verse number is valid.
		if (verseNumber < 1 || verseNumber > verses.length) {
			throw new JQuranTreeException(Errors.INVALID_VERSE_NUMBER);
		}

		// Return verse.
		return verses[verseNumber - 1];
	}

	/**
	 * Gets a verse in the chapter by {@link Location} reference.
	 * 
	 * @param location
	 *            the verse's location
	 * 
	 * @return the specified verse
	 */
	public Verse getVerse(Location location) {
		return getVerse(location.getVerseNumber());
	}

	/**
	 * Gets the number of verses in the chapter.
	 * 
	 * @return a positive integer
	 */
	public int getVerseCount() {
		return verses.length;
	}

	/**
	 * Gets the number of tokens in the chapter.
	 * 
	 * @return a positive integer
	 */
	public int getTokenCount() {

		// If not already cached, then calculate.
		if (tokenCount == 0) {

			// Count tokens.
			int tokenCount = 0;
			for (Verse verse : verses) {
				tokenCount += verse.getTokenCount();
			}
			this.tokenCount = tokenCount;
		}

		// Return token count.
		return tokenCount;
	}

	/**
	 * Gets an iterator used to enumerate over all verses in the chapter.
	 * 
	 * @return a verse iterator
	 */
	public Iterator<Verse> iterator() {
		return new ArrayIterator<Verse>(verses);
	}

	/**
	 * Gets a string representation of the chapter's location, for example
	 * "Chapter 18".
	 * 
	 * @return a <code>string</code> representing the chapter
	 */
	@Override
	public String toString() {
		return "Chapter " + location.getChapterNumber();
	}
}
