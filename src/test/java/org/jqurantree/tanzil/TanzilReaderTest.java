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

package org.jqurantree.tanzil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;
import org.junit.Test;

public class TanzilReaderTest {

	@Test
	public void testReadInvalidResource() {

		// Initiate reader.
		TanzilReader reader = new TanzilReader();

		// Test that reading an invalid resource file is correctly handled.
		try {
			reader.readXml("/tanzil/invalid.xml");
			fail();
		} catch (JQuranTreeException exception) {
			assertEquals(Errors.INVALID_TANZIL_XML, exception.getMessage());
		}
	}
}
