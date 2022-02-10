package baekjoon2841;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon2841_2 {
  public static void main(String[] args) throws Exception {
    int n, p; //멜로디에 포함되어 있는 음의 수 n과 프렛의 수 p
    int answer=0; //답
    
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in)); //BufferedReader를 통해 키보드에서 입력받음
	String s=bf.readLine(); //입력받은 내용을 한 줄 읽음
	StringTokenizer st=new StringTokenizer(s); //한 줄을 공백을 기준으로 나눔
	n=Integer.parseInt(st.nextToken()); //StringTokenizer의 토큰을 하나 받아 정수형으로 값을 리턴
	p=Integer.parseInt(st.nextToken()); //StringTokenizer의 다음 토큰을 하나 받아 정수형으로 값을 리턴
	
	Stack<Integer>[] stack = new Stack[7]; //Stack의 배열을 만듬. 6줄이기 때문에 7개를 만들어 Stack[1]부터 Stack[6]까지 사용하고자 함.
	
	for(int i=1; i<=6; i++)
	{
		stack[i]=new Stack<Integer>(); //만든 배열의 객체를 생성해야 한다.
		stack[i].push(0); //데이터를 0으로 초기화한다.
	}
    
    for( int i=0 ; i<n ; i++ ){

    	String str=bf.readLine(); //한줄을 읽어온다.
		st=new StringTokenizer(str); //위에서 만들어놨던 StringTokenizer가 공백을 기준으로 토큰을 나눈다.
		int num=Integer.parseInt(st.nextToken()); //StringTokenizer의 토큰을 하나 받아 정수형으로 값을 리턴
		int fret=Integer.parseInt(st.nextToken());//StringTokenizer의 다음 토큰을 하나 받아 정수형으로 값을 리턴
      
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

    System.out.println(answer); //프린트
  }
}