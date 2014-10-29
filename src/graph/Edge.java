package graph;

public class Edge<T> {
	
	private EVertex<T> a;
	private EVertex<T> b;
	
	public Edge(EVertex<T> a, EVertex<T> b) {
		this.a = a;
		this.b = b;
	}

	public EVertex<T> getA() {
		return this.a;
	}

	public EVertex<T> getB() {
		return this.b;
	}
	
	public String toString() {
		return "{" + this.a + "," + this.b + "}";
	}
}
