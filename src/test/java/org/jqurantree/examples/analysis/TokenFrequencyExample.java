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
import org.jqurantree.analysis.SortOrder;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Token;

/**
 * The Java program below contains two examples that list the 10 most frequent
 * tokens in the Quran, with and without diacritics. An analysis table is used
 * to tabulate results for each example. Frequency analysis is performed by
 * grouping the tables using Buckwalter transliteration.
 * 
 * @author Kais Dukes
 */
public class TokenFrequencyExample {

	public static void main() {

		// Example #1.
		topTokensWithDiacritics();

		// Example #2.
		topTokensWithoutDiacritics();
	}

	private static void topTokensWithDiacritics() {

		// Create a new analysis table.
		AnalysisTable table = new AnalysisTable("Token");

		// Add each token to the table.
		for (Token token : Document.getTokens()) {
			table.add(token.toBuckwalter());
		}

		// Group and display top 10 results.
		AnalysisTable groupTable = table.group("Token");
		groupTable.sort("Count", SortOrder.Descending);
		System.out.println(groupTable.toString(10));
	}

	private static void topTokensWithoutDiacritics() {

		// Create a new analysis table.
		AnalysisTable table = new AnalysisTable("Token");

		// Add each token to the table, without diacritics.
		for (Token token : Document.getTokens()) {
			table.add(token.removeDiacritics().toBuckwalter());
		}

		// Group and display top 10 results.
		AnalysisTable groupTable = table.group("Token");
		groupTable.sort("Count", SortOrder.Descending);
		System.out.println(groupTable.toString(10));
	}
}
