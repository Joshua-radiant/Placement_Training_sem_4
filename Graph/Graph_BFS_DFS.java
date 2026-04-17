import java.util.*;

class Graph {
	ArrayList<ArrayList<Integer>> list=new ArrayList<>();
	Graph(int v) {
		for(int i=0; i<v; i++) {
			list.add(new ArrayList<Integer>());
		}
	}
	void push(int u, int v) {
		list.get(u).add(v);
		list.get(v).add(u);
	}
	void display() {
		for(int i=0; i<list.size(); i++) {
			System.out.println("vertex: "+i);
			for(int j=0; j<list.get(i).size(); j++) {
				System.out.println(" "+list.get(i).get(j));
			}
		}
	}

	void bfs(int v) {
		int k = list.size();
		boolean visited[] = new boolean[k];
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		System.out.println("BFS: ");
		while(!q.isEmpty()) {
			int m = q.remove();
			System.out.println(m+" ");
			for(int i=0; i<list.get(m).size(); i++) {
				int h = list.get(m).get(i);
				if(!visited[h]) {
					q.add(h);
					visited[h] = true;
				}
			}
		}
	}

	void dfs(int v) {
		int s = list.size();
		boolean visited[] = new boolean[s];
		dfs1(v, visited);
	}

	void dfs1(int v, boolean visited[]) {
		visited[v] = true;
		System.out.println(v+" ");
		for(int i=0; i<list.get(v).size(); i++) {
			int m = list.get(v).get(i);
			if(!visited[m]) {
				dfs1(m, visited);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Number of Vertices: ");
		int k=in.nextInt();
		System.out.print("Enter Number of Edges: ");
		int e = in.nextInt();
		Graph g=new Graph(k);
		System.out.println("Enter Vertices and Edges: ");
		for(int i=0; i<e; i++)
		{
			int u=in.nextInt();
			int v=in.nextInt();
			g.push(u, v);
		}
		g.display();
		System.out.print("Enter Vertex for BFS Traversal: ");
		int a = in.nextInt();
		g.bfs(a);
		System.out.print("Enter vertex for DFS Traversal: ");
		int b = in.nextInt();
		g.dfs(b);
	}
}