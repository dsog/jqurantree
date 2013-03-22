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

import java.util.HashMap;
import java.util.Map;

class TableGroup {

	private AnalysisTable table;
	private int[] columnIndexes;
	private final Map<String, Group> groupMap = new HashMap<String, Group>();
	private static final char GROUP_KEY_SEPERATOR = '|';
	private static final String COUNT_COLUMN_NAME = "Count";

	public AnalysisTable group(AnalysisTable table, int[] columnIndexes) {

		// Initiate.
		this.table = table;
		this.columnIndexes = columnIndexes;

		// Group all rows.
		int size = table.getRowCount();
		for (int i = 0; i < size; i++) {
			groupRow(i);
		}

		// Return.
		return createGroupTable();
	}

	private void groupRow(int rowIndex) {

		// Create group key.
		String key = getGroupKey(rowIndex);

		// New group?
		Group group = groupMap.get(key);
		if (group == null) {
			group = new Group(rowIndex);
			groupMap.put(key, group);
		}

		// Increment group row count.
		group.setRowCount(group.getRowCount() + 1);
	}

	private AnalysisTable createGroupTable() {
		// Create table.
		int size = columnIndexes.length + 1;
		String[] columnNames = new String[size];
		for (int i = 0; i < size - 1; i++) {
			columnNames[i] = table.getColumnName(columnIndexes[i]);
		}
		columnNames[size - 1] = COUNT_COLUMN_NAME;
		AnalysisTable groupTable = new AnalysisTable(columnNames);

		// Fill table.
		for (Group group : groupMap.values()) {
			int rowIndex = group.getRowIndex();
			Object[] values = new Object[size];
			for (int i = 0; i < size - 1; i++) {
				values[i] = table.getValue(rowIndex, columnIndexes[i]);
			}
			values[size - 1] = group.getRowCount();
			groupTable.add(values);
		}

		// Return table.
		return groupTable;
	}

	private String getGroupKey(int rowIndex) {
		StringBuilder text = new StringBuilder();
		int size = columnIndexes.length;
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				text.append(GROUP_KEY_SEPERATOR);
			}
			text.append(table.getValue(rowIndex, columnIndexes[i]));
		}
		return text.toString();
	}
}
