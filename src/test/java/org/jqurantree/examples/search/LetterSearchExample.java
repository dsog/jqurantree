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

package org.jqurantree.examples.search;

import org.jqurantree.analysis.AnalysisTable;
import org.jqurantree.arabic.encoding.EncodingType;
import org.jqurantree.search.SearchOptions;
import org.jqurantree.search.TokenSearch;

/**
 * The example below shows how to use the search API to find tokens and ignore
 * diacritics. The program looks for the word "reward" in the Holy Quran, using
 * Buckwalter transliteration. The search criteria are Ajr (reward), wAjr (and
 * reward) and wlAjr (and the reward). A TokenSearch instance is constructed
 * using the RemoveDiacritics search option, and the crtieria are specified
 * through calls to findToken().
 * 
 * @author Kais Dukes
 */
public class LetterSearchExample {

	public static void main() {

		// Create a new search.
		TokenSearch search = new TokenSearch(EncodingType.Buckwalter,
				SearchOptions.RemoveDiacritics);

		// Search for "Ajr" (reward), "wAjr" (and reward) and "wlAjr" (and the
		// reward).
		search.findToken("Ajr");
		search.findToken("wAjr");
		search.findToken("wlAjr");

		// Display the results.
		AnalysisTable table = search.getResults();
		System.out.println(table);
		System.out.println("Matches: " + table.getRowCount());
	}
}
