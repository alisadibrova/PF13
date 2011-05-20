package org.assignment2.sms;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class smsapp extends Activity implements EssemmessListener{
	Essemmess sms;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        sms = EssemmessHelper.getServer(this);
		sms.addEssemmessEventListener(this);
       
        
        final EditText tag;
        tag = (EditText) findViewById(R.id.editTextTag);
        
        final EditText message;
        message = (EditText)findViewById(R.id.editTextMessage);
        
        
        
        
        Button btn;
        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(smsapp.this, tag.getText().toString(), 100).show();
				Toast.makeText(smsapp.this, message.getText().toString(), 100).show();
				
				sms.post(tag.getText().toString(),message.getText().toString() );
				
				
				Intent changeview = new Intent(smsapp.this,read_view.class);
				startActivity(changeview);
		        	
			}
		});
        

    }
	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub
		
	}
}