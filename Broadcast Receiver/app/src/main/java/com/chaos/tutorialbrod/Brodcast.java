package com.chaos.tutorialbrod;
import android.content.*;
import android.widget.*;
import android.net.*;

public class Brodcast extends BroadcastReceiver
{

  @Override
  public void onReceive(Context p1, Intent p2)
  {
	if(ConnectivityManager.CONNECTIVITY_ACTION.equals(p2.getAction())){
	   boolean onConnectivity = p2.getBooleanExtra(
	   ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
	   );if(onConnectivity){
		 Toast.makeText(p1,"Disconnected",Toast.LENGTH_SHORT).show();
	   }else{
		 Toast.makeText(p1,"Connected",Toast.LENGTH_SHORT).show();
	   }
	 }
  }
  
}

