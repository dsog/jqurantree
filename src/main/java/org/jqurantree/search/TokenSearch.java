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

package org.jqurantree.search;

import java.util.ArrayList;
import java.util.List;

import org.jqurantree.analysis.AnalysisTable;
import org.jqurantree.arabic.encoding.EncodingType;
import org.jqurantree.orthography.Document;
import org.jqurantree.orthography.Token;

/**
 * The <code>TokenSearch</code> class searches for tokens within the orthography
 * model. This class supports searching for tokens using an exact string match,
 * or by substring, and is used by performing the following steps:
 * <p>
 * Step 1. Initiate a new <code>TokenSearch</code> instance by specifying which
 * encoding type to use, e.g. Buckwalter transliteration, or Unicode. All string
 * comparisons will be performed using the specified encoding type.
 * <p>
 * Step 2. Define the search criteria through calls to
 * {@link #findToken(String)} and {@link #findSubstring(String)}.
 * <p>
 * Step 3. Run the search by calling the {@link #getResults()} method.
 * <p>
 * The results will be returned as an analysis table with 4 columns:
 * <p>
 * - The chapter number.<br/> - The verse number.<br/> - The token number.<br/>
 * - The token's text in the specified encoding.<br/>
 * <p>
 * The returned analysis table will list all matching tokens together with their
 * location. The search criteria are combined using a Boolean OR, so that if any
 * of the search criteria match, the token will be listed.
 * 
 * @author Kais Dukes
 */
public class TokenSearch {

	private final List<SearchItem> items = new ArrayList<SearchItem>();
	private final EncodingType encodingType;
	private final SearchOptions options;

	/**
	 * Creates a new <code>TokenSearch</code> instance, using the specified
	 * encoding scheme.
	 * 
	 * @param encodingType
	 *            the encoding scheme to use when performing string comparsions
	 */
	public TokenSearch(EncodingType encodingType) {
		this(encodingType, null);
	}

	/**
	 * Creates a new <code>TokenSearch</code> instance, using the specified
	 * encoding scheme and search options. If
	 * <code>SearchOptions.RemoveDiacritics</code> is specified, then the search
	 * performed will not be sensitive to the presence of diacritics.
	 * 
	 * @param encodingType
	 *            the encoding scheme to use when performing string comparsions
	 * 
	 * @param options
	 *            the search options to use.
	 */
	public TokenSearch(EncodingType encodingType, SearchOptions options) {
		this.encodingType = encodingType;
		this.options = options;
	}

	/**
	 * Adds an exact string match to the list of search criteria.
	 * 
	 * @param text
	 *            the string to search for, in the specified encoding scheme
	 */
	public void findToken(String text) {
		findToken(text, options);
	}

	/**
	 * Adds an exact string match to the list of search criteria, with search
	 * options.
	 * 
	 * @param text
	 *            the string to search for, in the specified encoding scheme
	 * 
	 * @param options
	 *            the search options to use when performing this match
	 */
	public void findToken(String text, SearchOptions options) {
		items.add(new SearchItem(SearchType.Token, text, options));
	}

	/**
	 * Adds a substring match to the list of search criteria.
	 * 
	 * @param text
	 *            the substring to search for, in the specified encoding scheme
	 */
	public void findSubstring(String text) {
		findSubstring(text, options);
	}

	/**
	 * Adds a substring match to the list of search criteria.
	 * 
	 * @param text
	 *            the substring to search for, in the specified encoding scheme
	 * 
	 * @param options
	 *            the search options to use when performing this match
	 */
	public void findSubstring(String text, SearchOptions options) {
		items.add(new SearchItem(SearchType.Substring, text, options));
	}

	/**
	 * Gets an {@link AnalysisTable} holding the search results. The returned
	 * analysis table will list all matching tokens together with their
	 * location. The search criteria are combined using a Boolean OR, so that if
	 * any of the search criteria match, the token will be listed.
	 * 
	 * @return an analysis table holding the search results
	 */
	public AnalysisTable getResults() {

		// Initiate an analysis table.
		AnalysisTable table = new AnalysisTable("ChapterNumber", "VerseNumber",
				"TokenNumber", "Token");

		// Check if any the search requires removing diaciritcs.
		boolean isRemoveDiacritics = false;
		for (SearchItem item : items) {
			if (item.getOptions() == SearchOptions.RemoveDiacritics) {
				isRemoveDiacritics = true;
				break;
			}
		}

		// Check each token in the Quranic text.
		for (Token token : Document.getTokens()) {

			// Encode token.
			String diacriticText = token.toString(encodingType);
			String cleanText = isRemoveDiacritics ? token.removeDiacritics()
					.toString(encodingType) : null;

			// Match token.
			if (isMatch(diacriticText, cleanText)) {
				table.add(token.getChapterNumber(), token.getVerseNumber(),
						token.getTokenNumber(), diacriticText);
			}
		}

		// Return results.
		return table;
	}

	private boolean isMatch(String diacriticText, String cleanText) {

		// Initiate.
		boolean isValid = false;

		// Match each search item.
		int size = items.size();
		for (int i = 0; i < size; i++) {
			if (isValid = isMatch(items.get(i), diacriticText, cleanText)) {
				break;
			}
		}

		// Return match.
		return isValid;
	}

	private boolean isMatch(SearchItem item, String diacriticText,
			String cleanText) {

		// Initiate.
		boolean isValid;
		String text = item.getOptions() == SearchOptions.RemoveDiacritics ? cleanText
				: diacriticText;

		// Token.
		if (item.getType() == SearchType.Token) {
			isValid = text.equals(item.getText());
		}

		// Substring.
		else {
			isValid = text.contains(item.getText());
		}

		// Return match.
		return isValid;
	}
}
