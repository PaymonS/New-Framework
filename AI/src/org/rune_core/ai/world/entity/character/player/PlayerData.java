package org.rune_core.ai.world.entity.character.player;

/**
 * A class that holds the data/information that can be serialized for a 
 * {@link Player} object.
 * 
 * @author Grabn_000
 *
 */
public final class PlayerData {
	
	/**
	 * A string representing the name of a {@link Player} object.
	 */
	private String username;
	
	/**
	 * A string representing the password to a {@link Player} 'account'.
	 */
	private String password;
	
	/**
	 * Constructs the <code>PlayerData</code> object.
	 * 
	 * @param username
	 * 		A String representation of a {@link Player}'s name.
	 * @param password
	 * 		A String representation of a {@link Player}'s password.
	 */
	public PlayerData(final String username) {
		this.username = username;
	}
	
	/**
	 * Gets the username for the <code>PlayerData</code>.
	 * 
	 * @return
	 * 		{@link #username}.
	 */
	public String getUsername() {
		
		return username;
	}
	
	/**
	 * Gets the password for the <code>PlayerData</code>.
	 * 
	 * @return
	 * 		{@link #password}.
	 */
	public String getPassword() {
		
		return password;
	}
	
	/**
	 * Sets the username of the <code>PlayerData</code> object.
	 * 
	 * @param username
	 * 		The String to set the {@link #username}.
	 */
	public void setUsername(final String username) {
		this.username = username;
	}
	
	/**
	 * Sets the password of the <code>PlayerData</code> object.
	 * 
	 * @param password
	 * 		The String to set the {@link #password}.
	 */
	public void setPassword(final String password) {
		this.password = password;
	}
}