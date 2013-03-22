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

package org.jqurantree.arabic.encoding;

import org.jqurantree.arabic.CharacterType;
import org.jqurantree.arabic.DiacriticType;

/**
 * <code>EncodingTableItem</code> is an entry in a table deriving from
 * {@link org.jqurantree.arabic.encoding.EncodingTableBase}, and is used by
 * table-driven encoders to map a character to a
 * {@link org.jqurantree.arabic.CharacterType} or a
 * {@link org.jqurantree.arabic.DiacriticType}.
 * 
 * @author Kais Dukes
 */
class EncodingTableItem {

	private final CharacterType characterType;
	private final DiacriticType diacriticType;

	public EncodingTableItem(CharacterType characterType,
			DiacriticType diacriticType) {
		this.characterType = characterType;
		this.diacriticType = diacriticType;
	}

	public CharacterType getCharacterType() {
		return characterType;
	}

	public DiacriticType getDiacriticType() {
		return diacriticType;
	}
}
