import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/**
 * Class GamePlayState is the state in the game where the actual game is being
 * played.
 * 
 * @author Philip Stiff and Samuel Philipson
 * 
 */

public class GamePlayState extends BasicGameState {
	private MoveableObject player1;
	private MoveableObject player2;
	private PongBall ball;
	private static int windowSizeY;
	private static int windowSizeX;
	private boolean gameOver = false; // Indicates whether the game is over or
										// not.
	int stateID = -1;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		windowSizeX = Main.screenX();
		windowSizeY = Main.screenY();
		ball = new PongBall();
		ball.setPosition(windowSizeX / 2 - ball.object.getWidth() / 2,
				windowSizeY / 2 - ball.object.getHeight() / 2);
		// player1 = new AI(ball, windowSizeY, windowSizeX);
		player1 = new Player();
		player1.setPosition(40, windowSizeY / 2 - player1.object.getHeight()
				/ 2);

		if (stateID == 2) {
			System.out.println("Multiplayer initiated");
			player2 = new Player();
		}
		if (stateID == 1) {
			System.out.println("Singleplayer initiated");
			player2 = new AI(ball, windowSizeY, windowSizeX);
		}
		player2.setPosition(windowSizeX - 40 - player2.object.getWidth(),
				windowSizeY / 2 - player1.object.getHeight() / 2);
		gc.setShowFPS(false);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		if (gameOver(sbg, gc)) {

			return;
		}
		ball.object.draw(ball.getPositionX(), ball.getPositionY());
		player1.object.draw(player1.getPositionX(), player1.getPositionY());
		player2.object.draw(player2.getPositionX(), player2.getPositionY());
		g.drawString("Lives: Player 1: " + player1.getLives() + " Player 2: "
				+ player2.getLives(), 5, windowSizeY - 20);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		ballAction();
		movePlayers(input);
		if (player1.getLives() <= 0 || player2.getLives() <= 0) {
			gameOver = true;
		}
	}

	/**
	 * Indicates whether the game is over or not. If the game is over it draws a
	 * message showing which player has won.
	 * 
	 * @return Whether the game is over or not.
	 * @throws SlickException
	 */
	private boolean gameOver(StateBasedGame sbg, GameContainer gc)
			throws SlickException {
		if (!gameOver) {
			return false;
		} else {
			if (player1.getLives() <= 0) {
				sbg.enterState(Main.GAMEOVERSTATE);
			} else { // Draws a message saying player1 has won.
				Image gameOverMessage = new Image("data/player1_win.png");
				gameOverMessage.draw(
						windowSizeX / 2 - gameOverMessage.getWidth() / 2,
						windowSizeY / 2 - gameOverMessage.getHeight() / 2);
			}
		}
		return true;
	}

	/**
	 * Checks the balls position and makes it bounce of walls and players. It
	 * also makes the players lose lives.
	 */
	private void ballAction() {
		if (ball.px <= 0) {
			player1.loseLife();
			ball.setPosition(windowSizeX / 2, windowSizeY / 2);
		} else if (ball.px + ball.object.getWidth() >= windowSizeX) {
			player2.loseLife();
			ball.setPosition(windowSizeX / 2, windowSizeY / 2);
		} else if (ball.py <= 1
				|| ball.py + ball.object.getHeight() >= windowSizeY - 1) {
			ball.wallBounce();
			ball.move(null);

		} else if ((ball.px == player1.px + player1.object.getWidth() && (ball.py
				+ ball.object.getHeight() >= player1.py && ball.py <= player1.py
				+ player1.object.getHeight()))) {
			ball.playerBounce(player1);
			ball.move(null);

		} else if ((ball.px + ball.object.getWidth() == player2.px && (ball.py
				+ ball.object.getHeight() >= player2.py && ball.py <= player2.py
				+ player2.object.getHeight()))) {
			ball.playerBounce(player2);
			ball.move(null);

		} else {
			ball.move(null);
		}
	}

	/**
	 * Moves the players. If they are AI:s they move by themselves, otherwise
	 * the method receives input from the user and moves the player accordingly.
	 * 
	 * @param input
	 *            An instance of Input to receive input from the user(s).
	 */
	private void movePlayers(Input input) {
		if (player1.getClass().getName().equals("Player")) {
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
		} else {
			// The player is an AI
			player1.move(null);
		}
		if (player2.getClass().getName().equals("Player")) {
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
		} else {
			// The player is an AI
			player2.move(null);
		}
	}

}
