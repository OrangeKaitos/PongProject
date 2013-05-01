import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PongBall extends MoveableObject {
	private float speedX = 1f;
	private float speedY = 1f;
	private Field field;
	
	public PongBall(int px, int py, Field field) throws SlickException{
		super(px, py);
		object = new Image("data/ball.png");
		this.field = field;
		sx = object.getWidth();
		sy = object.getHeight();
	}
	
	/**
	 * Moves the pong ball. Makes it bounce on walls and players.
	 */
	@Override
	public void move(String direction) {
		px += speedX;
		py += speedY;
	}

}
