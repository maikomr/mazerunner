package graph;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MazeRunnerTest {

	private MazeRunner mazeRunner;
	private GraphFactory graphFactory;
	
	@Before
	public void setUp() throws Exception {
		mazeRunner = new MazeRunner();
		graphFactory = new GraphFactory();
	}

	@After
	public void tearDown() throws Exception {
		mazeRunner = null;
		graphFactory = null;
	}
	
	@Test
	public void shouldReturnHamiltonPathsFromSimpleGraph() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/simpleGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPaths(graph);
		
		int expectedPathsCount = 8;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}

	@Test
	public void shouldReturnHamiltonPathsWithLoops() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/loopyGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPaths(graph);
		
		int expectedPathsCount = 8;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
	
	@Test
	public void shouldReturnHamiltonPathsFromMultiGraph() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/multiGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPaths(graph);
		
		int expectedPathsCount = 16;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
	
	@Test
	public void shouldReturnHamiltonPathsStartingAtAnSpecificNode() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/multiGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPathStartingAt(graph, graph.findNode('d'));
		
		int expectedPathsCount = 4;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
	
	@Test
	public void shouldNotReturnAnyHamiltonPathsStartingAtNodeA() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/multiGraph.txt");

		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPathStartingAt(graph, graph.findNode('a'));
		
		int expectedPathsCount = 0;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
	
	@Test
	public void testMazeWithOuterdoors() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/mazeGraphOuter.txt");
		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPaths(graph);
		
		int expectedPathsCount = 2;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
	
	@Test
	public void testMazeClosingOuterdoors() {
		AdjacencyListGraph<Character> graph;
		graph = graphFactory.readGraphFromFile("examples/mazeGraph.txt");
		List<Stack<Node<Character>>> paths;
		paths = mazeRunner.hamiltonPaths(graph);
		
		int expectedPathsCount = 0;
		int actualPathsCount = paths.size();
		
		assertEquals(expectedPathsCount, actualPathsCount);
	}
}
