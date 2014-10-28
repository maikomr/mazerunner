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

}
