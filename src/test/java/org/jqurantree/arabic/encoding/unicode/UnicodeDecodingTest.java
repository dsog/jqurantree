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

package org.jqurantree.arabic.encoding.unicode;

import static org.junit.Assert.assertEquals;

import org.jqurantree.arabic.ArabicText;
import org.junit.Test;

public class UnicodeDecodingTest {

	@Test
	public void testAlifWithHamzaAbove() {

		// Anamta.
		ArabicText text = new ArabicText(
				"\u0623\u064E\u0646\u0652\u0639\u064E\u0645\u0652\u062A\u064E");

		// Validate character count.
		assertEquals(5, text.getLength());

		// Validate characters.
		assertEquals("Alif + Fatha + HamzaAbove", text.getCharacter(0)
				.toString());
		assertEquals("Noon + Sukun", text.getCharacter(1).toString());
		assertEquals("Ain + Fatha", text.getCharacter(2).toString());
		assertEquals("Meem + Sukun", text.getCharacter(3).toString());
		assertEquals("Ta + Fatha", text.getCharacter(4).toString());
	}

	@Test
	public void testWawWithHamzaAbove() {

		// Yominoon.
		ArabicText text = new ArabicText(
				"\u064A\u064F\u0624\u0652\u0645\u0650\u0646\u064F\u0648\u0646\u064E");

		// Validate character count.
		assertEquals(6, text.getLength());

		// Validate characters.
		assertEquals("Ya + Damma", text.getCharacter(0).toString());
		assertEquals("Waw + Sukun + HamzaAbove", text.getCharacter(1)
				.toString());
		assertEquals("Meem + Kasra", text.getCharacter(2).toString());
		assertEquals("Noon + Damma", text.getCharacter(3).toString());
		assertEquals("Waw", text.getCharacter(4).toString());
		assertEquals("Noon + Fatha", text.getCharacter(5).toString());
	}

	@Test
	public void testAlifWithHamzaBelow() {

		// Eyaaka.
		ArabicText text = new ArabicText(
				"\u0625\u0650\u064A\u0651\u064E\u0627\u0643\u064E");

		// Validate character count.
		assertEquals(4, text.getLength());

		// Validate characters.
		assertEquals("Alif + Kasra + HamzaBelow", text.getCharacter(0)
				.toString());
		assertEquals("Ya + Fatha + Shadda", text.getCharacter(1).toString());
		assertEquals("Alif", text.getCharacter(2).toString());
		assertEquals("Kaf + Fatha", text.getCharacter(3).toString());
	}

	@Test
	public void testYayWithHamzaAbove() {

		// Olaaika.
		ArabicText text = new ArabicText(
				"\u0623\u064F\u0648\u06DF\u0644\u064E\u0670\u0653\u0626\u0650\u0643\u064E");

		// Validate character count.
		assertEquals(7, text.getLength());

		// Validate characters.
		assertEquals("Alif + Damma + HamzaAbove", text.getCharacter(0)
				.toString());
		assertEquals("Waw", text.getCharacter(1).toString());
		assertEquals("SmallHighRoundedZero", text.getCharacter(2).toString());
		assertEquals("Lam + Fatha", text.getCharacter(3).toString());
		assertEquals("Alif + Maddah + AlifKhanjareeya", text.getCharacter(4)
				.toString());
		assertEquals("Ya + Kasra + HamzaAbove", text.getCharacter(5).toString());
		assertEquals("Kaf + Fatha", text.getCharacter(6).toString());
	}

