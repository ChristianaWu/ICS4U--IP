 /* Christiana Wu
 * 20767703
 * Project 3 
 * This is just creates the binary tree for th game 20 questions 
 * this in put for this file is yes or no for each of the questions in the tree if your right no then it 
 * it will ask for your object then a question that distingues the two objects and it will also as if yur object is yes 
 * or no for this question.
 * September 18, 2019
 */
import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
	private PrintStream out;
	private Scanner input;
	private QuestionNode node;
	private int totalGames = 0;
	private int gamesWon = 0;
	
	public QuestionTree(Scanner input,PrintStream output) {//constructor
		if(input == null || output == null) {
			throw new IllegalArgumentException();
		}
		this.input = input;
		this.out = output;
		this.node= new QuestionNode ("Jedi");
	}
	
	public void play() {
		//helper method 
		totalGames++;
		this.node = play2(this.node);
	}
	
	private QuestionNode play2 (QuestionNode child) {
		if (child.left == null && child.right == null) {//base case
			this.out.print("Would your object happen to be " + child.data + "?");
			if(UserInterface.nextAnswer(input)) { //if computer guess is not right
				this.out.println("I win!"); //if computer was right
				gamesWon++;
			}else{
				this.out.print("I lose. What is your object?");  //get the new answer and create it into a new node
				String sUserInput = input.nextLine();
				this.out.print("Type a yes/no quesiton to distinguish you item from " + child.data + ": ");  //Answer to distinguash the new answer
				String ssUserInput = input.nextLine();
				this.out.print("And what is the answer for your object?"); //Answer for player's object to the questions
				if (!UserInterface.nextAnswer(input)) {
					return new QuestionNode (ssUserInput,new QuestionNode(child.data),new QuestionNode(sUserInput));
				}else {	
					return new QuestionNode (ssUserInput,new QuestionNode(sUserInput),new QuestionNode(child.data));
				}
			}
		}else {			
			this.out.print(child.data); //guessing the object
			if(UserInterface.nextAnswer(input)) {
				child.left = play2(child.left);
			}else {
				child.right = play2(child.right);
			}
		}
		return child;
	}
	
	public void save(PrintStream output) {
		if (output == null) {
			throw new IllegalArgumentException();
		}else {
			save2(this.node,output);
		}
	}
	
	private void save2(QuestionNode node,PrintStream output) {
		if(node == null) {
			return;
		}	
		if(node.left ==null && node.right == null) { //print the right line to the txt file
			output.println("A:"+node.data);
		}else {
			output.println("Q:"+node.data);
		}
		save2(node.left,output);
		save2(node.right,output);
	}
	
	public void load (Scanner input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}else {
			QuestionNode pointer = this.node;
			this.node = load2(pointer,input);
		}
	}
	
	private QuestionNode load2 (QuestionNode node, Scanner input) {
		String newNode = input.nextLine();
		if (newNode.startsWith("A")) {
			node = new QuestionNode (newNode.substring(2));
		}else if (newNode.startsWith("Q")) { //If it is a Q then add a node to it 
			node.left = load2(node.left,input);
			node.right = load2(node.right,input);
		}
		return node;
	}
	
	public int totalGames (){
		return this.totalGames;
	}
	
	public int gamesWon () {
		return this.gamesWon;
	}
	
}
