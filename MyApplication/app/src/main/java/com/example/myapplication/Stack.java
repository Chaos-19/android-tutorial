package com.example.myapplication;

public class Stack<T>
{
	Node top;
	static class Node<T>
	{
		T data;
		Node next;

		Node(T data)
		{
			this.data = data;
			next = null;
		}

	}

	public void push(T data)
	{
		Node node = new Node(data);
		if (top == null)
		{
			node.next = null;
		}
		else 
			node.next = top;
		top = node; 
	}

	public <T> T pop(){

		Node node = top;
		if(top==null){
		return null;	
		}
		Object data = node.data;
		top=node.next;
		return (T)data;
	}

	public <T> T peek(){

		Node node = top;
		if(top==null){
			System.exit(0);
		}
		Object data = node.data;
		return (T) data;
	}


	public boolean isEmpty(){
		return top==null;
	}
}