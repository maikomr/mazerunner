package graph;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EVertexTest {

	private EVertex<Character> vertex;
	@Before
	public void setUp() throws Exception {
		vertex = new EVertex<Character>('a');
	}

	@After
	public void tearDown() throws Exception {
		vertex = null;
	}

	@Test
	public void testAddAdjacent() {
		vertex.addAdjacent(new EVertex<>('b'));
		vertex.addAdjacent(new EVertex<>('c'));

		int expectedDegree = 2;
		int actualVertexDegree = vertex.getDegree();

		assertEquals(expectedDegree, actualVertexDegree);
	}

	@Test
	public void bothVerticesShouldHaveTheSameDegree() {
		EVertex<Character> b = new EVertex<Character>('b');
		vertex.addAdjacent(b);

		int expectedDegree = 1;
		int actualBDegree = b.getDegree();

		assertEquals(expectedDegree, actualBDegree);
	}
	
	@Test
	public void shouldAddTwoEdgesBetweenPairOfVertices() {
		EVertex<Character> b = new EVertex<Character>('b');
		vertex.addAdjacent(b);
		b.addAdjacent(vertex);

		int expectedDegree = 2;
		int actualVertexDegree = vertex.getDegree();
		int actualBDegree = b.getDegree();

		assertEquals(expectedDegree, actualVertexDegree);
		assertEquals(expectedDegree, actualBDegree);	
	}
	
	@Test
	public void incidentVerticesShouldShareTheSameEdge() {
		EVertex<Character> b = new EVertex<Character>('b');
		b.addAdjacent(vertex);

		Edge<Character> e1 = vertex.getNeighbors().get(0);
		Edge<Character> e2 = b.getNeighbors().get(0);

		assertEquals(e1, e2);
	}
}
