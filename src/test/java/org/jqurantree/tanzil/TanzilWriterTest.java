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

import java.io.IOException;

import org.jqurantree.arabic.encoding.EncodingOptions;
import org.jqurantree.arabic.encoding.EncodingType;
import org.jqurantree.core.resource.ResourceReader;
import org.jqurantree.orthography.Chapter;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Verse;
import org.junit.Test;

public class TanzilWriterTest {

	public static final String COPYRIGHT_RESOURCE_PATH = "/tanzil/copyright.txt";
	private final ResourceReader expectedReader = new ResourceReader(
			TanzilReader.TANZIL_RESOURCE_PATH);
	private static final String XML_PREAMBLE = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>";
	private int lineNumber = 0;

	@Test
	public void testWriteTanzilXml() throws IOException {

		// Write.
		writePreamble();
		writeCopyright();
		writeChapters();

		// Validate end.
		validateEnd();
	}

	private void writePreamble() {
		validateLine(XML_PREAMBLE);
	}

	private void writeCopyright() {

		// Start.
		validateLine("<!--");
		validateLine();

		// Copyright.
		ResourceReader reader = new ResourceReader(COPYRIGHT_RESOURCE_PATH);
		String line;
		while ((line = reader.readLine()) != null) {
			validateLine(line);
		}

		// End.
		validateLine("-->");
	}

	private void writeChapters() {

		// Start.
		validateLine("<quran>");

		// Chapters.
		for (Chapter chapter : Document.getChapters()) {
			writeChapter(chapter);
		}

		// End.
		validateLine("</quran>");
	}

	private void writeChapter(Chapter chapter) {

		// Start.
		validateLine("\t<sura index=\""
				+ chapter.getChapterNumber()
				+ "\" name=\""
				+ chapter.getName().toString(EncodingType.Unicode,
						EncodingOptions.CombineAlifWithMaddah) + "\">");

		// Verses.
		for (Verse verse : chapter) {

			// Write.
			StringBuilder text = new StringBuilder();
			text.append("\t\t<aya index=\"");
			text.append(verse.getVerseNumber());
			text.append("\" text=\"");
			text.append(verse.toUnicode());
			text.append("\"");

			// Bismillah.
			if (verse.getVerseNumber() == 1 && chapter.getBismillah() != null) {
				text.append(" bismillah=\"");
				text.append(chapter.getBismillah());
				text.append("\"");
			}
			text.append(" />");

			// Validate.
			validateLine(text.toString());
		}

		// End.
		validateLine("\t</sura>");
	}

	private void validateLine() {
		validateLine("");
	}

	private void validateLine(String actualLine) {

		// Expected line.
		lineNumber++;
		String expectedLine = expectedReader.readLine();

		// Validate.
		if (!expectedLine.equals(actualLine)) {

			// Status.
			System.out.println("Line " + lineNumber + ":");
			System.out.println("    Expected: [" + expectedLine + "]");
			System.out.println("    Actual:   [" + actualLine + "]");

			// Fail.
			assertEquals(expectedLine, actualLine);
		}
	}

	private void validateEnd() {

		// Expected line.
		lineNumber++;
		String expectedLine = expectedReader.readLine();

		// Validate.
		if (expectedLine != null) {

			// Status.
			System.out.println("Line " + lineNumber + ":");
			System.out.println("    Expected: [" + expectedLine + "]");
			System.out.println("    Actual:   <end>");

			// Fail.
			fail();
		}
	}
}
