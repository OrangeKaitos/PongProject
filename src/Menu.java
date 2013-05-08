import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * Class Menu is a menu for the game pong.
 * 
 * @author Philip Stiff
 * 
 */
public class Menu extends BasicGame {
	private final static int windowSizeX = 300;
	private final static int windowSizeY = 350;
	private ArrayList<Button> buttons;

	public Menu() {
		super("Pong!");
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		buttons = new ArrayList<Button>();
		for (int i = 0; i < 4; i++) {
			buttons.add(new Button());
		}
		buttons.get(0).setImage(new Image("data/onePlayer.png"));
		buttons.get(1).setImage(new Image("data/twoPlayers.png"));
		buttons.get(2).setImage(new Image("data/instructions.png"));
		buttons.get(3).setImage(new Image("data/highscore.png"));

		buttons.get(0).setPosX(
				windowSizeX / 2 - buttons.get(0).getImage().getWidth() / 2);
		buttons.get(0).setPosY(20);
		buttons.get(1).setPosX(
				windowSizeX / 2 - buttons.get(1).getImage().getWidth() / 2);
		buttons.get(1).setPosY(
				buttons.get(0).getPosY()
						+ buttons.get(0).getImage().getHeight() + 20);
		buttons.get(2).setPosX(
				windowSizeX / 2 - buttons.get(2).getImage().getWidth() / 2);
		buttons.get(2).setPosY(
				buttons.get(1).getPosY()
						+ buttons.get(1).getImage().getHeight() + 20);
		buttons.get(3).setPosX(
				windowSizeX / 2 - buttons.get(3).getImage().getWidth() / 2);
		buttons.get(3).setPosY(
				buttons.get(2).getPosY()
						+ buttons.get(2).getImage().getHeight() + 20);
	}

	@Override
	public void update(GameContainer gc, int x) throws SlickException {
		Input input = gc.getInput();
		if (input.isMouseButtonDown(0)) {
			click(input);
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).getImage()
					.draw(buttons.get(i).getPosX(), buttons.get(i).getPosY());
		}
	}

	private void click(Input input) {
		int x = input.getMouseX();
		int y = input.getMouseY();
		if (x >= buttons.get(0).getPosX()
				&& x <= buttons.get(0).getPosX()
						+ buttons.get(0).getImage().getWidth()) {
			if (y >= buttons.get(0).getPosY()
					&& y <= buttons.get(0).getPosY()
							+ buttons.get(0).getImage().getHeight()) {
				// ACTION TO PERFORM!!
			}
		}
		
		if (x >= buttons.get(1).getPosX()
				&& x <= buttons.get(1).getPosX()
						+ buttons.get(1).getImage().getWidth()) {
			if (y >= buttons.get(1).getPosY()
					&& y <= buttons.get(1).getPosY()
							+ buttons.get(1).getImage().getHeight()) {
				// ACTION TO PERFORM!!
			}
		}
		
		if (x >= buttons.get(2).getPosX()
				&& x <= buttons.get(2).getPosX()
						+ buttons.get(2).getImage().getWidth()) {
			if (y >= buttons.get(2).getPosY()
					&& y <= buttons.get(2).getPosY()
							+ buttons.get(2).getImage().getHeight()) {
				// ACTION TO PERFORM!!
			}
		}
		
		if (x >= buttons.get(3).getPosX()
				&& x <= buttons.get(3).getPosX()
						+ buttons.get(3).getImage().getWidth()) {
			if (y >= buttons.get(3).getPosY()
					&& y <= buttons.get(3).getPosY()
							+ buttons.get(3).getImage().getHeight()) {
				// ACTION TO PERFORM!!
			}
		}
	}

	/**
	 * @throws SlickException
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Menu());

		app.setDisplayMode(windowSizeX, windowSizeY, false);
		app.start();
	}
}