	@Test
	public void testAlifKhanjareeya() {

		// Al-Rahmaan.
		ArabicText text = new ArabicText(
				"\u0671\u0644\u0631\u0651\u064E\u062D\u0652\u0645\u064E\u0670\u0646\u0650");

		// Validate character count.
		assertEquals(7, text.getLength());

		// Validate characters.
		assertEquals("Alif + HamzatWasl", text.getCharacter(0).toString());
		assertEquals("Lam", text.getCharacter(1).toString());
		assertEquals("Ra + Fatha + Shadda", text.getCharacter(2).toString());
		assertEquals("HHa + Sukun", text.getCharacter(3).toString());
		assertEquals("Meem + Fatha", text.getCharacter(4).toString());
		assertEquals("AlifKhanjareeya", text.getCharacter(5).toString());
		assertEquals("Noon + Kasra", text.getCharacter(6).toString());
	}

	@Test
	public void testAlifWithHamzatWasl() {

		// Allah.
		ArabicText text = new ArabicText(
				"\u0671\u0644\u0644\u0651\u064E\u0647\u0650");

		// Validate character count.
		assertEquals(4, text.getLength());

		// Validate characters.
		assertEquals("Alif + HamzatWasl", text.getCharacter(0).toString());
		assertEquals("Lam", text.getCharacter(1).toString());
		assertEquals("Lam + Fatha + Shadda", text.getCharacter(2).toString());
		assertEquals("Ha + Kasra", text.getCharacter(3).toString());
	}

	@Test
	public void testHamzaAbove() {

		// Anbioonee.
		ArabicText text = new ArabicText(
				"\u0623\u064E\u0646\u06E2\u0628\u0650\u0640\u0654\u064F\u0648\u0646\u0650\u0649");

		// Validate character count.
		assertEquals(8, text.getLength());

		// Validate characters.
		assertEquals("Alif + Fatha + HamzaAbove", text.getCharacter(0)
				.toString());
		assertEquals("Noon", text.getCharacter(1).toString());
		assertEquals("SmallHighMeemIsolatedForm", text.getCharacter(2)
				.toString());
		assertEquals("Ba + Kasra", text.getCharacter(3).toString());
		assertEquals("Tatweel + Damma + HamzaAbove", text.getCharacter(4)
				.toString());
		assertEquals("Waw", text.getCharacter(5).toString());
		assertEquals("Noon + Kasra", text.getCharacter(6).toString());
		assertEquals("AlifMaksura", text.getCharacter(7).toString());
	}

	@Test
	public void testFathatan() {

		// Hoddan.
		ArabicText text = new ArabicText("\u0647\u064F\u062F\u064B\u0649");

		// Validate character count.
		assertEquals(3, text.getLength());

		// Validate characters.
		assertEquals("Ha + Damma", text.getCharacter(0).toString());
		assertEquals("Dal + Fathatan", text.getCharacter(1).toString());
		assertEquals("AlifMaksura", text.getCharacter(2).toString());
	}

	@Test
	public void testDammatan() {

		// Sawaoon.
		ArabicText text = new ArabicText(
				"\u0633\u064E\u0648\u064E\u0627\u0653\u0621\u064C");

		// Validate character count.
		assertEquals(4, text.getLength());

		// Validate characters.
		assertEquals("Seen + Fatha", text.getCharacter(0).toString());
		assertEquals("Waw + Fatha", text.getCharacter(1).toString());
		assertEquals("Alif + Maddah", text.getCharacter(2).toString());
		assertEquals("Hamza + Dammatan", text.getCharacter(3).toString());
	}

	@Test
	public void testKastratan() {

		// Dthulumaatin.
		ArabicText text = new ArabicText(
				"\u0638\u064F\u0644\u064F\u0645\u064E\u0670\u062A\u064D");

		// Validate character count.
		assertEquals(5, text.getLength());

		// Validate characters.
		assertEquals("DTha + Damma", text.getCharacter(0).toString());
		assertEquals("Lam + Damma", text.getCharacter(1).toString());
		assertEquals("Meem + Fatha", text.getCharacter(2).toString());
		assertEquals("AlifKhanjareeya", text.getCharacter(3).toString());
		assertEquals("Ta + Kasratan", text.getCharacter(4).toString());
	}
}
