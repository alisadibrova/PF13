package pfi3.assignment3.mole;

import java.util.*;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;



public class GameEngine extends View implements Callback {
	int score = 0;

	
	private Handler myHandler;
	Paint background;
	private List<Drawable> myMoles = new ArrayList<Drawable>();

	public GameEngine(Context context) {
		super(context);
		background = new Paint();
		background.setColor(Color.MAGENTA);
		myHandler = new Handler(this);
		GameUpdateThread gT;
		gT = new GameUpdateThread(myHandler);
		gT.start();
		createMoles();
	}
	
	
@Override
public boolean onTouchEvent(MotionEvent event) {
for (Drawable d : myMoles) {
if(d.pressed(event)== true){
	score++;
	if(score>=3){
		//Toast.makeText(this.getApplicationContext(), "You won", 100).show();
		//_context = getApplicationContext();
		CharSequence text = "You won!";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(this.getContext(), text, duration);
		toast.show();
		
		
	}
//Increase player score by one!
}
}
return super.onTouchEvent(event);
}





private void createMoles() {
for (int i = 0; i < 3; i++) {
myMoles.add(new Mole(80 + (i * 80), 100));
}
for (int i = 0; i < 3; i++) {
myMoles.add(new Mole(80 + (i * 80), 180));
}
for (int i = 0; i < 3; i++) {
myMoles.add(new Mole(80 + (i * 80), 260));
}
}

@Override
protected void onDraw(Canvas canvas) {
super.onDraw(canvas);

canvas.drawPaint(background);
for (Drawable d : myMoles) {
d.draw(canvas);
}
}


private void update() {
for (Drawable d : myMoles) {
d.update();
}
this.invalidate();

}

@Override
public boolean handleMessage(Message arg0) {
// TODO Auto-generated method stub
Log.i("mole", "iHandle");

update();
return false;
}

}