package org.rune_core.ai.world.util.pulse;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <code>PulseScheduler</code> is an immutable class written in the singleton design.
 * It's purpose is to handle the execution & submission of <code>Pulse</code> events.
 * 
 * <p>
 * The cycle of executing <code>Pulse</code>'s is based on a 600ms cycle of the game thread.
 * </p>
 * 
 * @author Grabn_000
 *
 */
public final class PulseScheduler {
	
	/**
	 * The reference field holding the singleton instance of <code>PulseScheduler</code>.
	 */
	private static PulseScheduler singleton;
	
	/**
	 * A {@link Queue} implementation holding the {@link Pulse}'s currently queued
	 * to be run.
	 */
	private final Queue<Pulse> awaiting = new LinkedList<>();
	
	/**
	 * A {@link Set} implementation containing the {@link Pulse}'s currently running.
	 */
	private final Set<Pulse> running = new HashSet<>();
	
	/**
	 * Private constructor to prevent instancing of this class outside
	 * of the singleton design pattern.
	 * 
	 * @see {@link #singleton}.
	 */
	private PulseScheduler() { }
	
	/**
	 * This is the method at the heart of <code>PulseScheduler</code>.  It handles
	 * all the utility functions needed to maintain {@link Pulse}'s.  This includes
	 * swapping queued pulses to running pulses, terminating dead pulses, and executing
	 * living pulses.
	 */
	public void beat() {
		/*
		 * Polls pulses waiting into the running Set.
		 */
		while (!awaiting.isEmpty())
			running.add(awaiting.poll());
		
		final Iterator<Pulse> itr = running.iterator();
		
		/*
		 * Iterates over the running Set and executes the pulse depending on
		 * it's state.
		 */
		for (final Pulse pulse = itr.next() ; itr.hasNext() ;) {
			
			switch (pulse.getState()) {
			
			case ALIVE:

				if (pulse.ready())
					pulse.beat().reset();
				
				break;
				
			case DEAD:
				
				running.remove(pulse.onDeath());
				
				break;
			
			}
		}
	}
	
	/**
	 * Submits a <code>Pulse</code> to the {@link #awaiting} queue to be registered
	 * and ran.
	 * 
	 * @param pulse
	 * 		The <code>Pulse</code> to submit.
	 * @param immediateExecution
	 * 		A flag to determine whether or not the <code>Pulse</code> should execute immediately.
	 * @return
	 * 		Boolean for if the addition was successful or not.
	 */
	public boolean submit(final Pulse pulse, final boolean immediateExecution) {
		
		return awaiting.add(immediateExecution ? pulse.beat() : pulse);
	}
	
	/**
	 * Get's the singleton instance of <code>PulseScheduler.
	 * 
	 * @return
	 * 		{@link #singleton}.
	 */
	public static PulseScheduler getSingleton() {
		
		return singleton != null ? singleton : (singleton = new PulseScheduler());
	}
}