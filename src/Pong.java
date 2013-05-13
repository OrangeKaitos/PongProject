import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
  
public class Pong extends StateBasedGame {
	
	 public static final int MAINMENUSTATE          = 0;
	 public static final int GAMEPLAYSTATE          = 1;
	 public static final int GAMEOVERSTATE			= 2;
	 public static final int INSTRUCTIONSTATE		= 3;
	 public static final int screenX						= 800;
	 public static final int screenY 						= 400;

	public Pong() {
		super("Pong");
	}

	public static void main(String[] args) throws SlickException
    {
         AppGameContainer app = new AppGameContainer(new Pong());
  
         app.setDisplayMode(screenX, screenY, false);
         app.start();
    }
  
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new MainMenuState(MAINMENUSTATE));
        this.addState(new GamePlayState(GAMEPLAYSTATE));
        this.addState(new GameOverState(GAMEOVERSTATE));
//        this.addState(new PausMenuState(PAUSMENUSTATE));
    }
    
    public static int screenX() {
    	return screenX;
    }
    public static int screenY() {
    	return screenY;
    }

}
