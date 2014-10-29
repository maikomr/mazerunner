package graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EulerianGraphTest {

	private EulerianGraph<Character> eGraph;

	@Before
	public void setUp() throws Exception {
		 eGraph = new EulerianGraph<>();
	}

	@After
	public void tearDown() throws Exception {
		eGraph = null;
	}

	@Test
	public void shouldAddAVertex() {
		eGraph.addVertex(new EVertex<>('a'));

		int expectedOrder = 1;
		int actualOrder = eGraph.V();

		assertEquals(expectedOrder, actualOrder);
	}

	@Test
	public void shouldNotAddTheSameVertexTwice() {
		EVertex<Character> vertex = new EVertex<>('a');
		eGraph.addVertex(vertex);
		eGraph.addVertex(vertex);

		int expectedOrder = 1;
		int actualOrder = eGraph.V();

		assertEquals(expectedOrder, actualOrder);
	}

	@Test
	public void shouldCreateAnEdgeFromStoredVertices() {
		EVertex<Character> a = new EVertex<>('a');
		EVertex<Character> b = new EVertex<>('b');
		eGraph.addVertex(a);
		eGraph.addVertex(b);
		
		assertTrue(eGraph.addEdge(a, b));
		
		int expectedSize = 1;
		int actualSize = eGraph.E();
		
		assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void shouldCreateAnEdgeFromNonStoredVertices() {
		EVertex<Character> a = new EVertex<>('a');
		EVertex<Character> b = new EVertex<>('b');
		
		assertTrue(eGraph.addEdge(a, b));
		
		int expectedSize = 1;
		int actualSize = eGraph.E();
		
		assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void shouldCreateTwoEdgeFromTwoDifferentVertices() {
		EVertex<Character> a = new EVertex<>('a');
		EVertex<Character> b = new EVertex<>('b');
		
		assertTrue(eGraph.addEdge(a, b));
		assertTrue(eGraph.addEdge(b, a));
		
		int expectedSize = 2;
		int actualSize = eGraph.E();
		
		assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void eachVertexShouldHaveTwoDifferentAdjacentEdges() {
		EVertex<Character> a = new EVertex<>('a');
		EVertex<Character> b = new EVertex<>('b');
		
		assertTrue(eGraph.addEdge(a, b));
		assertTrue(eGraph.addEdge(b, a));
		
		Edge a1 = a.getNeighbors().get(0);
		Edge a2 = a.getNeighbors().get(1);
		
		assertNotEquals(a1, a2);
	}
	
	@Test
	public void bothVertexShouldShareAdjacentEdges() {
		EVertex<Character> a = new EVertex<>('a');
		EVertex<Character> b = new EVertex<>('b');
		
		assertTrue(eGraph.addEdge(a, b));
		assertTrue(eGraph.addEdge(b, a));
		
		Edge a1 = a.getNeighbors().get(0);
		Edge a2 = a.getNeighbors().get(1);
		
		Edge b1 = b.getNeighbors().get(0);
		Edge b2 = b.getNeighbors().get(1);
		
		assertEquals(a1, b1);
		assertEquals(a2, b2);
	}
}
