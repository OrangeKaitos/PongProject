//package slick.path2glory.SimpleGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.*;

public class SimpleGame extends BasicGame {
	private Image land = null;
	private Image player1 = null;
	private Image player2 = null;
	private Image ball = null;
	private float p1x = 50;
	private float p1y = 400;
	private float p2x = 730;
	private float p2y = 400;
	private float bx = 250;
	private float by = 250;
	private float ballSpeedX = 5f;
	private float ballSpeedY = 5f;

	public SimpleGame() {
		super("Slick2DPath2Glory - SimpleGame");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		land = new Image("data/bild.jpg");
		player1 = new Image("data/player.png");
		player2 = new Image("data/player.png");
		ball = new Image("data/ball.png");
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyDown(Input.KEY_UP)) {
			p1y--;
		}
		if (input.isKeyDown(Input.KEY_DOWN)){
			p1y++;
		}
		if (input.isKeyDown(Input.KEY_W)) {
			p2y--;
		}
		if (input.isKeyDown(Input.KEY_S)){
			p2y++;
		}
		bx += ballSpeedX;
		by += ballSpeedY;
		// bounce on walls
		if (bx + 20 == 800 || bx == 0){
			ballSpeedX = -ballSpeedX;
		}
		if (by + 20 == 600 || by == 0){
			ballSpeedY = -ballSpeedY;
		}
		// bounce on players
		if ((bx == p1x + 20) && (by >= p1y && by <= p1y + 100)){
			ballSpeedX = -ballSpeedX;
		}
		if ((bx + 20 == p2x) && (by >= p2y && by <= p2y + 100)){
			ballSpeedX = -ballSpeedX;
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		land.draw(0, 0);
		player1.draw(p1x, p1y);
		player2.draw(p2x, p2y);
		ball.draw(bx, by);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SimpleGame());

		app.setDisplayMode(800, 600, false);
		app.start();
	}
}