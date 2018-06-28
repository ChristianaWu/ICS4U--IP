
public class Ghost {
 
  // CONSTANCE
  
  // INSTANCE VARIABLES
  private int xLoc;
  private int yLoc;
  
  
  public Ghost (){
  }
  
  public int getxLoc() {
      return xLoc;
  }
  
  public int getyLoc() {
      return yLoc;
  }
  
  public void draw() {
    
     rect( xLoc, yLoc, 25, 25 ); 
    
  }
  
  public void moveRight() {
     this.xLoc = this.xLoc + 10; 
  }
  
  public void moveLeft() {
     this.xLoc = this.xLoc - 10; 
  }
  
  public void moveUp() {
     this.yLoc = this.yLoc - 10; 
  }
  
  public void moveDown() {
     this.xLoc = this.xLoc + 10; 
  }
  
}
