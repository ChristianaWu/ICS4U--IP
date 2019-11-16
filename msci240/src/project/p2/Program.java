package project.p2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Program {
    private static final String RESULTS_FILENAME = "Results.csv";

    private static final String CANDIDATES_FILENAME = "Candidates.csv";

    private static final String PARTIES_FILENAME = "Parties.csv";

    private static final String RIDINGS_FILENAME = "Ridings.csv";

    // TODO: change this to the directory you store the data in (you can use this
    // one in your project, if you want)
    private static final String GAME_DATA_DIRECTORY = "canadian-federal-election-results-timeseries";

    // TODO: when testing, you may want to choose a smaller portion of the dataset.
    // This number lets you limit it to only the first MAX_ENTRIES. Setting this
    // over 3.5 million will get all the data.
    //
//    private static final int MAX_RESULTS = 100000;
    private static final int MAX_RESULTS = Integer.MAX_VALUE;

    private static final int MAX_CANDIDATES = 100;
//  private static final int MAX_CANDIDATES = Integer.MAX_VALUE;

    private static Stopwatch stopwatch = new Stopwatch();

    public static void main(String[] args) throws IOException {
	Path dir = Paths.get(GAME_DATA_DIRECTORY);

	// We are going to read all of the data and store them in lists to make the rest of your project
	// easier for you. This is NOT the way one would normally operate. There is no reason to store all
	// of the data in RAM. We only need to read data from the files, count them, and then move on
	// to the rest of the file.
	List<ResultData> results = readData(dir.resolve(RESULTS_FILENAME),
		"election results", ResultData::new, MAX_RESULTS, false);
	List<CandidateData> candidates = readData(dir.resolve(CANDIDATES_FILENAME),
		"candidates", CandidateData::new, MAX_CANDIDATES, false);
	List<PartyData> parties = readData(dir.resolve(PARTIES_FILENAME),
		"parties", PartyData::new, MAX_RESULTS, false);
	List<RidingData> ridings = readData(dir.resolve(RIDINGS_FILENAME),
		"ridings", RidingData::new, MAX_RESULTS, false);

	// ************************ IMPORTANT ***************************************
	//
	// NOTE: You may NOT change anything about these lists!
	// You should only read stats from index 0 to index list.size() - 1
	// Do NOT sort the list or change them in any way.
	//
	// **************************************************************************

	// --------------------------------------------------------------------------
	//
	// TODO: Add your code here to count the stats, etc. You will do best to create
	// many methods to organize your work and experiments.
	//
	// --------------------------------------------------------------------------
    }

    private static <T extends ElectionData> ArrayList<T> readData(Path path,
	    String description,
	    Supplier<T> supplier,
	    int limit,
	    boolean printHeader)
	    throws IOException {
	stopwatch.reset();
	stopwatch.start();

	ArrayList<T> list = Files.lines(path, StandardCharsets.UTF_8)
		.skip(1)
		.filter(s -> !s.isEmpty())
		.limit(limit)
		.map(s -> ElectionData.parse(s, supplier))
		.collect(Collectors.toCollection(ArrayList::new));
	stopwatch.stop();
	System.out.printf("Finished reading %,d %s in %f seconds.\n", list.size(), description,
		stopwatch.getElapsedSeconds());

	if (printHeader) {
	    Files.lines(path, StandardCharsets.UTF_8)
		    .limit(1)
		    .map(s -> ElectionData.parse(s, supplier))
		    .findFirst()
		    .ifPresent(ed -> {
			for (int i = 0; i < ed.size(); i++) {
			    System.out.printf("\t%d = %s\n", i, ed.get(i));
			}
		    });
	}

	return list;
    }
}
