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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;

/**
 * The <code>AnalyisTable</code> is a general purpose class which may be used to
 * tabulate, sort, group and export results. The table organizes a set of cells
 * into rows and columns, with each column having a unique column name. The
 * analysis table may be used as follows:
 * <p>
 * <ol>
 * <li>A new analysis table is created by specifying a list of column names.</li>
 * <li>Rows are added to the table by a Java program. These are typically the
 * results of a search, or other program you have written to collect data.</li>
 * <li>After rows have been added, the results can be analysed.</li>
 * </ol>
 * <p>
 * Once the table has been populated, the following operations may be performed:
 * <ul>
 * <li>Sort the data by a column, in ascending or descending order.</li>
 * <li>Group the data by a list of columns.</li>
 * <li>Display the table to screen, or display only the top rows of the table.</li>
 * <li>Export the table to a file, e.g. a tab delimited file or a CSV file.</li>
 * </ul>
 * 
 * @author Kais Dukes
 */
public class AnalysisTable implements Iterable<Object[]> {

	private final String[] columnNames;
	private final List<Object[]> rows = new ArrayList<Object[]>();

	/**
	 * Creates an empty analysis table with the specified columns and without
	 * any rows.
	 * 
	 * @param columnNames
	 *            an array of column names.
	 */
	public AnalysisTable(String... columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * Adds a new row to the analysis table using of the specified values.
	 * 
	 * @param values
	 *            the values that make up the row. The number of values
	 *            specified should match the number of columns in the table.
	 */
	public void add(Object... values) {
		rows.add(values);
	}

	/**
	 * Gets the number of rows in the table.
	 * 
	 * @return a positive number if the table contains any data, otherwise zero.
	 */
	public int getRowCount() {
		return rows.size();
	}

	/**
	 * Gets the number of columns in the table.
	 * 
	 * @return a positive value indicating the number of columns.
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Gets the name of a column in the table, by column index.
	 * 
	 * @param columnIndex
	 *            the zero-based index of the column.
	 * @return The name of the specified column.
	 */
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	/**
	 * Gets the index of a column in the table, by column name.
	 * 
	 * @param columnName
	 *            the name of column.
	 * @return the zero-based index of the specified column, or -1 if the column
	 *         name does not occur.
	 */
	public int getColumnIndex(String columnName) {
		int columnIndex = -1;
		int size = columnNames.length;
		for (int i = 0; i < size; i++) {
			if (columnNames[i] == columnName) {
				columnIndex = i;
				break;
			}
		}
		return columnIndex;
	}

	/**
	 * Gets the value of a cell in the table, given the cell's row index and
	 * column index.
	 * 
	 * @param rowIndex
	 *            the zero-based index of the row containing the cell.
	 * @param columnIndex
	 *            the zero-based index of the column containing the cell.
	 * @return the value of the cell at the specified position.
	 */
	public Object getValue(int rowIndex, int columnIndex) {
		return rows.get(rowIndex)[columnIndex];
	}

	/**
	 * Gets the value of a cell in the table, given the cell's row index and
	 * column name.
	 * 
	 * @param rowIndex
	 *            the zero-based index of the row containing the cell.
	 * @param columnName
	 *            the name of the column containing the cell.
	 * @return the value of the cell at the specified position.
	 */
	public Object getValue(int rowIndex, String columnName) {
		return getValue(rowIndex, getValidColumnIndex(columnName));
	}

	/**
	 * Converts the value of a cell to an <code>int</code>, given the cell's row
	 * index and column index.
	 * 
	 * @param rowIndex
	 *            the zero-based index of the row containing the cell.
	 * @param columnIndex
	 *            the zero-based index of the column containing the cell.
	 * @return the value of the cell at the specified position.
	 */
	public int getInteger(int rowIndex, int columnIndex) {
		return Integer.parseInt(getString(rowIndex, columnIndex));
	}

	/**
	 * Converts the value of a cell to an <code>int</code>, given the cell's row
	 * index and column name.
	 * 
	 * @param rowIndex
	 *            the zero-based index of the row containing the cell.
	 * @param columnName
	 *            the name of the column containing the cell.
	 * @return the value of the cell at the specified position.
	 */
	public int getInteger(int rowIndex, String columnName) {
		return getInteger(rowIndex, getValidColumnIndex(columnName));
	}

	/**
	 * Converts the value of a cell to a <code>string</code>, given the cell's
	 * row index and column index.
	 * 
	 * @param rowIndex
	 *            the zero-based index of the row containing the cell.
	 * @param columnIndex
	 *            the zero-based index of the column containing the cell.
	 * @return the value of the cell at the specified position.
	 */
	public String getString(int rowIndex, int columnIndex) {
		return getValue(rowIndex, columnIndex).toString();
	}

	/**
	 * Converts the value of a cell to a <code>string</code>, given the cell's
	 * row index and column name.
	 * 
	 * @param rowIndex
	 *            the zero-based index of the row containing the cell.
	 * @param columnName
	 *            the name of the column containing the cell.
	 * @return the value of the cell at the specified position.
	 */
	public String getString(int rowIndex, String columnName) {
		return getString(rowIndex, getValidColumnIndex(columnName));
	}

	/**
	 * Converts the analysis table to a <code>string</code>. The table will be
	 * correctly formatted and all columns will be aligned.
	 * 
	 * @return a string representation of the analysis table.
	 */
	@Override
	public String toString() {
		return toString(rows.size());
	}

	/**
	 * Converts the top rows of the analysis table to a <code>string</code>.
	 * 
	 * @param rowCount
	 *            the number of rows to use when converting the table. This
	 *            value should be a positive number.
	 * 
	 * @return a string representing the top rows of the table.
	 */
	public String toString(int rowCount) {
		return new TableWriter().write(this, 0, rowCount);
	}

	/**
	 * Saves the contents of the analysis table to disk, by writing out a
	 * delimited file. The file will be written using the default delimiter, the
	 * tab character.
	 * 
	 * @param filename
	 *            the name of the file to write to.
	 */
	public void writeFile(String filename) {
		new TableExport().write(this, 0, rows.size(), filename);
	}

	/**
	 * Saves the contents of the analysis table to disk, by writing out a
	 * delimited file. The file will be written using the specified delimiter.
	 * 
	 * @param filename
	 *            the name of the file to write to.
	 * 
	 * @param delimiter
	 *            the delimiter character used to write the file
	 */
	public void writeFile(String filename, char delimiter) {
		writeFile(filename, delimiter, rows.size());
	}

	/**
	 * Saves the top rows of the analysis table to disk, by writing out a
	 * delimited file. The file will be written using the specified delimiter.
	 * 
	 * @param filename
	 *            the name of the file to write to.
	 * 
	 * @param delimiter
	 *            the delimiter character used to write the file
	 * 
	 * @param rowCount
	 *            the number of rows to write to file. This value should be a
	 *            positive number.
	 */
	public void writeFile(String filename, char delimiter, int rowCount) {
		new TableExport().write(this, 0, rowCount, filename, delimiter);
	}

	/**
	 * Returns an <code>iterator</code> used to enumerate through all rows in
	 * the table.
	 * 
	 * @return an <code>iterator</code>.
	 */
	public Iterator<Object[]> iterator() {
		return rows.iterator();
	}

	/**
	 * Sorts all rows in ascending order, by the specified column.
	 * 
	 * @param columnName
	 *            the name of the column to sort by.
	 */
	public void sort(String columnName) {
		sort(columnName, SortOrder.Ascending);
	}

	/**
	 * Sorts all rows by a column, in the specified sort order.
	 * 
	 * @param columnName
	 *            the name of the column to sort by.
	 * 
	 * @param direction
	 *            the order to sort the rows in, ascending or descending.
	 */
	public void sort(String columnName, SortOrder direction) {
		Collections.sort(rows, new TableSort(getValidColumnIndex(columnName),
				direction));
	}

	/**
	 * Creates a new table by grouping this analysis table by the specified list
	 * of columns. The new table will contain the specified columns, together
	 * with an additional column named <i>Count</i>, which contains the number
	 * of items in each group.
	 * 
	 * @param columnNames
	 *            the list of columns to group by.
	 * 
	 * @return the grouped analysis table.
	 */
	public AnalysisTable group(String... columnNames) {

		// Column indexes.
		int size = columnNames.length;
		int[] columnIndexes = new int[size];
		for (int i = 0; i < size; i++) {
			columnIndexes[i] = getValidColumnIndex(columnNames[i]);
		}

		// Group.
		return new TableGroup().group(this, columnIndexes);
	}

	private int getValidColumnIndex(String columnName) {
		int columnIndex = getColumnIndex(columnName);
		if (columnIndex < 0) {
			throw new JQuranTreeException(Errors.INVALID_COLUMN_NAME);
		}
		return columnIndex;
	}
}
