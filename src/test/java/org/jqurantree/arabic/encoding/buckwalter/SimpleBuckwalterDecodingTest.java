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

import org.jqurantree.arabic.ArabicText;
import org.junit.Test;

public class SimpleBuckwalterDecodingTest {

	@Test
	public void test1() {

		// bulobulN.
		ArabicText text = ArabicText.fromBuckwalter("bulobulN");

		// Validate character count.
		assertEquals(4, text.getLength());

		// Validate characters.
		assertEquals("Ba + Damma", text.getCharacter(0).toString());
		assertEquals("Lam + Sukun", text.getCharacter(1).toString());
		assertEquals("Ba + Damma", text.getCharacter(2).toString());
		assertEquals("Lam + Dammatan", text.getCharacter(3).toString());
	}

	@Test
	public void test2() {

		// balaAbilu.
		ArabicText text = ArabicText.fromBuckwalter("balaAbilu");

		// Validate character count.
		assertEquals(5, text.getLength());

		// Validate characters.
		assertEquals("Ba + Fatha", text.getCharacter(0).toString());
		assertEquals("Lam + Fatha", text.getCharacter(1).toString());
		assertEquals("Alif", text.getCharacter(2).toString());
		assertEquals("Ba + Kasra", text.getCharacter(3).toString());
		assertEquals("Lam + Damma", text.getCharacter(4).toString());
	}

	@Test
	public void test3() {

		// qur~aA'N.
		ArabicText text = ArabicText.fromBuckwalter("qur~aA'N");

		// Validate character count.
		assertEquals(4, text.getLength());

		// Validate characters.
		assertEquals("Qaf + Damma", text.getCharacter(0).toString());
		assertEquals("Ra + Fatha + Shadda", text.getCharacter(1).toString());
		assertEquals("Alif", text.getCharacter(2).toString());
		assertEquals("Hamza + Dammatan", text.getCharacter(3).toString());
	}

	@Test
	public void test4() {

		// qiraA'apF.
		ArabicText text = ArabicText.fromBuckwalter("qiraA'apF");

		// Validate character count.
		assertEquals(5, text.getLength());

		// Validate characters.
		assertEquals("Qaf + Kasra", text.getCharacter(0).toString());
		assertEquals("Ra + Fatha", text.getCharacter(1).toString());
		assertEquals("Alif", text.getCharacter(2).toString());
		assertEquals("Hamza + Fatha", text.getCharacter(3).toString());
		assertEquals("TaMarbuta + Fathatan", text.getCharacter(4).toString());
	}

	@Test
	public void test5() {

		// $ayo'K.
		ArabicText text = ArabicText.fromBuckwalter("$ayo'K");

		// Validate character count.
		assertEquals(3, text.getLength());

		// Validate characters.
		assertEquals("Sheen + Fatha", text.getCharacter(0).toString());
		assertEquals("Ya + Sukun", text.getCharacter(1).toString());
		assertEquals("Hamza + Kasratan", text.getCharacter(2).toString());
	}

	@Test
	public void test6() {

		// $y}A.
		ArabicText text = ArabicText.fromBuckwalter("$y}A");

		// Validate character count.
		assertEquals(4, text.getLength());

		// Validate characters.
		assertEquals("Sheen", text.getCharacter(0).toString());
		assertEquals("Ya", text.getCharacter(1).toString());
		assertEquals("Ya + HamzaAbove", text.getCharacter(2).toString());
		assertEquals("Alif", text.getCharacter(3).toString());
	}

	@Test
	public void test7() {

		// $ayo}aAni.
		ArabicText text = ArabicText.fromBuckwalter("$ayo}aAni");

		// Validate character count.
		assertEquals(5, text.getLength());

		// Validate characters.
		assertEquals("Sheen + Fatha", text.getCharacter(0).toString());
		assertEquals("Ya + Sukun", text.getCharacter(1).toString());
		assertEquals("Ya + Fatha + HamzaAbove", text.getCharacter(2).toString());
		assertEquals("Alif", text.getCharacter(3).toString());
		assertEquals("Noon + Kasra", text.getCharacter(4).toString());
	}

	@Test
	public void test8() {

		// say~i}uwna.
		ArabicText text = ArabicText.fromBuckwalter("say~i}uwna");

		// Validate character count.
		assertEquals(5, text.getLength());

		// Validate characters.
		assertEquals("Seen + Fatha", text.getCharacter(0).toString());
		assertEquals("Ya + Kasra + Shadda", text.getCharacter(1).toString());
		assertEquals("Ya + Damma + HamzaAbove", text.getCharacter(2).toString());
		assertEquals("Waw", text.getCharacter(3).toString());
		assertEquals("Noon + Fatha", text.getCharacter(4).toString());
	}

	@Test
	public void test9() {

		// ziyaArapu {lz~uw~aAri.
		ArabicText text = ArabicText.fromBuckwalter("ziyaArapu {lz~uw~aAri");

		// Validate character count.
		assertEquals(12, text.getLength());

		// Validate characters.
		assertEquals("Zain + Kasra", text.getCharacter(0).toString());
		assertEquals("Ya + Fatha", text.getCharacter(1).toString());
		assertEquals("Alif", text.getCharacter(2).toString());
		assertEquals("Ra + Fatha", text.getCharacter(3).toString());
		assertEquals("TaMarbuta + Damma", text.getCharacter(4).toString());
		assertEquals("<space>", text.getCharacter(5).toString());
		assertEquals("Alif + HamzatWasl", text.getCharacter(6).toString());
		assertEquals("Lam", text.getCharacter(7).toString());
		assertEquals("Zain + Damma + Shadda", text.getCharacter(8).toString());
		assertEquals("Waw + Fatha + Shadda", text.getCharacter(9).toString());
		assertEquals("Alif", text.getCharacter(10).toString());
		assertEquals("Ra + Kasra", text.getCharacter(11).toString());
	}

	@Test
	public void test10() {

		// miA}apN bi{lomi}api.
		ArabicText text = ArabicText.fromBuckwalter("miA}apN bi{lomi}api");

		// Validate character count.
		assertEquals(11, text.getLength());

		// Validate characters.
		assertEquals("Meem + Kasra", text.getCharacter(0).toString());
		assertEquals("Alif", text.getCharacter(1).toString());
		assertEquals("Ya + Fatha + HamzaAbove", text.getCharacter(2).toString());
		assertEquals("TaMarbuta + Dammatan", text.getCharacter(3).toString());
		assertEquals("<space>", text.getCharacter(4).toString());
		assertEquals("Ba + Kasra", text.getCharacter(5).toString());
		assertEquals("Alif + HamzatWasl", text.getCharacter(6).toString());
		assertEquals("Lam + Sukun", text.getCharacter(7).toString());
		assertEquals("Meem + Kasra", text.getCharacter(8).toString());
		assertEquals("Ya + Fatha + HamzaAbove", text.getCharacter(9).toString());
		assertEquals("TaMarbuta + Kasra", text.getCharacter(10).toString());
	}
}
