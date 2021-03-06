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
	public void shouldNotAddDifferentVertexObjectsWithTheSameValue() {
		EVertex<Character> vertex = new EVertex<>('a');
		eGraph.addVertex(vertex);
		eGraph.addVertex(new EVertex<>('a'));

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
		
		Edge<Character> a1 = a.getNeighbors().get(0);
		Edge<Character> a2 = a.getNeighbors().get(1);
		
		assertNotEquals(a1, a2);
	}
	
	@Test
	public void bothVertexShouldShareAdjacentEdges() {
		EVertex<Character> a = new EVertex<>('a');
		EVertex<Character> b = new EVertex<>('b');
		
		assertTrue(eGraph.addEdge(a, b));
		assertTrue(eGraph.addEdge(b, a));
		
		Edge<Character> a1 = a.getNeighbors().get(0);
		Edge<Character> a2 = a.getNeighbors().get(1);
		
		Edge<Character> b1 = b.getNeighbors().get(0);
		Edge<Character> b2 = b.getNeighbors().get(1);
		
		assertEquals(a1, b1);
		assertEquals(a2, b2);
	}
	
	@Test
	public void shouldReadFromFile() {
		eGraph = GraphFactory.readEulerianGraphFromFile("examples/eulerianCycles.txt");
		
		int expectedSize = 7;
		int actualSize = eGraph.E();
		
		assertEquals(expectedSize, actualSize);
		
		int expectedOrder = 5;
		int actualOrder = eGraph.V();
		
		assertEquals(expectedOrder, actualOrder);
	}
	
	@Test
	public void shouldBeEulerianCycle() {
		eGraph = GraphFactory.readEulerianGraphFromFile("examples/eulerianCycles.txt");
		
		assertTrue(eGraph.isEulerian());
	}
	
	@Test
	public void shouldBeEulerianPath() {
		eGraph = GraphFactory.readEulerianGraphFromFile("examples/eulerianPath.txt");
		
		assertTrue(eGraph.isEulerian());
	}
	
	@Test
	public void shouldFindEulerianCycles() {
		eGraph = GraphFactory.readEulerianGraphFromFile("examples/eulerianCycles.txt");
		
		eGraph.findEulerianPaths();
	}
	
	@Test
	public void shouldFindEulerianCyclesWithinMultigraph() {
		eGraph = GraphFactory.readEulerianGraphFromFile("examples/eulerianCyclesMultigraph.txt");
		
		eGraph.findEulerianPaths();
	}
}
