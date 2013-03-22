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

package org.jqurantree.core.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;

/**
 * Utility class which supports reading lines of text from an embedded JAR
 * resource.
 * 
 * @author Kais Dukes
 */
public class ResourceReader {

	private final BufferedReader reader;
	private static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * Creates a new resource reader.
	 * 
	 * @param resourcePath
	 *            the full path and name of the resource, e.g. /foo/bar.txt
	 * 
	 * @throws JQuranTreeException
	 *             if the resource does not exist
	 */
	public ResourceReader(String resourcePath) {
		try {
			InputStream stream = ResourceUtil.open(resourcePath);
			reader = new BufferedReader(new InputStreamReader(stream,
					DEFAULT_ENCODING));
		} catch (UnsupportedEncodingException exception) {
			throw new JQuranTreeException(Errors.INVALID_ENCODING_TYPE,
					exception);
		}
	}

	/**
	 * Reads a line of text from the resource.
	 * 
	 * @return a <code>string</code> containing the contents of the line, not
	 *         including line break, or <code>null</code> if the end of the
	 *         resource has been reached.
	 */
	public String readLine() {
		String line;
		try {
			line = reader.readLine();
		} catch (IOException exception) {
			throw new JQuranTreeException(Errors.RESOURCE_READ_FAILED,
					exception);
		}
		return line;
	}

	/**
	 * Closes the resource.
	 */
	public void close() {
		try {
			reader.close();
		} catch (IOException exception) {
			throw new JQuranTreeException(Errors.RESOURCE_CLOSE_FAILED,
					exception);
		}
	}
}
