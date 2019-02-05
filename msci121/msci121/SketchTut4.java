package msci121;
/*
 * Christiana Wu	20767703
 * input nothing output the tree
 */
public class SketchTut4 {
	
	public static final int HEIGHT = 3;
	public static final String TOPPER = "$";
	public static void main(String[] args) {

		printPattern(HEIGHT, TOPPER);
		

	}
	
	public static void printPattern (int height, String top) {
		int numbRows = 2;
		
		for (int i = 1; i<= height*9 ; i++) {
			System.out.print(" ");
		}
		
		System.out.println(top);
		
		for (int i = 1; i<= height*9 -1; i++) {
			System.out.print(" ");
		}
		
		System.out.println("/ \\"); 
		
		for (int sec = 1; sec <= height; sec++) {
			for (int row = 1; row <= numbRows; row++) {
				for (int spa = 1; spa < (height *9 - (row)); spa++) {
					System.out.print(" ");
				}
				System.out.print("/ ");
				for (int star = 1; star<=row; star++) {
					System.out.print("* ");
				}
				System.out.println("\\");
			}
			numbRows++;
		}
		
		for (int i = 1; i<= height*9 -1; i++) {
			System.out.print(" ");
		}
		
		System.out.println("| |");
		
	}

}
