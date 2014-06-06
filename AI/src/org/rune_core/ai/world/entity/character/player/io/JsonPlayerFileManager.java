package org.rune_core.ai.world.entity.character.player.io;

import java.io.File;
import java.io.FileNotFoundException;

import org.rune_core.ai.world.entity.character.player.Player;
import org.rune_core.ai.world.entity.character.player.PlayerData;
import org.rune_core.ai.world.utilities.JsonObjectUtilities;

/**
 * A {@link PlayerFileManager} implementation that handles (de)serialization using the 
 * Google GSON library.
 * 
 * @author Grabn_000
 *
 */
public final class JsonPlayerFileManager implements PlayerFileManager {
	
	/**
	 * The {@link JsonObjectUtilities} instance for parsing json data.
	 */
	private final JsonObjectUtilities<PlayerData> jou = new JsonObjectUtilities<>(PlayerData.class);
	
	/**
	 * The reference field holding the singleton instance of <code>JsonPlayerFileManager</code>.
	 */
	public static JsonPlayerFileManager singleton;
	
	/**
	 * The private constructor of <code>JsonPlayerFileManager</code> to prevent
	 * unneeded instancing outside of the singleton design pattern. 
	 */
	private JsonPlayerFileManager() { }

	@Override
	public Player deserialize(final String username) {
		final File file = new File("./data/players/" + username.toLowerCase() + ".json");
		
		if (file.exists()) {
			
			try {
				
				return (new Player(jou.deserialize(file)));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
				return (new Player(new PlayerData(username)));
			}
		}
		
		return (new Player(new PlayerData(username)));
	}

	@Override
	public boolean serialize(final Player player) {
		final File file = new File("./data/players/" + player.getPlayerData().getUsername().toLowerCase() + ".json");
		
		return jou.serialize(file, player.getPlayerData());
	}
	
	/**
	 * Gets the singleton instance of <code>JsonPlayerFileManager</code>.
	 * 
	 * @return
	 * 		{@link #singleton}.
	 */
	public static JsonPlayerFileManager getSingleton() {
		
		return singleton == null ? singleton = new JsonPlayerFileManager() : singleton;
	}
}