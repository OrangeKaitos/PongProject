import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PongBall extends MoveableObject {
	private double speedX = 1f;
	private double speedY = 1f;
	// Uses pythagoras to decide overall speed of the ball.
	private double speedXY = Math.sqrt(speedX*speedX + speedY*speedY);
	
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
	
	public void wallBounce(){
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
	
	public void playerBounce(MoveableObject player){
			double middle = player.object.getHeight()/4;
		    double ballLength = this.object.getHeight();
		    double ballCenterY = this.py + ballLength/2;
		    double paddleLength = player.object.getHeight();
		    double paddleCenterY = player.getPositionY() + paddleLength/2;
		    // This number decides the influence that the length between the
		    // ball and the player has on the bounce of the ball in Y speed.
		    // Number must be between 0 and 1.
		    final double influenceY = 0.75;
		    // Calculate the position of the ball relative to the center of
		    // the paddle, and express this as a number between -1 and 1
		    double posY = (ballCenterY - paddleCenterY) / (paddleLength/2);
		    
	    	if(posY < middle){
	    		speedY = -speedXY * posY * influenceY;	
	    		speedX = Math.sqrt(speedXY*speedXY - speedY*speedY) *
			             (speedX > 0? -1 : 1);
		   	}
	    	else if(posY > middle){
	    		speedY = -speedXY * posY * influenceY;
	    		speedX = Math.sqrt(speedXY*speedXY - speedY*speedY) *
			             (speedX > 0? -1 : 1);
		   	}
//		    speedY = -speedXY * posY * influenceY;
		    
		    else {
		    	speedX = -speedX;
		    	System.out.println("mitt");
		    }
		    	
//		    	if(speedY >= 0.75*speedXY){
//		    		System.out.println("r�d");
//		    		speedY = 0.75*speedXY;
//		    	}
//		    	if(speedY <= -0.75*speedXY){
//		    		System.out.println("bl�");
//		    		speedY = -0.75*speedXY;
//		    	}
		    	
		    	
		    }
		    
	}


