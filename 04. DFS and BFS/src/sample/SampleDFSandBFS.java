package sample;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

class Graph {
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		/* class Graph�� �ʱ�ȭ���ִ� �Լ�.
		 * data�� ��ǲ ������, �湮 ���δ� false�� �����ϰ�, 
		 * ���� ��带 �Ҵ����ֱ� ���� LinkedList��ü�� �ν��Ͻ�ȭ�Ѵ�.*/
		Node (int data){
			this.data = data;
			this.marked=false;
			adjacent = new LinkedList<Node>();
		}
	}
	
    Node[] nodes; //��带 ������ �迭
    Graph(int size){
    	nodes = new Node[size]; //�־��� size�� �°� �迭�� ũ�⸦ �Ҵ�
    	for (int i=0;i<size;i++) {
    		nodes[i] = new Node(i); //Node�� class, �� ��ü�̱� ������ �ν��Ͻ�ȭ �ʿ�
    	}
    }
    
    /* �׷����� Node��� �� ��带 �����ϴ� Edge�� �̷����.
     * �� �Լ��� �� ��� ���� ������ �������ִ� ������ ��*/
    void addEdge(int i1, int i2) {
    	Node n1=nodes[i1];
    	Node n2=nodes[i2];
    	/* ��ǲ������ ���� �� ���� Ȯ���ϰ� ����Ǿ� �ִ� ���� ����̴�.
    	 * ���� ���� ��带 �˷��ִ� ���� ����Ʈ�� adjacent�� ���ԵǾ� ���� ���� ���¶��
    	 * �߰����־�� �Ѵ�.*/
    	if (!n1.adjacent.contains(n2)) {
    		n1.adjacent.add(n2);
    	}
    	if (!n2.adjacent.contains(n1)) {
    		n2.adjacent.add(n1);
    	}
    }
    
    void dfs() {//index���� dfs ȣ�� �� 0������ ������.
    	dfs(0);
    }
    
    void dfs(int index) { 
    	Node root = nodes[index]; //�켱 ��ǲ���� ���� ��尡 root��� �� ���
        Stack<Node> stack = new Stack<Node>(); //���� ���� �� root�� ���ؿ� ����
        stack.push(root);
        root.marked = true; //root���� �湮�Ǿ��ٴ� �� ǥ��
        
        
        while (!stack.isEmpty()) { //���ؿ� ���� �� ���� ������ dfs�� �����Ѵ�.
        	Node r = stack.pop(); //�켱 ���ؿ��� ��� �ϳ�(r)�� ������.
        	for(Node n : r.adjacent) { //r�� ���� ���(n)�� ��� �湮�ؾ� �Ѵ�.
        		if(n.marked == false) { //�׷��� �̹� �湮�ߴ� ���� �ٽ� �湮�ϸ� �� �ȴ�.
        			n.marked = true; //�湮 �� �ߴ� ��带 ��� ������ �湮�ߴٰ� ǥ���ϱ� ���� marked�� true�� �ٲ۴�.
        			stack.push(n); //n�� �ٽ� ���ؿ� �ִ´�.
        		}
        	}
        	visit(r);
        }
    }
    
    void bfs() { //index���� bfs ȣ�� �� 0������ ������.
    	bfs(0);
    }
    
    void bfs(int index) {
    	Node root = nodes[index]; //�켱 ��ǲ���� ���� ��尡 root��� �� ���
    	Queue<Node> queue = new LinkedList<Node>(); //ť ���� �� root�� ť�� ����
    	queue.add(root);
    	root.marked = true; //root���� �湮�Ǿ��ٴ� �� ǥ��
    	while(!queue.isEmpty()) { //ť�� ���� �� ���� ������ bfs�� �����Ѵ�.
    		Node r = queue.poll(); //�켱 ť���� ��� �ϳ�(r)�� ������.
    		for(Node n : r.adjacent) { //r�� ���� ���(n)�� ��� �湮�ؾ� �Ѵ�.
    			if(n.marked == false) { //�׷��� �̹� �湮�ߴ� ���� �ٽ� �湮�ϸ� �� �ȴ�.
    				n.marked = true; //�湮 �� �ߴ� ��带 ��� ������ �湮�ߴٰ� ǥ���ϱ� ���� marked�� true�� �ٲ۴�.
    				queue.add(n); //n�� �ٽ� ť�� �ִ´�.
    			}
    		}
    		visit(r);
    	}
    }
    
    void dfsR(Node r) { //��� �Լ��� �̿��� dfs ����
    	if (r==null) return; //���� ��尡 null�̸� ���ȣ���� ����
    	r.marked = true; //null�� �ƴ϶�� �湮�ߴٰ� üũ�� �� 
    	visit(r);
    	for(Node n : r.adjacent) {
    		if(n.marked==false) {
    			dfsR(n);
    		}
    	}
    }
    
    void dfsR(int index) { //���� ��带 �پ��ϰ� �õ��� ��
    	Node r = nodes[index];
    	dfsR(r);
    }
    
    void dfsR() {
    	dfsR(0);
    }
    
    /* ��� �Լ� */
    void visit(Node n) {
    	System.out.print(n.data + " ");
    }
}

public class SampleDFSandBFS {
	public static void main(String[] args) {
		Graph g = new Graph(9); //�׷��� �ν��Ͻ�ȭ
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		//g.dfs();
		System.out.println();
		g.bfs(); //�� �ڵ忡���� dfs�� bfs�� ���� ���� �Ұ����մϴ�. (marked ������)

		
	}
}
