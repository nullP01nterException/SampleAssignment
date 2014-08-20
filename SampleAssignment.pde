int red = 255;
int green = 0;
int blue = 255;

void setup()
{
  size(300,300);
  background(0);
}
void draw()
{
  fill(0,0,0,5);
  stroke(0,0,0,5);
  rect(0,0,300,300);
  noFill();
  stroke(red,green,blue);
  translate(150,150);
  rotate(random(2*PI));
  ellipse(0,0,250,random(250));
}

