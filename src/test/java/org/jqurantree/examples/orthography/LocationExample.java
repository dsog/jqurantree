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

package org.jqurantree.examples.orthography;

import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Location;
import org.jqurantree.orthography.Verse;

/**
 * This example shows how to use the Location class to access a verse. A
 * location references a position within the Quranic text by chapter number,
 * verse number or by token number. In this example, we create a new location
 * that references verse (27:30), and then retrieve the verse at this location.
 * By default, the verse will be displayed using Buckwalter transliteration.
 * 
 * @author Kais Dukes
 */
public class LocationExample {

	public static void main() {

		// Get verse (27:30) by location.
		Location location = new Location(27, 30);
		Verse verse = Document.getVerse(location);

		// Display the verse.
		System.out.println(verse);
	}
}
