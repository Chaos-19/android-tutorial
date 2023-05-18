package com.chaos.Custombttton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.app.*;
import android.hardware.camera2.*;
import android.content.pm.*;
import android.content.*;

public class MainActivity extends AppCompatActivity 
{
    private Toolbar toolbar;
	private CameraManager mCameraManager;
	private String mCameraId;
	boolean status ;
	int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.mainToolbar);
        
		toolbar.setTitle("Tourch Ligth");
        setSupportActionBar(toolbar);
		final Button btn = findViewById(R.id.activity_mainButton);
		Switch enable = findViewById(R.id.activity_mainSwitch);
		
	  final boolean isFlashAvailable = getApplicationContext().getPackageManager()
	                   .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
       
					   
	  mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);	   
					   
	  try
	  {
		mCameraId = mCameraManager.getCameraIdList()[0];
	  }
	  catch (CameraAccessException e)
	  {}	   

	  btn.setOnClickListener(new OnClickListener(){

		  @Override
		  public void onClick(View p1)
		  {
			if(i==0){
			  status=isFlashAvailable;
			  Toast.makeText(getApplicationContext(), "Filashed is ON", Toast.LENGTH_SHORT).show();
			  i++;
			}else if(i==1){
			status=false; 
			Toast.makeText(getApplicationContext(), "Filashed is OFF", Toast.LENGTH_SHORT).show();
			i=0;
			}
			try
			{
			  
			  mCameraManager.setTorchMode(mCameraId, status);
			}
			catch (CameraAccessException e)
			{}
		  }
		});
	  enable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

		  @Override
		  public void onCheckedChanged(CompoundButton p1, boolean p2)
		  {
			if(p2){
			  btn.setEnabled(true);
			 
			}else{
			  btn.setEnabled(false);
			 
			}
			  
		  }
		});
		
	  btn.setOnLongClickListener(new OnLongClickListener(){

		  @Override
		  public boolean onLongClick(View p1)
		  {
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("");
			builder.setMessage("You clicked it hard");
			builder.show();
			return true;
		  }
		});
         
		
		
		
    }
	
	public void butt(boolean status){
	  
	  
	}
}
