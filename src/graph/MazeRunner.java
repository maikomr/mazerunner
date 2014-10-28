package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MazeRunner {

	// TODO verify whether the graph is connected (conexo)
	public boolean isEulerian(AdjacencyListGraph<?> graph) {
		int numberOfOddDegrees = 0;
		for (Node<?> node : graph.getNodes()) {
			if (node.getDegree() % 2 != 0)
				numberOfOddDegrees++;
		}
		return numberOfOddDegrees == 0 || numberOfOddDegrees == 2;
	}

	/**
	 * Searchs for Hamilton paths within the specified graph
	 * @param graph if graph has at least one Hamilton path it's said that it's a Hamilton graph
	 * @return all possible Hamilton paths in this graph
	 */
	public <T> List<Stack<Node<T>>> hamiltonPath(AdjacencyListGraph<T> graph) {
		List<Stack<Node<T>>> res = new ArrayList<>();

		for (Node<T> node : graph.getNodes()) {
			Stack<Node<T>> path = new Stack<>();
			findHamiltonPath(res, path, node, 0, graph.getOrder());
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	private <T> void findHamiltonPath(List<Stack<Node<T>>> res, Stack<Node<T>> path, Node<T> actual,
			int index, int order) {

		if (index < actual.getDegree()) {

			if (!path.contains(actual)) {
				path.push(actual);
			}

			Node<T> neighbor = actual.getNeighbors().get(index);

			if (!path.contains(neighbor)) {
				findHamiltonPath(res, path, neighbor, 0, order);
			}

			findHamiltonPath(res, path, actual, index + 1, order);

			if (path.size() == order) {
				res.add((Stack<Node<T>>) path.clone());
			}

			if (path.contains(actual))
				path.pop();
		}
	}

	public <T> String printHamiltonPath(Stack<Node<T>> path) {
		String hamiltonPath = "{";
		for (Node<T> node : path) {
			hamiltonPath += node.getValue() + " ";
		}
		hamiltonPath += "}";
		return hamiltonPath;
	}
}