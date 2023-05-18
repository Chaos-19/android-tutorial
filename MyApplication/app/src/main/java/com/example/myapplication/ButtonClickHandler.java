package com.example.myapplication;

import android.icu.text.DecimalFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.InputHandler;

public class ButtonClickHandler implements View.OnClickListener {

    EditText input;
    TextView tv,autosize;
    StringBuilder inputVal;
    String result;
    
    
    ButtonClickHandler(EditText in,TextView display ,TextView autoSize){
         input =in;
         tv =display;
        autosize=autoSize;
        inputVal = new StringBuilder("");
        result="";
    }
    @Override
    public void onClick(View p1) {
        
        switch (p1.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_minus:
            case R.id.btn_plus:
            case R.id.btn_divid:
            case R.id.btn_multip:
            case R.id.btn_dot:
            case R.id.btn_persent:
        String digit = (String) ((Button) p1).getText();
        checkInput(digit);
            input.setText(inputVal.toString());
        break;
      case R.id.Btnclear:
        inputVal = new StringBuilder("");
        tv.setText("");
          input.setText(inputVal.toString());
        break;
      case R.id.btn_parath:
        setParenthesis();
           input.setText(inputVal.toString());
        break;
      case R.id.delet:
        if (inputVal.length() > 1) {
          inputVal.deleteCharAt(inputVal.length() - 1);
        } else {
          inputVal.deleteCharAt(0);
        }
        input.setText(inputVal.toString());
        break;
      case R.id.btn_equal:
        //   input.setText(result);
       
           inputVal = new StringBuilder("");
            tv.setText("");
               inputVal.append(result);
           // Toast.makeText(getApplicationContext()," Alert ",Toast.LENGTH_SHO
       break;
    }
        
     input.setText(inputVal.toString());
    input.setSelection(input.getText().length());
  
  }

  public void checkInput(String digit){
try{
    if (input.getText().toString().equals("")) {
      if (InputHandler.isDigit(digit)) {
         if(digit.equals("0")){
         inputVal.append("0.");
          }else
       inputVal.append(digit);
      }
    } else if (isOprator(inputVal.charAt(inputVal.length() - 1)) && isOprator(digit.charAt(0))) {
      inputVal.replace(inputVal.length()-1,inputVal.length(),digit);
    } else if (isOprator(inputVal.charAt(inputVal.length()-1)) && digit.equals("%") || InputHandler.openParenthesis(inputVal.charAt(inputVal.length()-1)) && digit.equals("%")) {
      System.out.println(digit);
    }else if (inputVal.charAt(inputVal.length() - 1)==')' && InputHandler.isDigit(String.valueOf(digit.charAt(0)))) {
        inputVal.append("×"+digit);
    }
      else {
      inputVal.append(digit);
    }

    input.setText(inputVal.toString());
        if(input.getText().length()>=2 && !isOprator(digit.charAt(0))){
            DecimalFormat df = new DecimalFormat("#,###.##");
             result =String.valueOf(Calculator.solve(input.getText().toString()));
            tv.setText(result);
         /*   System.out.println(result);
            System.out.println(Calculator.solve(input.getText().toString()));*/
        }else{ 
            tv.setText("");
        }
            
            }catch(Exception e){e.printStackTrace();}
  }

  public void setParenthesis() {
    if (inputVal.toString().equals("")) {
      inputVal.append("(");
    } else if (inputVal.length() >= 1) {
      if (!InputHandler.isBalanced(input.getText().toString())
          && !isOprator(inputVal.charAt(inputVal.length() - 1))
          && !InputHandler.openParenthesis(input.getText().toString().charAt(input.length() - 1))) {
        inputVal.append(")");
      } else if (InputHandler.isBalanced(input.getText().toString())
          && !isOprator(inputVal.charAt(inputVal.length() - 1))) {
        inputVal.append("×(");
      } else inputVal.append("(");
    }
  }

  public static boolean isOprator(char in) {
    return in == '+' || in == '-' || in == '*' || in == '/' || in == '×' || in == '÷' || in == '.'
        || in == '$';
  }
    
    
    public StringBuilder delete(){
        if(inputVal.length()<=0){
            return null;
        }
     return  inputVal.deleteCharAt(input.length()-1);
        
  }
}
