package org.rune_core.ai.world.entity.item;

public class ItemDefinition {
	
	private final boolean stackable;
	
	public static ItemDefinition[] definitions;
	
	public ItemDefinition(final boolean stackable) {
		this.stackable = stackable;
	}
	
	public boolean stackable() {
		
		return stackable;
	}
	
	public static ItemDefinition forIdentifier(final int identifier) {
		
		return definitions[identifier];
	}

}
