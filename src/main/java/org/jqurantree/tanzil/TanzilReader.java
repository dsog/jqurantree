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

import java.io.InputStream;

import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;
import org.jqurantree.core.resource.ResourceUtil;
import org.jqurantree.orthography.Chapter;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Used internally to initiate the orthography model by reading the embedded
 * Tanzil XML JAR resource.
 * 
 * @author Kais Dukes
 */
public class TanzilReader {

	/**
	 * The path to the Tanzil XML document, as an embedded JAR resource.
	 */
	public static final String TANZIL_RESOURCE_PATH = "/tanzil/quran-uthmani.xml";

	/**
	 * Loads the orthography model.
	 * 
	 * @return a <code>Chapter[]</code> array
	 */
	public Chapter[] readXml() {
		return readXml(TANZIL_RESOURCE_PATH);
	}

	/**
	 * Loads the orthography model, from the specified embedded JAR resource.
	 * 
	 * @param resourcePath
	 *            the full path and name of the resource
	 * 
	 * @return a <code>Chapter[]</code> array
	 */
	public Chapter[] readXml(String resourcePath) {

		try {

			// Create the Tanzil handler. This class will recieve
			// and handle the incoming SAX events.
			TanzilHandler handler = new TanzilHandler();

			// Use the default SAX reader.
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);

			// Initiate the SAX input source.
			InputStream stream = ResourceUtil.open(resourcePath);
			InputSource source = new InputSource(stream);

			// Parse the input.
			reader.parse(source);
			stream.close();

			// Return the chapters.
			return handler.getChapters();

		} catch (Exception exception) {
			throw new JQuranTreeException(Errors.INVALID_TANZIL_XML, exception);
		}
	}
}
