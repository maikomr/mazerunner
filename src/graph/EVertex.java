package graph;

import java.util.List;

public class EVertex<T> {

	private List<Edge> edges;
	private T value;
	
	public EVertex(T value) {
		this.value = value;
	}

	public T getValue() {
		return this.value;
	}

	public int getDegree() {
		return edges.size();
	}

	public boolean addAdjacent(EVertex<T> adjacent) {
		
		return false;
	}

	public List<Edge> getNeighbors() {
		return this.edges;
	}
}
