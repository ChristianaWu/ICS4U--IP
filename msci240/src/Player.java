
public class Player {
	private String name;
	private int score;
	
	public Player (String name, int score) {
		this.name = name;
		if (score < 0 ) {
			throw new IllegalArgumentException();
		}
		this.score = score;
	}
	
	public String getName () {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
}
