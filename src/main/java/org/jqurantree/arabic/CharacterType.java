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
 * The <code>CharacterType</code> enumeration specifies which letter or symbol
 * an {@link org.jqurantree.arabic.ArabicCharacter} has, such as <i>Alif</i> or
 * <i>Ba</i>.
 * 
 * @author Kais Dukes
 */
public enum CharacterType {

	/**
	 * Arabic letter <i>Alif</i>.
	 */
	Alif,

	/**
	 * Arabic letter <i>Ba</i>.
	 */
	Ba,

	/**
	 * Arabic letter <i>Ta</i>.
	 */
	Ta,

	/**
	 * Arabic letter <i>Tha</i>.
	 */
	Tha,

	/**
	 * Arabic letter <i>Jeem</i>.
	 */
	Jeem,

	/**
	 * Arabic letter <i>HHa</i>.
	 */
	HHa,

	/**
	 * Arabic letter <i>Kha</i>.
	 */
	Kha,

	/**
	 * Arabic letter <i>Dal</i>.
	 */
	Dal,

	/**
	 * Arabic letter <i>Thal</i>.
	 */
	Thal,

	/**
	 * Arabic letter <i>Ra</i>.
	 */
	Ra,

	/**
	 * Arabic letter <i>Zain</i>.
	 */
	Zain,

	/**
	 * Arabic letter <i>Seen</i>.
	 */
	Seen,

	/**
	 * Arabic letter <i>Sheen</i>.
	 */
	Sheen,

	/**
	 * Arabic letter <i>Sad</i>.
	 */
	Sad,

	/**
	 * Arabic letter <i>DDad</i>.
	 */
	DDad,

	/**
	 * Arabic letter <i>TTa</i>.
	 */
	TTa,

	/**
	 * Arabic letter <i>DTha</i>.
	 */
	DTha,

	/**
	 * Arabic letter <i>Ain</i>.
	 */
	Ain,

	/**
	 * Arabic letter <i>Ghain</i>.
	 */
	Ghain,

	/**
	 * Arabic letter <i>Fa</i>.
	 */
	Fa,

	/**
	 * Arabic letter <i>Qaf</i>.
	 */
	Qaf,

	/**
	 * Arabic letter <i>Kaf</i>.
	 */
	Kaf,

	/**
	 * Arabic letter <i>Lam</i>.
	 */
	Lam,

	/**
	 * Arabic letter <i>Meem</i>.
	 */
	Meem,

	/**
	 * Arabic letter <i>Noon</i>.
	 */
	Noon,

	/**
	 * Arabic letter <i>Ha</i>.
	 */
	Ha,

	/**
	 * Arabic letter <i>Waw</i>.
	 */
	Waw,

	/**
	 * Arabic letter <i>Ya</i>.
	 */
	Ya,

	/**
	 * Arabic letter <i>Hamza</i>.
	 */
	Hamza,

	/**
	 * Arabic letter <i>Alif Maksura</i>.
	 */
	AlifMaksura,

	/**
	 * Arabic letter <i>Ta Marbuta</i>.
	 */
	TaMarbuta,

	/**
	 * Orthographic symbol used to lengthen the previous letter. In Tanzil XML,
	 * a diacritic hamza may sit on a tatweel.
	 */
	Tatweel,

	/**
	 * Quranic symbol small high <i>Seen</i>.
	 */
	SmallHighSeen,

	/**
	 * Quranic symbol high rounded zero.
	 */
	SmallHighRoundedZero,

	/**
	 * Quranic symbol high upright rectangular zero.
	 */
	SmallHighUprightRectangularZero,

	/**
	 * Quranic symbol <i>Meem</i> isloated form.
	 */
	SmallHighMeemIsolatedForm,

	/**
	 * Quranic symbol small low <i>Seen</i>.
	 */
	SmallLowSeen,

	/**
	 * Quranic symbol small <i>Waw</i>.
	 */
	SmallWaw,

	/**
	 * Quranic symbol small <i>Ya</i>.
	 */
	SmallYa,

	/**
	 * Quranic symbol small high <i>Noon</i>.
	 */
	SmallHighNoon,

	/**
	 * Quranic symbol empty centre low stop.
	 */
	EmptyCentreLowStop,

	/**
	 * Quranic symbol empty centre high stop.
	 */
	EmptyCentreHighStop,

	/**
	 * Quranic symbol rounded high stop with filled centre.
	 */
	RoundedHighStopWithFilledCentre,

	/**
	 * Quranic symbol small low <i>Meem</i>.
	 */
	SmallLowMeem;

	/**
	 * Gets a character type given its ordinal value.
	 * 
	 * @param ordinal
	 *            the ordinal value of the character
	 * 
	 * @return the character type with the specified ordinal value
	 */
	public static CharacterType valueOf(int ordinal) {
		return values[ordinal];
	}

	/**
	 * An ordered array of character types.
	 */
	public static final CharacterType[] values = { Alif, Ba, Ta, Tha, Jeem,
			HHa, Kha, Dal, Thal, Ra, Zain, Seen, Sheen, Sad, DDad, TTa, DTha,
			Ain, Ghain, Fa, Qaf, Kaf, Lam, Meem, Noon, Ha, Waw, Ya, Hamza,
			AlifMaksura, TaMarbuta, Tatweel, SmallHighSeen,
			SmallHighRoundedZero, SmallHighUprightRectangularZero,
			SmallHighMeemIsolatedForm, SmallLowSeen, SmallWaw, SmallYa,
			SmallHighNoon, EmptyCentreLowStop, EmptyCentreHighStop,
			RoundedHighStopWithFilledCentre, SmallLowMeem };
}
