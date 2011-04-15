package pfi3.assignment3.mole;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Drawable{
void update();
void draw(Canvas c);
boolean pressed (MotionEvent m);

}
