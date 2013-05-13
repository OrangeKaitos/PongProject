import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PongBall extends MoveableObject {
	private double speedX = 1f;
	private double speedY = 1f;
	// Uses pythagoras to decide overall speed of the ball.
	private double speedXY = Math.sqrt(speedX * speedX + speedY * speedY);

	public PongBall() throws SlickException {
		super();
		object = new Image("data/ball.png");
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

	public void wallBounce() {
		speedY = -getSpeedY();
	}

	public double getSpeedY() {
		return speedY;
	}

	public double getSpeedX() {
		return speedX;
	}

	public double getSpeedXY() {
		return speedXY;
	}

	public void playerBounce(MoveableObject player) {
		int playerHeight = player.getObject().getHeight();
		speedX *= -1;
		if (speedY >= 0) {
			if (py + getObject().getHeight() < player.getPositionY()
					+ playerHeight / 3) {
				speedY *= -1;
			}
		} else {
			if (py > player.getPositionY() + (playerHeight / 3) * 2) {
				speedY *= -1;
			}
		}
	}

}
