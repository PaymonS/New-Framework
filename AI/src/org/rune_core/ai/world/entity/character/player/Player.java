package org.rune_core.ai.world.entity.character.player;

import org.rune_core.ai.world.entity.EntityType;
import org.rune_core.ai.world.entity.character.Character;

/**
 * A <code>Player</code> object represents a virtual game character that is
 * controlled by a remote client (person).  The class contains methods that
 * are directly associated with the <code>Player</code> object itself.
 * 
 * <p>
 * It is ill-advised to clutter the class with unrelated methods or fields.
 * We don't want this class to turn into a PI player class.
 * </p>
 * 
 * @author Grabn_000
 *
 */
public final class Player extends Character {
	
	/**
	 * The reference field holding the {@link PlayerData} object for the <code>Player</code>.
	 */
	private final PlayerData playerData;
	
	/**
	 * Constructs a <code>Player</code> based on the chained {@link #playerData} instance.
	 * 
	 * @param playerData
	 * 		The data to be chained to the <code>Player</code>.
	 */
	public Player(final PlayerData playerData) {
		this.playerData = playerData;
	}
	
	/**
	 * Gets the {@link PlayerData} instance chained to the <code>Player</code> object.
	 * 
	 * @return
	 * 		{@link #playerData}.
	 */
	public PlayerData getPlayerData() {

		return playerData;
	}

	@Override
	public EntityType getEntityType() {
		
		return EntityType.PLAYER;
	}
}