package graph;

public class Edge {
	
	private EVertex<?> a;
	private EVertex<?> b;
	public int id;
	
	public Edge(EVertex<?> a, EVertex<?> b, int id) {
		this.a = a;
		this.b = b;
		this.id = id;
	}

	public EVertex<?> getA() {
		return this.a;
	}

	public EVertex<?> getB() {
		return this.b;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean equals(Object obj) {
		return obj instanceof Edge
				&& ((Edge) obj).id == this.id;
	}
}
