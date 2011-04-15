package pfi3.assignment3.mole;
import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;

public class Mole implements Drawable {
private float _posX;
private float _posY;
private int alpha;
private Paint _p;
private float _radius = 25;
private boolean alive = false;
private Random randGen = new Random();

public Mole (float posX,float posY) {
_posX = posX;
_posY = posY;
alpha = 255;
_p = new Paint();
_p. setARGB (255, 205,170,255);
alive = false;
}

public void update() {
Random randGen = new Random();
if (randGen.nextInt(100)>98){
alpha = 255;
alive =true;

}
}
public void draw (Canvas c){
if (alpha <=0) {
alive=false;
alpha =255;
}
if	(alive){ 
c.drawCircle(_posX,_posY,_radius, _p);
}
}

public boolean pressed (MotionEvent m){
Log.i("mole","Pressed");
boolean hit = false;
float dx = (_posX - m.getX());
float dy = (_posY- m.getY());
float dist = (float) Math.sqrt(dx * dx+dy * dy);


if (dist <_radius) {
alive = false;
alpha = 255;
hit = true;
}
return hit;

}

}