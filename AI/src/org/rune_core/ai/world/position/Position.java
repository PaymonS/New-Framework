package org.rune_core.ai.world.position;

/**
 * A <code>Position</code> represents a set of coordinates in the game world.
 * This can be used for anything such as the location of a {@link Player}.
 * 
 * @author Grabn_000
 *
 */
public class Position {

	/**
	 * Represents the x coordinate of a location.
	 */
	private int x;
	
	/**
	 * Represents the y coordinate of a location.
	 */
	private int y;
	
	/**
	 * Represents the plane or height, of a location.
	 */
	private int plane;
	
	/**
	 * @see {@link #Position(int, int, int)}.
	 * 
	 * @param x
	 * 		The x coordinate of the location.
	 * @param y
	 * 		The y coordinate of the location.
	 */
	public Position(final int x, final int y) {
		this(x, y, 0);
	}
	
	/**
	 * Constructs a new <code>Position</code>.
	 * 
	 * @param x
	 * 		The x coordinate of the location.
	 * @param y
	 * 		The y coordinate of the location.
	 * @param plane
	 * 		The plane the <code>Position</code> is on.
	 */
	public Position(final int x, final int y, final int plane) {
		this.x = x;
		this.y = y;
		this.plane = plane;
	}
	
	/**
	 * Gets the x coordinate of the <code>Position</code>.
	 * 
	 * @return
	 * 		{@link #x}.
	 */
	public int getX() {
		
		return x;
	}
	
	/**
	 * Gets the y coordinate of the <code>Position</code>.
	 * 
	 * @return
	 * 		{@link y}.
	 */
	public int getY() {
		
		return y;
	}
	
	/**
	 * Gets the plane of the <code>Position</code>.
	 * 
	 * @return
	 * 		{@link #plane}.
	 */
	public int getPlane() {
		
		return plane;
	}
	
	/**
	 * A flag for checking if one <code>Position</code> has the same coordinate as another
	 * instance.
	 * 
	 * @param other
	 * 		The other <code>Position</code> to compare.
	 * @return
	 * 		True if the <code>Position</code>'s have the same coordinates.
	 */
	public boolean sameAs(final Position other) {
		
		return (x == other.getX() && y == other.getY() && plane == other.getPlane());
	}
}