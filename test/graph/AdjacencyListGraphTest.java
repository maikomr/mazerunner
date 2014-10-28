package graph;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdjacencyListGraphTest {

	private AdjacencyListGraph<Character> graph;
	
	@Before
	public void setUp() throws Exception {
		this.graph = new AdjacencyListGraph<>();
	}

	@After
	public void tearDown() throws Exception {
		this.graph = null;
	}

	@Test
	public void testAddNode() {
		
		this.graph.addNode(new Node<>('a'));
		this.graph.addNode(new Node<>('b'));
		this.graph.addNode(new Node<>('c'));
		
		int expectedGraphOrder = 3;
		int actualGraphOrder = graph.getOrder();
		
		assertEquals(expectedGraphOrder, actualGraphOrder);
		
		this.graph.addNode(new Node<>('a'));
		this.graph.addNode(new Node<>('b'));
		
		assertEquals(expectedGraphOrder, graph.getOrder());
	}
	
	@Test
	public void eachNodeShouldAddAdjacent() {
		this.graph.addEdge(new Node<>('b'), new Node<>('a'));
		this.graph.addEdge(new Node<>('c'), new Node<>('b'));
		this.graph.addEdge(new Node<>('b'), new Node<>('b'));
		this.graph.addEdge(new Node<>('d'), new Node<>('a'));
		this.graph.addEdge(new Node<>('d'), new Node<>('b'));
		
		int expectedNodeDegree = 4;
		int actualNodeDegree = graph.findNode('b').getDegree();
		
		assertEquals(expectedNodeDegree, actualNodeDegree);
	}

}
