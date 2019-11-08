

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MergeProgram {
    // --------------------------------------------------------------------
    // Unzip the data.zip file and copy the "data" folder to your Project
    // --------------------------------------------------------------------

    /**
     * DO NOT CHANGE THIS METHOD.
     * 
     * @param args the arguments passed into the program
     */
    public static void main(String[] args) {
	File dir = new File("data");

	if (!setupFiles(dir)) {
	    System.err.println("Unable to complete setup successfully. Exiting.");
	    return;
	}
	Stopwatch stopwatch = new Stopwatch();
	stopwatch.start();

	Queue<File> filesToMerge = new LinkedList<File>();
	File[] files = dir.listFiles();
	for (File file : files) {
	    if (file.getName().matches("\\d+.txt")) {
		file.setReadOnly();
		filesToMerge.add(file);
	    }
	}

	try {
	    System.out.println("Merge operation started.");
	    mergeFiles(dir, filesToMerge);
	} catch (IOException e) {
	    System.err.println("Error merging files");
	    e.printStackTrace();
	}

	stopwatch.stop();
	if (!checkSolution(dir)) {
	    System.out.println("ISSUE: Files solution.txt and merged.txt do NOT match.");
	} else {
	    System.out.println("SUCCESS: Files solution.txt and merged.txt do match!");
	}
	double elapsedSeconds = stopwatch.getElapsedSeconds();
	double minutes = Math.floor(elapsedSeconds / 60);
	double remainingSeconds = elapsedSeconds - (60.0 * minutes);
	System.out.printf("Merging took %.0f minutes and %f seconds.", minutes, remainingSeconds);
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * This method compares solution.txt to merged.txt
     * 
     * @param dir the directory containing the files
     * @return true if the solution.txt file matches the merged.txt file
     */
    public static boolean checkSolution(File dir) {
	try {
	    Scanner srSolution = new Scanner(new File(dir, "solution.txt"));
	    Scanner srAttempt = new Scanner(new File(dir, "merged.txt"));

	    try {
		while (srSolution.hasNextLine() && srAttempt.hasNextLine()) {
		    String solStr = srSolution.nextLine();
		    String solAtt = srAttempt.nextLine();
		    if (!solStr.equals(solAtt)) {
			return false;
		    }
		}

		if (srSolution.hasNextLine() || srAttempt.hasNextLine()) {
		    return false;
		}
	    } finally { // This makes sure these close calls happen, even if the
			// method returns false
		srSolution.close();
		srAttempt.close();
	    }
	} catch (Exception e) {
	    System.err.println("Caught an exception in SuccessfulSolution():");
	    System.err.println(e);
	    return false;
	}
	return true;
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * This method:
     *
     * 1. Changes the working directory to dataDirectoryPath
     *
     * 2. Makes all the data files read-only to avoid terrible errors.
     *
     * @param dataDirectoryPath full path to data directory
     * @return true if successful, false if something failed
     */
    public static boolean setupFiles(File dir) {
	try {
	    if (!dir.exists()) {
		System.err.println("Your data directory: ");
		System.err.println(dir.getName());
		System.err.println("does not exist or is inaccessible.");
		return false;
	    }

	    File solutionFile = new File(dir, "solution.txt");
	    if (!solutionFile.exists()) {
		System.err.println("File: \"solution.txt\" is missing.");
		return false;
	    }
	    solutionFile.setReadOnly();
	} catch (Exception e) {
	    System.err.println("Caught an exception during setup:");
	    System.err.println(e);
	    return false;
	}
	return true;

    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * The mergeFiles method merges all of the files in the queue into a file called "merged.txt"
     * 
     * @param dir          the directory where all the files are and where "merged.txt" will go
     * @param filesToMerge the list of files to merge
     * @throws IOException if something goes wrong
     */
    public static void mergeFiles(File dir, Queue<File> filesToMerge)
	    throws IOException {
	String tmpFileRoot = "tmpFile-";
	int currTmpFile = 0;
	while (filesToMerge.size() > 1) {
	    File fileA = filesToMerge.remove();
	    File fileB = filesToMerge.remove();
	    File resultFile = new File(dir, tmpFileRoot + currTmpFile + ".txt");
	    currTmpFile++;

	    mergeFiles(fileA, fileB, resultFile);
	    filesToMerge.add(resultFile);

	    if (fileA.getName().startsWith(tmpFileRoot)) {
		fileA.delete();
	    }
	    if (fileB.getName().startsWith(tmpFileRoot)) {
		fileB.delete();
	    }
	}
	File mergedFile = filesToMerge.remove();
	Files.move(mergedFile.toPath(),
		dir.toPath().resolve("merged.txt"),
		StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * 
     * This method is helpful for checking the next integer in a file without reading it in. It is
     * similar to hasNextInt, except it returns the integer that it sees.
     * 
     * @param scanner the Scanner object to peek at the next value in
     * @return the integer that will be returned from scanner.nextInt() the next time it is called
     */
    public static int peekAtNextInt(Scanner scanner) {
	scanner.hasNext(".*");
	return Integer.parseInt(scanner.match().group(0));
    }

    /**
     * TODO: CHANGE THIS METHOD.
     * 
     * THIS IS THE METHOD YOU ARE WRITING.
     *
     * This method merges two files, fileA and fileB, and puts the result in a new file, resultFile. You
     * may want to make use of the {@link #peekAtNextInt(Scanner)} method to look ahead one integer in
     * the file.
     * 
     * @param fileA      the first file to merge
     * @param fileB      the second file to merge
     * @param resultFile the file to put the merged result in
     * @throws FileNotFoundException if any of the three files is not found
     */
    public static void mergeFiles(File fileA, File fileB, File resultFile) throws FileNotFoundException {
	PrintStream output = new PrintStream(resultFile);

	// TODO: add your code here

	output.close();
    }
}
