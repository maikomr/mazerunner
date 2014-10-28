package graph;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MazeRunnerTest {

	private MazeRunner mazeRunner;
	private AdjacencyListGraphFactory graphFactory;
	
	@Before
	public void setUp() throws Exception {
		mazeRunner = new MazeRunner();
		graphFactory = new AdjacencyListGraphFactory();
	}

	@After
	public void tearDown() throws Exception {
		mazeRunner = null;
		graphFactory = null;
	}
	
	@Test
	public void shouldReturnHamiltonPathFromSimpleGraph() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/simpleGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPath(graph);
		
		int expectedPathsCount = 8;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}

	@Test
	public void shouldReturnHamiltonPathWithLoops() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/loopyGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPath(graph);
		
		int expectedPathsCount = 8;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
	
	@Test
	public void shouldReturnHamiltonPathFromMultiGraph() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/multiGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPath(graph);
		
		int expectedPathsCount = 16;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
}
