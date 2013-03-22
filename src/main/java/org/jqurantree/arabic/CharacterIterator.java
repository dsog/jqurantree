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

package org.jqurantree.arabic;

import org.jqurantree.core.collections.ImmutableIteratorBase;

class CharacterIterator extends ImmutableIteratorBase<ArabicCharacter> {

	private final byte[] buffer;
	private final int maxOffset;
	private int offset;

	public CharacterIterator(byte[] buffer, int offset, int characterCount) {
		this.buffer = buffer;
		this.offset = offset;
		this.maxOffset = offset + characterCount * ByteFormat.CHARACTER_WIDTH;
	}

	public boolean hasNext() {
		return offset < maxOffset;
	}

	public ArabicCharacter next() {
		ArabicCharacter character = new ArabicCharacter(buffer, offset);
		offset += ByteFormat.CHARACTER_WIDTH;
		return character;
	}
}
