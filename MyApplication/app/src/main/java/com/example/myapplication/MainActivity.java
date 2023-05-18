package com.example.myapplication;

import android.content.Context;
import android.os.*;
import android.service.autofill.OnClickAction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ButtonClickHandler;
import com.example.myapplication.MainActivity;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.itsaky.androidide.logsender.LogSender;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;

  // ImageButton btn_de;
  ButtonClickHandler btn;
  ImageButton imbtn1, imbt2, imbt3, imbt4;
  EditText input;
  TextView tv, auto;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // Remove this line if you don't want AndroidIDE to show this app's logs
    LogSender.startLogging(this);
    super.onCreate(savedInstanceState);
    // Inflate and get instance of binding
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    // set content view to binding's root
    setContentView(binding.getRoot());
    input = findViewById(R.id.input);
    tv = findViewById(R.id.tv);
    auto = findViewById(R.id.autoView);
    imbtn1 = findViewById(R.id.delet);
    btn = new ButtonClickHandler(input, tv, auto);

    ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
    setClickHandlers(rootView);

    input.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}

          @Override
          public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            auto.setText(arg0.toString());
            float size = auto.getTextSize();
            size = size / 2;
            input.setTextSize(size);
          }

          @Override
          public void afterTextChanged(Editable arg0) {}
        });

    imbtn1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View arg0) {

            /*  if (btn.delete().toString().equals(null)) {
            //
              return;
            }*/
            try {
              input.setText(btn.delete().toString());
            } catch (Exception e) {
              Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
            }
          }
        });
  }

  public void onBtn(View v) {
    Toast.makeText(this, "You Just Click the Button ", Toast.LENGTH_SHORT).show();
  }

  private void setClickHandlers(ViewGroup rootView) {
    final int childCount = rootView.getChildCount();
    for (int i = 0; i < childCount; i++) {
      View child = rootView.getChildAt(i);

      if (child instanceof ViewGroup) {
        setClickHandlers((ViewGroup) child);
      } else if (child instanceof Button) {
        child.setOnClickListener(btn);
      }
    }
  }
  /* public  void showToast(String message){
    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
  }*/
}
