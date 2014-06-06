package org.rune_core.ai.world.entity.item;

import org.rune_core.ai.world.entity.Entity;
import org.rune_core.ai.world.entity.EntityType;

/**
 * An <code>Item</code> object represents an item available in the virtual
 * in-game world.
 * 
 * @author Grabn_000
 *
 */
public class Item extends Entity {
	
	/**
	 * The integer identifier of the <code>Item</code>.
	 */
	private int identifier;
	
	/**
	 * The integer amount of the <code>Item</code>.
	 */
	private int amount;
	
	/**
	 * Constructs an <code>Item</code> instance with an amount of 1.
	 * 
	 * @param identifier
	 * 		The identifier of the <code>Item</code>.
	 */
	public Item(final int identifier) {
		this(identifier, 1);
	}
	
	/**
	 * Constructs an <code>Item</code> instance with a given amount.
	 * 
	 * @param identifier
	 * 		The identifier of the <code>Item</code>.
	 * @param amount
	 * 		The amount of the <code>Item</code>.
	 */
	public Item(final int identifier, final int amount) {
		this.identifier = identifier;
		this.amount = amount;
	}
	
	/**
	 * Gets the identifier of the <code>Item</code>.
	 * 
	 * @return
	 * 		{@link #identifier}.
	 */
	public int getIdentifier() {
		
		return identifier;
	}
	
	/**
	 * Gets the amount of the <code>Item</code>.
	 * 
	 * @return
	 * 		{@link #amount}.
	 */
	public int getAmount() {
		
		return amount;
	}
	
	/**
	 * Adds to the current {@link #amount}.
	 * 
	 * @param amount
	 * 		The amount to add.
	 */
	public Item add(final int amount) {
		this.amount += amount;
		
		return this;
	}
	
	/**
	 * Subtracts from the current {@link #amount}.
	 * 
	 * @param amount
	 * 		The amount to subtract.
	 */
	public Item subtract(final int amount) {
		this.amount -= amount;
		
		return this;
	}

	@Override
	public EntityType getEntityType() {
		
		return EntityType.ITEM;
	}
}