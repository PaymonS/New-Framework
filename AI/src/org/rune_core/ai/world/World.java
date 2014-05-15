package org.rune_core.ai.world;

import org.rune_core.ai.world.util.pulse.PulseScheduler;

/**
 * 
 * @author Grabn_000
 *
 */
public final class World {
	
	/**
	 * Reference field holding the singleton instance of <code>World</code>.
	 */
	private static World singleton = null;
	
	/**
	 * Private constructor to prevent instancing of this class outside of the
	 * singleton design pattern.
	 */
	private World() { }
	
	/**
	 * Creates the game world with the defined assets.
	 * 
	 * <p>
	 * Typically this method is used to physically create the game world
	 * environment.  This can include spawned items, creatures, npc's etc..
	 * </p>
	 * 
	 * @return
	 * 		The instance for chaining.
	 */
	public World create() {
		
		return this;
	}
	
	/**
	 * Initially starts the threads needed to run the game world environment
	 * properly.  If an attempt is made to call this method more than once,
	 * an exception will be thrown.
	 * 
	 * @return
	 * 		The instance for chaining.
	 */
	public World startThreads() {
		
		return this;
	}
	
	/**
	 * Get's the singleton instance of <code>World</code>.  
	 * 
	 * @return
	 * 		{@link #singleton}.
	 */
	public static World getSingleton() {
		
		return singleton != null ? singleton : (singleton = new World());
	}
}