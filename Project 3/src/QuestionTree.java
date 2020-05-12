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

	private QuestionNode node;
	private int totPlayed = 0;
	private int gamesWon = 0;
	private PrintStream output;
	private Scanner input;
	
	public QuestionTree(Scanner input, PrintStream output) {//constructor
		if (input == null || output == null) {
			throw new IllegalArgumentException();
		} else {
			this.output = output;
			this.input = input;
			this.node = new QuestionNode("Jedi");
		}
	}
	
	public void play() {
		this.node = play(this.node);
		totPlayed++;
	}
	
	private QuestionNode play(QuestionNode node) {	//helper method
		if (node.left == null && node.right==null) {//this is the base case
			this.output.println("Would your object happen to be "+node.data+"?");
			boolean ans = UserInterface.nextAnswer(this.input);
			if (ans) {//if the answer is true
				this.output.println("I win!");
				gamesWon++;
				return node;
			} else {//if the answer is false
				this.output.println("I lose. What is your object?");
				String snObject = this.input.nextLine();
				this.output.println("Type a yes/no question to distinguish your item from "+node.data+": ");
				String question = this.input.nextLine();
				this.output.println("And what is the answer for your object?");
				boolean ans2 = UserInterface.nextAnswer(this.input);		
				if (ans2) {
					return new QuestionNode(question, new QuestionNode(snObject), new QuestionNode(node.data));
				} else {
					return new QuestionNode(question, new QuestionNode(node.data), new QuestionNode(snObject));
				}
			}
		} else {//reccution part
			this.output.println(node.data);
			boolean ans = UserInterface.nextAnswer(this.input);
			if (ans) {
				node.left = play(node.left);
			} else {
				node.right = play(node.right);
			}
			return node;
		}
	}
	
	public void save(PrintStream output) {
		if (output == null) {
			throw new IllegalArgumentException();
		} else {
			if (this.node != null && output != null) {
				save(output,this.node);
			} else {
				throw new IllegalArgumentException();
			}
		}
	}
	
	private void save(PrintStream output, QuestionNode node) {//Helper method
		if (node != null && output != null && this.node != null) {
			if (node.left == null && node.right == null) {//base case
				output.println("A:" + node.data);
			} else if (node != null && node.left != null && node.right != null) {//print the questions and reccurtion part
				output.println("Q:"+ node.data);
				save(output,node.left);
				save(output,node.right);
			}
		}
	}
	
	public void load (Scanner input) {
		if (input == null) {
			throw new IllegalArgumentException();
		} else {
			this.node = load(input,this.node);
		}
	}
	
	public QuestionNode load (Scanner input, QuestionNode node) {//Helper method
		String line = input.nextLine();
		if (line.startsWith("A")) {//base case
			return new QuestionNode(line.substring(2));		
		} else if (line.startsWith("Q")) {//creating the node and the recurtion part
			QuestionNode nNode = new QuestionNode(line.substring(2));
			nNode.left = load(input,nNode.left);
			nNode.right = load(input,nNode.right);
			return nNode;
		}
		return node;
	}
	
	public int totalGames() {
		return this.totPlayed;
	}
	
	public int gamesWon() {
		return this.gamesWon;
	}

}
