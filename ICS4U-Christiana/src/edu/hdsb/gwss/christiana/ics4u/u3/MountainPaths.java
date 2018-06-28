/*
 * Mountain Paths - Greedy Algorithm
 * Mr. Muir
 * 2018.03.26 - v1.0
 */
package edu.hdsb.gwss.christiana.ics4u.u3;

import java.util.*;
import java.io.*;
import java.awt.*;

public class MountainPaths {

    /**
     * Mount Paths
     */
    public static void main( String[] args ) throws Exception {

        // ***********************************
        // TASK 1:  read data into a 2D Array
        // 
        System.out.println( "TASK 1: READ DATA" );
        int[][] data = read( "Colorado.844x480.dat" );


        // ***********************************
        // Construct DrawingPanel, and get its Graphics context
        //
        DrawingPanel panel = new DrawingPanel( data[0].length, data.length );
        Graphics g = panel.getGraphics();

        // ***********************************
        // TASK 2:  find HIGHEST & LOWEST elevation; for GRAY SCALE
        //
        System.out.println( "TASK 2: HIGHEST / LOWEST ELEVATION" );
        int min = findMinValue( data );
        System.out.println( "\tMin: " + min );

        int max = findMaxValue( data );
        System.out.println( "\tMax: " + max );

        // ***********************************
        // TASK 3:  Draw The Map
        //
        System.out.println( "TASK 3: DRAW MAP" );
        drawMap( g, data );

        // ***********************************
        // TASK 4A:  implement indexOfMinInCol
        //
        System.out.println( "TASK 4A: INDEX OF MIN IN COL 0" );
        int minRow = indexOfMinInCol( data, 0 );
        System.out.println( "\tRow with lowest Col 0 Value: " + minRow );

        // ***********************************
        // TASK 4B:  use minRow as starting point to draw path
        //
        System.out.println( "TASK 4B: PATH from LOWEST STARTING ELEVATION" );
        g.setColor( Color.RED );
        int totalChange = drawLowestElevPath( g, data, minRow, 0 ); //
        System.out.println( "\tLowest-Elevation-Change Path starting at row " + minRow + " gives total change of: " + totalChange );

        // ***********************************
        // TASK 5:  determine the BEST path
        //
        g.setColor( Color.RED );
        int bestRow = indexOfLowestElevPath( g, data );

        // ***********************************
        // TASK 6:  draw the best path
        //
        System.out.println( "TASK 6: DRAW BEST PATH" );
        //drawMap.drawMap(g); //use this to get rid of all red lines
        g.setColor( Color.GREEN ); //set brush to green for drawing best path
        totalChange = drawLowestElevPath( g, data, bestRow, 0 );
        System.out.println( "\tThe Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange );

    }

    /**
     * This method reads a 2D data set from the specified file. The Graphics'
     * industry standard is width by height (width x height), while programmers
     * use rows x cols / (height x width).
     *
     * @param fileName the name of the file
     * @return a 2D array (rows x cols) of the data from the file read
     */
    public static int[][] read( String fileName ) throws FileNotFoundException {
        int[][] data;
        int lineCounter=0,wordCount=0;
        String line;
        
        //String [] wordsPerLine;
        StringTokenizer elevationPoint, elevationPoint2;
        
        //File name 
        File elevation = new File( ".\\data\\mountain.paths\\"+ fileName );
        
        //Scanner 
        Scanner sc = new Scanner(elevation);
        
        //This is used to set the array
        while (sc.hasNext()){
            line = sc.nextLine();
            lineCounter++;  
            if (lineCounter == 1){
                elevationPoint = new StringTokenizer( line, "   " );
                wordCount = elevationPoint.countTokens();
            }     
        }   
        data = new int [lineCounter][wordCount];
        sc.close();
        
        //Re-open to start scanning from the beginning again
        Scanner sc2 = new Scanner(elevation);
        
        for (int row=0; row<data.length; row++){ 
            elevationPoint2 = new StringTokenizer( sc2.nextLine(), "   " );    
            for (int col=0; col<data[row].length; col++){
                data [row][col] = Integer.parseInt(elevationPoint2.nextToken());
            }
        }
        sc.close();
        
        // TODO
        return data;
    }

    /**
     * @param grid a 2D array from which you want to find the smallest value
     * @return the smallest value in the given 2D array
     */
    public static int findMinValue( int[][] grid ) {   
        int lowest = grid [0][0];
        for (int row=0; row<grid.length; row++){
            for (int col=0; col<grid[row].length; col++){
                if (grid[row][col]<lowest){
                    lowest = grid[row][col];
                }
            }
        }
        // TODO
        return lowest;

    }

    /**
     * @param grid a 2D array from which you want to find the largest value
     * @return the largest value in the given 2D array
     */
    public static int findMaxValue( int[][] grid ) {
        int highest = grid [0][0];
        for (int row=0; row<grid.length; row++){
            for (int col=0; col<grid[row].length; col++){
                if (grid[row][col]>highest){
                    highest = grid[row][col];
                }
            }
        }
        // TODO
        return highest;
    }

    /**
     * Given a 2D array of elevation data create a image of size rows x cols,
     * drawing a 1x1 rectangle for each value in the array whose color is set to
     * a a scaled gray value (0-255). Note: to scale the values in the array to
     * 0-255 you must find the min and max values in the original data first.
     *
     * @param g a Graphics context to use
     * @param grid a 2D array of the data
     */
    public static void drawMap( Graphics g, int[][] data ) {
        // Variables
        int c, incraments; //calculated grayscale value 
        int max = findMaxValue (data);
        int min = findMinValue (data);
        
        
        incraments = ((max-min)+1)/256;//Since the elevation goes to the thousands, but limited colours this splits that numers so a range of numbers will fit certain colours

        
        for (int row=0; row<data.length; row++){
            for (int col=0; col < data[row].length; col++){
                // Calculating the colour 
                c = ((data[row][col] - min)+1)/incraments;
                if( c>255){//There ate some numbers that are so big the the exceed the 255 incrament so this just makes sure that it will fit it to a colour range
                    c = 255;
                }
                g.setColor(new Color(c, c, c));
                g.fillRect(col,row,1,1);
            }
        }
  
    }

    /**
     * Scan a single column of a 2D array and return the index of the row that
     * contains the smallest value
     *
     * @param grid a 2D array
     * @col the column in the 2D array to process
     * @return the index of smallest value from grid at the given col
     */
    public static int indexOfMinInCol( int[][] grid, int col ) {
        //Variables 
        int lowest = grid[0][col];
        int rowIndex = 0;
        
        //Finding the index of the lowest elevation
        for (int row=1; row< grid.length; row++){
            if (grid[row][col]<lowest){
                lowest = grid[row][col];
                rowIndex = row;
            }
        }
        return rowIndex;
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @param row - the starting row for traversing to find the min path
     * @return total elevation of the route
     */
    public static int drawLowestElevPath( Graphics g, int[][] data, int row, int col) {
        int totalElevationChange = 0;
        int elevChangeFwd, elevChangeFwdUp, elevChangeFwdDown, lowest;

        //Base Case 
        if (col==data[row].length-1){
            return totalElevationChange;
        }   

        //Elevation change
        if (row > 0 && row < data.length-1){
            elevChangeFwd = Math.abs(data[row][col]-data[row][col+1]);
            elevChangeFwdDown = Math.abs(data[row][col]-data[row+1][col+1]);
            elevChangeFwdUp = Math.abs(data[row][col]-data[row-1][col+1]);   
        }else if (row == 0 ){
            elevChangeFwdUp = Integer.MAX_VALUE;
            elevChangeFwd = Math.abs(data[row][col]-data[row][col+1]);
            elevChangeFwdDown = Math.abs(data[row][col]-data[row+1][col+1]);
        }else if (row == data.length-1) {
            elevChangeFwdDown = Integer.MAX_VALUE;
            elevChangeFwd = Math.abs(data[row][col]-data[row][col+1]);
            elevChangeFwdUp = Math.abs(data[row][col]-data[row-1][col+1]);  
        }else {
            return totalElevationChange;
        }

        lowest = 0;
        int nCase = 0;
        if (elevChangeFwd < elevChangeFwdUp && elevChangeFwd < elevChangeFwdDown) {
            nCase = 0;
            lowest = elevChangeFwd;
        }
        if (elevChangeFwdUp < elevChangeFwd && elevChangeFwdUp < elevChangeFwdDown) {
            nCase = 1;
            lowest = elevChangeFwdUp;
        }
        if (elevChangeFwdDown < elevChangeFwd && elevChangeFwdDown < elevChangeFwdUp) {
            nCase = 2;
            lowest = elevChangeFwdDown;
        }
        if (elevChangeFwdUp == elevChangeFwdDown && elevChangeFwdDown < elevChangeFwd) {
            nCase = 1 + (int)(Math.random() * 2);
            lowest = elevChangeFwdUp;
        }
        if (elevChangeFwdUp == elevChangeFwd && elevChangeFwd < elevChangeFwdDown) {
            nCase = 0;
            lowest = elevChangeFwd;
        }
        if (elevChangeFwdDown == elevChangeFwd && elevChangeFwd < elevChangeFwdUp) {
            nCase = 0;
            lowest = elevChangeFwd;
        }
        
        switch (nCase){
            case 0:
                g.fillRect(col+1,row,1,1); 
                lowest += drawLowestElevPath (g, data, row, col+1); 
                break;
            case 1:
               g.fillRect(col+1,row-1,1,1); 
               lowest += drawLowestElevPath (g, data, row-1, col+1);
               break;
            case 2: 
               g.fillRect(col+1,row+1,1,1); 
               lowest += drawLowestElevPath (g, data, row+1, col+1);
               break;
                    
        }
        
        return lowest;
        
    }

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath( Graphics g, int[][] data ) {
        int lowestElevation = drawLowestElevPath (g, data, 0, 0);
        int evelvation, rowIndex = 0 ;
        for (int row=1; row< data.length; row++){
            evelvation = drawLowestElevPath (g, data, row, 0);
            if (lowestElevation>evelvation){
                lowestElevation = evelvation;
                rowIndex = row;
            }
        }

        return rowIndex;
    }

}
