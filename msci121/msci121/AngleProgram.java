/*
 * Christiana Wu
 * 20767703
 * Problem 3 Assignemnt 6
 * March 9, 2019 
 * Input none Output if this is true or false 
 * This will check if  the angles will produce a complementary and supplementary angle
 */
package msci121;

public class AngleProgram {

	public static void main(String[] args) {
		System.out.println(anglePairs (0, 90, 180));

	}
	public static boolean anglePairs (int x, int y, int z){
		return ((x + y == 90 || x + z == 90 || y + z == 90 ) && (x + y == 180 || x + z == 180 || y + z == 180));
	}
}
