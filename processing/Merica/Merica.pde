/*
 * 'Merica
 * 2017-18.S2
 * Christiana Wu
 * March 9, 2018
 */
import java.util.Scanner;
import java.util.StringTokenizer;

final static String[] FILE_NAMES_ELECTIONS = {
  "USA1960.txt", "USA1964.txt", "USA1968.txt", "USA1972.txt", "USA1976.txt", 
  "USA1980.txt", "USA1984.txt", "USA1988.txt", "USA1992.txt", "USA1996.txt", 
  "USA2000.txt", "USA2004.txt", "USA2008.txt", "USA2012.txt", "USA2016.txt"
};

int value;
String fileName;
String[][] electionResults;

/*
 * SETUP; CALLED ONCE @ STARTUP
 */
void setup() {

  size( 1200, 600 );

  // DEFAULT MAP
  for (int i = 0; i< FILE_NAMES_ELECTIONS.length; i++){
    fileName = FILE_NAMES_ELECTIONS[i];
  }

   // ELECTION RESULTS
  electionResult();
  
}

/*
 * ELECTION RESULTS
 * - parse election file INTO electionResults[][] 2D-Array, or data structure of your choice.
 */
void electionResult( ) {
  try {
    //Variables 
    int counter = 0;
    String line;
    StringTokenizer electionScores;
    boolean hasLine = true;
    
    // ELECTION RESULT DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\" + fileName ) );
    data.nextLine();
    
    while (data.hasNextLine() ){
      data.nextLine();
      counter++;
    }
    //println( counter );
    electionResults = new String [counter][4];
    data.close();
    
    //Re-open that file to got the results for the election 
    data = new Scanner( new File( dataPath("") + "\\" + fileName ) );
    data.nextLine();
    
    for (int row=0; row<electionResults.length; row++){
       electionScores = new StringTokenizer( data.nextLine(), "," );       
       for (int col=0; col<4; col++){
         electionResults [row][col] = electionScores.nextToken();
       }
 
    }
    data.close();
    
  }
  catch (Exception e ) {
    e.printStackTrace();
  }

  drawMap();
  
}

/*
 * DRAW MAP OFF USA w/ Election Results
 */
void drawMap() {
  // MAP
  try {
    //Vairable 
    float minLong, maxLong, minLat, maxLat, longitude, lat, stretch, stretch2, R, G, B, a, b, c, total;
    int stateSize, regions; 
    StringTokenizer gainingValues, latLongValues;
    String state;
    
    // USA MAP DATA
    Scanner data = new Scanner( new File( dataPath("") + "\\USA.txt" ) );
    
    //Reading the max and min points 
    gainingValues = new StringTokenizer( data.nextLine(), " " );
    
    minLong = Float.parseFloat (gainingValues.nextToken());
    minLat = Float.parseFloat (gainingValues.nextToken());
    
    gainingValues = new StringTokenizer( data.nextLine(), " " );
     
    maxLong = Float.parseFloat (gainingValues.nextToken());
    maxLat = Float.parseFloat (gainingValues.nextToken());
    
    stretch =  Math.abs(1200/(minLong - maxLong)); 
    stretch2 = Math.abs(600/(minLat - maxLat));

    regions = Integer.parseInt (data.nextLine());
   
     
    // REGIONS
    for (int i=0; i<regions; i++){
      
      //Skipping the lines that are not needed when we are drawing the map 
      data.nextLine();
      state = data.nextLine();
      data.nextLine();
      
      // LOOK UP YOUR ELECTION RESULTS 
      for (int j= 0; j<electionResults.length; j++){
        if (state.equals (electionResults[j][0])){
          
          //Getting the numbers to do the math 
          a = Float.parseFloat( electionResults[j][1] );
          b = Float.parseFloat( electionResults[j][2] );
          c = Float.parseFloat( electionResults[j][3] );
          
          //Math for the colours
          total = a+b+c;
          R = (a/total);
          G = (c/total);
          B = (b/total);
          
          //Colour Map
          j = electionResults.length;
          fill( R*255, G*255, B*255 );
        }        
        
      }
      
      // # OF POINTS IN THE SHAPE
      stateSize = Integer.parseInt ( data.nextLine());
      beginShape();
      for(int row=0; row<stateSize; row++){
        latLongValues = new StringTokenizer( data.nextLine(), " " );
        longitude = Float.parseFloat(latLongValues.nextToken());
        lat = Float.parseFloat(latLongValues.nextToken());
        vertex ((longitude -minLong)* stretch, (maxLat - lat)* stretch2);        
      }
      endShape();
    }


    data.close();
  }
  catch (Exception e ) {
    e.printStackTrace();
  }
}

void draw() {
  
  
}
void keyPressed() {
  if ( key >= 'a' && key <= ( 'a' + FILE_NAMES_ELECTIONS.length - 1 )  ) {
    fileName = FILE_NAMES_ELECTIONS[key-'a'];
    print( fileName );
    electionResult();
  }
}
