import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Class AI symbolizes a players "pad" in the game Pong played by the computer.
 * 
 * @author Philip Stiff
 * @version 2013-05-01
 * 
 */
public class AI extends MoveableObject {
	private PongBall ball;

	/**
	 * Creates a computerized player and sets its initial position.
	 * 
	 * @param px
	 *            The players positions x coordinate.
	 * @param py
	 *            The players positions y coordinate.
	 * @param ball
	 *            The pong games ball.
	 * @throws SlickException
	 */
	public AI(PongBall ball) throws SlickException {
		super();
		object = new Image("data/player.png");
		sx = object.getWidth();
		sy = object.getHeight();
		this.ball = ball;
	}

	@Override
	public void move(String direction) {
		if (ball.getPositionY() + ball.object.getHeight() / 2 < py
				+ object.getHeight() / 2) {
			py -= speed;
		} else if (ball.getPositionY() + ball.object.getHeight() / 2 > py
				+ object.getHeight() / 2) {
			py += speed;
		}
	}
}
