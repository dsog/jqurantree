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

package org.jqurantree.core.error;

/**
 * A <code>JQuranTreeException</code> is thrown by the API when an error occurs.
 * 
 * @author Kais Dukes
 */
public class JQuranTreeException extends RuntimeException {

	/**
	 * Creates a new <code>JQuranTreeException</code> with the specified error
	 * message.
	 * 
	 * @param message
	 *            the error message
	 */
	public JQuranTreeException(String message) {
		super(message);
	}

	/**
	 * Creates a new <code>JQuranTreeException</code> with an error message and
	 * an exception indicating the cause of the error
	 * 
	 * @param message
	 *            the error message
	 * 
	 * @param exception
	 *            an exception indicating the cause of the error
	 */
	public JQuranTreeException(String message, Exception exception) {
		super(message, exception);
	}
}
