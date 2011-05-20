package org.assignment2.sms;

import java.util.ArrayList;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import se.k3.goransson.andreas.essemmesslib.Post;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class read_view extends Activity implements EssemmessListener,OnClickListener  {

private ListView listview;
private ArrayList<String> data;
Essemmess sms;
ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read_veiw);
	
		sms = EssemmessHelper.getServer(this);
		sms.addEssemmessEventListener(this);

		Button btn;
        btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(this);
        listview = (ListView) findViewById(R.id.listView1);
		data = new ArrayList<String>();
		
        //String [] messages = new String []{"qw","we","ret"};
		//ArrayAdapter<String> adapter = new 
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
		
        listview.setAdapter(adapter);

    }
		
	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		 Log.i ("k3","newpost",null);
		ArrayList<Post> posts = evt.getPosts();
		for (Post p: posts) {
		    String s = p.message;
		    Log.i ("k3",s);
		    data.add(p.message+" "+p.tag);
		}
		
		adapter.notifyDataSetChanged();
	}


	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
        
        //data.add("");
        //data.add("sdf");
        
        sms.read("");
		
	}
	

}
