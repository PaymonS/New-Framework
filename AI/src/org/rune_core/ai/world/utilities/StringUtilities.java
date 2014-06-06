package org.rune_core.ai.world.utilities;

/**
 * A utility class containing static methods useful for different kinds of
 * String formatting that is not supported by the default Java API.
 * 
 * @author Grabn_000
 *
 */
public final class StringUtilities {
	
	/**
	 * Private constructor to prevent instancing of this class.
	 */
	private StringUtilities() { }
	
	/**
	 * Formats in input String passed as a parameter to capitalize the first
	 * letter. This is useful for formatting the naming of an enumeration type.
	 * 
	 * @param input
	 * 		The input String to format.
	 * @return
	 * 		The new formatted String.
	 */
	public static String firstCapital(final String input) {
		
		return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
	}
}