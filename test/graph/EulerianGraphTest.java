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
}
