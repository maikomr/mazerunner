package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdjacencyListGraphFactory {

	public AdjacencyListGraph<Character> readGraphFromFile(String fileName) {

		AdjacencyListGraph<Character> graph = new AdjacencyListGraph<>();
		FileReader file = null;
		BufferedReader reader = null;

		try {
			file = new FileReader(fileName);
			reader = new BufferedReader(file);
			String readed;
			while ((readed = reader.readLine()) != null) {
				graph.addEdge(new Node<>(readed.charAt(0)), new Node<>(readed.charAt(1)));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// Ignore issues during closing
				}
			}
		}
		return graph;
	}
}
