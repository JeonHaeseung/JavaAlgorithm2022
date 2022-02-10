package baekjoon2841;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon2841 {
  public static void main(String[] args) throws Exception {
    int n, p; 
    int answer=0;
    Scanner in = new Scanner(System.in); //Scanner 객체 생성
    n=in.nextInt(); //정수 하나 받아옴
    p=in.nextInt(); //다음 정수 하나 받아옴
    
	Stack<Integer>[] stack = new Stack[7]; //Stack의 배열을 만듬. 6줄이기 때문에 7개를 만들어 Stack[1]부터 Stack[6]까지 사용하고자 함.

	for(int i=1; i<=6; i++)
	{
		stack[i]=new Stack<Integer>(); //만든 배열의 객체를 생성해야 한다.
		stack[i].push(0); //데이터를 0으로 초기화한다.
	}
      
    int num, fret;
    
    for( int i=0 ; i<n ; i++ ){

      num=in.nextInt(); 
      fret=in.nextInt();
      
      while(true) { //무한루프
    	  if(stack[num].isEmpty()) { //만약 스텍이 비어있으면
    		  stack[num].push(fret); //프렛을 넣는다
    		  answer++; //손가락을 한 번 눌렀으므로 answer를 하나 증가
    		  break; //루프탈출
    	  }
    	  else { //만약 스텍이 안 비어있고
    		  if(fret<stack[num].peek()){ //스텍의 맨 위의 숫자가 프렛보다 크다면
    	          stack[num].pop();  //스텍에서 꺼내야(손가락을 때야) 함.
    	          answer++; //손가락을 한 번 땠으므로 answer를 하나 증가
    	        }
    		  else if(fret>stack[num].peek()){ //스텍의 맨 위의 숫자가 프렛보다 작다면
    	          stack[num].push(fret); //스텍에 집어넣어야 (손가락을 눌러야) 함.
    	          answer++; //손가락을 한 번 눌렀으므로 answer를 하나 증가
    	        }
    		  else { //만약 스텍의 맨 위 숫자가 프렛과 똑같다면
    			  break; //손가락을 추가로 누르거나 땔 필요가 없음. 루프 탈출
    		  }
    	  }
       }
     }
    
    in.close(); //스캐너 닫음
    System.out.println(answer); //프린트
  }
}