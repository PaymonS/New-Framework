package org.rune_core.ai.world.entity.character;


public class CharacterPopulation<T extends Character> {

	private final int capacity;
	
	private final Character[] population;

	public CharacterPopulation(final int capacity) {
		this.capacity = capacity;
		this.population = new Character[capacity];
	}
	
	
}