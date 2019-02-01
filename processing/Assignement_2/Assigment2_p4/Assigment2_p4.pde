float yPos, yNSpeed, heightOfBall;
float yDir = 1;
int rad = 100;
float ySpeed = 0;
float a = 0.5;
float deltaT = 0.5;

void setup(){
  size(1000,800);
  fill(255,0,0);
  yPos = 50;
}
void draw(){

  yNSpeed =ySpeed + a * yDir ;
  heightOfBall = (yNSpeed +ySpeed)/2;
  yPos = yPos + (heightOfBall * yDir);
  
  ySpeed = yNSpeed;
   
  if (yPos > height - (rad/2)){
    yDir = -1; 
    yPos = height - (rad/2);
  }else if (yPos <= (rad/2)){
    yDir = 1; 
    yPos = (rad/2);
    ySpeed = 0;
  }
  
  background(255);
  ellipse(500,yPos,rad, rad);
}
