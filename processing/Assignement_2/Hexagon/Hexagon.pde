/*
Christiana Wu 
20767703 
Jan 23 2019 
Assignemnt 2 - problem 3 
Input nothing, output 5 hexagons 
*/
int xCenter, yCenter;
void setup(){
  size(400,300);
  background(255);
  xCenter =  width/2;
  yCenter = height/2;
}

void draw(){
  for (int x = 50; x<=110; x+=15){
    drawHexgonLine (xCenter, yCenter, x , PI/3);
  }
}


void drawHexgonLine (int xCenter, int yCenter, int distance, float angle1){
  int p6x = xCenter - distance;//x-cord for point 6 
  int p3x = xCenter + distance;//x-cord for point 3
  float p54y = yCenter + (distance * sin(angle1)); // y-cord for 5 and 6
  float p12y = yCenter - (distance * sin(angle1)); // y-cord for 1 and 2
  float p5412x = xCenter + (distance * cos(angle1)); // y-cord for 1, 2, 5 and 6
  float p5412x2 = xCenter - (distance * cos(angle1)); // y-cord for 1, 2, 5 and 6
  line(p5412x,p12y, p5412x2, p12y);// top
  line(p5412x, p54y, p5412x2, p54y);// bottem
  //left
  line (p5412x2, p12y, p6x, yCenter);
  line (p5412x2, p54y, p6x, yCenter);
  //Right
  line (p5412x, p12y, p3x, yCenter);
  line (p5412x, p54y, p3x, yCenter);
}
