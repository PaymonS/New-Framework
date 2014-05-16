package org.rune_core.ai;

import org.rune_core.ai.world.World;

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
		 * Builds the game world and starts the threads needed for game play.
		 */
		World.getSingleton().create().startThreads();
	}

}