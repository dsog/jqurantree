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
import org.jqurantree.arabic.ArabicCharacter;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Token;

/**
 * This example generates a frequency table, which shows the number of
 * occurrences of each letter within the Quranic text. An analysis table is used
 * to tabulate and group the results.
 * 
 * @author Kais Dukes
 */
public class CharacterFrequencyExample {

	public static void main() {

		// Create a new analysis table.
		AnalysisTable table = new AnalysisTable("Character");

		// Add each character to the table.
		for (Token token : Document.getTokens()) {
			for (ArabicCharacter character : token) {
				table.add(character.getType());
			}
		}

		// Group and display results.
		AnalysisTable groupTable = table.group("Character");
		groupTable.sort("Count", SortOrder.Descending);
		System.out.println(groupTable);
	}
}
