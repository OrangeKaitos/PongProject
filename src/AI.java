import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Class AI symbolizes a players "pad" in the game Pong played by the computer.
 * 
 * @author Philip Stiff
 * 
 */
public class AI extends MoveableObject {
	private PongBall ball;
	private int windowSizeY;
	private int windowSizeX;

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
	public AI(PongBall ball, int windowSizeY, int windowSizeX)
			throws SlickException {
		super();
		object = new Image("data/player.png");
		sx = object.getWidth();
		sy = object.getHeight();
		this.ball = ball;
		this.windowSizeY = windowSizeY;
		this.windowSizeX = windowSizeX;
	}

	@Override
	public void move(String direction) {
		if ((px < windowSizeX / 2 && ball.getPositionX() < windowSizeX / 2)
				|| (px > windowSizeX / 2 && ball.getPositionX() > windowSizeX / 2)) {
			if (py > 0) {
				if (ball.getPositionY() + ball.object.getHeight() / 2 < py
						+ object.getHeight() / 2) {
					py -= speed;
				}
			}
			if (py + object.getHeight() < windowSizeY) {
				if (ball.getPositionY() + ball.object.getHeight() / 2 > py
						+ object.getHeight() / 2) {
					py += speed;
				}
			}
		}
	}
}
