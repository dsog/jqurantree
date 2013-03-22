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

package org.jqurantree.analysis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnalysisTableTest {

	@Test
	public void testEmptyTable() {

		// Create table.
		AnalysisTable table = new AnalysisTable("name", "count");

		// Validate.
		assertEquals("name count\r\n---- -----\r\n", table.toString());
	}

	@Test
	public void testSort() {

		// Create table.
		AnalysisTable table = new AnalysisTable("verb", "form", "frequency");
		table.add("eat", 1, 723);
		table.add("ate", 2, 1230);
		table.add("eaten", 3, 54);
		table.add("eating", 4, 553);
		table.add("eats", 5, 234);

		// Validate.
		StringBuilder text = new StringBuilder();
		text.append("verb   form frequency\r\n");
		text.append("----   ---- ---------\r\n");
		text.append("eat    1    723\r\n");
		text.append("ate    2    1230\r\n");
		text.append("eaten  3    54\r\n");
		text.append("eating 4    553\r\n");
		text.append("eats   5    234\r\n");
		assertEquals(text.toString(), table.toString());

		// Sort.
		table.sort("frequency", SortOrder.Descending);

		// Validate.
		text.setLength(0);
		text.append("verb   form frequency\r\n");
		text.append("----   ---- ---------\r\n");
		text.append("ate    2    1230\r\n");
		text.append("eat    1    723\r\n");
		text.append("eating 4    553\r\n");
		text.append("eats   5    234\r\n");
		text.append("eaten  3    54\r\n");
		assertEquals(text.toString(), table.toString());
	}

	@Test
	public void testGroup() {

		// Create table.
		AnalysisTable table = new AnalysisTable("A", "N", "G");
		table.add(16, 'J', 2);
		table.add(16, 'J', 1);
		table.add(16, 'M', 1);
		table.add(15, 'P', 1);
		table.add(17, 'L', 2);
		table.add(15, 'L', 1);
		table.add(18, 'J', 2);
		table.add(21, 'H', 1);
		table.add(15, 'H', 2);
		table.add(16, 'A', 1);
		table.add(17, 'E', 1);
		table.add(21, 'M', 1);
		table.add(15, 'P', 2);
		table.add(16, 'O', 2);
		table.add(16, 'S', 2);
		table.add(17, 'A', 1);
		table.add(16, 'B', 1);
		table.add(18, 'D', 2);
		table.add(16, 'F', 2);
		table.add(15, 'M', 1);

		// Group by G, A.
		AnalysisTable groupTable = table.group("G", "A");
		groupTable.sort("Count", SortOrder.Descending);

		// Validate.
		StringBuilder text = new StringBuilder();
		text.append("G A  Count\r\n");
		text.append("- -  -----\r\n");
		text.append("2 16 4\r\n");
		text.append("1 16 4\r\n");
		text.append("1 15 3\r\n");
		text.append("1 21 2\r\n");
		text.append("2 18 2\r\n");
		text.append("2 15 2\r\n");
		text.append("1 17 2\r\n");
		text.append("2 17 1\r\n");
		assertEquals(text.toString(), groupTable.toString());

		// Group by A.
		groupTable = table.group("A");
		groupTable.sort("A");

		// Validate.
		text.setLength(0);
		text.append("A  Count\r\n");
		text.append("-  -----\r\n");
		text.append("15 5\r\n");
		text.append("16 8\r\n");
		text.append("17 3\r\n");
		text.append("18 2\r\n");
		text.append("21 2\r\n");
		assertEquals(text.toString(), groupTable.toString());

		// Group by G.
		groupTable = table.group("G");
		groupTable.sort("G");

		// Validate.
		text.setLength(0);
		text.append("G Count\r\n");
		text.append("- -----\r\n");
		text.append("1 11\r\n");
		text.append("2 9\r\n");
		assertEquals(text.toString(), groupTable.toString());

		// Group by N
		groupTable = table.group("N");
		groupTable.sort("Count", SortOrder.Descending);

		// Validate first 5 rows.
		text.setLength(0);
		text.append("N Count\r\n");
		text.append("- -----\r\n");
		text.append("M 3\r\n");
		text.append("J 3\r\n");
		text.append("A 2\r\n");
		text.append("P 2\r\n");
		text.append("L 2\r\n");
		assertEquals(text.toString(), groupTable.toString(5));
	}
}
