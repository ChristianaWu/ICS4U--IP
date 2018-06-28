

//void setup() {
// size(500,500);
// noStroke();
// fill(0,45);
//}
int value = (int)(Math.random()*255), value2 = (int)(Math.random()*255), value3 = (int)(Math.random()*255);
void setup(){
  size (1200, 600);
  background (0,0,0);
  noFill();
  
}
void fracterCircle(int x, int y, int radius){
  stroke(value, value2, value3);
  ellipse(x, y, radius, radius);;
  
  //Farcture 
  //Method that calls its self 
<<<<<<< HEAD
  if (radius/3 >2){
    fracterCircle(x-radius/2, y, radius/3);
    fracterCircle(x+radius/2, y, radius/3);
    fracterCircle(x, y+radius/4, radius/2);
    fracterCircle(x, y-radius/4, radius/2);
=======
  if (radius/3 > 5){
    fracterCircle(x-radius/2, y, radius/2);
    fracterCircle(x+radius/2, y, radius/2);
    fracterCircle(x, y+radius/4, radius/3);
    fracterCircle(x, y-radius/4, radius/3);
>>>>>>> 9338cfdb086b2ff4b49ffed426ed4aaa7f683170
  }
 
}
void draw() {
<<<<<<< HEAD
  fracterCircle(width/2, height/2, 800);
=======
  fracterCircle(width/2, height/2, 600);
>>>>>>> 9338cfdb086b2ff4b49ffed426ed4aaa7f683170
}

void mouseMoved() {
  value = value + 5;
  if (value > 255) {
    value = 0;
  }

}
