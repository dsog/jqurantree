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

package org.jqurantree.orthography;

import java.util.Iterator;

import org.jqurantree.core.collections.ImmutableIteratorBase;

class VerseTokenIterator extends ImmutableIteratorBase<Token> implements Iterable<Token> {

	private final Verse verse;
	private int tokenNumber = 1;

	public VerseTokenIterator(Verse verse) {
		this.verse = verse;
	}

	public boolean hasNext() {
		return tokenNumber <= verse.getTokenCount();
	}

	public Token next() {
		return verse.getToken(tokenNumber++);
	}

	public Iterator<Token> iterator() {
		return this;
	}
}
