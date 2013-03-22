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

import java.io.InputStream;

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;

/**
 * Utiltiy class which provides convenience methods for accessing embedded JAR
 * resources.
 * 
 * @author Kais Dukes
 */
public class ResourceUtil {

	private static final Class resourceType = new ResourceUtil().getClass();

	private ResourceUtil() {
	}

	/**
	 * Opens an embedded JAR resource for reading.
	 * 
	 * @param resourcePath
	 *            the full path and name of the resource, e.g. /foo/bar.txt
	 * 
	 * @throws JQuranTreeException
	 *             if the resource does not exist
	 * 
	 * @return an open <code>InputStream</code> used to read the resource.
	 */
	public static InputStream open(String resourcePath) {
		InputStream stream = resourceType.getResourceAsStream(resourcePath);
		if (stream == null) {
			throw new JQuranTreeException(Errors.RESOURCE_NOT_FOUND);
		}
		return stream;
	}

	/**
	 * Opens an embedded JAR resource, reads the entire content as text, then
	 * closes the resource.
	 * 
	 * @param resourcePath
	 *            the full path and name of the resource, e.g. /foo/bar.txt
	 * 
	 * @throws JQuranTreeException
	 *             if the resource does not exist
	 * 
	 * @return a <code>string</code> containing the entire text content of the
	 *         resource
	 */
	public static String getText(String resourcePath) {

		// Open the resource.
		ResourceReader reader = new ResourceReader(resourcePath);

		// Read the source.
		StringBuilder text = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			text.append(line);
			text.append("\r\n");
		}

		// Close the resource.
		reader.close();

		// Return text.
		return text.toString();
	}
}
