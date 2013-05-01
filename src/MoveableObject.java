import org.newdawn.slick.*;

/**
 * Class MoveableObject symbolizes a moveable rectangle with a specified width
 * and height. Any class implementing this class is meant to implement its own
 * move-method.
 * 
 * @author Philip Stiff
 * @version 2013-05-01
 */
public abstract class MoveableObject {
	protected int px, py; // the objects position
	protected int sx, sy; // the objects size
	protected int speed = 1; // the speed of the object
	protected Image object;

	/**
	 * Creates a new MoveableObject and sets its position, size and speed.
	 * 
	 * @param px
	 *            The objects positions x coordinate.
	 * @param py
	 *            The objects positions y coordinate.
	 * @throws SlickException
	 */
	public MoveableObject(int px, int py){
		setPosition(px, py);
	}

	/**
	 * Calculates a new position for the object and moves the object.
	 */
	abstract public void move(String direction);

	/**
	 * @return The objects size in the x direction.
	 */
	public int getSizeX() {
		return sx;
	}

	/**
	 * @return The objects size in the y direction.
	 */
	public int getSizeY() {
		return sy;
	}

	/**
	 * @return The objects positions x coordinate.
	 */
	public int getPositionX() {
		return px;
	}

	/**
	 * @return The objects positions y coordinate.
	 */
	public int getPositionY() {
		return py;
	}

	/**
	 * Sets the position of the object.
	 * 
	 * @param px
	 *            The objects new x coordinate.
	 * @param py
	 *            The objects new y coordinate.
	 */
	public void setPosition(int px, int py) {
		this.px = px;
		this.py = py;
	}

	/**
	 * @return The speed of the object.
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed of the object.
	 * 
	 * @param speed
	 *            The new speed.
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Returns the image of the object.
	 * 
	 * @return The image of the object.
	 */
	public Image getImage() {
		return object;
	}
}
