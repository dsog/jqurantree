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

package org.jqurantree.arabic.encoding;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.jqurantree.arabic.ArabicText;
import org.jqurantree.core.resource.ResourceUtil;
import org.jqurantree.tanzil.TanzilReader;
import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class DocumentEncodingTest extends DefaultHandler {

	private EncodingType encodingType;

	@Test
	public void testUnicode() throws Exception {
		testEncoding(EncodingType.Unicode);
	}

	@Test
	public void testBuckwalter() throws Exception {
		testEncoding(EncodingType.Buckwalter);
	}

	private void testEncoding(EncodingType encodingType) throws Exception {

		// Initiate test.
		this.encodingType = encodingType;

		// Use the default SAX reader.
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(this);

		// Initiate the SAX input source.
		InputStream stream = ResourceUtil
				.open(TanzilReader.TANZIL_RESOURCE_PATH);
		InputSource source = new InputSource(stream);

		// Parse the input.
		reader.parse(source);
		stream.close();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		// Test verse.
		if (localName.equals("aya")) {
			testVerse(attributes.getValue("text"));
		}
	}

	private void testVerse(String unicode) {

		// Decode Unicode.
		ArabicText text = new ArabicText(unicode);

		// Unicode.
		if (encodingType == EncodingType.Unicode) {

			// Encode to check that we recover the original character data.
			assertEquals(unicode, text.toString());

		} else {

			// Encode.
			String expectedText = text.toString(encodingType);

			// Decode to check that we recover the original character data.
			String actualText = ArabicText.fromEncoding(expectedText,
					encodingType).toString(encodingType);
			assertEquals(expectedText, actualText);
		}
	}
}
