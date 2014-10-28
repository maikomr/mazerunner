package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph<E> {

	private List<Node<E>> nodes;

	public AdjacencyListGraph() {
		super();
		this.nodes = new ArrayList<>();
	}

	public void addNode(Node<E> node) {
		if ( ! this.contains(node)) {
			this.nodes.add(node);
		}
	}
	
	public boolean contains(Node<E> node) {
		return this.nodes.contains(node);
	}

	public void addEdge(Node<E> x, Node<E> y) {
		if ( ! this.contains(x) == false)
			this.nodes.add(x);
		if ( ! this.contains(y) == false)
			this.nodes.add(y);
	}

	public List<Node<E>> getNodes() {
		return this.nodes;
	}

	public int getOrder() {
		return this.nodes.size();
	}
}
