package org.assignment2.sms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class smsapp extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText tag;
        tag = (EditText) findViewById(R.id.editText1);
        
        final EditText message;
        message = (EditText)findViewById(R.id.editText2);
        
        
        final EditText text;
        text = (EditText)findViewById(R.id.editText3);
        
        Button btn;
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(smsapp.this, tag.getText().toString(), 100).show();
				Toast.makeText(smsapp.this, message.getText().toString(), 100).show();
				Toast.makeText(smsapp.this, text.getText().toString(), 200).show();
		        	
			}
		});
        

    }
}