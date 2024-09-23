float xPos;
float yPos;
float a;
int r1 = 252, g1 = 113, b1 = 5, r2 = 255, g2 = 226, b2 = 0, r3 = 0, g3 = 11, b3 = 108;
float r3Inc = 0.9133, g3Inc = 1.2933, b3Inc = 0;
int frameMod;
Boolean col = false;
float sunY;
float xIter;
float cloudX = 0;
int windowX = 230;
int houseHeight = 80;
int houseX = 230;
void setup() {
  size(500, 300);
  background(#7CC7FF);
  noStroke();
  xPos = 500;
  yPos = 300;
  sunY = 0;
  xIter = -250;
}
void showMouseCoordinates() {
  fill(0);
  text(mouseX + " , " + mouseY, mouseX, mouseY);
}

void draw() {
  print(frameCount);
  noStroke();
  background(r3, g3, b3);
  if (col == true) {
    r1 = 255;
    g1 = 255;
    b1 = 255;
    r2 = 8;
    g2 = 1;
    b2 = 116;
    r3 = 0;
    g3 = 11;
    b3 = 108;
  } else {
    r2 = 252;
    g2 = 113;
    b2 = 5;
    r1 = 255;
    g1 = 226;
    b1 = 0;
    r3 = 137;
    g3 = 205;
    b3 = 255;
  }
  //draw sun
  fill(r2, g2, b2);
  ellipse(435, sunY, 90, 90);
  fill(r1, g1, b1);
  ellipse(435, sunY, 80, 80);
  fill(#018E13);
  ellipse(250, 300, 600, 200);
  stroke(0);
  fill(#FFF2C1);
  rectMode(CENTER);
  //Draw house
  rect(houseX, 210, 80, houseHeight);
  rectMode(CORNER);
  shearY(-(PI/20));
  translate(0, 43);
  rect(270, 180, 30, 60);
  shearY((PI/20));
  translate(0, -43);
  fill(#B70018);
  triangle(270, 180, 300, 175, 284, 165);
  quad(190, 180, 206, 165, 284, 165, 270, 180);
  fill(#714400);
  rect(220, 210, 20, 30);
  rectMode(CENTER);
  fill(#6CE8FF);
  rect(windowX, 195, 60, 20);
  ellipseMode(CENTER);
  fill(0, 0, 0);
  ellipse(235, 225, 5, 5);
  fill(255, 255, 255);
  noStroke();
  //draw clouds
  ellipse(cloudX, 20, 60, 70);
  ellipse(cloudX, 38, 80, 50);
  ellipse(cloudX, 31, 80, 50);
  /*if ((frameCount % 150) == 0) {
    col = !col;
  }*/
  sunY = sq(0.1*xIter);
  if (xIter == 250) {
    xIter = -250;
    col = !col;
  }
  xIter++;
  cloudX += 0.2;
  if (cloudX == 500) {
    cloudX = 0;
  }
  showMouseCoordinates();
}
