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

/**
 * Interface for classes which decode {@link org.jqurantree.arabic.ArabicText}.
 * This interface is used to support the
 * {@link org.jqurantree.arabic.ArabicText#fromEncoding(String, EncodingType)}
 * method.
 * 
 * @author Kais Dukes
 */
public interface ArabicDecoder {

	/**
	 * Decodes a plain text <code>string</code> into the internal
	 * {@link org.jqurantree.arabic.ByteFormat} according to the encoding
	 * scheme.
	 * 
	 * @param text
	 *            the plain text <code>string</code> to decode
	 * 
	 * @return a <code>byte[]</code> array in the internal
	 *         {@link org.jqurantree.arabic.ByteFormat}
	 */
	public byte[] decode(String text);
}
