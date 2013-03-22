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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.jqurantree.arabic.ArabicText;
import org.junit.Test;

public class TokenTest {

	@Test
	public void TestChapter1Verse1() {

		// Get tokens.
		Iterator<Token> tokens = Document.getVerse(1, 1).getTokens().iterator();

		// Token #1.
		Token token = tokens.next();
		assertEquals(3, token.getLength());
		assertEquals("Ba + Kasra", token.getCharacter(0).toString());
		assertEquals("Seen + Sukun", token.getCharacter(1).toString());
		assertEquals("Meem + Kasra", token.getCharacter(2).toString());

		// Token #2.
		token = tokens.next();
		assertEquals(4, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Lam", token.getCharacter(1).toString());
		assertEquals("Lam + Fatha + Shadda", token.getCharacter(2).toString());
		assertEquals("Ha + Kasra", token.getCharacter(3).toString());

		// Token #3.
		token = tokens.next();
		assertEquals(7, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Lam", token.getCharacter(1).toString());
		assertEquals("Ra + Fatha + Shadda", token.getCharacter(2).toString());
		assertEquals("HHa + Sukun", token.getCharacter(3).toString());
		assertEquals("Meem + Fatha", token.getCharacter(4).toString());
		assertEquals("AlifKhanjareeya", token.getCharacter(5).toString());
		assertEquals("Noon + Kasra", token.getCharacter(6).toString());

		// Token #4.
		token = tokens.next();
		assertEquals(6, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Lam", token.getCharacter(1).toString());
		assertEquals("Ra + Fatha + Shadda", token.getCharacter(2).toString());
		assertEquals("HHa + Kasra", token.getCharacter(3).toString());
		assertEquals("Ya", token.getCharacter(4).toString());
		assertEquals("Meem + Kasra", token.getCharacter(5).toString());

		// Check that we have read all tokens.
		assertFalse(tokens.hasNext());
	}

	@Test
	public void TestChapter3Verse17() {

		// Get tokens.
		Iterator<Token> tokens = Document.getVerse(3, 17).getTokens()
				.iterator();

		// Token #1.
		ArabicText token = tokens.next();
		assertEquals(8, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Lam", token.getCharacter(1).toString());
		assertEquals("Sad + Fatha + Shadda", token.getCharacter(2).toString());
		assertEquals("AlifKhanjareeya", token.getCharacter(3).toString());
		assertEquals("Ba + Kasra", token.getCharacter(4).toString());
		assertEquals("Ra + Kasra", token.getCharacter(5).toString());
		assertEquals("Ya", token.getCharacter(6).toString());
		assertEquals("Noon + Fatha", token.getCharacter(7).toString());

		// Token #2.
		token = tokens.next();
		assertEquals(9, token.getLength());
		assertEquals("Waw + Fatha", token.getCharacter(0).toString());
		assertEquals("Alif + HamzatWasl", token.getCharacter(1).toString());
		assertEquals("Lam", token.getCharacter(2).toString());
		assertEquals("Sad + Fatha + Shadda", token.getCharacter(3).toString());
		assertEquals("AlifKhanjareeya", token.getCharacter(4).toString());
		assertEquals("Dal + Kasra", token.getCharacter(5).toString());
		assertEquals("Qaf + Kasra", token.getCharacter(6).toString());
		assertEquals("Ya", token.getCharacter(7).toString());
		assertEquals("Noon + Fatha", token.getCharacter(8).toString());

		// Token #3.
		token = tokens.next();
		assertEquals(9, token.getLength());
		assertEquals("Waw + Fatha", token.getCharacter(0).toString());
		assertEquals("Alif + HamzatWasl", token.getCharacter(1).toString());
		assertEquals("Lam + Sukun", token.getCharacter(2).toString());
		assertEquals("Qaf + Fatha", token.getCharacter(3).toString());
		assertEquals("AlifKhanjareeya", token.getCharacter(4).toString());
		assertEquals("Noon + Kasra", token.getCharacter(5).toString());
		assertEquals("Ta + Kasra", token.getCharacter(6).toString());
		assertEquals("Ya", token.getCharacter(7).toString());
		assertEquals("Noon + Fatha", token.getCharacter(8).toString());

		// Token #4.
		token = tokens.next();
		assertEquals(9, token.getLength());
		assertEquals("Waw + Fatha", token.getCharacter(0).toString());
		assertEquals("Alif + HamzatWasl", token.getCharacter(1).toString());
		assertEquals("Lam + Sukun", token.getCharacter(2).toString());
		assertEquals("Meem + Damma", token.getCharacter(3).toString());
		assertEquals("Noon", token.getCharacter(4).toString());
		assertEquals("Fa + Kasra", token.getCharacter(5).toString());
		assertEquals("Qaf + Kasra", token.getCharacter(6).toString());
		assertEquals("Ya", token.getCharacter(7).toString());
		assertEquals("Noon + Fatha", token.getCharacter(8).toString());

		// Token #5.
		token = tokens.next();
		assertEquals(11, token.getLength());
		assertEquals("Waw + Fatha", token.getCharacter(0).toString());
		assertEquals("Alif + HamzatWasl", token.getCharacter(1).toString());
		assertEquals("Lam + Sukun", token.getCharacter(2).toString());
		assertEquals("Meem + Damma", token.getCharacter(3).toString());
		assertEquals("Seen + Sukun", token.getCharacter(4).toString());
		assertEquals("Ta + Fatha", token.getCharacter(5).toString());
		assertEquals("Ghain + Sukun", token.getCharacter(6).toString());
		assertEquals("Fa + Kasra", token.getCharacter(7).toString());
		assertEquals("Ra + Kasra", token.getCharacter(8).toString());
		assertEquals("Ya", token.getCharacter(9).toString());
		assertEquals("Noon + Fatha", token.getCharacter(10).toString());

		// Token #6.
		token = tokens.next();
		assertEquals(8, token.getLength());
		assertEquals("Ba + Kasra", token.getCharacter(0).toString());
		assertEquals("Alif + HamzatWasl", token.getCharacter(1).toString());
		assertEquals("Lam + Sukun", token.getCharacter(2).toString());
		assertEquals("Alif + Fatha + HamzaAbove", token.getCharacter(3)
				.toString());
		assertEquals("Seen + Sukun", token.getCharacter(4).toString());
		assertEquals("HHa + Fatha", token.getCharacter(5).toString());
		assertEquals("Alif", token.getCharacter(6).toString());
		assertEquals("Ra + Kasra", token.getCharacter(7).toString());

		// Check that we have read all tokens.
		assertFalse(tokens.hasNext());
	}

	@Test
	public void TestChapter38Verse1() {

		// Get tokens.
		Iterator<Token> tokens = Document.getVerse(38, 1).getTokens()
				.iterator();

		// Token #1.
		ArabicText token = tokens.next();
		assertEquals(1, token.getLength());
		assertEquals("Sad + Maddah", token.getCharacter(0).toString());

		// Token #2.
		token = tokens.next();
		assertEquals(8, token.getLength());
		assertEquals("Waw + Fatha", token.getCharacter(0).toString());
		assertEquals("Alif + HamzatWasl", token.getCharacter(1).toString());
		assertEquals("Lam + Sukun", token.getCharacter(2).toString());
		assertEquals("Qaf + Damma", token.getCharacter(3).toString());
		assertEquals("Ra + Sukun", token.getCharacter(4).toString());
		assertEquals("Hamza + Fatha", token.getCharacter(5).toString());
		assertEquals("Alif", token.getCharacter(6).toString());
		assertEquals("Noon + Kasra", token.getCharacter(7).toString());

		// Token #3.
		token = tokens.next();
		assertEquals(2, token.getLength());
		assertEquals("Thal + Kasra", token.getCharacter(0).toString());
		assertEquals("AlifMaksura", token.getCharacter(1).toString());

		// Token #4.
		token = tokens.next();
		assertEquals(5, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Lam", token.getCharacter(1).toString());
		assertEquals("Thal + Kasra + Shadda", token.getCharacter(2).toString());
		assertEquals("Kaf + Sukun", token.getCharacter(3).toString());
		assertEquals("Ra + Kasra", token.getCharacter(4).toString());

		// Check that we have read all tokens.
		assertFalse(tokens.hasNext());
	}

	@Test
	public void TestChapter81Verse2() {

		// Get tokens.
		Iterator<Token> tokens = Document.getVerse(81, 2).getTokens()
				.iterator();

		// Token #1.
		ArabicText token = tokens.next();
		assertEquals(4, token.getLength());
		assertEquals("Waw + Fatha", token.getCharacter(0).toString());
		assertEquals("Alif + Kasra + HamzaBelow", token.getCharacter(1)
				.toString());
		assertEquals("Thal + Fatha", token.getCharacter(2).toString());
		assertEquals("Alif", token.getCharacter(3).toString());

		// Token #2.
		token = tokens.next();
		assertEquals(6, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Lam", token.getCharacter(1).toString());
		assertEquals("Noon + Damma + Shadda", token.getCharacter(2).toString());
		assertEquals("Jeem + Damma", token.getCharacter(3).toString());
		assertEquals("Waw", token.getCharacter(4).toString());
		assertEquals("Meem + Damma", token.getCharacter(5).toString());

		// Token #3.
		token = tokens.next();
		assertEquals(6, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Noon", token.getCharacter(1).toString());
		assertEquals("Kaf + Fatha", token.getCharacter(2).toString());
		assertEquals("Dal + Fatha", token.getCharacter(3).toString());
		assertEquals("Ra + Fatha", token.getCharacter(4).toString());
		assertEquals("Ta + Sukun", token.getCharacter(5).toString());

		// Check that we have read all tokens.
		assertFalse(tokens.hasNext());
	}

	@Test
	public void TestChapter114Verse1() {

		// Get tokens.
		Iterator<Token> tokens = Document.getVerse(114, 1).getTokens()
				.iterator();

		// Token #1.
		ArabicText token = tokens.next();
		assertEquals(2, token.getLength());
		assertEquals("Qaf + Damma", token.getCharacter(0).toString());
		assertEquals("Lam + Sukun", token.getCharacter(1).toString());

		// Token #2.
		token = tokens.next();
		assertEquals(4, token.getLength());
		assertEquals("Alif + Fatha + HamzaAbove", token.getCharacter(0)
				.toString());
		assertEquals("Ain + Damma", token.getCharacter(1).toString());
		assertEquals("Waw", token.getCharacter(2).toString());
		assertEquals("Thal + Damma", token.getCharacter(3).toString());

		// Token #3.
		token = tokens.next();
		assertEquals(3, token.getLength());
		assertEquals("Ba + Kasra", token.getCharacter(0).toString());
		assertEquals("Ra + Fatha", token.getCharacter(1).toString());
		assertEquals("Ba + Kasra + Shadda", token.getCharacter(2).toString());

		// Token #4.
		token = tokens.next();
		assertEquals(5, token.getLength());
		assertEquals("Alif + HamzatWasl", token.getCharacter(0).toString());
		assertEquals("Lam", token.getCharacter(1).toString());
		assertEquals("Noon + Fatha + Shadda", token.getCharacter(2).toString());
		assertEquals("Alif", token.getCharacter(3).toString());
		assertEquals("Seen + Kasra", token.getCharacter(4).toString());

		// Check that we have read all tokens.
		assertFalse(tokens.hasNext());
	}
}
