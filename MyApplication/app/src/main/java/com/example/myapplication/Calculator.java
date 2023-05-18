package com.example.myapplication;

import android.icu.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  public static int infinxSize = -1;
  public boolean isDigit(String in) {
    try {
      Double.valueOf(in);
      return true;
    } catch (NumberFormatException e) {
    }

    return false;
  }

  public int precedence(String opra) {
    char n = opra.charAt(0);
    if (n == '+' || n == '-') return 1;
    else if (n == '×' || n == '÷') return 2;
    else if (n == '^') return 3;
    else if (n == '$') return 4;
    else if (n == '%') return 4;
    return -1;
  }

  public String[] infinixToPostfixConverter(String infinxExpression) {

    if (infinxExpression == null) return new String[] {""};

    Stack<String> stack = new Stack<String>();
    Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\%\\$\\^\\+\\-\\×/\\(÷)]))");
    String postfixExpression[] = new String[infinxExpression.length()];
    Matcher m = pattern.matcher(infinxExpression);
    while (m.find()) {
      String n = m.group();
      if (isDigit(n)) {
        postfixExpression[++infinxSize] = n;
      } else if ("(".equals(n)) {
        stack.push(n);
      } else if (")".equals(n)) {
        while (!stack.isEmpty() && !"(".equals(stack.peek())) {
          postfixExpression[++infinxSize] = stack.peek();
          stack.pop();
        }
        stack.pop();
      } else {
        if (!stack.isEmpty()) {
          while (!stack.isEmpty() && precedence(n) <= precedence((String) stack.peek())) {
            postfixExpression[++infinxSize] = stack.peek();
            stack.pop();
          }
        }

        stack.push(n);
      }
    }

    while (!stack.isEmpty()) {
      postfixExpression[++infinxSize] = stack.peek();
      stack.pop();
    }

    return postfixExpression;
  }

  public double postfixCalculator(String postfixExpression[]) {
    if (postfixExpression.length <= 1) return 0;
    double y = 0, x = 0;
    Stack<Double> stack = new Stack<Double>();
    for (int i = 0; i <= infinxSize; i++) {

      String v = postfixExpression[i];
      System.out.println("Value    :   " + v);
      if (isDigit(v)) {
        stack.push(Double.valueOf(v));

      } else if (v.equals("$")) {
        x = (Double) stack.pop();
        stack.push(-x);
      } else if (v.equals("%")) {
        x = (Double) stack.pop();
        stack.push(x / 100);
      } else if (v.equals("(")) {
        continue;
      } else {
        if (!stack.isEmpty()) x = (Double) stack.pop();
        if (!stack.isEmpty()) y = (Double) stack.pop();
        switch (v) {
          case "+":
            stack.push(y + x);
            break;
          case "-":
            stack.push(y - x);
            break;
          case "×":
            stack.push(y * x);
            break;
          case "÷":
            stack.push(y / x);
            break;
          case "^":
            stack.push(Math.pow(y, x));
            break;
        }
      }
    }

    infinxSize = -1;
    return (Double) stack.pop();
  }
    
   
public static double solve(String input){	Calculator cal = new Calculator();
		String post[] =cal. infinixToPostfixConverter(input);
return cal.postfixCalculator(post);	
	}
    
    
}
