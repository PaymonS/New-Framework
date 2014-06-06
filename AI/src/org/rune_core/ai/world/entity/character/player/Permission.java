package org.rune_core.ai.world.entity.character.player;

import org.rune_core.ai.world.utilities.StringUtilities;

/**
 * An enumeration holding the values that represent the permission a player
 * has in the game world.  Be aware that {@link Permission#ordinal()} is used to
 * determine the value to send to the client to draw an icon, if any.
 * 
 * <p>
 * So keeping a linear order is very important.  You may also find a few utility
 * methods in the class you will find useful.
 * </p>
 * 
 * @author Grabn_000
 *
 */
public enum Permission {

	DEFAULT,
	
	MODERATOR,
	
	ADMINISTRATOR;
	
	/**
	 * Checks if a <code>Permission</code> is greater than or equal to another.
	 * 
	 * @param permission
	 * 		The <code>Permission</code> to compare.
	 * @return
	 * 		True if the order is greater or equal to the other.
	 */
	public boolean greaterOrEqualTo(final Permission permission) {
		
		return ordinal() >= permission.ordinal();
	}
	
	/**
	 * Checks if a <code>Permission</code> is greater than another.
	 * 
	 * @param permission
	 * 		The <code>Permission</code> to compare.
	 * @return
	 * 		True if the order is greater than the other.
	 */
	public boolean greaterThan(final Permission permission) {
		
		return ordinal() > permission.ordinal();
	}
	
	/**
	 * Returns a value that represents a 'promoted' permission (+1 ordinal) if possible.
	 * 
	 * @return
	 * 		The promoted <code>Permission</code>.
	 */
	public Permission promote() {
		
		return (ordinal() < values().length - 1 ? values()[ordinal() + 1] : this);
	}
	
	/**
	 * Returns a value that represents a 'demoted' permission (-1 ordinal) if possible.
	 * 
	 * @return
	 * 		The demoted <code>Permission</code>.
	 */
	public Permission demote() {
		
		return (ordinal() > 0 ? values()[ordinal() - 1] : this);
	}
	
	@Override
	public String toString() {
		
		return StringUtilities.firstCapital(name());
	}
}