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

package org.jqurantree.arabic.encoding.buckwalter;

import org.jqurantree.arabic.CharacterType;
import org.jqurantree.arabic.DiacriticType;
import org.jqurantree.arabic.encoding.EncodingTableBase;
import org.jqurantree.arabic.encoding.unicode.UnicodeType;

class BuckwalterTable extends EncodingTableBase {

	public static BuckwalterTable buckwalterTable = new BuckwalterTable();

	public static BuckwalterTable getBuckwalterTable() {
		return buckwalterTable;
	}

	private BuckwalterTable() {

		addItem(UnicodeType.Hamza, '\'', CharacterType.Hamza);
		addItem(UnicodeType.AlifWithHamzaAbove, '>', CharacterType.Alif,
				DiacriticType.HamzaAbove);
		addItem(UnicodeType.WawWithHamzaAbove, '&', CharacterType.Waw,
				DiacriticType.HamzaAbove);
		addItem(UnicodeType.AlifWithHamzaBelow, '<', CharacterType.Alif,
				DiacriticType.HamzaBelow);
		addItem(UnicodeType.YaWithHamzaAbove, '}', CharacterType.Ya,
				DiacriticType.HamzaAbove);
		addItem(UnicodeType.Alif, 'A', CharacterType.Alif);
		addItem(UnicodeType.Ba, 'b', CharacterType.Ba);
		addItem(UnicodeType.TaMarbuta, 'p', CharacterType.TaMarbuta);
		addItem(UnicodeType.Ta, 't', CharacterType.Ta);
		addItem(UnicodeType.Tha, 'v', CharacterType.Tha);
		addItem(UnicodeType.Jeem, 'j', CharacterType.Jeem);
		addItem(UnicodeType.HHa, 'H', CharacterType.HHa);
		addItem(UnicodeType.Kha, 'x', CharacterType.Kha);
		addItem(UnicodeType.Dal, 'd', CharacterType.Dal);
		addItem(UnicodeType.Thal, '*', CharacterType.Thal);
		addItem(UnicodeType.Ra, 'r', CharacterType.Ra);
		addItem(UnicodeType.Zain, 'z', CharacterType.Zain);
		addItem(UnicodeType.Seen, 's', CharacterType.Seen);
		addItem(UnicodeType.Sheen, '$', CharacterType.Sheen);
		addItem(UnicodeType.Sad, 'S', CharacterType.Sad);
		addItem(UnicodeType.DDad, 'D', CharacterType.DDad);
		addItem(UnicodeType.TTa, 'T', CharacterType.TTa);
		addItem(UnicodeType.DTha, 'Z', CharacterType.DTha);
		addItem(UnicodeType.Ain, 'E', CharacterType.Ain);
		addItem(UnicodeType.Ghain, 'g', CharacterType.Ghain);
		addItem(UnicodeType.Tatweel, '_', CharacterType.Tatweel);
		addItem(UnicodeType.Fa, 'f', CharacterType.Fa);
		addItem(UnicodeType.Qaf, 'q', CharacterType.Qaf);
		addItem(UnicodeType.Kaf, 'k', CharacterType.Kaf);
		addItem(UnicodeType.Lam, 'l', CharacterType.Lam);
		addItem(UnicodeType.Meem, 'm', CharacterType.Meem);
		addItem(UnicodeType.Noon, 'n', CharacterType.Noon);
		addItem(UnicodeType.Ha, 'h', CharacterType.Ha);
		addItem(UnicodeType.Waw, 'w', CharacterType.Waw);
		addItem(UnicodeType.AlifMaksura, 'Y', CharacterType.AlifMaksura);
		addItem(UnicodeType.Ya, 'y', CharacterType.Ya);
		addItem(UnicodeType.Fathatan, 'F', DiacriticType.Fathatan);
		addItem(UnicodeType.Dammatan, 'N', DiacriticType.Dammatan);
		addItem(UnicodeType.Kasratan, 'K', DiacriticType.Kasratan);
		addItem(UnicodeType.Fatha, 'a', DiacriticType.Fatha);
		addItem(UnicodeType.Damma, 'u', DiacriticType.Damma);
		addItem(UnicodeType.Kasra, 'i', DiacriticType.Kasra);
		addItem(UnicodeType.Shadda, '~', DiacriticType.Shadda);
		addItem(UnicodeType.Sukun, 'o', DiacriticType.Sukun);
		addItem(UnicodeType.Maddah, '^', DiacriticType.Maddah);
		addItem(UnicodeType.HamzaAbove, '#', DiacriticType.HamzaAbove);
		addItem(UnicodeType.AlifKhanjareeya, '`', CharacterType.Alif,
				DiacriticType.AlifKhanjareeya);
		addItem(UnicodeType.AlifWithHamzatWasl, '{', CharacterType.Alif,
				DiacriticType.HamzatWasl);
		addItem(UnicodeType.SmallHighSeen, ':', CharacterType.SmallHighSeen);
		addItem(UnicodeType.SmallHighRoundedZero, '@',
				CharacterType.SmallHighRoundedZero);
		addItem(UnicodeType.SmallHighUprightRectangularZero, '"',
				CharacterType.SmallHighUprightRectangularZero);
		addItem(UnicodeType.SmallHighMeemIsolatedForm, '[',
				CharacterType.SmallHighMeemIsolatedForm);
		addItem(UnicodeType.SmallLowSeen, ';', CharacterType.SmallLowSeen);
		addItem(UnicodeType.SmallWaw, ',', CharacterType.SmallWaw);
		addItem(UnicodeType.SmallYa, '.', CharacterType.SmallYa);
		addItem(UnicodeType.SmallHighNoon, '!', CharacterType.SmallHighNoon);
		addItem(UnicodeType.EmptyCentreLowStop, '-',
				CharacterType.EmptyCentreLowStop);
		addItem(UnicodeType.EmptyCentreHighStop, '+',
				CharacterType.EmptyCentreHighStop);
		addItem(UnicodeType.RoundedHighStopWithFilledCentre, '%',
				CharacterType.RoundedHighStopWithFilledCentre);
		addItem(UnicodeType.SmallLowMeem, ']', CharacterType.SmallLowMeem);
	}
}
