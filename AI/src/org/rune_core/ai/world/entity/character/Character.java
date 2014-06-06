package org.rune_core.ai.world.entity.character;

import java.util.HashMap;
import java.util.Map;

import org.rune_core.ai.world.entity.Entity;

public abstract class Character extends Entity {
	
	/**
	 * A {@link Map} implementation that holds the sessions attributes of a <code>Character</code>.
	 */
	private final Map<CharacterAttribute, Object> attributes = new HashMap<>();
	
	/**
	 * Adds an attribute with a default boolean flag of true.
	 * 
	 * @param attr
	 * 		The {@link CharacterAttribute} to add.
	 * @return
	 * 		This for chaining.
	 */
	public Character addAttribute(final CharacterAttribute attr) {
		addAttribute(attr, true);
		
		return this;
	}
	
	/**
	 * Adds a {@link CharacterAttribute} binded to an Object.
	 * 
	 * @param attr
	 * 		The {@link CharacterAttribute} to add.
	 * @param obj
	 * 		The Object value to bind.
	 * @return
	 * 		This for chaining.
	 */
	public Character addAttribute(final CharacterAttribute attr, final Object obj) {
		attributes.put(attr, obj);
		
		return this;
	}
	
	/**
	 * Removes a {@link CharacterAttribute} from the {@link #attributes} collection.
	 * 
	 * @param attr
	 * 		The {@link CharacterAttribute} to remove.
	 * @return
	 * 		True if the attribute was removed.
	 */
	public boolean removeAttribute(final CharacterAttribute attr) {
		
		return attributes.remove(attr) == null ? false : true;
	}
	
	/**
	 * Checks if a <code>Character</code> currently has a given attribute.
	 * 
	 * @param attr
	 * 		The {@link CharacterAttribute} to check.
	 * @return
	 * 		True if the attribute exists.
	 */
	public boolean hasAttribute(final CharacterAttribute attr) {
		
		return attributes.containsKey(attr);
	}
	
	/**
	 * Gets an attribute as a boolean.
	 * 
	 * @param attr
	 * 		The {@link CharacterAttribute} to get.
	 * @return
	 * 		True if the attribute equals true.
	 */
	public boolean getAttrAsBoolean(final CharacterAttribute attr) {
		
		return attributes.get(attr).equals(true);
	}
}