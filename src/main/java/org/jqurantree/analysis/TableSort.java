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

import java.util.Comparator;

class TableSort implements Comparator<Object[]> {

	private final int columnIndex;
	private final SortOrder direction;

	public TableSort(int columnIndex, SortOrder direction) {
		this.columnIndex = columnIndex;
		this.direction = direction;
	}

	@SuppressWarnings("unchecked")
	public int compare(Object[] row1, Object[] row2) {
		Comparable value1 = (Comparable) row1[columnIndex];
		Comparable value2 = (Comparable) row2[columnIndex];
		return direction == SortOrder.Ascending ? value1.compareTo(value2)
				: value2.compareTo(value1);
	}
}
