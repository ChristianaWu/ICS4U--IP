
public class Player {
	private String name;
	private int score;
	
	public Player (String name, int score) {
		this.name = name;
		this.score = score;

	}
	
	public String getPlayerName () {
		if (this.name == null) {
			throw new NullPointerException();
		}
		return this.name;
	}
	
	public int getPlayerScore() {
		if (this.name == null) {
			throw new NullPointerException();
		}
		return this.score;
	}
	public String toString () {
		return this.name + "," + this.score;
	}
}
