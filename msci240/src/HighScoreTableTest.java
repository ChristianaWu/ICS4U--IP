

import java.io.File;
import java.io.FileNotFoundException;

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
        try {
        	HighScoreTable x = new HighScoreTable (-7);
        }catch (NegativeArraySizeException e) { 	
        }
    }
    
    public void testSize() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	assertEquals (5,x.size());
    }
    
    public void testSizeEmpty() {
    	HighScoreTable x = new HighScoreTable (7); 
    	
    	assertEquals (0,x.size());
    }

    public void testGetCapacity() {
    	HighScoreTable x = new HighScoreTable (7); 

        assertEquals (7,x.getCapacity());
    }
    
    public void testGetCapacityNegative() {
    	try {
    		HighScoreTable x = new HighScoreTable (-7);
    		assertEquals (7,x.getCapacity());
    		fail("Should not reach here");
    	}catch (NegativeArraySizeException e) { 
    	}
    }

    public void testAdd() {
    	HighScoreTable x2 = new HighScoreTable();
    	x2.add("Christiana", 1240);
        x2.add("Paloma", 1230);
        
        assertEquals (1240, x2.getScore(0));
        assertEquals ("Christiana", x2.getName(0));
        assertEquals (1230, x2.getScore(1));
        assertEquals ("Paloma", x2.getName(1));
    }
    
    public void testAddLowerScoreFrist() {
    	HighScoreTable x2 = new HighScoreTable();
    	x2.add("Christiana", 1230);
        x2.add("Paloma", 1240);
        
        assertEquals (1240, x2.getScore(0));
        assertEquals ("Paloma", x2.getName(0));
    }
    
    public void testAddIfZeroCapcity() {
    	HighScoreTable x2 = new HighScoreTable(0);
    	x2.add("Christiana", 1240);

        try {
        	assertEquals (1240, x2.getScore(0));
        	assertEquals ("Christiana", x2.getName(0));
        	fail ("Should not reach this point");
        }catch (ArrayIndexOutOfBoundsException e) {
        }
    }
    
    public void testAddNegativeScore() {
    	HighScoreTable x2 = new HighScoreTable();
    	x2.add("Christiana", -1240);
    	
    	try {
    		assertEquals (-1240,x2.getScore(0));
    	}catch (IllegalArgumentException e) {    		
    	}
    }
    
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
    
    public void testAddReplace() {
    	HighScoreTable x2 = new HighScoreTable(3);
    	x2.add("Christiana", 1240);
    	x2.add("Paloma", 2240);
    	x2.add("Sabrina", 2240);
    	x2.add("Ethan", 3340);
    	
    	assertEquals(3340, x2.getScore(0));
    	assertEquals("Ethan", x2.getName(0));
    }
    
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

    public void testGetName() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	assertEquals ("dfdfdfdfs", x.getName(0));
    	assertEquals ("dfdeeefs", x.getName(1));
    	assertEquals ("dfdddfs ", x.getName(3));
    }
    
    public void testGetNameEmpty() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	assertEquals (null, x.getName(5));
    }

    public void testGetNameOutOfBounds() {
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
    
    public void testGetScoreEmpty() {
    	HighScoreTable x = new HighScoreTable (7); 
    	x.add("dfdfs", 234);
    	x.add("dfdddfs", 224);
    	x.add("dfdeeefs", 244);
    	x.add("dfdfdfdfs", 264);
    	x.add("dfwewedfs", 204);
    	
    	assertEquals (null, x.getName(6));
    }
    
    public void testGetScoreOutOfBound() {
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

    public void testPrint() {
        fail("Not yet implemented");
    }

    public void testRead() throws FileNotFoundException {
    	File file = new File ("High Score.txt");
     	HighScoreTable x2 = HighScoreTable.read(file);
     	
     	assertEquals (10, x2.getCapacity());
     	assertEquals (5,x2.size());
     	assertEquals (264, x2.getScore(0));
     	assertEquals ("asdf", x2.getName(0));
     	
    }
}
