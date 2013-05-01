import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Class Player symbolizes a player "pad" in the game Pong steered by a person.
 * The pad has a position, a size and a speed of which it moves when moved.
 * 
 * @author Philip Stiff
 * @version 2013-05-01
 * 
 */
public class Player extends MoveableObject {
	private Field field;
	/**
	 * Creates a Player with a position, size and speed.
	 * 
	 * @param px
	 *            The players positions x coordinate.
	 * @param py
	 *            The players positions y coordinate.
	 * @param sx
	 *            The players size in the x direction.
	 * @param sy
	 *            The players size in the y direction.
	 * @param speed
	 *            The players speed.
	 * @throws SlickException 
	 */
	public Player(int px, int py, Field field) throws SlickException {
		super(px, py);
		sx = object.getWidth();
		sy = object.getHeight();
		object = new Image("data/player.png");
		this.field = field;
	}

	/**
	 * Moves the player according to the parameterized String.
	 */
	@Override
	public void move(String direction) {
		if (direction.toLowerCase().equals("up")){
			if (!(py <= 0)) {
				py -= speed;
			}
		} else if (direction.toLowerCase().equals("down")){
			if (!(py >= field.getSizeX())) { //kolla fields metoder!!!
				py += speed;
			}
		}
	}
}
