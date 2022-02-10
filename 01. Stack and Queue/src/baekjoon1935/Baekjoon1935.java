package baekjoon1935;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

class Baekjoon1935 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); //피연산자 몇 개 있는지 입력받기
    
    String s = br.readLine(); //수식 입력 받기
    char[] myChars = s.toCharArray(); //문자로 나눠주는 배열 생성

    double [] num = new double[n+1]; //A, B, C...에 맞는 숫자를 저장할 배열
    for( int i=0 ; i<n ; i++ ){
      num[i] = Integer.parseInt(br.readLine());
    }
    
    int j =0;
    Stack<Double> st = new Stack<Double>(); //계산을 처리할 스텍 생성
    for (int i=0; i<myChars.length; i++){ //문자열의 문자를 하나하나 스텍에 집어넣음

      if(myChars[i]=='*' || myChars[i]=='+'||myChars[i]=='/'||myChars[i]=='-'){ //이때 만약 집어넣어야 할게 연산자라면
        double b = st.pop(); //숫자 하나 스택에서 꺼내기
        double a = st.pop(); //숫자 하나 스택에서 꺼내기
        switch(myChars[i]){
          case '*':
            st.push(a*b);
            break;

          case '/':
            st.push(a/b);
            break;

          case '+':
            st.push(a+b);
            break;

          case '-':
            st.push(a-b);
            break;
        }
      }
      else{ //만약 피연산자라면
        int code = (int)myChars[i]; //문자 A, B, C...를 아스키코드로 변경
        st.push(num[code-65]); //-65를 하면 A는 0으로, B는 1로, ... 와 같이 바뀜. 
            
      }
    }
    System.out.printf("%.2f", st.pop());
  }
}
