package com.chaos.tutorialbrod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.*;
import android.content.*;
import android.net.*;

public class MainActivity extends AppCompatActivity 
{
    private Toolbar toolbar;
	Brodcast brodCast = new Brodcast();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       toolbar = (Toolbar) findViewById(R.id.mainToolbar);
	   
        setSupportActionBar(toolbar);
        
        
        
    }

	@Override
	protected void onStart()
	{
	  // TODO: Implement this method
	  super.onStart();
	  IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
	  registerReceiver(brodCast,filter);
	}

	@Override
	protected void onStop()
	{
	  // TODO: Implement this method
	  super.onStop();
	  unregisterReceiver(brodCast);
	}
	

}
