package com.chaos.Gpacl;


import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import androidx.appcompat.app.*;
import androidx.appcompat.widget.*;
import java.util.*;

import android.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import org.apache.http.conn.util.*;

public class InputeHandler extends AppCompatActivity implements View.OnClickListener
{

  Toolbar bar;
  Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
  Button submit,result,clear;
  EditText edit_1;
  EditText edit_2,temp;
  String finalView,m1,k;

  ArrayList<String> grade= new ArrayList<String>();
  ArrayList<Integer> credit= new ArrayList<Integer>();

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.button_lay);


	bar=findViewById(R.id.layinclude);
    setTitle(" GPA Calculator");
	setSupportActionBar(bar);

    initalize();
	edit_1.setFocusedByDefault(true);
	edit_1.requestFocus();

	if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
	  edit_1.setShowSoftInputOnFocus(false);
	  edit_2.setShowSoftInputOnFocus(false);
	}
	submit.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View p1)
		{

		  if(edit_1.length()==0 || edit_2.length()==0){
			Alert();
		  }  
		  else{
			m1=edit_1.getText().toString();
			grade.add(m1);
			edit_1.setText("");
			k=edit_2.getText().toString();
			credit.add(Integer.valueOf(k));
			edit_2.setText("");}

		}
	  });

  }
  @Override
  public void onClick(View p1)
  {

    check();
	switch(p1.getId()){
	  case R.id.Button_0:
		input("0");
		break;
	  case R.id.buttonlayButton1:
        input("1");
		break;
	  case R.id.buttonlayButton2:
		input("2");
		break;
	  case R.id.buttonlayButton3:
        input("3");
		break;
	  case R.id.buttonlayButton4:
		input("4");
		break;
	  case R.id.buttonlayButton5:
		input("5");
		break;
	  case R.id.buttonlayButton6:
		input("6");
		break;
	  case R.id.buttonlayButton7:
		input("7");
		break;
	  case R.id.buttonlayButton8:
		input("8");
		break;
	  case R.id.buttonlayButton9:
		input("9");
		break;
	  case R.id.btnresult:
		Intent intent = new Intent(this,Result_Activity.class);
		intent.putStringArrayListExtra("grade",grade);
		intent.putIntegerArrayListExtra("credit",credit);
		startActivity(intent);
		break;
	  case R.id.btnclear:
		temp.setText("");
		break;
	  default:

	}

  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
	MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.menu_2,menu);
	return true;
  }

  public void initalize(){
	btn0 = findViewById(R.id.Button_0);
	btn1 = findViewById(R.id.buttonlayButton1);
    btn2 = findViewById(R.id.buttonlayButton2);
    btn3 = findViewById(R.id.buttonlayButton3);
	btn4 = findViewById(R.id.buttonlayButton4);
	btn5 = findViewById(R.id.buttonlayButton5);
	btn6 = findViewById(R.id.buttonlayButton6);
    btn7 = findViewById(R.id.buttonlayButton7);
    btn8 = findViewById(R.id.buttonlayButton8);
    btn9 = findViewById(R.id.buttonlayButton9);
    submit = findViewById(R.id.btnsubmit);
    result = findViewById(R.id.btnresult);
    clear = findViewById(R.id.btnclear);
	edit_1=findViewById(R.id.EditText1);
	edit_2 = findViewById(R.id.EditText2);

	btn0.setOnClickListener(this);
	btn1.setOnClickListener(this);
    btn2.setOnClickListener(this);
    btn3.setOnClickListener(this);
	btn4.setOnClickListener(this);
	btn5.setOnClickListener(this);
	btn6.setOnClickListener(this);
    btn7.setOnClickListener(this);
    btn8.setOnClickListener(this);
    btn9.setOnClickListener(this);
    submit.setOnClickListener(this);
    result.setOnClickListener(this);
    clear.setOnClickListener(this);
  }


  public void input(String t){
	finalView = temp.getText().toString();
	finalView = finalView +t;
	temp.setText(finalView);
  }

  public void check(){
	if(this.getCurrentFocus().getId() == edit_1.getId()){
	  temp =edit_1;
	}else if(this.getCurrentFocus().getId()==edit_2.getId()){
	  temp=edit_2;}
  }

  public void Alert(){
	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	builder.setTitle("Notice");
	builder.setMessage("Please Fill Both The Mark and Credit Hour");
	builder.show();
  }


}
