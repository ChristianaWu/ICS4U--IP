package project.p2;

/**
 * This class stores data about each candidate.
 * 
 * It is useful to know that {@link #getCandidateKey()} is unique for this candidate,
 * {@link #getRidingKey()} is unique for each riding and is the same for all candidates that share
 * the same riding, and {@link #getPartyKey()} is unique for each party and is the same for all
 * candidates that share the same party.
 * 
 * There are also methods to update the candidate's name, {@link #setCandidateName(String)}, the
 * name of their riding, {@link #setRidingName(String)}, the name of their province,
 * {@link #setRidingProvince(String)}, and their party name, {@link #setPartyName(String)}.
 * 
 * There are also methods to update the candidate's vote count ({@link #addVotes(int)}), as well as
 * the total vote count for this candidate's riding, even if the votes are for a different candidate
 * in the same riding ({@link #addRidingVotes(int)}).
 * 
 * A very important method is the {@link #getVoteSharePercent()} method that returns this
 * candidate's vote share, as long as the vote count and total vote count have been updated
 * correctly.
 *
 * @author Mark Hancock
 *
 */
public class VoteCount  implements Comparable<VoteCount>{
    private String candidateKey;
    private String ridingKey;
    private String partyKey;

    private String candidateName;
    private String ridingName;
    private String ridingProvince;
    private String partyName;

    private int votes;
    private int totalRidingVotes;

    public VoteCount(String candidateKey, String ridingKey, String partyAbbrv) {
    	this.candidateKey = candidateKey;
		this.ridingKey = ridingKey;
		this.partyKey = partyAbbrv;
	
		this.votes = 0;
		this.totalRidingVotes = 0;
    }

    public double getVoteSharePercent() {
    	return 100.0 * votes / totalRidingVotes;
    }

    public void addVotes(int votes) {
    	this.votes += votes;
    }
    
    //added
    public int getRidingVotes() {
    	return this.totalRidingVotes;
    }

    public void addRidingVotes(int votes) {
    	this.totalRidingVotes += votes;
    }

    public String getCandidateName() {
    	return candidateName;
    }

    public void setCandidateName(String candidateName) {
    	this.candidateName = candidateName;
    }

    public String getRidingName() {
    	return ridingName;
    }

    public void setRidingName(String ridingName) {
    	this.ridingName = ridingName;
    }

    public String getRidingProvince() {
	return ridingProvince;
    }

    public void setRidingProvince(String ridingProvince) {
	this.ridingProvince = ridingProvince;
    }

    public String getPartyName() {
	return partyName;
    }

    public void setPartyName(String partyName) {
	this.partyName = partyName;
    }

    public String getCandidateKey() {
	return candidateKey;
    }

    public String getRidingKey() {
	return ridingKey;
    }

    public String getPartyKey() {
	return partyKey;
    }

    public void setPartyKey(String partyKey) {
	this.partyKey = partyKey;
    }

    public int getVotes() {
	return votes;
    }

	@Override
	public int compareTo(VoteCount o) {
		// TODO Auto-generated method stub
		return Double.compare(this.getVoteSharePercent(), o.getVoteSharePercent());
	}
}
