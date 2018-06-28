/*
 * Name: Christiana
 * Date: Febuary 21, 2018
 * Version: 1.1
 */
package edu.hdsb.gwss.christiana.ics4u.u1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.util.Scanner;
//import io.xom.Builder;

/**
 * Movie Review Assignment
 *
 * @author 
 * @version 2017-18.S2
 */
public class MovieReview {

    public static void main( String[] args ) throws Exception {

        // MOVIE REVIEW FILE
        File reviews = new File( ".\\data\\movie.review\\MovieReviews.txt" );
        
        //Object
        Scanner input = new Scanner (System.in);
        
        //Variables
        int userInput;
        String wordEntered,fileName;
        File usedFile;
        boolean loop = true;
        
        while (loop == true){
            //Into and instructions to the menu 
            System.out.println("What would you like to do?\n 1. Get the score of a word\n 2. Get the average "
                    + "score of the word in a file (one word per line)\n 4. Sort wortds from a file into positive.txt"
                    + "and negative.txt\n 5. Exit the program");
            System.out.print("Enter a number 1-5: ");
            userInput = input.nextInt();
        
            switch (userInput){
                case 1:
//                    //Variables 
//                    int counter;
//                    double averageofWord;
                    
                    //input
                    System.out.print("\nEnter a word: ");
                    wordEntered = input.next(); 
                    
                    //Counting 
                    
                    //output
                    System.out.println("\n" + wordEntered+ " appears " + wordCount(wordEntered,reviews));
                    System.out.println("The average score for reviews containing " 
                            + wordEntered + " is " + wordAverage(wordEntered,reviews)+ "\n");

                    break;
                case 2:
                    //Variables 
                    double average;
                    
                    //input
                    System.out.print("\nEnter a file name with the words that you want to find the average to: ");
                    fileName = input.next();
                    usedFile = new File(".\\data\\movie.review\\"+fileName);
                    
                    average= sentenceAverage( usedFile, reviews );
                    
                    //output
                    System.out.println("\nThe average of the words in " + fileName + " is " + average);
                    if (average>2.01){
                         System.out.println("The overall score of the words in " + fileName + " is positive.\n"); 
                    }else if (average<1.99) {
                        System.out.println("The overall score of the words in " + fileName + " is negative.\n");
                    }else {
                        System.out.println("The overall " + fileName + " has no sentiment.\n");
                    }
                    break;
                case 3:
                    //input
                    System.out.print("\nEnter a file name with the words that you want score: ");
                    fileName = input.next();
                    usedFile = new File(".\\data\\movie.review\\"+fileName);
                    
                    //output
                    System.out.println("\nThe most posititve word, with a score of "+multiplScoreMax(usedFile, reviews));
                    System.out.println("The most nevative word, with a score of "+multiplScoreMin(usedFile, reviews)+ "\n");
                    break;
                case 4: 
                    System.out.print("\nEnter a file name with the words that you want sort: ");
                    fileName = input.next();
                    usedFile = new File(".\\data\\movie.review\\"+fileName);
                    
                    wordSort (usedFile, reviews);
                    System.out.println("\nFiles created!\n");
                    break;
                case 5: 
                    loop = false; 
                    break;
                    
            }
        
        }
    }

    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the number of reviews that contain the key work at least once.
     */
    
    public static int wordCount( String word, File reviews ) throws Exception {
        //Variables 
        int Counter = 0;
        boolean hasTheWord = false;
        String line;
        String [] Word;
        
        //Read the file first
       Scanner sc = new Scanner(reviews);
       
        //Reading the file line by line 
        while (sc.hasNext()){
            line = sc.nextLine();
            Word = line.split(" ");
            for (int i=1; i< Word.length; i++){
               int CompareValue = Word [i].compareToIgnoreCase(word);
               if (CompareValue == 0){
                   Counter++;
                   hasTheWord = true;
                   break;
               } 
            }  
        }   
        return Counter;

    }

    /**
     * This method will accumulate the the movie review scores that contain the
     * key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the sum of the scores for reviews that contain the key work at
     * least once.
     */
    public static int wordTotalScore( String word, File reviews ) throws Exception {
        //Variable 
        int Accumlator = 0;
        int Rating=0;

        //Read the file first
       Scanner sc = new Scanner(reviews);
       
        //Reading the file line by line 
        while (sc.hasNext()){
            String line = sc.nextLine();
            String [] Word = line.split(" ");
            for (int i=1; i< Word.length; i++){
               int CompareValue = Word [i].compareToIgnoreCase(word);
               if (CompareValue == 0){
                   Rating = Integer.parseInt(Word[0]);//Changing the first Sring array into a int so I can add the values up
                   Accumlator+=Rating;
                   break;
               } 
            }
        }
        return Accumlator;
    }

