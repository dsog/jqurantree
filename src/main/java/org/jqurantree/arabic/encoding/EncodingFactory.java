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

import org.jqurantree.arabic.ArabicText;
import org.jqurantree.arabic.encoding.buckwalter.BuckwalterDecoder;
import org.jqurantree.arabic.encoding.buckwalter.BuckwalterEncoder;
import org.jqurantree.arabic.encoding.simple.SimpleEncoder;
import org.jqurantree.arabic.encoding.unicode.UnicodeDecoder;
import org.jqurantree.arabic.encoding.unicode.UnicodeEncoder;
import org.jqurantree.core.error.Errors;
import org.jqurantree.core.error.JQuranTreeException;

/**
 * The <code>EncodingFactory</code> supports the creation of
 * {@link org.jqurantree.arabic.encoding.ArabicEncoder} and
 * {@link org.jqurantree.arabic.encoding.ArabicDecoder} instances. This class is
 * used by the {@link ArabicText#toString(EncodingType)} and
 * {@link ArabicText#fromEncoding(String, EncodingType)} methods.
 * 
 * @author Kais Dukes
 */
public class EncodingFactory {

	static {

		// Code coverage.
		new EncodingFactory();
	}

	private EncodingFactory() {
	}

	/**
	 * Gets a new <code>ArabicEncoder</code> instance for the specified encoding
	 * scheme.
	 * 
	 * @param encodingType
	 *            the encoding scheme to use
	 * @return a new <code>ArabicEncoder</code> instance
	 */
	public static ArabicEncoder getEncoder(EncodingType encodingType) {

		// Initiate.
		ArabicEncoder encoder;

		// Create an encoder for the encoding type.
		switch (encodingType) {
		case Simple:
			encoder = new SimpleEncoder();
			break;
		case Unicode:
			encoder = new UnicodeEncoder();
			break;
		case Buckwalter:
			encoder = new BuckwalterEncoder();
			break;
		default:
			throw new JQuranTreeException(Errors.INVALID_ENCODING_TYPE);
		}

		// Return the encoder.
		return encoder;
	}

	/**
	 * Gets a new <code>ArabicDecoder</code> instance for the specified encoding
	 * scheme.
	 * 
	 * @param encodingType
	 *            the encoding scheme to use
	 * 
	 * @return a new <code>ArabicDecoder</code> instance
	 */
	public static ArabicDecoder getDecoder(EncodingType encodingType) {

		// Initiate.
		ArabicDecoder decoder;

		// Create a decoder for the encoding type.
		switch (encodingType) {
		case Unicode:
			decoder = new UnicodeDecoder();
			break;
		case Buckwalter:
			decoder = new BuckwalterDecoder();
			break;
		default:
			throw new JQuranTreeException(Errors.INVALID_ENCODING_TYPE);
		}

		// Return the decoder.
		return decoder;
	}
}
