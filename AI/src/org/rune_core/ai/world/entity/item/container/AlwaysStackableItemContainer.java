package org.rune_core.ai.world.entity.item.container;

import org.rune_core.ai.world.entity.item.Item;

public class AlwaysStackableItemContainer extends ItemContainer {

	public AlwaysStackableItemContainer(final byte capacity, final boolean consolidates, final StackPolicy stackPolicy) {
		super(capacity, consolidates, stackPolicy);
	}

	@Override
	public boolean add(final Item item) {
		final byte slot = getFirstOccurrenceSlot(item.getIdentifier());
		
		switch (slot) {
		
		case -1:
			final byte _slot = getAvailableSlot();                
			
			if (_slot == -1)
				return false;

			getItems()[_slot] = item;
			
			return true;
			
		default:
			getItems()[slot].add(item.getAmount());
			
			return true;
		}
	}

}
