package com.chaos.Gpacl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.*;
import androidx.drawerlayout.widget.*;
import androidx.appcompat.app.*;
import android.view.*;
import java.util.zip.*;
import android.widget.*;
import androidx.annotation.*;
import com.google.android.material.navigation.*;
import android.widget.SearchView.*;
import android.content.*;
import java.net.*;
import android.net.*;
import android.graphics.*;
import androidx.core.view.*;
import android.util.DisplayMetrics;
import android.app.*;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener
{



  public DrawerLayout drawerLayout;
  private ActionBarDrawerToggle actionBarDrawerToggle;
  private Toolbar tool;
  public NavigationView navi;

  ImageView cal;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	
	
	tool = findViewById(R.id.mainToolbar);
	tool.setTitle("GPA Calcu");
	setSupportActionBar(tool);

	drawerLayout=findViewById(R.id.my_drawer_layout);
	navi=findViewById(R.id.navigation);
	actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,tool,R.string.nav_open,R.string.nav_close);
	drawerLayout.addDrawerListener(actionBarDrawerToggle);
	actionBarDrawerToggle.syncState();


	cal=findViewById(R.id.activity_mainImageView);
	navi =findViewById(R.id.navigation);
	navi.setNavigationItemSelectedListener(this);

	cal.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View p1)
		{
		Intent intent = new Intent(MainActivity.this,InputeHandler.class);
		  startActivity(intent);
		}
	  });
	


  } 

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem p1)
  {
	int id=p1.getItemId();

	switch(id){
	 case R.id.home:
		break;
	  case R.id.tele:
		Intent i = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("https://t.me/Chaos831"));
		startActivity(i);
		break;
	  case R.id.about:
		Toast.makeText(getApplicationContext(),"Opening..Setting",Toast.LENGTH_SHORT).show();
		break;
	  case R.id.feedback:
		//Toast.makeText(getApplicationContext(),"Internat Time Out..",Toast.LENGTH_SHORT);
		Intent intent = new Intent(Intent.ACTION_ALL_APPS);
		startActivity(intent);
		break;
	  default:
	}
	drawerLayout.closeDrawers();
	return true;
  }




  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
	MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.menu_2,menu); 
	return true;
  }



  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) { 

  if(item.getItemId()==R.id.setting){
	Toast.makeText(getApplicationContext(),"Opening ",Toast.LENGTH_SHORT).show();
	}else if(item.getItemId()==R.id.exit){
	  finish();
	}
	return true;

  } 

  


}
