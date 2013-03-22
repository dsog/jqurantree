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

package org.jqurantree.tanzil;

import java.util.ArrayList;
import java.util.List;

import org.jqurantree.arabic.ArabicText;
import org.jqurantree.orthography.Chapter;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Verse;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class TanzilHandler extends DefaultHandler {

	private int chapterNumber;
	private ArabicText chapterName;
	private ArabicText bismillah;
	private static final String SURA_ELEMENT = "sura";
	private static final String AYA_ELEMENT = "aya";
	private final Chapter[] chapters = new Chapter[Document.getChapterCount()];
	private final List<Verse> verses = new ArrayList<Verse>();

	public Chapter[] getChapters() {
		return chapters;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		// If the element is a sura, then note the chapter number.
		if (localName.equals(SURA_ELEMENT)) {

			// The chapter number is represented by the index attribute.
			String value = attributes.getValue("index");
			chapterNumber = Integer.parseInt(value);

			// Read the chapter name.
			String chapterNameText = attributes.getValue("name");
			chapterName = ArabicText.fromUnicode(chapterNameText);
		}

		// Otherwise, if the element is an aya, then read a verse.
		else if (localName.equals(AYA_ELEMENT)) {

			// The verse number is represented by the index attribute.
			String value = attributes.getValue("index");
			int verseNumber = Integer.parseInt(value);

			// Get the verse text.
			String text = attributes.getValue("text");

			// Create then buffer the verse.
			verses.add(new Verse(chapterNumber, verseNumber, text));

			// If this is the first verse, get bismillah.
			if (verseNumber == 1) {
				String bismillahText = attributes.getValue("bismillah");
				bismillah = bismillahText != null ? ArabicText
						.fromUnicode(bismillahText) : null;
			}
		}
	}
	
	public void endElement(String uri, String localName, String qName) {

		// If the element is a sura, then create a new chapter.
		if (localName.equals(SURA_ELEMENT)) {

			// Get the verses as an array.
			int size = this.verses.size();
			Verse[] verses = new Verse[size];
			this.verses.toArray(verses);

			// Reset the verses buffer for the next chapter.
			this.verses.clear();

			// Create the chapter.
			chapters[chapterNumber - 1] = new Chapter(chapterNumber,
					chapterName, bismillah, verses);
		}
	}
}
