package org.rune_core.ai.world.entity.character.creature;

import org.rune_core.ai.world.entity.EntityType;
import org.rune_core.ai.world.entity.character.Character;

public final class Creature extends Character {

	@Override
	public EntityType getEntityType() {
		
		return EntityType.CREATURE;
	}

}
