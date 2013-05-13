import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InstructionState extends BasicGameState {
	Image background = null;
	Image backOption = null;
	int backY;
	int backX;
	float scale = 1;
	float scaleStep = 0.0001f;
	int stateID = -1;

	public InstructionState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		background = new Image("data/InstructionsMenu.png");
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
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg)
			throws SlickException {
		int delta = 1;
		boolean insideBack = false;

		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
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

}
