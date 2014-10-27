package graph;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	private Node<Character> node;

	@Before
	public void setUp() throws Exception {
		this.node = new Node<Character>('a');
	}

	@After
	public void tearDown() throws Exception {
		this.node = null;
	}

	@Test
	public void testAddAdjacent() {
		this.node.addAdjacent(new Node<>('b'));
		this.node.addAdjacent(new Node<>('c'));
		this.node.addAdjacent(new Node<>('d'));
		this.node.addAdjacent(new Node<>('d'));
		this.node.addAdjacent(new Node<>('d'));
		this.node.addAdjacent(new Node<>('d'));

		int expectedDegree = 6;
		int nodeDegree = this.node.getDegree();

		assertEquals("Must be equals", expectedDegree, nodeDegree);
	}

	@Test
	public void testAddLoop() {
		Node<Integer> node = new Node<Integer>(4);
		Node<Integer> node2 = new Node<Integer>(5);

		node.addAdjacent(node);
		node.addAdjacent(node2);
		node.addAdjacent(node);

		int expectedDegree = 3;
		int actualDegree = node.getDegree();

		assertEquals(expectedDegree, actualDegree);
	}

	@Test
	public void testDeleteAdjacent() {
		Node<Character> node2 = new Node<>('b');
		Node<Character> node3 = new Node<>('d');

		this.node.addAdjacent(node2);
		this.node.addAdjacent(new Node<>('c'));
		this.node.addAdjacent(node3);

		this.node.removeAdjacent(node2);
		int expectedDegree = 2;

		int nodeDegree = this.node.getDegree();
		assertEquals(expectedDegree, nodeDegree);
	}

	@Test
	public void testDeleteLoop() {
		Node<Integer> node = new Node<Integer>(4);
		Node<Integer> node2 = new Node<Integer>(5);

		node.addAdjacent(node);
		node.addAdjacent(node2);
		node.addAdjacent(node);
		node.addAdjacent(node2);
		node.addAdjacent(new Node<>(6));

		node.removeAdjacent(node);

		int expectedDegree = 4;
		int actualDegree = node.getDegree();

		assertEquals(expectedDegree, actualDegree);
	}

	@Test
	public void testToString() {

		this.node.addAdjacent(new Node<>('b'));
		this.node.addAdjacent(new Node<>('c'));
		this.node.addAdjacent(new Node<>('d'));
		this.node.addAdjacent(new Node<>('d'));
		this.node.addAdjacent(new Node<>('e'));
		this.node.addAdjacent(new Node<>('d'));

		String expectedNodeStr = "a: {b, c, d, d, e, d}";
		String nodeStr = node.toString();

		assertEquals(expectedNodeStr, nodeStr);
	}
}
