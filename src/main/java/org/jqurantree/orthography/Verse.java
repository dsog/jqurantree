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
import org.jqurantree.arabic.ByteFormat;

/**
 * The <code>verse</code> class represents one of the numbered verses in a
 * chapter. Each {@link Chapter} is divided into a sequence of verses
 * (<i>ayat</i> in Arabic), with a total of 6236 verses in the Holy Quran. The
 * verses contain the actual words used in the Quran. This class derives from
 * the <code>ArabicText</code> class.
 * 
 * @author Kais Dukes
 */
public class Verse extends ArabicText {

	private final Location location;
	private final int[] tokenOffsets;

	/**
	 * Creates a new verse, used by JQuranTree when constructing the orthography
	 * model.
	 * 
	 * @param chapterNumber
	 *            the chapter number, between 1 and 114 inclusive
	 * 
	 * @param verseNumber
	 *            the verse number, a positive integer
	 * 
	 * @param text
	 *            the Unicode text of the verse
	 */
	public Verse(int chapterNumber, int verseNumber, String text) {
		super(text);
		location = new Location(chapterNumber, verseNumber);
		tokenOffsets = getTokenOffsets();
	}

	/**
	 * Gets the verse's location.
	 * 
	 * @return a location referencing the verse
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Gets the chapter that contains the verse.
	 * 
	 * @return the verse's chapter
	 */
	public Chapter getChapter() {
		return Document.getChapter(location);
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
	 * Gets an iterator used to enumerate over all tokens in the verse.
	 * 
	 * @return a token iterator
	 */
	public Iterable<Token> getTokens() {
		return new VerseTokenIterator(this);
	}

	/**
	 * Gets a token in the verse by {@link Location} reference.
	 * 
	 * @param location
	 *            the token's location
	 * 
	 * @return the specified token
	 */
	public Token getToken(Location location) {
		return getToken(location.getTokenNumber());
	}

	/**
	 * Gets a token in the verse by token number.
	 * 
	 * @param tokenNumber
	 *            the token number, a positive integer
	 * 
	 * @return the specified token
	 */
	public Token getToken(int tokenNumber) {
		int index = tokenNumber - 1;
		int offset = index > 0 ? tokenOffsets[index - 1] : 0;
		return new Token(location.getChapterNumber(),
				location.getVerseNumber(), tokenNumber, buffer, offset,
				(tokenOffsets[index] - offset) / ByteFormat.CHARACTER_WIDTH - 1);
	}

	/**
	 * Gets the number of tokens in the verse.
	 * 
	 * @return a positive integer
	 */
	public int getTokenCount() {
		return tokenOffsets.length;
	}

	private int[] getTokenOffsets() {

		// Pass 1: Count tokens.
		int size = 1;
		int offset = this.offset;
		for (int i = 0; i < characterCount; i++) {
			if (buffer[offset] == ByteFormat.WHITESPACE) {
				size++;
			}
			offset += ByteFormat.CHARACTER_WIDTH;
		}

		// Pass 2: Get offsets.
		int[] tokenOffsets = new int[size];
		int index = 0;
		offset = this.offset;
		for (int i = 0; i < characterCount; i++) {
			if (buffer[offset] == ByteFormat.WHITESPACE) {
				tokenOffsets[index++] = offset + ByteFormat.CHARACTER_WIDTH;
			}
			offset += ByteFormat.CHARACTER_WIDTH;
		}
		tokenOffsets[size - 1] = offset + ByteFormat.CHARACTER_WIDTH;

		// Return offsets.
		return tokenOffsets;
	}

	/**
	 * Converts the verse to a <code>string</code>. The format used is the
	 * location followed by the Buckwalter transliteration of the verse, For
	 * example "(114:2) maliki {ln~aAsi".
	 * 
	 * @return a <code>string</code> representing the verse
	 */
	@Override
	public String toString() {
		return location + " " + toBuckwalter();
	}
}
