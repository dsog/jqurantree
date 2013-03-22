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

package org.jqurantree.core.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;

/**
 * Utility class which supports writing to a file.
 * 
 * @author Kais Dukes
 */
public class FileWriter {

	private final PrintStream printStream;

	/**
	 * Creates a new file writer by opening the specified file for writing.
	 * 
	 * @param filename
	 *            the path and name of the file, e.g. foo/bar.txt
	 */
	public FileWriter(String filename) {

		// Initiate file stream.
		FileOutputStream stream;
		try {
			stream = new FileOutputStream(filename);
		} catch (FileNotFoundException exception) {
			throw new JQuranTreeException(Errors.FILE_NOT_FOUND, exception);
		}

		// Initiate print stream.
		printStream = new PrintStream(stream);
	}

	/**
	 * Writes a character to the file.
	 * 
	 * @param ch
	 *            the <code>char</code> to write
	 */
	public void write(char ch) {
		printStream.print(ch);
	}

	/**
	 * Writes a string to the file
	 * 
	 * @param text
	 *            the <code>string</code> to write
	 */
	public void write(String text) {
		printStream.print(text);
	}

	/**
	 * Writes a line break to the file.
	 */
	public void writeLine() {
		printStream.println();
	}

	/**
	 * Writes a new line of text to the file.
	 * 
	 * @param text
	 *            the line of text to write
	 */
	public void writeLine(String text) {
		printStream.println(text);
	}

	/**
	 * Closes the resource.
	 */
	public void close() {
		printStream.close();
	}
}
