package project.p2;

/**
 * This class stores data from the Results.csv file. Methods are provided to get a key that links to
 * the candidate in other csv files (e.g., Candidates.csv) and the riding in other csv files (e.g.,
 * Ridings.csv), as well as the number of votes tallied in this poll.
 * 
 * @author Mark Hancock
 *
 */
public class ResultData extends ElectionData {
    public String getCandidateKey() {
	return String.join(":", get(0), get(2), get(5));
    }

    public String getRidingKey() {
	return String.join(":", get(0), get(2));
    }

    public int getVotes() {
	return getAsInt(7);
    }
}
