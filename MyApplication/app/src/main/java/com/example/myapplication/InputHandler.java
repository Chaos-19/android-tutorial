package com.example.myapplication;

import com.example.myapplication.Stack;

public class InputHandler {
    
	 public static boolean isBalanced(String input)
	 {

		  if (input.length() < 1)
		  {
			   return false;
		  }
		  char val = ' ';
		  Stack<Character> stack = new Stack<>();
		  for (int i = 0; i < input.length(); i++)
		  {
			   val = input.charAt(i);
			   if (openParenthesis(val))
			   {
					stack.push(val);
			   } 
			   else if (isDigit(String.valueOf(val)) ||  isOprator(val))
			   {
					continue;
			   }
			   else
			   {
					try
					{
		//System.out.println(stack.peek() + "  comparsion : " + val + " result  = " + balanceParenthesis(stack.peek(), val));
						 if (!stack.isEmpty() && !balanceParenthesis(stack.peek(), val))
						 {
							  return false;
						 }
						 else
						 {
							  stack.pop();
						 }
						 val = ' ';
					}
					catch (Exception e)
					{
						 return false;
					}
			   }
		  }

		  if (!stack.isEmpty())
		  {
			   return balanceParenthesis(stack.pop(), val);
		  }
		  // System.out.println("empty : " + stack.isEmpty());
		  return true;
	 }

	 public static boolean openParenthesis(char in)
	 {
		  return in == '(' |  in == '{'  | in == '[';
	 }

	 public static boolean balanceParenthesis(char open, char close)
	 {

		  return (open == '(' && close == ')') | (open == '[' && close == ']') | (open == '{' && close == '}');
	 }

	 public static boolean isDigit(String in)
	 {
		  try
		  {
			   Double.valueOf(in);
			   return true;
		  }
		  catch (NumberFormatException e)
		  {
		  }

		  return false;
	 }
	 public static boolean isOprator(char in)
	 {
		  return in == '+'  || in == '-' || in == '*' || in == '/' || in=='×' || in=='÷' || in=='.'||in=='%'||in=='$';
	 }
}
