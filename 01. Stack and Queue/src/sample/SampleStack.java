package sample;

import java.util.EmptyStackException;

/* stack Ŭ������ ����. �� Ŭ���� �ȿ��� node Ŭ������ pop, push, peek, isEmpty �޼ҵ尡 �ִ�. */
class Stack<T>{ 

  class Node<T>{    //node Ŭ������ ����. stack�ȿ� ��尡 ���δٰ� �����ϸ� �ȴ�.
    private T data; //Node�ȿ� ������� ������
    private Node<T> next; //���� ��带 ����Ű�� �κ�.

    public Node(T data){  //�޼ҵ�� Node�� data�� ������ ���� ������ �����Ѵ�.
      this.data = data;   //���� ������ ����
    }
  }

  private Node<T> top; //top�̶�� Node ��ü�� �ϳ� �����Ѵ�.

  /* stack���� data�� ������ */
  public T pop(){
    /* stack�� �ƹ��͵� ���� ���(=top�� null�� ���) */
    if(top ==null){
      throw new EmptyStackException(); //throw�� �ڹ��� ���ܴ�������. �츮�� import�� "java.util.EmptyStackException"���� �� ���ܸ� �޾� ó����.
    }

    /* stack�� data�� ���� ���(=top�� null�� �ƴ� ���)) */
    T item = top.data;  //top ����� data�� item�� �Ѱ��ش�.
    top = top.next;     //top ��尡 ����Ű�� �־��� ��带 ���ο� top���� ����� ��.
    return item;        //item�� ��ȯ��.
  }

  /* stack���� data�� �ִ´� */
  public void push(T item){
    Node<T> t = new Node<T>(item);  //item�� data ������ ������ ���ο� ��� t ����
    t.next = top;                   //������ top�� ���� ���ÿ� ���� t ��尡 ����Ű�� ����
    top = t;                        // t ��带 ���ο� top���� ����
  }

  /* stack�� top�� �ִ� data�� �������� Ȯ���Ѵ� */
  public T peek(){
    /* stack�� �ƹ��͵� ���� ���(=top�� null�� ���) */
    if(top == null){
      throw new EmptyStackException(); //EmptyStackException ����ó��
    }

    /* stack�� data�� ���� ���(=top�� null�� �ƴ� ���)) */
    return top.data; //top�� �ִ� data ��ȯ
  }
 
  /* stack�� ����ִ��� Ȯ���Ѵ� */
  public boolean isEmpty(){
    return top == null; //������ ��������� true, ������ ä���� ������ false�� ��ȯ
  }
}

/*�ڹٿ��� public static void main(String[] args)�� �ִ� class�� �̸��� ������ ���ϸ�� ���ƾ� �Ѵ�. 
���󿡼��� Test.java �����̿��� class���� Test��� ��������, ������ ���ϸ��� SampleStack.java��� SampleStack���� ���ľ� ��.*/
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
