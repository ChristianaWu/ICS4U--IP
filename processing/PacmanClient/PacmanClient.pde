
Pacman p;
Ghost Blinky;

void setup() {
  
  size( 400, 400 );
  frameRate( 4 );
  
  p = new Pacman();
  Blinky = new Ghost();
  
  
}

void draw() {
  
  clear();
  
  p.draw();
  

 // p.moveDown();
  
}

 void keyPressed() {
    if (key == RIGHT) {
       p.moveRight();
    }
  }
