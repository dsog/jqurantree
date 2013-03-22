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

import org.jqurantree.core.collections.ImmutableIteratorBase;

class DocumentTokenIterator extends ImmutableIteratorBase<Token> implements
		Iterable<Token> {

	private Chapter[] chapters;
	private Verse[] verses;
	private Verse verse;
	private int chapterNumber;
	private int verseNumber;
	private int tokenNumber;

	public DocumentTokenIterator(Chapter[] chapters) {
		this.chapters = chapters;
	}

	public Iterator<Token> iterator() {
		return this;
	}

	public boolean hasNext() {
		return chapterNumber < Document.CHAPTER_COUNT
				|| verseNumber < verses.length
				|| tokenNumber < verse.getTokenCount();
	}

	public Token next() {

		// Increment token number.
		if (verse == null || ++tokenNumber > verse.getTokenCount()) {

			// Increment verse number.
			if (verses == null || ++verseNumber > verses.length) {

				// Increment chapter number.
				verses = chapters[++chapterNumber - 1].verses;
				verseNumber = 1;
			}
			verse = verses[verseNumber - 1];
			tokenNumber = 1;
		}

		// Return token.
		return verse.getToken(tokenNumber);
	}
}
