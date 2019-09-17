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
			//When height is a negative 
			assertEquals (2,r3.getX());
			assertEquals (3,r3.getY());
			assertEquals (-5,r3.getHeight());
			assertEquals (4,r3.getWidth());
			fail("This should not reach this point");
		}catch (IllegalArgumentException e) {
		}
		
		Rectangle r4 = new Rectangle(-2,3,4,5);
		
		//When x is negative
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
		Rectangle r = new Rectangle (0,0,4,4);
		Rectangle r2 = new Rectangle (2,2,4,4);
		
		Rectangle r3 = r.union(r2);
		assertEquals (0,r3.getX());
		assertEquals (0,r3.getY());
		assertEquals (6,r3.getHeight());
		assertEquals (6,r3.getWidth());
		
		//Rectnagle r4 = new Rectangle (0,)
	}

	public void testIntersection() {
		Rectangle r = new Rectangle(2,3,4,5);
		Rectangle r2 = new Rectangle (4,5,6,7);
		//Rectangle r3 = new Rectangle (4,5,2,3);
		
		//should work
		Rectangle r3 = r.intersection(r2);
		assertEquals (4, r3.getX());
		assertEquals (5, r3.getY());
		assertEquals (3, r3.getHeight());
		assertEquals (2, r3.getWidth());
		
		Rectangle r6 = new Rectangle (-4,5,6,7);
		
		//just intersects
		r3 = r.intersection(r6);
		assertEquals (2, r3.getX());
		assertEquals (5, r3.getY());
		assertEquals (3, r3.getHeight());
		assertEquals (0, r3.getWidth());
		
		Rectangle r7 = new Rectangle (-10,-5,2,5);
		
		//when it does not intersect
		assertEquals (null,r.intersection(r7));
		
		//when one of the widths or lengths for the rectangle is negative
		try {
			Rectangle r4 = new Rectangle (4,5,6,-7);
			
			r3 = r.intersection(r4);
			assertEquals (4, r3.getX());
			assertEquals (5, r3.getY());
			assertEquals (3, r3.getHeight());
			assertEquals (2, r3.getWidth());
			fail ("This should not reach this point");
		}catch (IllegalArgumentException e) {
			
		}
		
		try {
			Rectangle r5 = new Rectangle (4,5,-6,7);
			
			r3 = r.intersection(r5);
			assertEquals (4, r3.getX());
			assertEquals (5, r3.getY());
			assertEquals (3, r3.getHeight());
			assertEquals (2, r3.getWidth());
			fail ("This should not reach this point");
		}catch (IllegalArgumentException e) {
			
		}
		
	}

}
