
public class Pacman {
 
  // CONSTANCE
  
  // INSTANCE VARIABLES
  private int xLoc;
  private int yLoc;
  private int lives;
  
  public Pacman (){
  }
  
  public int getxLoc() {
      return xLoc;
  }
  public int getyLoc() {
      return yLoc;
  }
  public int getLives() {
      return lives;
  }
  
  
  public void draw() {
    
     rect( xLoc, yLoc, 25, 25 ); 
    
  }
  
  //private final int moveRight = 0; 
  //private final int moveLeft = 1; 
  //private final int moveUp = 2;
  //private final int moveDown = 3;
  
  
  //public void moving (int direction) {
  //  switch (direction){
  //     case moveRight :
  //       if (this.xLoc < width-25){
  //         this.xLoc = this.xLoc + 10; 
  //       }
  //       break; 
  //     case moveLeft:
  //       if (this.xLoc < 0){
  //         this.xLoc = this.xLoc - 10; 
  //       }
  //       break;
  //     case moveUp:
  //       if (this.yLoc < 0){
  //         this.yLoc = this.yLoc - 10; 
  //       }
  //       break;
  //     case moveDown:
  //       if (this.yLoc < height-25){
  //         this.yLoc = this.yLoc + 10; 
  //       }
  //       break;
         
      
  //  }
  //}
  
  public void moveRight (){
    if (this.xLoc < width-25){
           this.xLoc = this.xLoc + 10; 
    }
  }
}
