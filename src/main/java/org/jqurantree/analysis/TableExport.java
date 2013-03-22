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

import org.jqurantree.core.io.FileWriter;

class TableExport {

	private FileWriter writer;
	private AnalysisTable table;
	private static final char DEFAULT_DELIMETER = '\t';
	private char delimiter;

	public void write(AnalysisTable table, int startRowIndex, int rowCount,
			String filename) {
		write(table, startRowIndex, rowCount, filename, DEFAULT_DELIMETER);
	}

	public void write(AnalysisTable table, int startRowIndex, int rowCount,
			String filename, char delimiter) {

		// Initiate.
		this.table = table;
		this.delimiter = delimiter;
		writer = new FileWriter(filename);

		// Write table.
		writeColumnNames();
		for (int i = 0; i < rowCount; i++) {
			writeRow(startRowIndex + i);
		}

		// Close file.
		writer.close();
	}

	private void writeColumnNames() {

		// Write colum names.
		int columnCount = table.getColumnCount();
		for (int i = 0; i < columnCount; i++) {

			// Delimiter.
			if (i > 0) {
				writer.write(delimiter);
			}

			// Valie.
			writer.write(table.getColumnName(i));
		}
		writer.writeLine();
	}

	private void writeRow(int rowIndex) {

		// Write row values.
		int columnCount = table.getColumnCount();
		for (int i = 0; i < columnCount; i++) {

			// Delimiter.
			if (i > 0) {
				writer.write(delimiter);
			}

			// Valie.
			writer.write(table.getString(rowIndex, i));
		}
		writer.writeLine();
	}
}
