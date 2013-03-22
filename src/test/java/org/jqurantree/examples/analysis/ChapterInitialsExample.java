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

package org.jqurantree.examples.analysis;

import org.jqurantree.analysis.AnalysisTable;
import org.jqurantree.arabic.ArabicCharacter;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Token;

/**
 * The example program below finds all chapters in the Holy Quran that begin
 * with special initials. These are sequences of letters (e.g. Alif, Lam, Meem)
 * which make up the first verses of certain chapters, but do not combine to
 * form words. Within the Uthmani script, the initials are the only tokens in
 * the Quran that have no diacritics other than maddah.
 * 
 * @author Kais Dukes
 */
public class ChapterInitialsExample {

	public static void main() {

		// Initiate an analysis table.
		AnalysisTable table = new AnalysisTable("Verse", "Initials");

		// Check each token in the Quranic text.
		for (Token token : Document.getTokens()) {

			// The token is not what we are looking for if it has a diacritic
			// other than maddah.
			boolean isValid = true;
			for (ArabicCharacter ch : token) {
				if (!ch.isMaddah() && ch.getDiacriticCount() != 0) {
					isValid = false;
					break;
				}
			}

			// If this token has only maddah for diacritics, then add it to the
			// analysis table.
			if (isValid) {
				table.add(token.getVerse().getLocation(), token
						.removeDiacritics().toSimpleEncoding());
			}
		}

		// Display the results.
		System.out.println(table);
	}
}
