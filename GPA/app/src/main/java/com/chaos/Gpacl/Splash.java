package com.chaos.Gpacl;

import android.app.*;
import android.os.*;
import androidx.appcompat.app.*;
import android.content.*;
import android.widget.*;
import android.view.animation.*;

public class Splash extends AppCompatActivity
{
  private static int SPLASH_TIME_OUT =1900;
  ImageView imageView;
  Animation animation;
  LinearLayout lay;
  
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.splash);
	imageView = findViewById(R.id.splashImageView);
	lay = findViewById(R.id.splashLinearLayout);
	  animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
	  lay.startAnimation(animation);

	new Handler().postDelayed(new Runnable(){
		@Override
		public void run(){
		  Intent homeIntent = new Intent(Splash.this,MainActivity.class);
		  startActivity(homeIntent);
		  finish();
		}
	  },SPLASH_TIME_OUT);
  }
}
