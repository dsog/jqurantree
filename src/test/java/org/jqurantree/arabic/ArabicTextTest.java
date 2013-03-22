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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArabicTextTest {

	@Test
	public void testArabicText() {

		// Create Arabic text from byte buffer.
		ArabicText text = new ArabicText(new byte[] { 0, 0, 8, 22, 0, 0, 11,
				65, 0, 23, 1, 0, 0, 0, 1, 28, 2, 0 });

		// Validate character count.
		assertEquals(6, text.getLength());

		// Validate characters.
		assertEquals(CharacterType.Alif, text.getCharacter(0).getType());
		assertEquals(CharacterType.Lam, text.getCharacter(1).getType());
		assertEquals(CharacterType.Seen, text.getCharacter(2).getType());
		assertEquals(CharacterType.Meem, text.getCharacter(3).getType());
		assertEquals(CharacterType.Alif, text.getCharacter(4).getType());
		assertEquals(CharacterType.Hamza, text.getCharacter(5).getType());

		// Check existing diacritics.
		assertTrue(text.getCharacter(0).isHamzatWasl());
		assertTrue(text.getCharacter(2).isFatha());
		assertTrue(text.getCharacter(2).isShadda());
		assertTrue(text.getCharacter(3).isFatha());
		assertTrue(text.getCharacter(4).isMaddah());
		assertTrue(text.getCharacter(5).isDamma());

		// Check non-existing diacritics.
		assertFalse(text.getCharacter(0).isAlifKhanjareeya());
		assertFalse(text.getCharacter(1).isKasratan());
		assertFalse(text.getCharacter(2).isDammatan());
		assertFalse(text.getCharacter(3).isSukun());
		assertFalse(text.getCharacter(4).isDamma());
		assertFalse(text.getCharacter(5).isMaddah());
	}

	@Test
	public void testUnicode() {

		// Decode.
		String unicode = "\u0623\u064E\u0646\u0652\u0639\u064E\u0645\u0652\u062A\u064E";
		ArabicText text = ArabicText.fromUnicode(unicode);

		// Encode + validate.
		assertEquals(unicode, text.toUnicode());
	}

	@Test
	public void testEnumerateCharacters() {

		// Expected results.
		String[] characters = { "Alif + Kasra + HamzaBelow",
				"Ya + Fatha + Shadda", "Alif", "Kaf + Fatha" };

		// Create Arabic text.
		ArabicText text = new ArabicText(
				"\u0625\u0650\u064a\u0651\u064e\u0627\u0643\u064e");

		// Test that we can enumerate through all characters.
		int characterCount = 0;
		for (ArabicCharacter ch : text) {

			// Validate.
			assertEquals(characters[characterCount++], ch.toString());
		}

		// We should have read 4 characters.
		assertEquals(4, characterCount);
	}
}
