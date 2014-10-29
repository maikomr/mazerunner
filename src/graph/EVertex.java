package graph;

import java.util.ArrayList;
import java.util.List;

public class EVertex<T> {

	private List<Edge> edges;
	private T value;
	
	public EVertex(T value) {
		this.value = value;
		this.edges = new ArrayList<>();
	}

	public T getValue() {
		return this.value;
	}

	public int getDegree() {
		return edges.size();
	}

	public boolean addAdjacent(EVertex<T> adjacent) {
		Edge edge = new Edge(this, adjacent);
		return this.edges.add(edge) && adjacent.edges.add(edge);
	}

	public List<Edge> getNeighbors() {
		return this.edges;
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}
	
	public boolean equals(Object obj) {
		return obj instanceof EVertex
				&& ((EVertex<?>)obj).value == this.value;
	}
}
