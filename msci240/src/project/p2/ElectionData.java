package project.p2;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Each ElectionData object stores data from each line of the comma-separated input files. The two
 * methods of interest are get(i) and getAsInt(i), which return the data from the ith field as
 * either a String or integer, respectively.
 *
 * @author Mark Hancock
 *
 */
public class ElectionData {

    /**
     * An array list storing each field of data.
     */
    protected ArrayList<String> data;

    /**
     * A private constructor, to prevent creation of these objects directly.
     */
    public ElectionData() {
	data = new ArrayList<String>();
    }

    protected ElectionData(ElectionData ed) {
	// copy all of the data
	this.data = new ArrayList<String>(ed.data);
    }

    /**
     * The only way to create HockeyData objects is by reading them from a line of input from a file in
     * this method.
     *
     * @param str The line of input from a file.
     * @return The object that was created.
     */
    public static <T extends ElectionData> T parse(String str, Supplier<T> supplier) {
	T electionData = supplier.get();
	tokenize(str, ',', '"', electionData.data);

	return electionData;
    }

    /**
     * The get method returns the ith field as a String.
     *
     * @param i the index of the field to return.
     * @return the ith field.
     */
    public String get(int i) {
	return data.get(i);
    }

    /**
     * The getAsInt method returns the ith field as an integer.
     *
     * @param i the index of the field to return.
     * @return the ith field as an integer.
     */
    public int getAsInt(int i) {
	return Integer.parseInt(get(i));
    }

    /**
     * The size method returns the number of fields in this data.
     *
     * @return the number of fields in this data.
     */
    public int size() {
	return data.size();
    }

    @Override
    public String toString() {
	return data.toString();
    }

    /**
     * A private helper method to convert a line of input into each field, separated by commas. Quotes
     * are used when a comma is part of the field itself and need to be handled differently.
     *
     * @param text      the text to tokenize.
     * @param delimiter the delimiter to use to tokenize with.
     * @param quoteChar the quote character that escapes all other characters.
     * @param data      the array list to add each field to.
     */
    private static void tokenize(String text,
	    char delimiter,
	    char quoteChar,
	    ArrayList<String> data) {
	char[] ca = text.toCharArray();
	int start = 0;

	int i;
	int length = 0;
	boolean quoteStarted = false;
	for (i = 0; i < ca.length; ++i) {
	    if (!quoteStarted) {
		if (ca[i] == quoteChar) {
		    quoteStarted = true;
		    start = i + 1;
		} else if (ca[i] == delimiter) {
		    data.add(new String(ca, start, length));
		    start = i + 1;
		    quoteStarted = false;
		    length = 0;
		} else {
		    length++;
		}
	    } else if (ca[i] == quoteChar) {
		quoteStarted = false;
	    } else {
		length++;
	    }
	}

	// add the last field (fence post)
	data.add(new String(ca, start, length));
    }
}
