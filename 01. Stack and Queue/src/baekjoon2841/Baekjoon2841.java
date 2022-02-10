package baekjoon2841;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon2841 {
  public static void main(String[] args) throws Exception {
    int n, p; 
    int answer=0;
    Scanner in = new Scanner(System.in); //Scanner ��ü ����
    n=in.nextInt(); //���� �ϳ� �޾ƿ�
    p=in.nextInt(); //���� ���� �ϳ� �޾ƿ�
    
	Stack<Integer>[] stack = new Stack[7]; //Stack�� �迭�� ����. 6���̱� ������ 7���� ����� Stack[1]���� Stack[6]���� ����ϰ��� ��.

	for(int i=1; i<=6; i++)
	{
		stack[i]=new Stack<Integer>(); //���� �迭�� ��ü�� �����ؾ� �Ѵ�.
		stack[i].push(0); //�����͸� 0���� �ʱ�ȭ�Ѵ�.
	}
      
    int num, fret;
    
    for( int i=0 ; i<n ; i++ ){

      num=in.nextInt(); 
      fret=in.nextInt();
      
      while(true) { //���ѷ���
    	  if(stack[num].isEmpty()) { //���� ������ ���������
    		  stack[num].push(fret); //������ �ִ´�
    		  answer++; //�հ����� �� �� �������Ƿ� answer�� �ϳ� ����
    		  break; //����Ż��
    	  }
    	  else { //���� ������ �� ����ְ�
    		  if(fret<stack[num].peek()){ //������ �� ���� ���ڰ� �������� ũ�ٸ�
    	          stack[num].pop();  //���ؿ��� ������(�հ����� ����) ��.
    	          answer++; //�հ����� �� �� �����Ƿ� answer�� �ϳ� ����
    	        }
    		  else if(fret>stack[num].peek()){ //������ �� ���� ���ڰ� �������� �۴ٸ�
    	          stack[num].push(fret); //���ؿ� ����־�� (�հ����� ������) ��.
    	          answer++; //�հ����� �� �� �������Ƿ� answer�� �ϳ� ����
    	        }
    		  else { //���� ������ �� �� ���ڰ� ������ �Ȱ��ٸ�
    			  break; //�հ����� �߰��� �����ų� �� �ʿ䰡 ����. ���� Ż��
    		  }
    	  }
       }
     }
    
    in.close(); //��ĳ�� ����
    System.out.println(answer); //����Ʈ
  }
}