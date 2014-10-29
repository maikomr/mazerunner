package graph;

public class Edge {
	
	private EVertex<?> a;
	private EVertex<?> b;
	
	public Edge(EVertex<?> a, EVertex<?> b) {
		this.a = a;
		this.b = b;
	}

	public EVertex<?> getA() {
		return this.a;
	}

	public EVertex<?> getB() {
		return this.b;
	}
}
