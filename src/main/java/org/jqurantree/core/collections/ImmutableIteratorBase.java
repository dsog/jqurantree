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

import org.jqurantree.core.error.Errors;

/**
 * <code>ImmutableIteratorBase</code> provides a common implementation for
 * iterators that do not modify their underlying collection.
 * 
 * @author Kais Dukes
 * 
 * @param <T>
 *            the type of element supported by this iterator
 */
public abstract class ImmutableIteratorBase<T> implements Iterator<T> {

	/**
	 * Returns <code>true</code> if the iteration has more elements.
	 * 
	 * @return <code>true</code> if the iterator has more elements.
	 */
	public abstract boolean hasNext();

	/**
	 * Returns the next element in the iteration.
	 * 
	 * @return the next element in the iteration.
	 */
	public abstract T next();

	/**
	 * Always throws an <code>UnsupportedOperationException</code>, since the
	 * underlying collection is immutable
	 * 
	 * @exception UnsupportedOperationException
	 *                since the <code>remove</code> operation is not supported
	 *                by this immutable iterator.
	 */
	public void remove() {
		throw new UnsupportedOperationException(Errors.IMMUTABLE_COLLECTION);
	}
}
