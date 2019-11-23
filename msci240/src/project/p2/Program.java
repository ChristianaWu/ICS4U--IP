/*
 * Christiana Wu
 * 20767703
 * Nov 20 2019
 * Project 2
 * This program looks as the data the is extracted from a website and tries to find the top 20 candidate that have the highest vote share 
 * This program has 3 differnt implemtations using tree map, hash map and array list (each is a seperate method)
 * The input is 3 list candidats,riding and results list
 * The output is the top 20 candidates' name, votes gotten, vote share, riding name, province. THne it also prints the time it took to get the vote share and to read the csv files. Then it prints the total votes counted
 */
package project.p2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
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
    private static final int MAX_RESULTS = 100000;
    //private static final int MAX_RESULTS = Integer.MAX_VALUE;

    private static final int MAX_CANDIDATES = 800;
    //private static final int MAX_CANDIDATES = Integer.MAX_VALUE;

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
		
		//Callng the methods for the different implementation.
		//System.out.println("\nTree Map\n");
		countVoteShareTM(results,candidates,parties,ridings);
		//System.out.println("\nHash Map\n");
		countVoteShareHT(results,candidates,parties,ridings);
		//System.out.println("\nArray List\n");
		countVoteShareAL(results,candidates,parties,ridings);
    }
    
    public static void countVoteShareTM(List<ResultData> results,List<CandidateData> candidates, List<PartyData> parties, List<RidingData> ridings) {
    	stopwatch.reset();
    	stopwatch.start();
    	
    	TreeMap<String, VoteCount> trackCandiditeKey = new TreeMap <String, VoteCount>();
    	TreeMap<String, Integer> ridingVotes = new TreeMap<String, Integer>();
    	int totVotes = 0;
    	
    	//get candidate, riding and party key and candidate name and create the vote counts
    	for (CandidateData  candidate : candidates) {
    		if (!trackCandiditeKey.containsKey(candidate.getKey())) {
    			VoteCount value = new VoteCount(candidate.getKey(),candidate.getRidingKey(),candidate.getPartyKey());
    			value.setCandidateName(candidate.getName());
    			trackCandiditeKey.put(candidate.getKey(), value);
    		}    	
    	}
    	
    	//Get the votes for the candidates and found the total riding votes 
    	for (ResultData result : results) {
    		VoteCount value = trackCandiditeKey.get(result.getCandidateKey());
    		if (value != null) {
    			value.addVotes(result.getVotes());
        		trackCandiditeKey.put(result.getCandidateKey(), value);
        		totVotes+=result.getVotes();
    		}
    		
    		 if (!ridingVotes.containsKey(result.getRidingKey())) {
    			 ridingVotes.put(result.getRidingKey(), result.getVotes());
    		 }else {
    			 int vote = ridingVotes.get(result.getRidingKey());
    			 ridingVotes.put(result.getRidingKey(), vote+=result.getVotes());
    		 }
    	}

    	TreeMap <String, List<VoteCount>> trackRidingIdKey = new TreeMap <String, List<VoteCount>>();
    	TreeMap<String, RidingData> ridingMap = new TreeMap<String, RidingData>();
    	int totRiding;
    	
    	//Create map that gets a list of candidats in the same ridings key is the riding key
    	for (CandidateData  candidate : candidates) {
    		if (!trackRidingIdKey.containsKey(candidate.getRidingKey())) {
    			VoteCount value = trackCandiditeKey.get(candidate.getKey());
    			List <VoteCount> candidateInRiding = new ArrayList <VoteCount>();
    			candidateInRiding.add(value);
    			trackRidingIdKey.put(candidate.getRidingKey(), candidateInRiding);
    		}else {
    			List <VoteCount> candidateInRiding = trackRidingIdKey.get(candidate.getRidingKey());
    			candidateInRiding.add(trackCandiditeKey.get(candidate.getKey()));
    			trackRidingIdKey.put(candidate.getRidingKey(), candidateInRiding);
    		}
    	}
    	
    	//collect total votes and place total riding votes into the vote counts 
    	for (RidingData riding : ridings) {
    		List <VoteCount> candidateRiding = trackRidingIdKey.get(riding.getKey());
    		if (ridingVotes.get(riding.getKey()) != null) {
    			totRiding = ridingVotes.get(riding.getKey());
    			//totVotes += totRiding;
    			if (candidateRiding != null) {
        			for (int i = 0; i < candidateRiding.size(); i++ ) {
            			candidateRiding.get(i).addRidingVotes(totRiding);
            		}
        		}
    		}
    		if (!ridingMap.containsKey(riding.getKey())) {
    			ridingMap.put(riding.getKey(), riding);
   		 	}
    	}
    	
    	stopwatch.stop();
    	System.out.printf("To count all the votes and get the vote share for all the candidates "
    			+ "too %f seconds.\n", 
    			stopwatch.getElapsedSeconds());
    	System.out.printf("Counted %d total votes. \n", totVotes);
    	
    	
    	//the PriorityQueue in decending order
    	PriorityQueue<VoteCount> top20H = new PriorityQueue<VoteCount>(Collections.reverseOrder());
    	TreeMap <String,String> partyMap = new TreeMap <String,String>();
    	int size;
    	if (trackCandiditeKey.size() < 20) {
    		size = trackCandiditeKey.size();
    	}else {
    		size = 20;
    	}
    	VoteCount[] top20 = new VoteCount [size];
    	
    	//sort
    	top20H.addAll(trackCandiditeKey.values());
    	
    	//Input the top into the the array that hold the top  
    	for (int i = 0; i < top20.length; i++) {
    		top20[i] = top20H.remove();
    	}
    	
    	//create party map
    	for (PartyData party : parties) {
    		partyMap.put(party.getKey(), party.getName());
    	}
    	
    	//set party name and riding name and riding province 
    	for (int i = 0; i < top20.length; i++) {
    		top20[i].setPartyName(partyMap.get(top20[i].getPartyKey()));
    		top20[i].setRidingName(ridingMap.get(top20[i].getRidingKey()).getName());
    		top20[i].setRidingProvince(ridingMap.get(top20[i].getRidingKey()).getProvince());
    	}
    	
    	//Print
    	for (int i = 0; i <top20.length; i++) {
    		System.out.println(top20[i].getCandidateName() + " (" +  top20[i].getPartyName() + ") from " + top20[i].getRidingName() + ", "
    				+ top20[i].getRidingProvince() + " got " + top20[i].getVotes() + " votes (" + Math.round(top20[i].getVoteSharePercent()*10.0)/10.0 + "%) votes");
    	}
    }
    
    public static void countVoteShareHT(List<ResultData> results,List<CandidateData> candidates, List<PartyData> parties, List<RidingData> ridings) {
    	stopwatch.reset();
    	stopwatch.start();
    	
    	HashMap<String, VoteCount> trackCandiditeKey = new HashMap <String, VoteCount>();
    	HashMap<String, Integer> ridingVotes = new HashMap<String, Integer>();
    	int totVotes = 0;

    	//get candidate, riding and party key and candidate name and create the vote counts
    	for (CandidateData  candidate : candidates) {
    		if (!trackCandiditeKey.containsKey(candidate.getKey())) {
    			VoteCount value = new VoteCount(candidate.getKey(),candidate.getRidingKey(),candidate.getPartyKey());
    			value.setCandidateName(candidate.getName());
    			trackCandiditeKey.put(candidate.getKey(), value);
    		}    	
    	}
    	
    	//Get the votes for the candidates and found the total riding votes 
    	for (ResultData result : results) {
    		VoteCount value = trackCandiditeKey.get(result.getCandidateKey());
    		if (value != null) {
    			value.addVotes(result.getVotes());
        		trackCandiditeKey.put(result.getCandidateKey(), value);
        		totVotes+=result.getVotes();
    		}
    		
    		 if (!ridingVotes.containsKey(result.getRidingKey())) {
    			 ridingVotes.put(result.getRidingKey(), result.getVotes());
    		 }else {
    			 int vote = ridingVotes.get(result.getRidingKey());
    			 ridingVotes.put(result.getRidingKey(), vote+=result.getVotes());
    		 }
    	}

    	HashMap <String, List<VoteCount>> trackRidingIdKey = new HashMap <String, List<VoteCount>>();
    	HashMap<String, RidingData> ridingMap = new HashMap<String, RidingData>();
    	int totRiding;
    	
    	//Create map that gets a list of candidats in the same ridings key is the riding key
    	for (CandidateData  candidate : candidates) {
    		if (!trackRidingIdKey.containsKey(candidate.getRidingKey())) {
    			VoteCount value = trackCandiditeKey.get(candidate.getKey());
    			List <VoteCount> candidateInRiding = new ArrayList <VoteCount>();
    			candidateInRiding.add(value);
    			trackRidingIdKey.put(candidate.getRidingKey(), candidateInRiding);
    		}else {
    			List <VoteCount> candidateInRiding = trackRidingIdKey.get(candidate.getRidingKey());
    			candidateInRiding.add(trackCandiditeKey.get(candidate.getKey()));
    			trackRidingIdKey.put(candidate.getRidingKey(), candidateInRiding);
    		}
    	}
    	
    	//collect total votes and place total riding votes into the vote counts 
    	for (RidingData riding : ridings) {
    		List <VoteCount> candidateRiding = trackRidingIdKey.get(riding.getKey());
    		if (ridingVotes.get(riding.getKey()) != null) {
    			totRiding = ridingVotes.get(riding.getKey());
    			if (candidateRiding != null) {
        			for (int i = 0; i < candidateRiding.size(); i++ ) {
            			candidateRiding.get(i).addRidingVotes(totRiding);
            		}
        		}
    		}
    		if (!ridingMap.containsKey(riding.getKey())) {
    			ridingMap.put(riding.getKey(), riding);
   		 	}
    	}
    	
    	stopwatch.stop();
    	System.out.printf("To count all the votes and get the vote share for all the candidates "
    			+ "too %f seconds.\n", 
    			stopwatch.getElapsedSeconds());
    	System.out.printf("Counted %d total votes. \n", totVotes);
    	
    	//the PriorityQueue in decending order
    	PriorityQueue<VoteCount> top20H = new PriorityQueue<VoteCount>(Collections.reverseOrder());
    	HashMap <String,String> partyMap = new HashMap <String,String>();
    	int size;
    	if (trackCandiditeKey.size() < 20) {
    		size = trackCandiditeKey.size();
    	}else {
    		size = 20;
    	}
    	
    	VoteCount[] top20 = new VoteCount [size];
    	//sort
    	top20H.addAll(trackCandiditeKey.values());
    	
    	//Input the top into the the array that hold the top  
    	for (int i = 0; i < top20.length; i++) {
    		top20[i] = top20H.remove();
    	}
    	
    	//Create party map
    	for (PartyData party : parties) {
    		partyMap.put(party.getKey(), party.getName());
    	}
    	
    	//set party name and riding name and riding province 
    	for (int i = 0; i < top20.length; i++) {
    		top20[i].setPartyName(partyMap.get(top20[i].getPartyKey()));
    		top20[i].setRidingName(ridingMap.get(top20[i].getRidingKey()).getName());
    		top20[i].setRidingProvince(ridingMap.get(top20[i].getRidingKey()).getProvince());
    	}
    	
    	//Print
    	for (int i = 0; i <top20.length; i++) {
    		System.out.println(top20[i].getCandidateName() + " (" +  top20[i].getPartyName() + ") from " + top20[i].getRidingName() + ", "
    				+ top20[i].getRidingProvince() + " got " + top20[i].getVotes() + " votes (" + Math.round(top20[i].getVoteSharePercent()*10.0)/10.0 + "%) votes");
    	}
    }
    
    public static void countVoteShareAL (List<ResultData> results,List<CandidateData> candidates, List<PartyData> parties, List<RidingData> ridings) {
    	//Timing the program
    	stopwatch.reset();
		stopwatch.start();
    
    	ArrayList<VoteCount> trackCandiditeKey = new ArrayList<VoteCount>();
    	int totVotes = 0;
    	
    	//Placing the information from the cadidates list to the arraylist of votecounts
    	for (CandidateData  candidate : candidates) {
    		VoteCount value = new VoteCount(candidate.getKey(),candidate.getRidingKey(),candidate.getPartyKey());
    		value.setCandidateName(candidate.getName());
    		trackCandiditeKey.add(value);
    	}
    	
    	//Filling out the votes data of votecounts and then tracking the total riding votes and the total votes counted
    	for (ResultData result : results) {
    		for (VoteCount vote: trackCandiditeKey) {
    			if (result.getCandidateKey().equals(vote.getCandidateKey())) {
    				vote.addVotes(result.getVotes());
    				totVotes+=result.getVotes();
    			}
    			if (result.getRidingKey().equals(vote.getRidingKey())) {
    				vote.addRidingVotes(result.getVotes());
    			}
    		}
    		
    	}
    	
    	//Fill in the riding name and the riding province
    	for (RidingData riding : ridings) {
    		for (VoteCount vote: trackCandiditeKey) {
    			if (riding.getKey().equals(vote.getRidingKey())) {
    				vote.setRidingName(riding.getName());
    				vote.setRidingProvince(riding.getProvince());
    			}
    		}
    	}
    	
    	//Out puts the tme ofr votes shares to be calcualted and the total votes counted
    	stopwatch.stop();
    	System.out.printf("To count all the votes and get the vote share for all the candidates "
    			+ "too %f seconds.\n", 
    			stopwatch.getElapsedSeconds());
    	System.out.printf("Counted %d total votes. \n", totVotes);
    	
    	//Fill in the party name 
    	for(PartyData party : parties) {
    		for(VoteCount vote: trackCandiditeKey) {
    			if (party.getKey().equals(vote.getPartyKey())) {
    				vote.setPartyName(party.getName());
    			}
    		}
    	}
    	
    	int size;
    	if (trackCandiditeKey.size() < 20) {
    		size = trackCandiditeKey.size();
    	}else {
    		size = 20;
    	}
    	VoteCount[] top20 = new VoteCount[size];
    	
    	//Sort the arraylist in decending form
    	Collections.sort(trackCandiditeKey,Collections.reverseOrder());
    	
    	//add top 20 to an array
    	for(int i = 0; i < top20.length; i++) {
    		top20[i] = trackCandiditeKey.get(i);
    	}
    	
    	//Print out informations
    	for (int i = 0; i <top20.length; i++) {
    		System.out.println(top20[i].getCandidateName() + " (" +  top20[i].getPartyName() + ") from " + top20[i].getRidingName() + ", "
    				+ top20[i].getRidingProvince() + " got " + top20[i].getVotes() + " votes (" + Math.round(top20[i].getVoteSharePercent()*10.0)/10.0 + "%) votes");
    	}
    	
    }
   
    private static <T extends ElectionData> ArrayList<T> readData(Path path,String description,Supplier<T> supplier,int limit,boolean printHeader)throws IOException {
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
