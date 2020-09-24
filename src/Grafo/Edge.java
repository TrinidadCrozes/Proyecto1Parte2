package Grafo;

public class Edge {
	
	protected Integer n1;
	protected Integer n2;
	
	public Edge( Integer node1, Integer node2 ) {
		n1 = node1;
		n2 = node2;
	}
	
	public Integer getN1() {
		return n1;
	}
	
	public Integer getN2() {
		return n2;
	}
	
}