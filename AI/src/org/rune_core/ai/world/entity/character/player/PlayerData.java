package org.rune_core.ai.world.entity.character.player;

public final class PlayerData {
	
	/**
	 * A string representing the name of a {@link Player} object.
	 */
	private String username;
	
	/**
	 * A string representing the password to a {@link Player} 'account'.
	 */
	private String password;
	
	public PlayerData(final String username, final String password) {
		this.username = username;
		this.password = password;
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