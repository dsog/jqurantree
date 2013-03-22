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

package org.jqurantree.core.collections;

import java.util.Iterator;

/**
 * Supports iterating over an array without modifying the underlying values.
 * 
 * @author Kais Dukes
 * 
 * @param <T>
 *            the type of array element supported by this iterator
 */
public class ArrayIterator<T> extends ImmutableIteratorBase<T> implements
		Iterable<T> {

	private final T[] items;
	private int index;

	public ArrayIterator(T[] items) {
		this.items = items;
	}

	/**
	 * Returns the iterator.
	 * 
	 * @return the same <code>iterator</code> instance.
	 */
	public Iterator<T> iterator() {
		return this;
	}

	public boolean hasNext() {
		return index < items.length;
	}

	public T next() {
		return items[index++];
	}
}
