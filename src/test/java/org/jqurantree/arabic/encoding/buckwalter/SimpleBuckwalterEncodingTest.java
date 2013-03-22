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

import static org.junit.Assert.assertEquals;

import org.jqurantree.arabic.ArabicTextBuilder;
import org.jqurantree.arabic.CharacterType;
import org.jqurantree.arabic.DiacriticType;
import org.junit.Test;

public class SimpleBuckwalterEncodingTest {

	@Test
	public void test1() {

		// bulobulN.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Ba + Damma
		builder.add(CharacterType.Ba, DiacriticType.Damma);

		// Lam + Sukun
		builder.add(CharacterType.Lam, DiacriticType.Sukun);

		// Ba + Damma
		builder.add(CharacterType.Ba, DiacriticType.Damma);

		// Lam + Dammatan
		builder.add(CharacterType.Lam, DiacriticType.Dammatan);

		// Validate.
		assertEquals("bulobulN", builder.toText().toBuckwalter());
	}

	@Test
	public void test2() {

		// balaAbilu.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Ba + Fatha
		builder.add(CharacterType.Ba, DiacriticType.Fatha);

		// Lam + Fatha
		builder.add(CharacterType.Lam, DiacriticType.Fatha);

		// Alif
		builder.add(CharacterType.Alif);

		// Ba + Kasra
		builder.add(CharacterType.Ba, DiacriticType.Kasra);

		// Lam + Damma
		builder.add(CharacterType.Lam, DiacriticType.Damma);

		// Validate.
		assertEquals("balaAbilu", builder.toText().toBuckwalter());
	}

	@Test
	public void test3() {

		// qur~aA'N.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Qaf + Damma
		builder.add(CharacterType.Qaf, DiacriticType.Damma);

		// Ra + Shadda + Fatha
		builder
				.add(CharacterType.Ra, DiacriticType.Shadda,
						DiacriticType.Fatha);

		// Alif
		builder.add(CharacterType.Alif);

		// Hamza + Dammatan
		builder.add(CharacterType.Hamza, DiacriticType.Dammatan);

		// Validate.
		assertEquals("qur~aA'N", builder.toText().toBuckwalter());
	}

	@Test
	public void test4() {

		// qiraA'apF.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Qaf + Kasra
		builder.add(CharacterType.Qaf, DiacriticType.Kasra);

		// Ra + Fatha
		builder.add(CharacterType.Ra, DiacriticType.Fatha);

		// Alif
		builder.add(CharacterType.Alif);

		// Hamza + Fatha
		builder.add(CharacterType.Hamza, DiacriticType.Fatha);

		// TaMarbuta + Fathatan
		builder.add(CharacterType.TaMarbuta, DiacriticType.Fathatan);

		// Validate.
		assertEquals("qiraA'apF", builder.toText().toBuckwalter());
	}

	@Test
	public void test5() {

		// $ayo'K.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Sheen + Fatha
		builder.add(CharacterType.Sheen, DiacriticType.Fatha);

		// Ya + Sukun
		builder.add(CharacterType.Ya, DiacriticType.Sukun);

		// Hamza + Kasratan
		builder.add(CharacterType.Hamza, DiacriticType.Kasratan);

		// Validate.
		assertEquals("$ayo'K", builder.toText().toBuckwalter());
	}

	@Test
	public void test6() {

		// $y}A.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Sheen
		builder.add(CharacterType.Sheen);

		// Ya
		builder.add(CharacterType.Ya);

		// Ya + HamzaAbove
		builder.add(CharacterType.Ya, DiacriticType.HamzaAbove);

		// Alif
		builder.add(CharacterType.Alif);

		// Validate.
		assertEquals("$y}A", builder.toText().toBuckwalter());
	}

