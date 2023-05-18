package com.chaos.tutorial;

import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import androidx.appcompat.app.*;
import androidx.appcompat.widget.*;
import androidx.core.app.*;
import androidx.core.view.*;
import android.transition.*;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity 
{
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       toolbar = findViewById(R.id.mainToolbar);

       setSupportActionBar(toolbar);
	   
	   setTitle("Activity_1");
	   /*Fade fade = new Fade();
	   View decor = getWindow().getDecorView();
	   fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
	   fade.excludeTarget(android.R.id.statusBarBackground,true);
	   fade.excludeTarget(android.R.id.navigationBarBackground,true);
	   
	   getWindow().setEnterTransition(fade);
	   getWindow().setExitTransition(fade);*/
	 final ImageView  ImageView = findViewById(R.id.activity_mainImageView);
	  Button btn = findViewById(R.id.activity_mainButton);
	   
	  btn.setOnClickListener(new OnClickListener(){

		  @Override
		  public void onClick(View p1)
		  {
			Intent inten = new Intent(MainActivity.this,Second_Activity.class);
ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,ImageView,ViewCompat.getTransitionName(ImageView));
		  startActivity(inten,options.toBundle());
}
		});
	  
        /*

To use AIDEUtils, create an instance of it in your activity and then you can use the functions defined in that class

for example, to create a simple toast using AIDEUtils, do this :

AIDEUtils utils = new AIDEUtils(getApplicationContext());
utils.toast("Simple Short Toast");

OR, you can use the following way :

private AIDEUtils utils;

*In onCreate*

utils = new AIDEUtils(getApplicationContext());
utils.toast("Simple Short Toast");

*/
        
    }
}
