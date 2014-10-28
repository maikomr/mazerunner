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
	
	/**
	 * Returns the Node containing the input value.
	 * @param value is the criteria for searching the node.
	 * @return The the node found in this graph, otherwise a null value.
	 */
	public Node<E> findNode(E value) {
		for(Node<E> node: this.nodes) {
			if(node.getValue() == value)
				return node;
		}
		return null;
	}
	
	public boolean contains(Node<E> node) {
		return this.nodes.contains(node);
	}

	public void addEdge(Node<E> x, Node<E> y) {
		if ( this.contains(x) == false)
			this.nodes.add(x);
		if ( this.contains(y) == false)
			this.nodes.add(y);
		
		Node<E> from = this.nodes.get(nodes.indexOf(x));
		Node<E> to = this.nodes.get(nodes.indexOf(y));
		
		from.addAdjacent(to);
		if(from != to)
			to.addAdjacent(from);
	}

	public List<Node<E>> getNodes() {
		return this.nodes;
	}

	public int getOrder() {
		return this.nodes.size();
	}
}
