/*
 * Christiana Wu
 * 2767703 
 * Tut 9
 * OOP 
 * this has setters and getters  
 */
package msci121;

public class Name {
	private String first;
	private String last;
	private char middle;
	
	public Name (String first, String last, char middle) {
		this.first = first;
		this.last = last;
		this.middle = middle;
	}
	
	

	public void setName(String first, String last, char middle) {
		this.first = first;
		this.last = last;
		this.middle = middle;
	}
	
	public String getName() {
		
		return this.first + " " + this.last;
	}
	
	public String getReverseName() {
		return this.last + " " + this.middle + ". " + this.first;
	}

	@Override
	public String toString() {
		return "Name [first=" + this.first + ", middle=" + this.middle + ", last=" + this.last + "]";
	}

}
