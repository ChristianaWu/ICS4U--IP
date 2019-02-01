void setup(){
  size(600,600);
  background(255);
}

int x = 60;
int y = 60;

void draw(){  
    rect(x,y,60,60);
    fill(0);
}

void keyPressed() {
    if (key == CODED){
      if (keyCode == RIGHT) {
        x = x+30;
      } else if (keyCode == LEFT) {
        x = x-30;
        fill (0);
      } else if (keyCode == DOWN){
        y = y+30;
      } else if (keyCode == UP){
        y = y-30;
      }
  
    }
}
