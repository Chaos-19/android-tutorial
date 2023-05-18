package com.chaos.tutorial;
import androidx.appcompat.app.*;
import android.os.*;
import android.transition.*;
import android.view.*;

public class Second_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
		 setTitle("Activity_2");
	 /*Fade fade = new Fade();
	  View decor = getWindow().getDecorView();
	  fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
	  fade.excludeTarget(android.R.id.statusBarBackground,true);
	  fade.excludeTarget(android.R.id.navigationBarBackground,true);

	  getWindow().setEnterTransition(fade);
	  getWindow().setExitTransition(fade);*/
		
  
}}
