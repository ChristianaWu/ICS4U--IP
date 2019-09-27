/*
 * Christiana Wu
 * 20767703
 * Project 1 part a
 * Testing for the HighScoreTable class
 * No input no output
 * September 18, 2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import junit.framework.TestCase;

public class HighScoreTableTest extends TestCase {
	
	//No parameter passed
    public void testHighScoreTable() {
       HighScoreTable x = new HighScoreTable (); 
       
       assertEquals (10,x.getCapacity());
    }
    
    //Proper Parameter passed
    public void testHighScoreTableInt() {
    	HighScoreTable x = new HighScoreTable (5); 
        
        assertEquals (5,x.getCapacity());
    }
    
    //Trying to make the capacity zero
    public void testHighScoreTableIntZero() {
        HighScoreTable x = new HighScoreTable (0); 
        
        assertEquals (0,x.getCapacity());
    }
    
    //Trying to make the capacity negative
    public void testHighScoreTableNegativeCapacity() {        
        try {
        	HighScoreTable x = new HighScoreTable (-7);
        }catch (NegativeArraySizeException e) { 	
        }
    }
    
    //With the object i nthe array
    public void testSize() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	assertEquals (5,x.size());
    }
    
    //Empty array
    public void testSizeEmpty() {
    	HighScoreTable x = new HighScoreTable (7); 
    	
    	assertEquals (0,x.size());
    }
    
  //Size at Capacity
    public void testSizeACapactiy() {
    	HighScoreTable x = new HighScoreTable (2); 
    	x.add("dfsdfsd", 12455);
    	x.add("dffdfdsd", 13556);
    	
    	assertEquals (2,x.size());
    }
    
    //Int parameter
    public void testGetCapacity() {
    	HighScoreTable x = new HighScoreTable (7); 

        assertEquals (7,x.getCapacity());
    }
    
    //Negative parameter
    public void testGetCapacityNegative() {
    	try {
    		HighScoreTable x = new HighScoreTable (-7);
    		assertEquals (7,x.getCapacity());
    		fail("Should not reach here");
    	}catch (NegativeArraySizeException e) { 
    	}
    }
    
    //Add in the right order
    public void testAdd() {
    	HighScoreTable x2 = new HighScoreTable();
    	x2.add("Christiana", 1240);
        x2.add("Paloma", 1230);
        
        assertEquals (1240, x2.getScore(0));
        assertEquals ("Christiana", x2.getName(0));
        assertEquals (1230, x2.getScore(1));
        assertEquals ("Paloma", x2.getName(1));
    }
    
    //Add out of order
    public void testAddLowerScoreFrist() {
    	HighScoreTable x2 = new HighScoreTable();
    	x2.add("Christiana", 1230);
        x2.add("Paloma", 1240);
        
        assertEquals (1240, x2.getScore(0));
        assertEquals ("Paloma", x2.getName(0));
    }
    
    //Add out of bound
    public void testAddIfZeroCapcity() {
        try {
        	HighScoreTable x2 = new HighScoreTable(0);
        	x2.add("Christiana", 1240);
        	assertEquals (1240, x2.getScore(0));
        	assertEquals ("Christiana", x2.getName(0));
        	fail ("Should not reach this point");
        }catch (ArrayIndexOutOfBoundsException e) {
        }
    }
    
    //Add negative score
    public void testAddNegativeScore() {
    	try {
    		HighScoreTable x2 = new HighScoreTable();
        	x2.add("Christiana", -1240);
    		assertEquals (-1240,x2.getScore(0));
    	}catch (IndexOutOfBoundsException e) {    		
    	}
    }
    
    //Add the same score
    public void testAddSameScore() {
    	HighScoreTable x2 = new HighScoreTable();
    	x2.add("Christiana", 1240);
    	x2.add("Paloma", 2240);
    	x2.add("Sabrina", 2240);
    	
    	assertEquals(2240, x2.getScore(0));
    	assertEquals("Paloma", x2.getName(0));
    	assertEquals(2240, x2.getScore(1));
    	assertEquals("Sabrina", x2.getName(1));	
    }
    
    //Replace highest score with when the array is full
    public void testAddReplace() {
    	HighScoreTable x2 = new HighScoreTable(3);
    	x2.add("Christiana", 1240);
    	x2.add("Paloma", 2240);
    	x2.add("Sabrina", 2240);
    	x2.add("Ethan", 3340);
    	
    	assertEquals(3340, x2.getScore(0));
    	assertEquals("Ethan", x2.getName(0));
    	assertEquals(2240, x2.getScore(2));
    	assertEquals("Sabrina", x2.getName(2));
    }
    
    //Try to add a lower score on a full table 
    public void testAddToFullTable() {
    	HighScoreTable x2 = new HighScoreTable(3);
    	x2.add("Christiana", 1240);
    	x2.add("Paloma", 2240);
    	x2.add("Sabrina", 2240);
    	x2.add("Ethan", 3340);
    	x2.add("Tina", 240);
    	
    	assertEquals(2240, x2.getScore(2));
    	assertEquals("Sabrina", x2.getName(2));
    }
    
    //Get the names
    public void testGetName() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	assertEquals ("dfdfdfdfs", x.getName(0));
    	assertEquals ("dfdeeefs", x.getName(1));
    	assertEquals ("dfdddfs", x.getName(3));
    }
    
    //get name from empty array
    public void testGetNameEmpty() {
    	try {	
    		HighScoreTable x = new HighScoreTable (7);
    		assertNull (x.getName(0));
    		fail ("This should not reach this point");
    	}catch(IndexOutOfBoundsException e) {
    	}
    }
    
    //Get an array out of bounds
    public void testGetNameNegative() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	try {
    		assertEquals (null, x.getName(-5));
    	}catch (ArrayIndexOutOfBoundsException e ) {
    	}
    }
    
    //Get score
    public void testGetScore() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	assertEquals (264, x.getScore(0));
    	assertEquals (244, x.getScore(1));
    	assertEquals (224, x.getScore(3));
    }
    
    //Get a score from empty index
    public void testGetScoreEmpty() {
    	
    	try {
    		HighScoreTable x = new HighScoreTable (7); 
    		assertNull (x.getName(0));
    	}catch(IndexOutOfBoundsException e) {
    	}
    }
    
    //get score negative
    public void testGetScoreNegative() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	try {
    		assertEquals (null, x.getName(-5));
    	}catch (ArrayIndexOutOfBoundsException e ) {
    	}
    }
    
    //Test the write to the file
    public void testWrite() throws FileNotFoundException {
        File file = new File ("High Score.txt");
        HighScoreTable x = new HighScoreTable ();
        x.add("as", 234);
    	x.add("ase", 224);
    	x.add("asd", 244);
    	x.add("asdf", 264);
    	x.add("asef", 204);
   
    	x.write(file);
    }
    
    //This check the writing to see if it is right
   public void testRead() throws FileNotFoundException {
    	File file = new File ("High Score.txt");
     	HighScoreTable x2 = HighScoreTable.read(file);
     	
     	assertEquals (10, x2.getCapacity());
     	assertEquals (5,x2.size());
     	assertEquals (264, x2.getScore(0));
     	assertEquals ("asdf", x2.getName(0));
    }
    
   /* public void testReadEmpty() throws FileNotFoundException {
    	File file = new File ("High Score.txt");
     	HighScoreTable x2 = HighScoreTable.read(file);
     
     	assertEquals (0, x2.getCapacity());
     	assertEquals (0,x2.size());
     	//assertEquals (, x2.getScore(0));
     	//assertEquals ("asdf", x2.getName(0));
    }
    */
}
