void setup(){
  size (600, 600);
  background (255,255,255);
  int sL = width ;
  fractureTriangle (width/2,0, width);

}

void fractureTriangle(int x, int y, int sL){
  int h = (int) Math.sqrt((sL*sL)-(sL/2)*(sL/2));
  //fill((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
  
  
  triangle (
  x , y, //top, center
  x - (sL/2),h, //Bot, left
  x + (sL/2),h  //Bot, right
  );
  
  //Fracture
  if (sL>3){
    int newHeight = (int) (Math.sqrt ( (sL/2)*(sL/2) - (sL/4)*(sL/4)));
    fractureTriangle(x, y, newHeight);//Top canter
    fractureTriangle(x-(h/4), y+h/2, newHeight);//Bot, Left
    fractureTriangle(x+(h/4), y+ h/2,newHeight);//Bot, Right
  }
  
}