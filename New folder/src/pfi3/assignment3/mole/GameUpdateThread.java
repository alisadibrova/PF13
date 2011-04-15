package pfi3.assignment3.mole;


import android.os.Handler;
import android.util.Log;

public class GameUpdateThread extends Thread {

Handler _handler;
private boolean running = true;

public GameUpdateThread(Handler handler) {
_handler = handler;
}

public void run() {
super.run();
while (running) {
try {

//	Log.i("mole", "Thread RUNNING");
_handler.obtainMessage(1).sendToTarget();
Thread.sleep(50);
} catch (InterruptedException e) {
Log.i("mole", e.getMessage());
}
}
}

		
	}
	
	
	

