package sample;

/* 각각의 노드를 설계하는 class
 * Tree의 Node에는 data와 왼쪽 자식 노드를 가리키는 left,
 * 오른쪽 자식 노드를 가리키는 right에 대한 정보가 있음*/
class Node {
	int data;
	Node left;
	Node right;
}

/* Tree 전체를 설계하는 class */
class Tree {
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
	public Node makeNode (Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	/* 전위 순회 함수 */
    public void inorder (Node node) {
    	if (node != null) { //만약 루트 노드가 비어있지 않다면
    		inorder(node.left); //왼쪽 노드로 이동한다.
    		System.out.println(node.data); //왼쪽 노드로 끝까지 간 다음에는 출력한다.
    		inorder(node.right); //오른쪽 노드로 이동한다.
    	}
    }
    
    /* 중위 순회 함수 */
    public void preorder(Node node) {
    	if (node != null) { //만약 루트 노드가 비어있지 않다면
    		System.out.println(node.data); //자기 자신을 우선 출력한다.
    		preorder(node.left); //왼쪽 노드로 이동한다.
    		preorder(node.right); //오른쪽 노드로 이동한다.
    	}
    }
    /* 후위 순회 함수 */
    public void postorder (Node node) {
    	if (node != null) { //만약 루트 노드가 비어있지 않다면
    		postorder(node.left); //왼쪽 노드로 이동한다.
    		postorder(node.right); //오른쪽 노드로 이동한다. 
    		System.out.println(node.data); //자기 자신을 출력한다.
    	}
    }
}

public class SampleBinaryTree {
	public static void main (String[] args) {
		Tree t = new Tree();
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);
		t.setRoot(n1);
		t.inorder(t.getRoot());
	}

}
