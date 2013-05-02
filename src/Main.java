import org.newdawn.slick.*;

public class Main extends BasicGame {
	private static int windowSizeX = 800;
	private static int windowSizeY = 600;
	private MoveableObject player1;
	private MoveableObject player2;
	private PongBall ball;

	public Main() {
		super("Pong!");
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		player1 = new Player();
		player1.setPosition(40, windowSizeY / 2 - player1.object.getHeight()
				/ 2);
		player2 = new Player();
		player2.setPosition(windowSizeX - 40 - player2.object.getWidth(),
				windowSizeY / 2 - player1.object.getHeight() / 2);
		ball = new PongBall();
		ball.setPosition(windowSizeX / 2 - ball.object.getWidth() / 2,
				windowSizeY / 2 - ball.object.getHeight() / 2);
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		if (ball.py <= 0 || ball.py + ball.object.getHeight() >= windowSizeY) {
			ball.wallBounce();
			ball.move(null);
		} else if ((ball.px == player1.px + player1.object.getWidth()
				&& (ball.py - ball.object.getHeight() >= player1.py && ball.py <= player1.py
				+ player1.object.getHeight()))
				|| (ball.px + ball.object.getWidth() == player2.px
						&& (ball.py + ball.object.getHeight() >= player2.py && ball.py <= player2.py
						+ player2.object.getHeight()))) {
			ball.playerBounce();
			ball.move(null);
		} else if(ball.px == 0 || ball.px + ball.object.getWidth() == windowSizeX){
			ball.setPosition(windowSizeX / 2, windowSizeY / 2);
		} else {
			ball.move(null);
		}

		if (input.isKeyDown(Input.KEY_W)) {
			if (player1.getPositionY() > 0) {
				player1.move("up");
			}
		}
		if (input.isKeyDown(Input.KEY_S)) {
			if (player1.getPositionY() + player2.getSizeY() < windowSizeY) {
				player1.move("down");
			}
		}
		if (input.isKeyDown(Input.KEY_UP)) {
			if (player2.getPositionY() > 0) {
				player2.move("up");
			}
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			if (player2.getPositionY() + player2.getSizeY() < windowSizeY) {
				player2.move("down");
			}
		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		ball.object.draw(ball.getPositionX(), ball.getPositionY());
		player1.object.draw(player1.getPositionX(), player1.getPositionY());
		player2.object.draw(player2.getPositionX(), player2.getPositionY());
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main());

		app.setDisplayMode(windowSizeX, windowSizeY, false);
		app.start();
	}
}