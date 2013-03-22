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

package org.jqurantree.examples.orthography;

import org.jqurantree.orthography.Chapter;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Verse;

/**
 * The Java program below shows how to scan the orthography model to find
 * occurrences of bismillahi arahmani raheem (In the name of Allah, the
 * Beneficent, the Merciful). Nearly all 114 chapters of the Holy Quran are
 * preceded by this phrase. The Chapter.getBismillah() accessor returns the
 * phrase if it is present for a chapter.
 * 
 * The program performs two steps. In step 1, each chapter in the Holy Quran is
 * enumerated. If the chapter does not have a preceding bismillah, then the
 * chapter number is listed. The program also looks for occurrences of the
 * phrase that have a single additional diacritic shadda attached to the first
 * letter. In step 2, the verses of the Quran are scanned to see if they contain
 * the phrase. The second step is performed using Buckwalter transliteration.
 * 
 * @author Kais Dukes
 */
public class BismillahExample {

	public static void main() {

		// Step #1. Enumerate each chapter.
		for (Chapter chapter : Document.getChapters()) {

			// If this chapter has no bismillah, then list it.
			if (chapter.getBismillah() == null) {
				System.out.println("No bismillah: " + chapter);
			}

			// Otherwise, check if the chapter has a shadda
			// on the first letter, the Ba.
			else if (chapter.getBismillah().getCharacter(0).isShadda()) {
				System.out.println("Shadda on Ba: " + chapter);
			}
		}

		// Step #2. Search for bismillah in verses.
		for (Verse verse : Document.getVerses()) {
			if (verse.toBuckwalter().contains(
					"bisomi {ll~ahi {lr~aHoma`ni {lr~aHiymi")) {
				System.out.println("Bismillah in verse " + verse.getLocation());
			}
		}
	}
}
