package baekjoon2605;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon2605_2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    int[] change = new int[n+1]; //앞으로 이동하는 숫자 적을 배열 생성

    for( int i=1 ; i<=n ; i++ ){
      change[i] = in.nextInt();
    }

    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(1); //맨 처음 학생은 무조건 추가하기

    for( int i=2 ; i<=n ; i++ ) {
      if(change[i]==0){ //만약 이동이 없는 학생이라면 리스트의 맨 마지막에 그대로 추가하기
        list.add(i);
      }
      else{
        list.add(i-change[i]-1, i); //만약 이동이 있는 학생이라면 해당 위치에 추가하기
      }
    }

    for (int i = 0; i < n; i++) {
			System.out.print(list.get(i) + " "); //프린트하기
		}
  }
}