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

import org.junit.Test;

public class LocationTest {

	@Test
	public void testLocation1() {

		// Initate location.
		Location location = new Location(81, 3);

		// Check components.
		assertEquals(81, location.getChapterNumber());
		assertEquals(3, location.getVerseNumber());

		// Check string format.
		assertEquals("(81:3)", location.toString());
	}

	@Test
	public void testLocation2() {

		// Initate location.
		Location location = new Location(81, 3, 2);

		// Check components.
		assertEquals(81, location.getChapterNumber());
		assertEquals(3, location.getVerseNumber());
		assertEquals(2, location.getTokenNumber());

		// Check string format.
		assertEquals("(81:3:2)", location.toString());
	}
}
