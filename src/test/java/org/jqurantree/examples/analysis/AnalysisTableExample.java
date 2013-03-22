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
import org.jqurantree.orthography.Verse;

/**
 * This example demonstrates how to use an analysis table. The program finds the
 * 5 longest verses in the Quranic text, measuring length by the number of
 * tokens in each verse. The Java program below searches the orthography model,
 * using an analysis table to collect the results.
 * 
 * Step 1 creates a new empty table by specifying a list of column names. In
 * step 2, each verse is added to the table. In step 3, the table is sorted by
 * the TokenCount column in descending order, and the top 5 rows are displayed.
 * A frequency table is then constructed by grouping the original table by the
 * TokenCount count. The resulting frequency table shows the most common token
 * lengths in the Quranic text.
 * 
 * @author Kais Dukes
 */
public class AnalysisTableExample {

	public static void main() {

		// -----------------
		// Tabluate and sort
		// -----------------

		// Step 1. Create a new analysis table.
		AnalysisTable table = new AnalysisTable("ChapterNumber", "VerseNumber",
				"TokenCount");

		// Step 2. Tabulate the number of tokens in each verse.
		for (Verse verse : Document.getVerses()) {
			table.add(verse.getChapterNumber(), verse.getVerseNumber(), verse
					.getTokenCount());
		}

		// Step 3. Sort the table, then display the first 5 rows.
		table.sort("TokenCount", SortOrder.Descending);
		System.out.println(table.toString(5));

		// -------------
		// Group results
		// -------------

		// Group the token count table by number of tokens.
		AnalysisTable groupTable = table.group("TokenCount");

		// Sort the group table by the Count column, in descending order.
		groupTable.sort("Count", SortOrder.Descending);

		// Display the first 5 rows of the group table.
		System.out.println(groupTable.toString(5));
	}
}
