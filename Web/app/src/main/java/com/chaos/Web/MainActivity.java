package com.chaos.Web;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.*;
import android.webkit.*;

public class MainActivity extends AppCompatActivity 
{
    private Toolbar toolbar;
	WebView web;
	String content="Comp.html";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.mainToolbar);

        setSupportActionBar(toolbar);
        
		web = findViewById(R.id.simpleWebView);
		//web.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
		//web.loadUrl("file:///android_assets/Comp.html");
		
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
