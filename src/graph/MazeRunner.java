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
	 * 
	 * @param graph
	 *            if graph has at least one Hamilton path it's said that it's a
	 *            Hamilton graph
	 * @return all possible Hamilton paths in this graph
	 */
	public <T> List<Stack<Node<T>>> hamiltonPaths(AdjacencyListGraph<T> graph) {
		List<Stack<Node<T>>> res = new ArrayList<>();

		for (Node<T> node : graph.getNodes()) {
			Stack<Node<T>> path = new Stack<>();
			findHamiltonPath(res, path, node, 0, graph.getOrder());
		}
		removeOutdoor(res);
		return res;
	}
	
	/**
	 * Checks and removes the outdoor node in the path
	 * @param paths found Hamilton paths
	 */
	private <T> void removeOutdoor(List<Stack<Node<T>>> paths) {
		for (Stack<Node<T>> path : paths) {
			path.remove(new Node<>('x'));
		}
	}
	
	/**
	 * Traverses the graphs searching for Hamilton paths starting at the specified node
	 * 
	 * @param graph
	 *            The graph in which the traverse will be performed
	 * @param start The initial node from which the traverse will be performed
	 * @return all possible Hamilton paths starting from the given node
	 */
	public <T> List<Stack<Node<T>>> hamiltonPathStartingAt(
			AdjacencyListGraph<T> graph, Node<T> start) {
		List<Stack<Node<T>>> res = new ArrayList<>();

		Stack<Node<T>> path = new Stack<>();
		findHamiltonPath(res, path, start, 0, graph.getOrder());
		return res;
	}

	@SuppressWarnings("unchecked")
	private <T> void findHamiltonPath(List<Stack<Node<T>>> res,
			Stack<Node<T>> path, Node<T> actual, int index, int order) {

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

	public <T> String strHamiltonPath(Stack<Node<T>> path) {
		String hamiltonPath = "{";
		for (Node<T> node : path) {
			hamiltonPath += node.getValue() + " ";
		}
		hamiltonPath += "}";
		return hamiltonPath;
	}
}