    /**
     * Average score of reviews containing that word, given the specified file.
     *
     * @param word the key word the review must contain.
     * @param reviews reviews the file that contains the movie reviews.
     * @return the average score for the key word. Word Total Score / Word Count
     */
    public static double wordAverage( String word, File reviews ) throws Exception {
       //Variables
       double counter = wordCount(word, reviews);
       double ratingScore = wordTotalScore(word, reviews);
       double avrage;
       
       //This is where the math is done
       avrage = ratingScore/counter;
       
       return avrage;
       
    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given th specified movie review file.
     */
    public static double sentenceAverage( File wordList, File reviews ) throws Exception {
        //Vaiable 
        String word;
        double counter, score,average;
        double sentenceCounter = 0.0, sentenceScore = 0.0;
        
        //Read the word list file to gain the word
        Scanner sc2 = new Scanner(wordList);
//        Scanner sc = new Scanner(reviews);
        
        //This will read that file line by line and find the average of the  
        while (sc2.hasNext()){
            word = sc2.nextLine().replaceAll(" ", "");
            counter = wordCount (word, reviews);
            score = wordTotalScore(word, reviews); 
            sentenceCounter+=counter;
            sentenceScore += score;
        }
        
        average = sentenceScore/sentenceCounter;
        
        return average;
    }
    
    public static String[][] multipleWordScore (File wordList, File reviews) throws Exception{
        //Variables
        String [][] words;
        //double[]wordsScore;
        int lineCounter = 0;
        String line, average;

        //Read the the word list file
        Scanner sc2 = new Scanner(wordList);
        
        //Place each line in the an array;
        String word;
        while (sc2.hasNext()){
            word = sc2.nextLine();
            lineCounter++;  
        } 
        sc2.close();

        sc2 = new Scanner(wordList);
        
        words = new String [lineCounter][2];//String is an object threfore mush initilize it

        for (int i=0; i<lineCounter; i++){
          line = sc2.nextLine().replaceAll(" ", "");
          words [i][0] = line;
          double dAverage = wordAverage(line,reviews);
          average = Double.toString(dAverage);
          words[i][1] = average;
        }
        
        sc2.close();
        return words;
    }
    
    public static String multiplScoreMax(File wordList, File reviews) throws Exception{
        //Variables
        String [][] words =  multipleWordScore (wordList,reviews);
        String highestValues;
        double highest, average;
        int n;
        highest = Double.parseDouble(words[0][1]);
        n = 0;
        
        //finding the highest
        for (int i=1; i< words.length; i++){
            average = Double.parseDouble(words[i][1]);
            if (average> highest ){
                highest = average;
                n=i;
            }
        }
        highestValues = words[n][1].concat(" is "+ words[n][0]);
        
        return highestValues;
    }
    
    public static String multiplScoreMin(File wordList, File reviews) throws Exception{
        //Variables
        String [][] words =  multipleWordScore (wordList,reviews);
        String highestValues;
        double lowest, average;
        int n;
        lowest = Double.parseDouble(words[0][1]);
        n = 0;
        
        //finding the highest
        for (int i=1; i< words.length; i++){
            average = Double.parseDouble(words[i][1]);
            if (average< lowest ){
                lowest = average;
                n=i;
            }
        }
        highestValues = words[n][1].concat(" is "+ words[n][0]);
        
        return highestValues;
    }
    
    public static void wordSort (File wordList, File reviews) throws Exception{
        //Build and writer of thefiles that I need
        File fPostitive = new File(".\\data\\movie.review\\positive.txt");
        File fNegatvie = new File(".\\data\\movie.review\\negative.txt");
        BufferedWriter writer = new BufferedWriter (new FileWriter (fPostitive));
        BufferedWriter writer2 = new BufferedWriter (new FileWriter (fNegatvie));
        
        //Variables
        String[][] wordScore = multipleWordScore (wordList, reviews);
        double average;
        
        //Sorting the words 
        for (int i=0; i<wordScore.length; i++){
            average = Double.parseDouble(wordScore [i][1]);
            if (average>2.1){
                writer.write(wordScore [i][0]+ "\n");
            }else if (average<1.9){
                writer2.write(wordScore [i][0]+ "\n");
            }
        }

        writer.close();
        writer2.close();
    }
    

}

