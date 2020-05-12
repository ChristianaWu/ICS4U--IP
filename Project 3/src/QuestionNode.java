
public class QuestionNode {
	public QuestionNode left;
	public QuestionNode right;
	public String data;
	
	public QuestionNode (String data) {
		this(data,null,null);
	}
	
	public QuestionNode(String data, QuestionNode left, QuestionNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
