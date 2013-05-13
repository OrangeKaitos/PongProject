import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
  
public class GameOverState extends BasicGameState {
	
	private int stateID = -1;
	private Image gameOverMessage;
	private int windowSizeX = 800;
	private int windowSizeY = 600;
	private TextField tf;
	
	public GameOverState(int stateID) {
		this.stateID = stateID;
	}
	
	@Override
	public int getID() {
		return stateID;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		gameOverMessage = new Image("data/player2_win.png");
		tf = new TextField(gc, gc.getDefaultFont(), 5, 5, 200, 30);
		tf.setInput(gc.getInput());
		tf.inputStarted();
    }
	
	@Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		gameOverMessage.draw(
				windowSizeX / 2 - gameOverMessage.getWidth() / 2,
				windowSizeY / 2 - gameOverMessage.getHeight() / 2);
		tf.render(gc, g);
    }
	
	@Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_ENTER)){
			tf.inputEnded();
			Highscore hs = new Highscore(5);
			hs.write(tf.getText(), 34);
		}
    }
	
}

