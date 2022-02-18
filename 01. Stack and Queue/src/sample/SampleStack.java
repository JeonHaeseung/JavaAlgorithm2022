package sample;

import java.util.EmptyStackException;

/* stack 클래스를 선언. 이 클래스 안에는 node 클래스와 pop, push, peek, isEmpty 메소드가 있다. */
class Stack<T>{ 

  class Node<T>{    //node 클래스를 선언. stack안에 노드가 쌓인다고 생각하면 된다.
    private T data; //Node안에 들어있을 데이터
    private Node<T> next; //다음 노드를 가리키는 부분.

    public Node(T data){  //메소드명 Node는 data를 받으면 내부 변수에 저장한다.
      this.data = data;   //내부 변수에 저장
    }
  }

  private Node<T> top; //top이라는 Node 객체를 하나 생성한다.

  /* stack에서 data를 꺼낸다 */
  public T pop(){
    /* stack에 아무것도 없을 경우(=top이 null일 경우) */
    if(top ==null){
      throw new EmptyStackException(); //throw는 자바의 예외던지기임. 우리가 import한 "java.util.EmptyStackException"에서 이 예외를 받아 처리함.
    }

    /* stack에 data가 있을 경우(=top이 null이 아닐 경우)) */
    T item = top.data;  //top 노드의 data를 item에 넘겨준다.
    top = top.next;     //top 노드가 가리키고 있었던 노드를 새로운 top으로 만들어 줌.
    return item;        //item을 반환함.
  }

  /* stack에서 data를 넣는다 */
  public void push(T item){
    Node<T> t = new Node<T>(item);  //item을 data 값으로 가지는 새로운 노드 t 생성
    t.next = top;                   //기존의 top을 새로 스택에 들어가는 t 노드가 가리키게 만듬
    top = t;                        // t 노드를 새로운 top으로 만듬
  }

  /* stack의 top에 있는 data가 무엇인지 확인한다 */
  public T peek(){
    /* stack에 아무것도 없을 경우(=top이 null일 경우) */
    if(top == null){
      throw new EmptyStackException(); //EmptyStackException 예외처리
    }

    /* stack에 data가 있을 경우(=top이 null이 아닐 경우)) */
    return top.data; //top에 있는 data 반환
  }
 
  /* stack이 비어있는지 확인한다 */
  public boolean isEmpty(){
    return top == null; //스택이 비어있으면 true, 스택이 채워져 있으면 false를 반환
  }
}

/*자바에서 public static void main(String[] args)이 있는 class의 이름은 무조건 파일명과 같아야 한다. 
영상에서는 Test.java 파일이여서 class명을 Test라고 지었지만, 본인의 파일명이 SampleStack.java라면 SampleStack으로 고쳐야 함.*/
public class SampleStack { 
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.peek());
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
  }
}
