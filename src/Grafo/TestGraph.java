package Grafo;

public class TestGraph {

	public static void main ( String[]args ) {
		
		Graph grafo = new Graph();
		
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addNode(5);
		grafo.addNode(3);
		
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);
		grafo.addEdge(3, 4);
		grafo.addEdge(3, 7);
		grafo.addEdge(4, 3);
		grafo.addEdge(4, 5);
		grafo.addEdge(5, 1);
		grafo.addEdge(5, 2);
		grafo.addEdge(6, 9);
		grafo.addEdge(7, 1);
		
		grafo.removeEdge(4, 3);
		grafo.removeEdge(8, 2);
		grafo.removeEdge(4, 9);
		grafo.removeEdge(7, 9);
		
		grafo.removeNode(1);
		grafo.removeNode(4);
		grafo.removeNode(6);
		
	}
	
}

