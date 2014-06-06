package org.rune_core.ai.world.pulse;

/**
 * A <code>Pulse</code> is an event that is scheduled to execute on a set cycle.
 * This class contains methods to fully customize the execution and creation of
 * different types of <code>Pulse</code> driven events.
 * 
 * @author Grabn_000
 *
 */
public abstract class Pulse {
	
	/**
	 * The heartbeat count of the game cycles since the last execution of the
	 * <code>Pulse</code>.
	 */
	private int heartbeat;
	
	/**
	 * A flag for checking if a <code>Pulse</code> is currently dead or not.
	 * 
	 * <p>
	 * This is practically the same thing as the <b>stop</code> flag in
	 * other event/task based systems.
	 * </p>
	 */
	private PulseState state = PulseState.ALIVE;
	
	/**
	 * Represents the threshold of game cycles(heartbeats) to trigger the pulse
	 * execution.
	 */
	private final int heartbeats;
	
	/**
	 * Represents the default key of a <code>Pulse</code>.
	 */
	private static final String DEFAULT_KEY = "pulse-default";
	
	/**
	 * An abstract method that must be implemented to handle the execution
	 * tasks of a <code>Pulse</code>.
	 */
	public abstract Pulse beat();
	
	/**
	 * Constructs a <code>Pulse</code> with a heartbeat threshold and a given policy
	 * for execution.
	 * 
	 * @param heartbeats
	 * 		The heartbeat threshold for execution of the <code>Pulse</code>.
	 */
	public Pulse(final int heartbeats) {
		this.heartbeat = 0;
		this.heartbeats = heartbeats;
	}
	
	/**
	 * Get's the {@link Object} key representing the chain to the <code>Pulse</code>.
	 * 
	 * @return
	 * 		{@link #DEFAULT_KEY} if this method is not overridden.
	 */
	public Object getKey() {
		
		return DEFAULT_KEY;
	}
	
	/**
	 * An optional method to be overridden in implementations.  Handles a specific
	 * task that should be executed upon the death of the <code>Pulse</code>.
	 */
	public Pulse onDeath() { 
		
		return this;
	}
	
	/**
	 * Get's the current state of the <code>Pulse</code>.
	 * 
	 * @return
	 * 		{@link #state}.
	 */
	public PulseState getState() {
		
		return state;
	}
	
	/**
	 * Checks if the <code>Pulse</code> is dead or not.
	 * 
	 * @return
	 * 		{@link #state}.
	 */
	public boolean isDead() {
		
		return (state == PulseState.DEAD);
	}
	
	/**
	 * Kills the <code>Pulse</code> by setting the dead flag to {@link PulseState#DEAD}.
	 * 
	 * <p>
	 * A note of warning, calling this method can not be undone. Once it
	 * is called, that's it.  The next heart beat will remove the <code>Pulse</code>.
	 * </p>
	 */
	public void kill() {
		
		state = PulseState.DEAD;
	}
	
	/**
	 * Checks if the <code>Pulse</code> is ready for execution.
	 * 
	 * @return
	 * 		True of the {@link #heartbeat} increment is equal (or greater) than {@link #heartbeats}.
	 */
	public boolean ready() {
		
		return ++heartbeat >= heartbeats;
	}
	
	/**
	 * Set's the {@link #heartbeat} to 0.  This method is called
	 * during the main beat after execution has been met.
	 * 
	 * @see {@link PulseScheduler#beat()}.
	 */
	public void reset() {
		
		heartbeat = 0;
	}
}