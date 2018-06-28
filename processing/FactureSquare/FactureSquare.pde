void setup(){
  size (600, 600);
  background (255,255,255);
  rectMode (CENTER);
  
  fracterSquare(width/2, height/2, 200,200);
  
  
}

void fracterSquare(int x, int y, int w, int h){
   //Big Square 
  fill((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
  rect(x, y, w, h);
  
  //Farcture 
  //Method that calls its self 
  if (w/3 >2){
    fracterSquare(x-w/2, y-h/2, w/2, h/2);
    fracterSquare(x+w/2, y-h/2, w/2, h/2);
    fracterSquare(x+w/2, y+h/2, w/2, h/2);
    fracterSquare(x-w/2, y+h/2, w/2, h/2);
  }
  
  
}