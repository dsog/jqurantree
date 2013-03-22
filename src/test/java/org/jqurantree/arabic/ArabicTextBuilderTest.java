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

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ArabicTextBuilderTest {

	@Test
	public void testTextBuilder() {

		// Alif + HamzatWasl
		ArabicTextBuilder builder = new ArabicTextBuilder();
		builder.add(CharacterType.Alif, DiacriticType.HamzatWasl);

		// Lam
		builder.add(CharacterType.Lam);

		// Seen + Fatha + Shadda
		builder.add(CharacterType.Seen, DiacriticType.Fatha,
				DiacriticType.Shadda);

		// Meem + Fatha
		builder.add(CharacterType.Meem, DiacriticType.Fatha);

		// Alif + Maddah
		builder.add(CharacterType.Alif, DiacriticType.Maddah);

		// Hamza + Damma
		builder.add(CharacterType.Hamza, DiacriticType.Damma);

		// Validate byte buffer.
		byte[] expectedBuffer = new byte[] { 0, 0, 8, 22, 0, 0, 11, 65, 0, 23,
				1, 0, 0, 0, 1, 28, 2, 0 };
		assertArrayEquals(expectedBuffer, builder.toByteArray());
	}
}
