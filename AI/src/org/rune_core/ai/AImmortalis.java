package org.rune_core.ai;

import org.rune_core.ai.world.World;
import org.rune_core.ai.world.entity.character.player.Player;
import org.rune_core.ai.world.entity.character.player.io.JsonPlayerFileManager;

/**
 * Holds the {@link #main(String...)}, the entry point into the application.
 * 
 * <p>
 * This class should contain no other methods/fields besides those directly
 * associated with running the application.  Though, this is just a recommendation.
 * </p>
 * 
 * @author Grabn_000
 *
 */
public final class AImmortalis {
	
	/**
	 * This is an immutable class, and as such get's a private constructor.
	 */
	private AImmortalis() { }
	
	/**
	 * The entry point into the <b>Aeturnus Immortalis</b> framework.
	 * 
	 * <p>
	 * For debugging mode, the parameter 'debug' should be passed.
	 * </p>
	 * 
	 * @param args
	 * 		The parameter arguments passed from the command line.
	 */
	public static void main(final String...args) {
		/*
		 * Checks if the appropriate arguments have been passed.
		 */
		if (args.length == 0 || (!args[0].equalsIgnoreCase("local") && !args[0].equalsIgnoreCase("database"))) {
			
			System.out.println("Invalid arguments passed!  Must be 'local' or 'database'");
			return;
		}
		
		switch (args[0].toLowerCase()) {
		
			case "local":
				World.getSingleton().setPlayerFileManager(JsonPlayerFileManager.getSingleton());
				break;
				
			case "database":
				World.getSingleton().setPlayerFileManager(null);
				break;
		
		}
		
		/*
		 * Builds the game world and starts the threads needed for game play.
		 */
		World.getSingleton().create().startThreads();
		final Player p = World.getSingleton().getPlayerFileManager().deserialize("Vendetta");
		World.getSingleton().getPlayerFileManager().serialize(p);
	}
}