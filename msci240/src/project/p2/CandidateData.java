package project.p2;

/**
 * This class stores data from the Candidates.csv file. Methods are provided to get a unique key for
 * this candidate that links to other csv files, in addition to a key that links to the candidate's
 * party in other csv files (e.g., Candidates.csv) and the candidate's riding in other csv files
 * (e.g., Ridings.csv), as well as the candidate's name.
 * 
 * @author Mark Hancock
 *
 */
public class CandidateData extends ElectionData {
    public String getKey() {
	return String.join(":", get(0), get(2), get(3));
    }

    public String getRidingKey() {
	return String.join(":", get(0), get(2));
    }

    public String getPartyKey() {
	return get(16);
    }

    public String getName() {
	return get(4);
    }
}
