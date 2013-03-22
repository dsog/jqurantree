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
import org.jqurantree.search.TokenSearch;

/**
 * This example shows how to use the search API to find substrings in the
 * Quranic text. The program below performs two searches. The first search looks
 * for occurrences of the the Sun, and the second search looks for occurrences
 * of the the Moon. The TokenSearch class is used, which is initiated through
 * calls to findSubstring() and findToken(). These methods specify search
 * criteria. The getResults() method is used to perform the search, and returns
 * the results as an analysis table.
 * 
 * @author Kais Dukes
 */
public class TokenSearchExample {

	public static void main() {

		// Search #1: The Sun.
		searchSun();

		// Search #2: The Moon.
		searchMoon();
	}

	private static void searchSun() {

		// Search for substring "$~amos" or exact token "$amosFA"
		TokenSearch search = new TokenSearch(EncodingType.Buckwalter);
		search.findSubstring("$~amos");
		search.findToken("$amosFA");

		// Display the results.
		AnalysisTable table = search.getResults();
		System.out.println(table);
		System.out.println("Matches: " + table.getRowCount() + "\r\n");
	}

	private static void searchMoon() {

		// Search for substring "qamar" or exact token "lo>ahil~api"
		TokenSearch search = new TokenSearch(EncodingType.Buckwalter);
		search.findSubstring("qamar");
		search.findToken("{lo>ahil~api");

		// Display the results.
		AnalysisTable table = search.getResults();
		System.out.println(table);
		System.out.println("Matches: " + table.getRowCount() + "\r\n");
	}
}
