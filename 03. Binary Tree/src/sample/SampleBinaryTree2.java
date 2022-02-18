package sample;

import java.util.Arrays;
import java.util.TreeSet;

public class SampleBinaryTree2 {
	public static void main(String[] args) {
		String phrase = "the quick brown fox jumps over the lazy dog";
		String[] phraseList = phrase.split(" "); //string을 공백으로 나눠서 각 단어를 배열에 저장함
		
		TreeSet<String> words = new TreeSet<>(); //트리 셋 생성(인스턴스 화)
		words.addAll(Arrays.asList(phraseList)); //배열에 각각 저장되어 있던 단어를 트리 셋에 추가함
		
		for (String w : words) {
			System.out.println(w); //트리를 순회하면서 결과를 출력함
			
		}
	}
}

/* 루트 노드와 비교했을 때, 알파벳 상으로 더 빠른 단어는 왼쪽 노드에 위치해야 하고,
 * 더 나중에 있는 단어는 오른쪽 노드에 위치해야 한다.
 * 1. 'the'는 가장 처음 들어온 단어이므로 루트 노드가 된다.
 * 2. 'quick'는 'the'보다 알파벳 상으로 빠르므로, 'the'의 왼쪽 노드가 된다.
 * 3. 'brown'은 'the'보다 빠르므로 왼쪽으로 이동한다. 이때 'quick'을 만나는데, 'brown'이 더 빠르므로 왼쪽으로 또 이동한다.
 * 4. 'fox'는 'the'보다 빠르고, 'quick'보다 빠르고, 'brown'보다는 느리므로 오른쪽 노드가 된다.
 * ...(중략)...
 * */
