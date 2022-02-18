package sample;

/* ������ ��带 �����ϴ� class
 * Tree�� Node���� data�� ���� �ڽ� ��带 ����Ű�� left,
 * ������ �ڽ� ��带 ����Ű�� right�� ���� ������ ����*/
class Node {
	int data;
	Node left;
	Node right;
}

/* Tree ��ü�� �����ϴ� class */
class Tree {
	public Node root; //��Ʈ ��忡 ���� ����
	
	/* ��Ʈ ��带 �����ϴ� setRoot �Լ� */
	public void setRoot (Node node) {
		this.root = node;
	}
	
	/* ��Ʈ ��尡 �������� �˷��ִ� getRoot �Լ� */
	public Node getRoot() {
		return root;
	}
	
	/* �� ��带 ����� makeNode �Լ�*/
	public Node makeNode (Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	/* ���� ��ȸ �Լ� */
    public void inorder (Node node) {
    	if (node != null) { //���� ��Ʈ ��尡 ������� �ʴٸ�
    		inorder(node.left); //���� ���� �̵��Ѵ�.
    		System.out.println(node.data); //���� ���� ������ �� �������� ����Ѵ�.
    		inorder(node.right); //������ ���� �̵��Ѵ�.
    	}
    }
    
    /* ���� ��ȸ �Լ� */
    public void preorder(Node node) {
    	if (node != null) { //���� ��Ʈ ��尡 ������� �ʴٸ�
    		System.out.println(node.data); //�ڱ� �ڽ��� �켱 ����Ѵ�.
    		preorder(node.left); //���� ���� �̵��Ѵ�.
    		preorder(node.right); //������ ���� �̵��Ѵ�.
    	}
    }
    /* ���� ��ȸ �Լ� */
    public void postorder (Node node) {
    	if (node != null) { //���� ��Ʈ ��尡 ������� �ʴٸ�
    		postorder(node.left); //���� ���� �̵��Ѵ�.
    		postorder(node.right); //������ ���� �̵��Ѵ�. 
    		System.out.println(node.data); //�ڱ� �ڽ��� ����Ѵ�.
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
