import java.io.*;
import java.util.ArrayList;

/**
 * Class Highscore is a class used to read and write a highscore in a file.
 * 
 * @author Philip
 * 
 */
public class Highscore {
	private int listSize;
	
	public Highscore(int listSize){
		this.listSize = listSize;
	}
	
	/**
	 * Reads the highscore from top to bottom and returns an Array containing
	 * the scores. Each element in the Array contains the score followed by the
	 * name of the player.
	 * 
	 * @return The scores.
	 */
	public ArrayList<String> read() {
		ArrayList<String> scores = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"data/highscore.txt"));
			String temp = reader.readLine();
			while (temp != null) {
				scores.add(temp);
				temp = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File could not be found.");
		} catch (IOException e) {
			System.err.println("There was a problem reading from file.");
		}

		return scores;
	}

	/**
	 * Writes the parameterized score to the highscore file and sets it in the
	 * right position in the file.
	 */
	public void write(String name, int score) {
		try {
			File scoreFile = new File("data/highscore.txt");
			File tempFile = new File("data/highscoretemp.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					tempFile));
			BufferedReader reader = new BufferedReader(new FileReader(
					scoreFile));
			
			String temp = reader.readLine();
			int writes = 0;
			boolean notWritten = true;
			while(temp != null && writes < listSize){
				String[] temp2 = temp.split(" ");
				if(Integer.parseInt(temp2[0]) < score && notWritten){
					if (writes != 0) {
						writer.newLine();
						//writes++;
					}
					writer.write(score + " " + name);
					writes++;
					notWritten = false;
				}
				if (writes != 0) {
					writer.newLine();
					//writes++;
				}
				writer.write(temp);
				writes++;
				temp = reader.readLine();
			}
			reader.close();
			writer.close();
			
			// Delete the old highscore file.
			if(!scoreFile.delete()){
				System.err.println("There was a problem deleting a temp file.");
			}
			tempFile.renameTo(scoreFile);

		} catch (IOException e) {
			System.err.println("There was a problem writing to file.");
		};
	}
}
