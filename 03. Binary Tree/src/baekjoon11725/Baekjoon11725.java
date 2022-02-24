package baekjoon11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Node{
  Node left;
  Node right;
  Node parent;
  int data;
}

class Tree{
  Node root;

  public void setRoot(Node node){
    this.root=node;
  }

  public Node makeNode(int data, Node left, Node right,  Node parent){
    Node node = new Node();
    node.data=data;
    node.left=left;
    node.right=right;
    node.parent=parent;
    return node;
  }
  
}

public class Baekjoon11725 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Tree t = new Tree();

    int num = Integer.parseInt(br.readLine());
    int[] check = new int[num+1];
    int a, b;
    //노드 세팅하기
    Node[] array = new Node[num+1];
    array[1]=t.makeNode(1, null, null, null);
    t.setRoot(array[1]);
    check[1]=1;
    
    for(int i=1;i<num;i++){
      st = new StringTokenizer(br.readLine(), " ");
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());

      if(check[a]!=1){
        array[a]=t.makeNode(a, null, null, array[b]);
        if(array[b].left==null){
          array[b].left=array[a];
        }
        else{
          array[b].right=array[a];
        }
        check[a]=1;
      }
      else{
        array[b]=t.makeNode(b, null, null, array[a]);
        if(array[a].left==null){
          array[a].left=array[b];
        }
        else{
          array[a].right=array[b];
        }
        check[b]=1;
      }
    }

   for(int i=2;i<num+1;i++){
     System.out.println(array[i].parent.data);
   }
    
  }
}