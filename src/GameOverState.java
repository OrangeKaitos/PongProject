import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Class GameOverState is a state in the game showing a game over screen where
 * the player can enter his or her highscore.
 * 
 * @author Philip Stiff and Samuel Philipson
 * 
 */
public class GameOverState extends BasicGameState {

	private int stateID = -1;
	private Image gameOverMessage;
	private int windowSizeX = 800;
	private int windowSizeY = 600;
	private TextField tf;
	private long gameDuration;

	public GameOverState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		gameDuration = (System.currentTimeMillis() - Main.timeSinglePlayGameStarted);
		gameOverMessage = new Image("data/player2_win.png");
		tf = new TextField(gc, gc.getDefaultFont(), windowSizeX / 2 - 100, 5,
				200, 30);
		tf.setInput(gc.getInput());
		tf.inputStarted();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		gameOverMessage.draw(windowSizeX / 2 - gameOverMessage.getWidth() / 2,
				windowSizeY / 2 - gameOverMessage.getHeight() / 2);
		tf.render(gc, g);
		g.drawString("Enter name and press enter", windowSizeX / 2 - 120, 40);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			tf.inputEnded();
			Highscore hs = new Highscore(Main.HIGHSCORE_SIZE);
			hs.write(tf.getText(), gameDuration);
			System.exit(0);
		}
	}

}
