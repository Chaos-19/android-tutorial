package com.chaos.BroadcastSender;
import android.content.*;
import android.widget.*;

public class BroadcastReceiver2 extends BroadcastReceiver
{

  @Override
  public void onReceive(Context p1, Intent p2)
  {
	Toast.makeText(p1,"EBR2 triggered ",Toast.LENGTH_SHORT).show();
	
  }
  
}
