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
	
	/**
	 * Creates a Player.
	 * 
	 * @throws SlickException 
	 */
	public Player() throws SlickException {
		super();
		object = new Image("data/player.png");
		sx = object.getWidth();
		sy = object.getHeight();
	}

	/**
	 * Moves the player according to the parameterized String.
	 */
	@Override
	public void move(String direction) {
		if (direction.equals("up")){
			py -= speed;
		}
		if (direction.equals("down")){
			py += speed;
		}
	}
}
