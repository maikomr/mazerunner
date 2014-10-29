package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	 * A connected graph has Eulerian cycle if all its vertices have even
	 * degree; but it has Eulerian path if two of them (vertices) have odd
	 * degrees
	 * 
	 * @return true if this graph has at least has one Eulerian path or cycle
	 */
	public boolean isEulerian() {
		int numberOfOddDegrees = 0;
		for (EVertex<T> vertex : this.vertices) {
			if (vertex.getDegree() % 2 != 0)
				numberOfOddDegrees++;
		}
		return numberOfOddDegrees == 0 || numberOfOddDegrees == 2;
	}

	public int E() {
		return this.E;
	}

	public int V() {
		return this.vertices.size();
	}

	public boolean addVertex(EVertex<T> vertex) {
		if (!this.vertices.contains(vertex)) {
			return this.vertices.add(vertex);
		}
		return false;
	}

	private boolean addEdge(T a, T b) {
		EVertex<T> thisA = findVertex(a);
		EVertex<T> thisB = findVertex(b);
		if (thisA.addAdjacent(thisB)) {
			this.E++;
			return true;
		}
		return false;
	}

	/**
	 * Adds a new edge from vertex a to vertex b if some of them is not stored
	 * then will be added.
	 * 
	 * @param a
	 *            vertex a
	 * @param b
	 *            vertex b
	 * @return true if the graph could add the connection
	 */
	public boolean addEdge(EVertex<T> a, EVertex<T> b) {
		addVertex(a);
		addVertex(b);
		return this.addEdge(a.getValue(), b.getValue());
	}

	public EVertex<T> findVertex(T value) {
		for (EVertex<T> vertex : this.vertices) {
			if (vertex.getValue() == value)
				return vertex;
		}
		return null;
	}

	public void findEulerianPaths() {
		if (!isEulerian()) {
			System.out.println("The graph does not have eulerian path");
			return;
		} else {
			Stack<EVertex<T>> path = new Stack<>();
			Stack<Edge<T>> visited = new Stack<>();
			EVertex<T> ini = this.vertices.get(0);
			path.push(ini);
			findEulerianPaths(path, visited, ini, 0, this.E);
		}
	}

	private void findEulerianPaths(Stack<EVertex<T>> path,
			Stack<Edge<T>> visited, EVertex<T> actual, int index, int size) {

		if (index < actual.getDegree()) {
			Edge<T> actualEdge = actual.getNeighbors().get(index);
			if (!visited.contains(actualEdge)) {
				visited.push(actualEdge);
				EVertex<T> neighbor = actual.moveTo(actualEdge);
				path.push(neighbor);
				findEulerianPaths(path, visited, neighbor, 0, size);
			}
			findEulerianPaths(path, visited, actual, index + 1, size);
		}
		else if(index == actual.getDegree()) {
			if (visited.size() == size) {
				printEulerianPath(path);
			}
			if(!path.isEmpty())
				path.pop();
			if(!visited.isEmpty())
				visited.pop();
		}
	}

	public void printEulerianPath(Stack<EVertex<T>> path) {
		System.out.print("{");
		for (EVertex<T> vertex : path) {
			System.out.print(vertex.getValue() + " ");
		}
		System.out.println("}");
	}
}