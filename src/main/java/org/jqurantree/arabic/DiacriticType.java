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

/**
 * The <code>DiacriticType</code> enumeration specifies the type of diaciritcs
 * attached to an {@link org.jqurantree.arabic.ArabicCharacter}, such as
 * <i>Fatha</i> or <i>Kasra</i>.
 * 
 * @author Kais Dukes
 */
public enum DiacriticType {

	/**
	 * Diacritic above a character.
	 */
	Fatha,

	/**
	 * Diacritic above a character.
	 */
	Damma,

	/**
	 * Diacritic below a character.
	 */
	Kasra,

	/**
	 * Double <i>Fatha</i>.
	 */
	Fathatan,

	/**
	 * Double <i>Damma</i>.
	 */
	Dammatan,

	/**
	 * Double <i>Kasra</i>.
	 */
	Kasratan,

	/**
	 * Diacritic above a character.
	 */
	Shadda,

	/**
	 * Diacritic above a character.
	 */
	Sukun,

	/**
	 * Diacritic above a character.
	 */
	Maddah,

	/**
	 * <i>Hamza</i> above a character.
	 */
	HamzaAbove,

	/**
	 * <i>Hamza</i> below a character.
	 */
	HamzaBelow,

	/**
	 * Diacritic above an <i>Alif</i>.
	 */
	HamzatWasl,

	/**
	 * Superscript <i>Alif</i>.
	 */
	AlifKhanjareeya;

	/**
	 * An ordered array of diacritic types.
	 */
	public static DiacriticType[] values = { Fatha, Damma, Kasra, Fathatan,
			Dammatan, Kasratan, Shadda, Sukun, Maddah, HamzaAbove, HamzaBelow,
			HamzatWasl, AlifKhanjareeya };
}