	@Test
	public void test7() {

		// $ayo}aAni.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Sheen + Fatha
		builder.add(CharacterType.Sheen, DiacriticType.Fatha);

		// Ya + Sukun
		builder.add(CharacterType.Ya, DiacriticType.Sukun);

		// Ya + HamzaAbove + Fatha
		builder.add(CharacterType.Ya, DiacriticType.HamzaAbove,
				DiacriticType.Fatha);

		// Alif
		builder.add(CharacterType.Alif);

		// Noon + Damma
		builder.add(CharacterType.Noon, DiacriticType.Kasra);

		// Validate.
		assertEquals("$ayo}aAni", builder.toText().toBuckwalter());
	}

	@Test
	public void test8() {

		// say~i}uwna.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Seen + Fatha
		builder.add(CharacterType.Seen, DiacriticType.Fatha);

		// Ya + Shadda + Kasra
		builder
				.add(CharacterType.Ya, DiacriticType.Shadda,
						DiacriticType.Kasra);

		// Ya + HamzaAbove + Damma
		builder.add(CharacterType.Ya, DiacriticType.HamzaAbove,
				DiacriticType.Damma);

		// Waw
		builder.add(CharacterType.Waw);

		// Noon + Fatha
		builder.add(CharacterType.Noon, DiacriticType.Fatha);

		// Validate.
		assertEquals("say~i}uwna", builder.toText().toBuckwalter());
	}

	@Test
	public void test9() {

		// ziyaArapu {lz~uw~aAri.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Zain + Kasra
		builder.add(CharacterType.Zain, DiacriticType.Kasra);

		// Ya + Fatha
		builder.add(CharacterType.Ya, DiacriticType.Fatha);

		// Alif
		builder.add(CharacterType.Alif);

		// Ra + Fatha
		builder.add(CharacterType.Ra, DiacriticType.Fatha);

		// TaMarbuta + Damma
		builder.add(CharacterType.TaMarbuta, DiacriticType.Damma);

		// Whitespace
		builder.addWhitespace();

		// Alif + HamzatWasl
		builder.add(CharacterType.Alif, DiacriticType.HamzatWasl);

		// Lam
		builder.add(CharacterType.Lam);

		// Zain + Shadda + Damma
		builder.add(CharacterType.Zain, DiacriticType.Shadda,
				DiacriticType.Damma);

		// Waw + Shadda + Fatha
		builder.add(CharacterType.Waw, DiacriticType.Shadda,
				DiacriticType.Fatha);

		// Alif
		builder.add(CharacterType.Alif);

		// Ra + Kasra
		builder.add(CharacterType.Ra, DiacriticType.Kasra);

		// Validate.
		assertEquals("ziyaArapu {lz~uw~aAri", builder.toText().toBuckwalter());
	}

	@Test
	public void test10() {

		// miA}apN bi{lomi}api.
		ArabicTextBuilder builder = new ArabicTextBuilder();

		// Meem + Kasra
		builder.add(CharacterType.Meem, DiacriticType.Kasra);

		// Alif
		builder.add(CharacterType.Alif);

		// Ya + HamzaAbove + Fatha
		builder.add(CharacterType.Ya, DiacriticType.HamzaAbove,
				DiacriticType.Fatha);

		// TaMarbuta + Dammatan
		builder.add(CharacterType.TaMarbuta, DiacriticType.Dammatan);

		// Whitespace
		builder.addWhitespace();

		// Ba + Kasra
		builder.add(CharacterType.Ba, DiacriticType.Kasra);

		// Alif + HamzatWasl
		builder.add(CharacterType.Alif, DiacriticType.HamzatWasl);

		// Lam + Sukun
		builder.add(CharacterType.Lam, DiacriticType.Sukun);

		// Meem + Kasra
		builder.add(CharacterType.Meem, DiacriticType.Kasra);

		// Ya + HamzaAbove + Fatha
		builder.add(CharacterType.Ya, DiacriticType.HamzaAbove,
				DiacriticType.Fatha);

		// TaMarbuta + Kasra
		builder.add(CharacterType.TaMarbuta, DiacriticType.Kasra);

		// Validate.
		assertEquals("miA}apN bi{lomi}api", builder.toText().toBuckwalter());
	}
}
