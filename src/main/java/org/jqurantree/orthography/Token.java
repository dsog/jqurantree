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

import org.jqurantree.arabic.ArabicText;

/**
 * An orthographic token is whitespace-delimited
 * {@link org.jqurantree.arabic.ArabicText} within a verse. This is typically a
 * word with its affixes. In Arabic, a word and multiple particles may be fused
 * together into a single orthographic token.
 * 
 * @author Kais Dukes
 */
public class Token extends ArabicText {

	private final Location location;

	Token(int chapterNumber, int verseNumber, int tokenNumber, byte[] buffer,
			int offset, int characterCount) {
		super(buffer, offset, characterCount);
		location = new Location(chapterNumber, verseNumber, tokenNumber);
	}

	/**
	 * Gets the token's location.
	 * 
	 * @return a location referencing the token
	 */
	public Location getLocation() {
		return location;
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
	 * Gets the verse number.
	 * 
	 * @return the verse number, a positive integer
	 */
	public int getVerseNumber() {
		return location.getVerseNumber();
	}

	/**
	 * Gets the token number.
	 * 
	 * @return the token number, a positive integer
	 */
	public int getTokenNumber() {
		return location.getTokenNumber();
	}

	/**
	 * Gets the verse that contains the token.
	 * 
	 * @return the token's verse
	 */
	public Verse getVerse() {
		return Document.getVerse(location);
	}

	/**
	 * Gets the chapter that contains the token.
	 * 
	 * @return the token's chapter
	 */
	public Chapter getChapter() {
		return Document.getChapter(location);
	}
}
