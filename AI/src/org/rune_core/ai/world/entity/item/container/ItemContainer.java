package org.rune_core.ai.world.entity.item.container;

import org.rune_core.ai.world.entity.item.Item;
import org.rune_core.ai.world.entity.item.ItemDefinition;

public abstract class ItemContainer {
	
	/**
	 * The capacity of {@link Item}'s that can be stored in the <code>ItemContainer</code>.
	 */
	private final byte capacity;
	
	/**
	 * A boolean flag to check if the container should move null positions.
	 */
	private final boolean consolidates;
	
	/**
	 * A type reference to the {@link StackPolicy} of the <code>ItemContainer</code>.
	 */
	private final StackPolicy stackPolicy;
	
	/**
	 * An array holding the {@link Item} instances contained within the <code>ItemContainer</code>.
	 */
	private final Item[] items;
	
	public abstract boolean add(final Item item);
	
	public ItemContainer(final byte capacity, final boolean consolidates, final StackPolicy stackPolicy) {
		this.capacity = capacity;
		this.consolidates = consolidates;
		this.stackPolicy = stackPolicy;
		items = new Item[capacity];
	}
	
	public Item[] getItems() {
		
		return items;
	}
	/**
	 * Gets the count of a specific {@link Item} identifier from the <code>ItemContainer</code>.
	 * 
	 * @param identifier
	 * 		The {@link Item} identifier to search for.
	 * @return
	 * 		The count of the {@link Item}.
	 */
	public int getCount(final int identifier) {
		int count = 0;
		
		for (final Item item : items) {

			if (item == null)
				continue;
			
			if (item.getIdentifier() == identifier) {
				count += item.getAmount();
				
				if (ItemDefinition.forIdentifier(item.getIdentifier()).stackable())
					return count;
			}
		}
		
		return count;
	}
	
	public byte getFirstOccurrenceSlot(final int identifier) {
		
		for (byte index = 0 ; index < items.length-1 ; index++) {
			
			if (items[index].getIdentifier() == identifier)
				return index;
		}
		
		return -1;
	}
	
	/**
	 * Checks if the <code>Item</code> container contains (at least) 1 of the
	 * {@link Item}'s by identifier.
	 * 
	 * @param identifier
	 * 		The identity of the {@link Item}.
	 * @return
	 * 		True if the {@link Item} identifier exists.
	 */
	public boolean contains(final int identifier) {
		
		for (final Item item : items) {
			
			if (item.getIdentifier() == identifier) {
				
				return true;
			}
		}
		
		return false;
	}
	
	public byte getAvailableSlot() {
		
		for (byte index = 0 ; index < items.length-1 ; index++) {
			
			if (items[index] == null)
				return index;
		}
		
		return -1;
	}
	
	/**
	 * Consolidates the {@link #items} array to push null values to the end.
	 * 
	 * @param slot
	 * 		The slot(index) in the array to begin consolidation.
	 */
	public void consolidate(final int slot) {
		
		for (int index = slot ; index < items.length-2 ; index++) {
			
			items[index] = items[index + 1];
		}
	}
	
	/**
	 * A nested static enumeration whose types represent the policy when
	 * {@link Item}'s are to be stacked within an <code>ItemContainer</code>.
	 * 
	 * @author Grabn_000
	 *
	 */
	public static enum StackPolicy {
		/*
		 * (@Item)'s will never be stacked in the container.
		 */
		NEVER,
		/*
		 * (@Item)'s will stack only if it is defined as stackable.
		 */
		AS_REQUIRED,
		/*
		 * (@Item)'s will always stack regardless of the definition.
		 */
		ALWAYS;
	}
}