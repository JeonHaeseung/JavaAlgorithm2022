package baekjoon2841;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon2841_2 {
  public static void main(String[] args) throws Exception {
    int n, p; //��ε� ���ԵǾ� �ִ� ���� �� n�� ������ �� p
    int answer=0; //��
    
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in)); //BufferedReader�� ���� Ű���忡�� �Է¹���
	String s=bf.readLine(); //�Է¹��� ������ �� �� ����
	StringTokenizer st=new StringTokenizer(s); //�� ���� ������ �������� ����
	n=Integer.parseInt(st.nextToken()); //StringTokenizer�� ��ū�� �ϳ� �޾� ���������� ���� ����
	p=Integer.parseInt(st.nextToken()); //StringTokenizer�� ���� ��ū�� �ϳ� �޾� ���������� ���� ����
	
	Stack<Integer>[] stack = new Stack[7]; //Stack�� �迭�� ����. 6���̱� ������ 7���� ����� Stack[1]���� Stack[6]���� ����ϰ��� ��.
	
	for(int i=1; i<=6; i++)
	{
		stack[i]=new Stack<Integer>(); //���� �迭�� ��ü�� �����ؾ� �Ѵ�.
		stack[i].push(0); //�����͸� 0���� �ʱ�ȭ�Ѵ�.
	}
    
    for( int i=0 ; i<n ; i++ ){

    	String str=bf.readLine(); //������ �о�´�.
		st=new StringTokenizer(str); //������ �������� StringTokenizer�� ������ �������� ��ū�� ������.
		int num=Integer.parseInt(st.nextToken()); //StringTokenizer�� ��ū�� �ϳ� �޾� ���������� ���� ����
		int fret=Integer.parseInt(st.nextToken());//StringTokenizer�� ���� ��ū�� �ϳ� �޾� ���������� ���� ����
      
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

    System.out.println(answer); //����Ʈ
  }
}