package sample;

import java.util.Arrays;
import java.util.TreeSet;

public class SampleBinaryTree2 {
	public static void main(String[] args) {
		String phrase = "the quick brown fox jumps over the lazy dog";
		String[] phraseList = phrase.split(" "); //string�� �������� ������ �� �ܾ �迭�� ������
		
		TreeSet<String> words = new TreeSet<>(); //Ʈ�� �� ����(�ν��Ͻ� ȭ)
		words.addAll(Arrays.asList(phraseList)); //�迭�� ���� ����Ǿ� �ִ� �ܾ Ʈ�� �¿� �߰���
		
		for (String w : words) {
			System.out.println(w); //Ʈ���� ��ȸ�ϸ鼭 ����� �����
			
		}
	}
}

/* ��Ʈ ���� ������ ��, ���ĺ� ������ �� ���� �ܾ�� ���� ��忡 ��ġ�ؾ� �ϰ�,
 * �� ���߿� �ִ� �ܾ�� ������ ��忡 ��ġ�ؾ� �Ѵ�.
 * 1. 'the'�� ���� ó�� ���� �ܾ��̹Ƿ� ��Ʈ ��尡 �ȴ�.
 * 2. 'quick'�� 'the'���� ���ĺ� ������ �����Ƿ�, 'the'�� ���� ��尡 �ȴ�.
 * 3. 'brown'�� 'the'���� �����Ƿ� �������� �̵��Ѵ�. �̶� 'quick'�� �����µ�, 'brown'�� �� �����Ƿ� �������� �� �̵��Ѵ�.
 * 4. 'fox'�� 'the'���� ������, 'quick'���� ������, 'brown'���ٴ� �����Ƿ� ������ ��尡 �ȴ�.
 * ...(�߷�)...
 * */
