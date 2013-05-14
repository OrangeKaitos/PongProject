import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Class main manages different states of a game.
 * 
 * @author Samuel Philipson and Philip Stiff
 * 
 */

public class Main extends StateBasedGame {

	public static final int MAINMENUSTATE = 0;
	public static final int GAMESINGLESTATE = 1;
	public static final int GAMEMULTISTATE = 2;
	public static final int GAMEOVERSTATE = 3;
	public static final int INSTRUCTIONSTATE = 4;
	public static final int HIGHSCORESTATE = 5;
	public static final int screenX = 800;
	public static final int screenY = 600;
	public static long timeSinglePlayGameStarted = -1;
	public static final int HIGHSCORE_SIZE = 20;

	public Main() {
		super("Pong");
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main());

		app.setDisplayMode(screenX, screenY, false);
		app.start();
	}

	@Override
	public void initStatesList(GameContainer gameContainer)
			throws SlickException {
		this.addState(new MainMenuState(MAINMENUSTATE));
		this.addState(new GamePlayState(GAMESINGLESTATE));
		this.addState(new GamePlayState(GAMEMULTISTATE));
		this.addState(new InstructionState(INSTRUCTIONSTATE));
		this.addState(new HighscoreState(HIGHSCORESTATE));
		this.addState(new GameOverState(GAMEOVERSTATE));
	}

	public static int screenX() {
		return screenX;
	}

	public static int screenY() {
		return screenY;
	}

	/**
	 * Set the time when a single play game was started.
	 * 
	 * @param time
	 *            The time when the game was started.
	 */
	public void setTimeSinglePlayGameStarted(long time) {
		timeSinglePlayGameStarted = time;
	}

	/**
	 * @return The time a single play game started, or -1 if no single play game
	 *         has been started.
	 */
	public long getTimeSinglePlayGameStarted() {
		return timeSinglePlayGameStarted;
	}

}
