package org.rune_core.ai.world.entity.character.player.rw;

import org.rune_core.ai.world.entity.character.player.Player;

/**
 * A simple interface the represents the type of (de)serialization should take
 * place during the handling of a {@link Player} saved game.
 * 
 * @author Grabn_000
 *
 */
public interface PlayerFileManager {
	
	/**
	 * Reads and deserializes a {@link Player} object.
	 * 
	 * @param username
	 * 		The username of the {@link Player} object to deserialize.
	 * @return
	 * 		The deserialized {@link Player} instance.
	 */
	public Player deserialize(final String username);
	
	/**
	 * Writes (serializes) a {@link Player} object.
	 * 
	 * @param player
	 * 		The {@link Player} instance to be serialized
	 * @return
	 * 		True if the serialization process completed.
	 */
	public boolean serialize(final Player player);

}
