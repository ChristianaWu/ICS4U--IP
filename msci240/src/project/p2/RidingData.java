package project.p2;

/**
 * This class stores data from the Ridings.csv file. Methods are provided to get a unique key for
 * this riding that links to other csv files, as well as the province and name of this riding
 * easily.
 * 
 * @author Mark Hancock
 *
 */
public class RidingData extends ElectionData {
    public String getKey() {
	return String.join(":", get(0), get(4));
    }

    public String getProvince() {
	return get(2);
    }

    public String getName() {
	return get(5);
    }
}
