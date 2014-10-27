package graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	private T value;
	private List<Node<T>> neighbors;

	public Node(T value) {
		super();
		this.value = value;
		this.neighbors = new ArrayList<Node<T>>();
	}

	private String neighborsToString() {
		String adjacencyStr = new String();
		if (this.neighbors.isEmpty() == false) {
			int degree = this.getDegree();
			adjacencyStr = ": {";
			for (int offset = 0; offset < degree; offset++) {
				adjacencyStr += String.valueOf(neighbors.get(offset).value);
				adjacencyStr += (offset < degree - 1) ? ", " : "}";
			}
		}
		return adjacencyStr;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value) + neighborsToString();
	}

	public int getDegree() {
		return this.neighbors.size();
	}

	public boolean addAdjacent(Node<T> adjacent) {
		return this.neighbors.add(adjacent);
	}

	public boolean removeAdjacent(Node<T> adjacent) {
		return this.neighbors.remove(adjacent);
	}

	public boolean isAdjacent(Node<T> adjacent) {
		return this.neighbors.contains(adjacent);
	}

	public List<Node<T>> getNeighbors() {
		return this.neighbors;
	}
}
