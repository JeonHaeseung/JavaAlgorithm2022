package sample;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

class Graph {
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		/* class Graph를 초기화해주는 함수.
		 * data는 인풋 값으로, 방문 여부는 false로 설정하고, 
		 * 인접 노드를 할당해주기 위해 LinkedList객체를 인스턴스화한다.*/
		Node (int data){
			this.data = data;
			this.marked=false;
			adjacent = new LinkedList<Node>();
		}
	}
	
    Node[] nodes; //노드를 구현할 배열
    Graph(int size){
    	nodes = new Node[size]; //주어진 size에 맞게 배열의 크기를 할당
    	for (int i=0;i<size;i++) {
    		nodes[i] = new Node(i); //Node는 class, 즉 객체이기 때문에 인스턴스화 필요
    	}
    }
    
    /* 그래프는 Node들과 그 노드를 연결하는 Edge로 이루어짐.
     * 이 함수는 두 노드 간의 엣지를 저장해주는 역할을 함*/
    void addEdge(int i1, int i2) {
    	Node n1=nodes[i1];
    	Node n2=nodes[i2];
    	/* 인풋값으로 들어온 두 노드는 확실하게 연결되어 있는 인접 노드이다.
    	 * 따라서 인접 노드를 알려주는 연결 리스트인 adjacent에 포함되어 있지 않은 상태라면
    	 * 추가해주어야 한다.*/
    	if (!n1.adjacent.contains(n2)) {
    		n1.adjacent.add(n2);
    	}
    	if (!n2.adjacent.contains(n1)) {
    		n2.adjacent.add(n1);
    	}
    }
    
    void dfs() {//index없이 dfs 호출 시 0번부터 시작함.
    	dfs(0);
    }
    
    void dfs(int index) { 
    	Node root = nodes[index]; //우선 인풋으로 들어온 노드가 root라는 걸 명시
        Stack<Node> stack = new Stack<Node>(); //스텍 생성 후 root를 스텍에 넣음
        stack.push(root);
        root.marked = true; //root노드는 방문되었다는 걸 표시
        
        
        while (!stack.isEmpty()) { //스텍에 남은 게 없을 때까지 dfs를 진행한다.
        	Node r = stack.pop(); //우선 스텍에서 노드 하나(r)를 꺼낸다.
        	for(Node n : r.adjacent) { //r의 인접 노드(n)를 모두 방문해야 한다.
        		if(n.marked == false) { //그런데 이미 방문했던 노드는 다시 방문하면 안 된다.
        			n.marked = true; //방문 안 했던 노드를 골라서 이제는 방문했다고 표시하기 위해 marked를 true로 바꾼다.
        			stack.push(n); //n을 다시 스텍에 넣는다.
        		}
        	}
        	visit(r);
        }
    }
    
    void bfs() { //index없이 bfs 호출 시 0번부터 시작함.
    	bfs(0);
    }
    
    void bfs(int index) {
    	Node root = nodes[index]; //우선 인풋으로 들어온 노드가 root라는 걸 명시
    	Queue<Node> queue = new LinkedList<Node>(); //큐 생성 후 root를 큐에 넣음
    	queue.add(root);
    	root.marked = true; //root노드는 방문되었다는 걸 표시
    	while(!queue.isEmpty()) { //큐에 남은 게 없을 때까지 bfs를 진행한다.
    		Node r = queue.poll(); //우선 큐에서 노드 하나(r)를 꺼낸다.
    		for(Node n : r.adjacent) { //r의 인접 노드(n)를 모두 방문해야 한다.
    			if(n.marked == false) { //그런데 이미 방문했던 노드는 다시 방문하면 안 된다.
    				n.marked = true; //방문 안 했던 노드를 골라서 이제는 방문했다고 표시하기 위해 marked를 true로 바꾼다.
    				queue.add(n); //n을 다시 큐에 넣는다.
    			}
    		}
    		visit(r);
    	}
    }
    
    void dfsR(Node r) { //재귀 함수를 이용한 dfs 구현
    	if (r==null) return; //받은 노드가 null이면 재귀호출을 끝냄
    	r.marked = true; //null이 아니라면 방문했다고 체크해 줌 
    	visit(r);
    	for(Node n : r.adjacent) {
    		if(n.marked==false) {
    			dfsR(n);
    		}
    	}
    }
    
    void dfsR(int index) { //시작 노드를 다양하게 시도해 봄
    	Node r = nodes[index];
    	dfsR(r);
    }
    
    void dfsR() {
    	dfsR(0);
    }
    
    /* 출력 함수 */
    void visit(Node n) {
    	System.out.print(n.data + " ");
    }
}

public class SampleDFSandBFS {
	public static void main(String[] args) {
		Graph g = new Graph(9); //그래프 인스턴스화
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
		g.bfs(); //이 코드에서는 dfs와 bfs가 동시 실행 불가능합니다. (marked 때문에)

		
	}
}
