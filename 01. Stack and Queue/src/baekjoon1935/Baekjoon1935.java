package baekjoon1935;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

class Baekjoon1935 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); //�ǿ����� �� �� �ִ��� �Է¹ޱ�
    
    String s = br.readLine(); //���� �Է� �ޱ�
    char[] myChars = s.toCharArray(); //���ڷ� �����ִ� �迭 ����

    double [] num = new double[n+1]; //A, B, C...�� �´� ���ڸ� ������ �迭
    for( int i=0 ; i<n ; i++ ){
      num[i] = Integer.parseInt(br.readLine());
    }
    
    int j =0;
    Stack<Double> st = new Stack<Double>(); //����� ó���� ���� ����
    for (int i=0; i<myChars.length; i++){ //���ڿ��� ���ڸ� �ϳ��ϳ� ���ؿ� �������

      if(myChars[i]=='*' || myChars[i]=='+'||myChars[i]=='/'||myChars[i]=='-'){ //�̶� ���� ����־�� �Ұ� �����ڶ��
        double b = st.pop(); //���� �ϳ� ���ÿ��� ������
        double a = st.pop(); //���� �ϳ� ���ÿ��� ������
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
      else{ //���� �ǿ����ڶ��
        int code = (int)myChars[i]; //���� A, B, C...�� �ƽ�Ű�ڵ�� ����
        st.push(num[code-65]); //-65�� �ϸ� A�� 0����, B�� 1��, ... �� ���� �ٲ�. 
            
      }
    }
    System.out.printf("%.2f", st.pop());
  }
}
