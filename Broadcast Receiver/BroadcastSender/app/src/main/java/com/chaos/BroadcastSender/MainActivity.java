package com.chaos.BroadcastSender;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;

public class MainActivity extends Activity 
{
  TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		 text= findViewById(R.id.mainTextView);
    }
	
  public void sendBroadcast(View v){
	Intent intent = new Intent(this,BroadcastReceiver2.class);
	sendBroadcast(intent);
  }
  
  
  
}
