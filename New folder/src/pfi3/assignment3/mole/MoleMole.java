package pfi3.assignment3.mole;

import android.app.Activity;
import android.os.Bundle;

public class MoleMole extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(new GameEngine( this));
	}

}
