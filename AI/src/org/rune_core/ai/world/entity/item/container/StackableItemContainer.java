package org.rune_core.ai.world.entity.item.container;

import org.rune_core.ai.world.entity.item.Item;
import org.rune_core.ai.world.entity.item.ItemDefinition;

public class StackableItemContainer extends ItemContainer {

	public StackableItemContainer(final byte capacity, final boolean consolidates, final StackPolicy stackPolicy) {
		super(capacity, consolidates, stackPolicy);
	}

	@Override
	public boolean add(final Item item) {
		final boolean stacks = ItemDefinition.forIdentifier(item.getIdentifier()).stackable();
		
		if (stacks) {
		
			
		}
		
		return false;
	}

}
