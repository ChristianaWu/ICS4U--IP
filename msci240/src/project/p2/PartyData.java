package project.p2;

/**
 * This class stores data from the Parties.csv file. Methods are provided to get a unique key for
 * this party that links to other csv files, as well as the party's name.
 * 
 * @author Mark Hancock
 *
 */
public class PartyData extends ElectionData {
    public String getKey() {
	return get(0);
    }

    public String getName() {
	return get(2);
    }
}
