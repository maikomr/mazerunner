package graph;

public class Edge {
	
	private Node<?> a;
	private Node<?> b;
	
	public Edge(Node<?> a, Node<?> b) {
		this.a = a;
		this.b = b;
	}

	public Node<?> getA() {
		return this.a;
	}

	public Node<?> getB() {
		return this.b;
	}	
}
