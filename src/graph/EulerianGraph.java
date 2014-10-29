package graph;

import java.util.ArrayList;
import java.util.List;

public class EulerianGraph<T> {

	/**
	 * All vertices stored in this graph
	 */
	private List<EVertex<T>> vertices;
	
	/**
	 * Size of the graph (total amount of edges)
	 */
	private int E;
	
	EulerianGraph() {
		this.vertices = new ArrayList<>();
		this.E = 0;
	}
	
	/**
	 * A connected graph has Eulerian cycle if all its vertices
	 * have even degree; but it has Eulerian path if two of them (vertices) have odd degrees
	 * @return true if this graph has at least has one Eulerian path or cycle
	 */
	public boolean isEulerian() {
		return false;
	}
	
	public int E() {
		return this.E;
	}
	
	public int V() {
		return this.vertices.size();
	}

	public boolean addVertex(EVertex<T> vertex) {
		if(!this.vertices.contains(vertex)) {
			return this.vertices.add(vertex);
		}
		return false;
	}

	public boolean addEdge(EVertex<T> a, EVertex<T> b) {
		addVertex(a);
		addVertex(b);
		if(a.addAdjacent(b)) {
			this.E++;
			return true;
		}
		return false;
	}
}