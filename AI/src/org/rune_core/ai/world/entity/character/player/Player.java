package org.rune_core.ai.world.entity.character.player;

import org.rune_core.ai.world.entity.EntityType;
import org.rune_core.ai.world.entity.character.Character;

public final class Player extends Character {
	
	/**
	 * The reference field holding the {@link PlayerData} object for the <code>Player</code>.
	 */
	private final PlayerData playerData;
	
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