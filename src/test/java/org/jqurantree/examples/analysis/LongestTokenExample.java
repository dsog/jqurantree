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
 * The example below displays the longest tokens in the Quran. The program uses
 * the getLetterCount() accessor to measure token length. This excludes Quranic
 * symbols which are not letters, as defined by the orthography model. The
 * program below has two steps. In step 1, an analysis table is used to perform
 * frequency analysis, showing the number of tokens of various lengths. In step
 * 2, a second analysis table is used to tabulate occurrences of the longest
 * tokens.
 * 
 * @author Kais Dukes
 */
public class LongestTokenExample {

	public static void main() {

		// ---------------------------------
		// Step 1. Most common token lengths
		// ---------------------------------

		// Create a new analysis table.
		AnalysisTable table = new AnalysisTable("TokenLength");

		// Add the length of each token to the table.
		for (Token token : Document.getTokens()) {
			table.add(token.getLetterCount());
		}

		// Group by token length and display results.
		AnalysisTable groupTable = table.group("TokenLength");
		groupTable.sort("TokenLength", SortOrder.Descending);
		System.out.println(groupTable);

		// ----------------------
		// Step 2. Longest tokens
		// ----------------------

		// Get the maximum token length.
		int maxTokenLength = groupTable.getInteger(0, "TokenLength");

		// Find all tokens of that size.
		AnalysisTable tokenTable = new AnalysisTable("ChapterNumber",
				"VerseNumber", "TokenNumber", "Token");
		for (Token token : Document.getTokens()) {
			if (token.getLetterCount() == maxTokenLength) {
				tokenTable.add(token.getChapterNumber(),
						token.getVerseNumber(), token.getTokenNumber(), token
								.removeNonLetters().toBuckwalter());
			}
		}

		// Display tokens.
		System.out.println(tokenTable);
	}
}
