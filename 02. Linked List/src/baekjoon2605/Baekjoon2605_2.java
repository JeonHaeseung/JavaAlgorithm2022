package baekjoon2605;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon2605_2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    int[] change = new int[n+1]; //������ �̵��ϴ� ���� ���� �迭 ����

    for( int i=1 ; i<=n ; i++ ){
      change[i] = in.nextInt();
    }

    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(1); //�� ó�� �л��� ������ �߰��ϱ�

    for( int i=2 ; i<=n ; i++ ) {
      if(change[i]==0){ //���� �̵��� ���� �л��̶�� ����Ʈ�� �� �������� �״�� �߰��ϱ�
        list.add(i);
      }
      else{
        list.add(i-change[i]-1, i); //���� �̵��� �ִ� �л��̶�� �ش� ��ġ�� �߰��ϱ�
      }
    }

    for (int i = 0; i < n; i++) {
			System.out.print(list.get(i) + " "); //����Ʈ�ϱ�
		}
  }
}