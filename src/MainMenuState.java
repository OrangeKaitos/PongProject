//import java.util.ArrayList;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Class Menu is a menu for the game.
 * 
 * @author Samuel Philipson
 * 
 */
public class MainMenuState extends BasicGameState {
	Image background = null;
	Image startSingleOption = null;
	Image exitOption = null;
	Image startMultiOption = null;
	Image InstructionsOption = null;
	float startSingleScale = 1;
	float startMultiScale = 1;
	float startInstructionScale = 1;
	float exitScale = 1;
	float scaleStep = 0.0001f;
	float menuX = 100;
	float menuY = 150;
	private static int windowSizeY;
	private static int windowSizeX;

	// private ArrayList<Button> buttons;
	int stateID = -1;

	public MainMenuState(int stateID) {
		this.stateID = stateID;
		// super("!");
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		background = new Image("data/menu.png");

		// load the menu images
		Image menuOptions = new Image("data/menuoptions.png");

		startSingleOption = menuOptions.getSubImage(0, 0, 355, 49);

		startMultiOption = menuOptions.getSubImage(0, 49, 355, 49);

		InstructionsOption = menuOptions.getSubImage(0, 98, 355, 49);

		exitOption = menuOptions.getSubImage(0, 147, 355, 49);

		windowSizeX = Main.screenX();
		windowSizeY = Main.screenY();
		System.out.println("" + windowSizeX + ", " + windowSizeY);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		float delta = 1;

		boolean insideSingleGame = false;
		boolean insideMultiGame = false;
		boolean insideInstructions = false;
		boolean insideExit = false;

		if ((mouseX >= menuX && mouseX <= menuX + startSingleOption.getWidth())
				&& (mouseY >= menuY && mouseY <= menuY
						+ startSingleOption.getHeight())) {
			insideSingleGame = true;
		} else if ((mouseX >= menuX && mouseX <= menuX
				+ startMultiOption.getWidth())
				&& (mouseY >= menuY + 49 && mouseY <= menuY + 49
						+ startMultiOption.getHeight())) {
			insideMultiGame = true;
		} else if ((mouseX >= menuX && mouseX <= menuX
				+ InstructionsOption.getWidth())
				&& (mouseY >= menuY + 98 && mouseY <= menuY + 98
						+ InstructionsOption.getHeight())) {
			insideInstructions = true;
		} else if ((mouseX >= menuX && mouseX <= menuX + exitOption.getWidth())
				&& (mouseY >= menuY + 147 && mouseY <= menuY + 147
						+ exitOption.getHeight())) {
			insideExit = true;
		}

		if (insideSingleGame) {
			if (startSingleScale < 1.05f)
				startSingleScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				Main.timeSinglePlayGameStarted = System.currentTimeMillis();
				sbg.enterState(Main.GAMESINGLESTATE);
			}
		} else {
			if (startSingleScale > 1.0f)
				startSingleScale -= scaleStep * delta;

		}

		if (insideMultiGame) {
			if (startMultiScale < 1.05f)
				startMultiScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sbg.enterState(Main.GAMEMULTISTATE);
			}
		} else {
			if (startMultiScale > 1.0f)
				startMultiScale -= scaleStep * delta;

		}

		if (insideInstructions) {
			if (startInstructionScale < 1.05f)
				startInstructionScale += scaleStep * delta;

			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
				sbg.enterState(Main.INSTRUCTIONSTATE);
			}
		} else {
			if (startInstructionScale > 1.0f)
				startInstructionScale -= scaleStep * delta;

		}

		if (insideExit) {
			if (exitScale < 1.05f)
				exitScale += scaleStep * delta;
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
				sbg.enterState(Main.HIGHSCORESTATE);
		} else {
			if (exitScale > 1.0f)
				exitScale -= scaleStep * delta;
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics arg2)
			throws SlickException {
		// render the background
		background.draw(0, 0);

		// Draw menu
		startSingleOption.draw(menuX, menuY, startSingleScale);

		startMultiOption.draw(menuX, menuY + 50, startMultiScale);

		InstructionsOption.draw(menuX, menuY + 100, startInstructionScale);

		exitOption.draw(menuX, menuY + 150, exitScale);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main());

		app.setDisplayMode(windowSizeX, windowSizeY, false);
		app.start();
	}
}