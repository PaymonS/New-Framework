package org.rune_core.ai.world.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonObjectUtilities<T> {
	
	/**
	 * A utility reference for holding the class of generic type <code>T</code>.
	 */
	private final Class<T> clazz;
	
	/**
	 * The {@link Gson} instance to handle the (de)serialization processes.
	 */
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	/**
	 * Constructs a <code>JsonObjectUtilities</code> instance and holds the class type.
	 * 
	 * @param clazz
	 * 		The class of generic type <code>T</code>.
	 */
	public JsonObjectUtilities(final Class<T> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * Deserializes a JSON file if it exists and returns an instance of the object.
	 * 
	 * @param file
	 * 		The file to parse.
	 * @return
	 * 		The instance of type <code>T</code>.
	 * @throws FileNotFoundException 
	 */
	public T deserialize(final File file) throws FileNotFoundException {
		final FileReader reader = new FileReader(file);
			
		return (T) gson.fromJson(reader, clazz);
	}
	
	/**
	 * Serializes (writes) an object of type <code>T</code> to a file in JSON format.
	 * 
	 * @param file
	 * 		The {@link File} to write to.
	 * @return
	 * 		True if the serialization was a success.
	 */
	public boolean serialize(final File file, final T object) {
		
		try (final BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			
			writer.write(gson.toJson(object));
			return true;
		} catch (final IOException e) {

			e.printStackTrace();
			return false;
		}
	}
}