package baekjoon2504;

import java.util.EmptyStackException;
import java.util.Scanner;

class Stack<T>{
  class Node<T>{
    private T data;
    private Node<T> next;

    private Node(T data){
      this.data = data;
    }
  }

  private Node<T> top;
  
  public T pop(){
    if(top == null){
      throw new EmptyStackException();
    }
    T item = top.data;
    top = top.next;
    return item;
  }

  public void push(T item){
    Node<T> t = new Node<T>(item);
    t.next = top;
    top = t;
  }

  public T peek(){
    if(top == null){
      throw new EmptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty(){
    return top==null;
  }
}


public class Baekjoon2504 {
  public static void main(String[] args) {
    Stack<Character> s = new Stack<Character>();
    char ch;
    int temp=1;
    int answer=0;

    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    
    int s_len = str.length();

    for( int i=0 ; i<s_len ; i++ ){
      ch = str.charAt(i);

      if(ch=='(' || ch=='['){
        temp *= (ch=='(') ? 2 : 3 ;
        s.push(ch);
      }

      else if(ch==')'){
        if(s.isEmpty() || s.peek() != '('){
          answer=0;
          break;
        } 
        if(str.charAt(i-1) == '(') {
          answer += temp;
          temp /= 2;
          s.pop();
        }
        else {
          temp /= 2;
          s.pop();
        }

      }
      else if(ch==']'){
        if(s.isEmpty() || s.peek() != '['){
          answer=0;
          break;
        } 
        if(str.charAt(i-1) == '[') {
          answer += temp;
          temp /= 3;
          s.pop();
        }
        else {
          temp /= 3;
          s.pop();
        }
      }
    }
    if(!s.isEmpty()) answer = 0;

    System.out.println(answer);
  }
}

