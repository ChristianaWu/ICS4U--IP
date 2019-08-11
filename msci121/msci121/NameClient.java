/*
 * Christiana Wu
 * 2767703 
 * Tut 9
 * OOP 
 * this creates the objects the Client that will use the program
 */
package msci121;

public class NameClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Name name = new Name ("Christiana", "Wu", 'Z');
		System.out.println(name.getName());
		System.out.println(name.getReverseName());
	}

}
