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

public class login_view extends Activity implements EssemmessListener {
    Essemmess sms;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_veiw);
		sms = EssemmessHelper.getServer(this);
		sms.addEssemmessEventListener(this);
		
		 final EditText login;
	        login = (EditText) findViewById(R.id.editTextLogin);
	        
	        final EditText password;
	        password = (EditText)findViewById(R.id.EditTextPassword);
	        
		
		 Button btn;
	        btn = (Button) findViewById(R.id.buttonsubmitlogin);
	        btn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					sms.login(login.getText().toString(),password.getText().toString() );
					
					Intent changeview = new Intent(login_view.this,smsapp.class);
					startActivity(changeview);
				}}); 
				

	}
	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub
		evt.getLoggedin();
	}
	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
