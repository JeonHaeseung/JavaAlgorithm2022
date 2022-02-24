package baekjoon1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Node {
  char data;
  Node left;
  Node right;
}

class Tree{
	
  public Node root; //루트 노드에 대한 정보
	
	/* 루트 노드를 설정하는 setRoot 함수 */
  public void setRoot (Node node) {
	this.root = node;
  }
  
  /* 루트 노드가 무엇인지 알려주는 getRoot 함수 */
  public Node getRoot() {
	return root;
  }
  
  /* 새 노드를 만드는 makeNode 함수*/
	public Node makeNode (char data, Node left, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}

  public void inorder(Node node){
    inorder(node.left);
    System.out.printf("%c", node.data);
    inorder(node.right);
  }

  public void preorder(Node node){
    System.out.printf("%c", node.data);
    preorder(node.left);
    preorder(node.right);
  }

  public void postorder(Node node){
    postorder(node.left);
    postorder(node.right);
    System.out.printf("%c", node.data);

  }
}

public class Baekjoon1991 {
  public static void main(String[] args) throws IOException {
	
    //트리 객체를 인스턴스화하고, 루트를 A로 정한다.
    Node[] arrayNode = new Node[27];
    for (int i = 0; i < 27 ; i++) {
    	arrayNode[i] = new Node();
    }
    
    Tree t = new Tree();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nodeNum = Integer.parseInt(br.readLine());
    //데이터만 저장
    char[][] tempNode = new char[nodeNum][3];

    
    for(int i=0 ; i<nodeNum ; i++){
    	String temp = br.readLine();
        tempNode[i][0] = temp.charAt(0);
        tempNode[i][1] = temp.charAt(2);
        tempNode[i][2] = temp.charAt(4);
    }
    
    for(int i=0 ; i<nodeNum ; i++){
      //맨 처음은 그냥 저장해줌
      arrayNode[i].data=tempNode[i][0];

      //해당 노드의 왼쪽을 검사함
      if(tempNode[i][1]=='.'){ //null일 경우
        arrayNode[i].left=null;
      }
      else{
        for(int j = i+1 ; j<nodeNum ; j++){
          if(arrayNode[j].data == tempNode[i][1]){
            arrayNode[i].left = arrayNode[j];
          }
        }
      }

      //해당 노드의 오른쪽을 검사함
      if(tempNode[i][2]=='.'){ //null일 경우
        arrayNode[i].right=null;
      }
      else{
        for(int j = i+1 ; j<nodeNum ; j++){
          if(arrayNode[j].data == tempNode[i][2]){
            arrayNode[i].right = arrayNode[j];
          }
        }
      }
    }
    
    Node root=arrayNode[0];

    t.inorder(root);
    System.out.println();
    t.preorder(root);
    System.out.println();
    t.postorder(root);
  }
}