import junit.framework.TestCase;

public class RectangleTest extends TestCase {

	public void testRectangle() {
		Rectangle r = new Rectangle(2,3,4,5);
		
		//When nothing is negative
		assertEquals (2,r.getX());
		assertEquals (3,r.getY());
		assertEquals (4,r.getWidth());
		assertEquals (5,r.getHeight());
		
		Rectangle r2 = new Rectangle (2,3,4,0);
		//When height is 0 
		assertEquals (2,r2.getX());
		assertEquals (3,r2.getY());
		assertEquals (4,r2.getWidth());
		assertEquals (0,r2.getHeight());
		
		try {
			Rectangle r3 = new Rectangle (2,3,-4,5);
			//When width is a negative 
			assertEquals (2,r3.getX());
			assertEquals (3,r3.getY());
			assertEquals (5,r3.getHeight());
			assertEquals (-4,r3.getWidth());
			fail("This should not reach this point");
		}catch (IllegalArgumentException e) {
		}
		
		try {
			Rectangle r3 = new Rectangle (2,3,4,-5);
			//When width is a negative 
			assertEquals (2,r3.getX());
			assertEquals (3,r3.getY());
			assertEquals (-5,r3.getHeight());
			assertEquals (4,r3.getWidth());
			fail("This should not reach this point");
		}catch (IllegalArgumentException e) {
		}
		
		Rectangle r4 = new Rectangle(-2,3,4,5);
		
		//When x is negatie
		assertEquals (-2,r4.getX());
		assertEquals (3,r4.getY());
		assertEquals (4,r4.getWidth());
		assertEquals (5,r4.getHeight());
		
	}

	public void testContains() {
		Rectangle r = new Rectangle(2,3,4,5);
		
		//When this is a corner coordinate
		assertEquals (true,r.contains(2,3));
		
		//When this is not a corner but is still in the rectangle
		assertEquals (true,r.contains(4,5));
		
		//When this point is not in the bounds of the rectangle
		assertEquals (false,r.contains(0,0));
		
		//When a point is negative
		assertEquals (false,r.contains(-1,0));

	}

	public void testUnion() {
		fail("Not yet implemented");
	}

	public void testIntersection() {
		fail("Not yet implemented");
	}

}
