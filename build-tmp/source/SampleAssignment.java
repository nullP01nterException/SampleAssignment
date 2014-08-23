import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import ddf.minim.analysis.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SampleAssignment extends PApplet {




Minim minim;
AudioPlayer song;
PImage cursorpic;
PImage cursorpic2;
PImage currentcursor;

int red = 255;
int green = 0;
int blue = 255;

double rrand;
double grand;
double brand;

boolean grow = false;
Circle round = new Circle();
int cirx = 0;
int ciry = 0;
int age = 0;

public void setup()
{
  minim = new Minim(this);
  song = minim.loadFile("Ageage Again.mp3");
  song.loop();
  cursorpic = loadImage("imageedit_3_8454391464.gif");
  cursorpic2 = loadImage("imageedit_4_7227815009.gif");
  size(500,500);
  background(0);
}
public void draw()
{
  if(mousePressed == true){
    currentcursor = cursorpic2;
  }else{
    currentcursor = cursorpic;
  }
  cursor(currentcursor,0,0);
  rrand = Math.random();
grand = Math.random();
brand = Math.random();
  if(rrand < 0.5f || red < 10){
    red+=10;
  }else{
    red-=10;
  }
  if(grand < 0.5f || green < 10){
    green+=10;
  }else{
    green-=10;
  }
  if(brand < 0.5f || blue < 10){
    blue+=10;
  }else{
    blue-=10;
  }
  fill(0);
  noStroke();
  rect(0,0,500,500);
  noFill();
  stroke(red,green,blue);
  pushMatrix();
  translate(250,150);
  rotate(random(2*PI));
  ellipse(0,0,250,random(250));
  ellipse(0,0,250,random(250));
  popMatrix();
   for (int x = 0; x < song.bufferSize(); x+=10)
  {
    float amplitude = song.right.get(x);
    int height = PApplet.parseInt(50 * -amplitude);
     fill(0);
     stroke(blue, green, red);
    rect(x, 400, 10, height);
  }
  if (grow == true) {
     round.grow();
    round.show();
    age+=5;
  }
  if(grow == false){
  age = 0;
    cirx = cirx;
    ciry = ciry;
    round.reset();
  }
  if(age > 150){
    grow = false;
  }
  if(grow == true && mousePressed == true){
    round.reset();
  }
}

public void mousePressed(){
 if (mousePressed==true) {
    grow = true;
     cirx = mouseX;
    ciry = mouseY;
  }
}

public void stop()
{
  song.close();
  minim.stop();
  super.stop();
}

public class Circle {
  int growx;
  int growy;
  int age;
  int strokeCol;

  public Circle() {
    growx = 0;
    growy = 0;
    strokeCol = 255;
  }
  public void grow() {
    growx++;
    growy++;
    strokeCol-=2;
  }
  public void reset(){
    growx = 0;
    growy = 0;
    strokeCol = 255;
  }
  public void show() {
    noFill();
    stroke(strokeCol);
    ellipse(cirx, ciry, growx, growy);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SampleAssignment" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
