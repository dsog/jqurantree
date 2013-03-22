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

package org.jqurantree.examples.analysis;

import org.jqurantree.analysis.AnalysisTable;
import org.jqurantree.orthography.Chapter;
import org.jqurantree.orthography.Document;

/**
 * The program below demonstrates how to export an analysis table to a CSV file.
 * The program lists all chapter names in the Quran using Buckwalter
 * transliteration, then saves these results to a file.
 * 
 * @author Kais Dukes
 */
public class CsvExportExample {

	public static void main() {

		// Create a new analysis table.
		AnalysisTable table = new AnalysisTable("ChapterNumber", "ChapterName");

		// Add chapter names using Buckwalter transliteration.
		for (Chapter chapter : Document.getChapters()) {
			table.add(chapter.getChapterNumber(), chapter.getName()
					.toBuckwalter());
		}

		// Write results to screen.
		System.out.println(table);

		// Export results to a CSV file.
		table.writeFile("c:\\temp\\chapters.csv", ',');
	}
}
