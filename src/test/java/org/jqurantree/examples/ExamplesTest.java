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

package org.jqurantree.examples;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jqurantree.core.error.JQuranTreeException;
import org.jqurantree.core.resource.ResourceUtil;
import org.jqurantree.examples.analysis.AnalysisTableExample;
import org.jqurantree.examples.analysis.ChapterInitialsExample;
import org.jqurantree.examples.analysis.CharacterFrequencyExample;
import org.jqurantree.examples.analysis.CsvExportExample;
import org.jqurantree.examples.analysis.LongestTokenExample;
import org.jqurantree.examples.analysis.TokenCountExample;
import org.jqurantree.examples.analysis.TokenFrequencyExample;
import org.jqurantree.examples.analysis.VerseCountExample;
import org.jqurantree.examples.orthography.BismillahExample;
import org.jqurantree.examples.orthography.BuckwalterExample;
import org.jqurantree.examples.orthography.LocationExample;
import org.jqurantree.examples.orthography.SimpleEncodingExample;
import org.jqurantree.examples.search.LetterSearchExample;
import org.jqurantree.examples.search.TokenSearchExample;
import org.junit.Test;

public class ExamplesTest {

	@Test
	public void testChapterInitials() {
		testExample(ChapterInitialsExample.class);
	}

	@Test
	public void testAnalysisTable() {
		testExample(AnalysisTableExample.class);
	}

	@Test
	public void testTokenSearch() {
		testExample(TokenSearchExample.class);
	}

	@Test
	public void testLetterSearch() {
		testExample(LetterSearchExample.class);
	}

	@Test
	public void testLongestToken() {
		testExample(LongestTokenExample.class);
	}

	@Test
	public void testTokenFrequency() {
		testExample(TokenFrequencyExample.class);
	}

	@Test
	public void testCharacterFrequency() {
		testExample(CharacterFrequencyExample.class);
	}

	@Test
	public void testTokenCount() {
		testExample(TokenCountExample.class);
	}

	@Test
	public void testVerseCount() {
		testExample(VerseCountExample.class);
	}

	@Test
	public void testCsvExport() {
		testExample(CsvExportExample.class);
	}

	@Test
	public void testBismillah() {
		testExample(BismillahExample.class);
	}

	@Test
	public void testLocation() {
		testExample(LocationExample.class);
	}

	@Test
	public void testBuckwalter() {
		testExample(BuckwalterExample.class);
	}

	@Test
	public void testSimpleEncoding() {
		testExample(SimpleEncodingExample.class);
	}

	private void testExample(Class<?> exampleType) {

		// Run the example.
		String actualOutput = runExample(exampleType);

		// Load the expected output from src/test/resources
		String name = "/" + exampleType.getName().replace('.', '/') + ".txt";
		String expectedOutput = ResourceUtil.getText(name);

		// Validate the example's results.
		assertEquals(expectedOutput, actualOutput);
	}

	private String runExample(Class<?> exampleType) {

		// Get existing standard output stream.
		PrintStream standardOutput = System.out;

		// Redirect standard output to a byte stream.
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteStream));

		// Run the example.
		try {
			exampleType.getMethod("main").invoke(null);
		} catch (Exception exception) {
			throw new JQuranTreeException("Failed to run example.", exception);
		}

		// Restore standard output.
		System.setOut(standardOutput);

		// Return results.
		return byteStream.toString();
	}
}
