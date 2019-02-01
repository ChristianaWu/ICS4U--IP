void setup(){ 
 size(500,500);
 background(0);
 translate(width/2, height/2); 
 stroke(255);
 strokeWeight(2);
 line(0,-250,0,250);
 line(-250,0,250,0);
 for (float x = -250; x <= 250; x += 0.01){
   point(x, -0.001*(x*x));
 }
}
