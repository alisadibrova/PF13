package pfi3.assignment3.mole;

import android.app.Activity;
import android.os.Bundle;

public class Game extends Activity {
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(new GameEngine(this));
}
}