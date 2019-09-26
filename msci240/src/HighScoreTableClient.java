
public class HighScoreTableClient {

	public static void main(String[] args) {
		HighScoreTable x = new HighScoreTable (7);
		
		System.out.println(x.getCapacity());
		//System.out.println(x.getName(0));
		
		HighScoreTable x2 = new HighScoreTable (2);
		x2.add("Christiana", 1240);
    	x2.add("Paloma", 2240);
    	x2.add("Sabrina", 2240);
    	
    	x2.toString();
		
	}

}
