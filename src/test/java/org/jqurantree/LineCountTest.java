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

package org.jqurantree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jqurantree.core.error.JQuranTreeException;
import org.junit.Ignore;
import org.junit.Test;

public class LineCountTest {

	@Test
	@Ignore
	public void testLineCount() {

		// Count lines.
		int mainCount = countDirectory(new File("src/main"));
		int testCount = countDirectory(new File("src/test"));

		// Display counts.
		System.out.println("Line count (main): " + mainCount);
		System.out.println("Line count (test): " + testCount);
		System.out.println("Total: " + (mainCount + testCount));
	}

	private int countDirectory(File file) {

		// Count files.
		int count = 0;
		if (file.getName().endsWith(".java")) {
			count += countFile(file);
		}

		// Recurse through subdirectories.
		String[] directories = file.list();
		if (directories != null) {
			for (String directory : directories) {
				count += countDirectory(new File(file, directory));
			}
		}

		// Return count.
		return count;
	}

	private int countFile(File file) {
		int count = 0;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			while (reader.readLine() != null) {
				count++;
			}
			reader.close();
		} catch (IOException exception) {
			throw new JQuranTreeException("Failed to read: "
					+ file.getAbsolutePath(), exception);
		}
		return count;
	}
}
