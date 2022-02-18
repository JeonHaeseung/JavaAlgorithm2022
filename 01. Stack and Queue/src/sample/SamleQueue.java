package sample;

import java.util.NoSuchElementException;

/* queue Ŭ������ ����. �� Ŭ���� �ȿ��� node Ŭ������ add, remove, peek, isEmpty �޼ҵ尡 �ִ�. */
class Queue<T>{     
  class Node<T>{    //node Ŭ������ ����. Queue �ȿ� ��尡 ���δٰ� �����ϸ� �ȴ�.
    private T data; //Node �ȿ� ������� ������
    private Node<T> next;   //���� ��带 ����Ű�� �κ�.

    public Node(T data){    //�޼ҵ�� Node�� data�� ������ ���� ������ �����Ѵ�.
      this.data = data;     //���� ������ ����
    }
    
  }

  private Node<T> first;  //first��� ��ü ����
  private Node<T> last;   //last��� ��ü ����

  public void add(T item){
    /* t��� Node ��ü�� �޸𸮿� �Ҵ�(�ν��Ͻ�ȭ), item�� ���� �� ��忡 ���� */
    Node<T> t = new Node<T>(item); 
    /* ���� ť�� �ִ� ù ��尡 �ƴ϶�� */
    if(last != null){
       last.next = t;   //last�� �ڿ� t�� �̾� ���̱�
    }

    last = t;           //t�� ���ο� last�� �����
    /* ���� ť�� �ִ� ù �����(���� ť�� ���� ����ִٸ�) */
    if(first == null){
      first = last;     //first�� last�� �ּ� ���Ͻ��ϱ�
    }
  }

  public T remove(){
    /* ���� ť�� ����ִٸ� */
    if(first == null){
      throw new NoSuchElementException(); //throw�� �ڹ��� ���ܴ�������. �츮�� import�� "java.util.NoSuchElementException"���� �� ���ܸ� �޾� ó����.
    }

    T data = first.data;  //first�� ������ ���
    first = first.next;   //first�� ���� ��尡 first �ڸ� �̾����

    if(first == null){    //�̾�ް� ���� first�� null�̸� ť �ȿ� �����Ͱ� ���ٴ� ��
      last = null;        //last ���� null�� ������ش�.
    }
    return data;  //������ ��ȯ
  }

  /* queue�� first�� �ִ� data�� �������� Ȯ���Ѵ� */
  public T peek(){
    /* ���� ť�� ����ִٸ� */
    if(first == null){
      throw new NoSuchElementException(); //throw�� �ڹ��� ���ܴ�������. �츮�� import�� "java.util.NoSuchElementException"���� �� ���ܸ� �޾� ó����.
    }
    return first.data; //first�� data ��ȯ
  }
  
  /* queue�� ����ִ��� Ȯ���Ѵ� */
  public boolean isEmpty(){
    return first == null;   //ť�� ��������� true, ť�� ä���� ������ false�� ��ȯ
  }
}

/*�ڹٿ��� public static void main(String[] args)�� �ִ� class�� �̸��� ������ ���ϸ�� ���ƾ� �Ѵ�. 
���󿡼��� Test.java �����̿��� class���� Test��� ��������, ������ ���ϸ��� SamleQueue.java��� SamleQueue���� ���ľ� ��.*/
public class SamleQueue {
  public static void main(String[] args) {
    /* q��� Queue ��ü�� �޸𸮿� �Ҵ�(�ν��Ͻ�ȭ) */
    Queue<Integer> q = new Queue<Integer>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.peek());
    System.out.println(q.remove());
    System.out.println(q.isEmpty());
    System.out.println(q.remove());
    System.out.println(q.isEmpty());
  }
}