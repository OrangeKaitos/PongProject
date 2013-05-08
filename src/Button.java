import org.newdawn.slick.Image;

/**
 * A button with an Image and a position.
 * 
 * @author Philip
 *
 */
public class Button {
	private Image image;
	private int posX, posY;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	
}
