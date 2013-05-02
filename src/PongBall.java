import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PongBall extends MoveableObject {
	private float speedX = 1f;
	private float speedY = 1f;
	
	public PongBall() throws SlickException{
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
	
	public void bounce(int paddleYPosition){
		speedX += (float) (speed * Math.sin(Math.toRadians(paddleYPosition)));
		speedY -= (float) (speed * Math.sin(Math.toRadians(paddleYPosition)));
	}
	
	public void wallBounce(){
		speedY = -speedY;
	}
	
	public void playerBounce(){
		speedX = -speedX;
	}

}
