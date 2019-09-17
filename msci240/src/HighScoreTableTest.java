

import junit.framework.TestCase;

public class HighScoreTableTest extends TestCase {

    public void testHighScoreTable() {
       HighScoreTable x = new HighScoreTable (); 
       
       assertEquals (10,x.getCapacity());
    }

    public void testHighScoreTableInt() {
    	HighScoreTable x = new HighScoreTable (5); 
        
        assertEquals (5,x.getCapacity());
    }
    
    public void testHighScoreTableIntZero() {
        HighScoreTable x = new HighScoreTable (0); 
        
        assertEquals (0,x.getCapacity());
    }
 
    public void testHighScoreTableNegativeCapacity() {
        HighScoreTable x = new HighScoreTable (-7); 
        
        try {
        	assertEquals (-7,x.getCapacity());
        	fail("should not reach this point");
        }catch (IllegalArgumentException e) { 	
        }
    }

    public void testSize() {
        fail("Not yet implemented");
    }

    public void testGetCapacity() {
    	HighScoreTable x = new HighScoreTable (7); 

        assertEquals (7,x.getCapacity());
    }

    public void testAdd() {
        fail("Not yet implemented");
    }

    public void testGetName() {
        fail("Not yet implemented");
    }

    public void testGetScore() {
        fail("Not yet implemented");
    }

    public void testWrite() {
        fail("Not yet implemented");
    }

    public void testPrint() {
        fail("Not yet implemented");
    }

    public void testRead() {
        fail("Not yet implemented");
    }
}
