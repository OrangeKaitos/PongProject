import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Class HighscoreState is a state in the game reading and displaying a
 * highscore from a file.
 * 
 * @author Philip Stiff and Samuel Philipson
 * 
 */
public class HighscoreState extends BasicGameState {
	int stateID = -1;
	Image background = null;
	Image backOption = null;
	private Highscore highscore;
	private ArrayList<String> score = null;
	int backY;
	int backX;
	float scale = 1;
	float scaleStep = 0.0001f;

	public HighscoreState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		highscore = new Highscore(Main.HIGHSCORE_SIZE);
		background = new Image("data/HighscoreBack.png");
		Image menuOptions = new Image("data/menuoptions.png");
		backOption = menuOptions.getSubImage(0, 196, 355, 49);
		backX = 0;
		backY = background.getHeight() - backOption.getHeight();

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		background.draw(0, 0);
		backOption.draw(backX, backY, scale);
		int posY = 155;
		for (int i = 0; i < score.size(); i++) {
			g.drawString(i + 1 + ".  " + score.get(i), 100, posY);
			posY = posY + 15;
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int g)
			throws SlickException {
		float delta = 1;
		boolean insideBack = false;

		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		score = highscore.read();
		if ((mouseX >= backX && mouseX <= backX + backOption.getWidth())
				&& (mouseY >= backY && mouseY <= backY + backOption.getHeight())) {
			insideBack = true;
		}
		if (insideBack) {
			if (scale < 1.05f)
				scale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sbg.enterState(Main.MAINMENUSTATE);
			}
		} else {
			if (scale > 1.0f)
				scale -= scaleStep * delta;

		}
	}

	@Override
	public int getID() {
		return stateID;
	}
}
