package Grafo;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Filter;

public class Graph {

	private List<Integer> nodos;
	private List<Edge> arcos;
	private static Logger logger;

	public Graph() {
		
		nodos = new ArrayList<Integer>();
		arcos = new ArrayList<Edge>();

		if (logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.WARNING);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
		
	}

	public void addNode(int node) {
		
		boolean estaN = nodos.contains(node);
		
		if ( !estaN ) {
			nodos.add(node);
			logger.info("Se agregó el nodo " + node + " al grafo.");
		}
		else {
			logger.warning("El nodo " + node + " ya pertenece al grafo.");
		}
		
	}
	
	public void addEdge(int node1, int node2) {
		
		boolean estaN1 = nodos.contains(node1);
		boolean estaN2 = nodos.contains(node2);
		boolean encontro = false;
		int i = 0;
		Edge arco = new Edge(node1, node2);
		
		if ( estaN1 && estaN2 ) {
			while( i < arcos.size() && !encontro ) {
				if ( arcos.get(i).getN1() == node1 && arcos.get(i).getN2() == node2 ) {
					encontro = true;
					logger.warning("El arco del nodo " + node1 + " al nodo " + node2 + " ya pertenece al grafo.");	
				}
				i++;
			}
			if ( !encontro ) {
				arcos.add(arco);
				logger.info("Se agregó un arco del nodo " + node1 + " al nodo " + node2 + "." );
			}	
		}
		else {
			if ( !estaN1 && estaN2 )
				logger.warning("El nodo " + node1 + " no pertenece al grafo.");
			else {
				if ( estaN1 && !estaN2 )
					logger.warning("El nodo " + node2 + " no pertenece al grafo.");
				else
					logger.warning("Los nodos " + node1 + " y " + node2 + " no pertenecen al grafo.");
			}
		}
		
	}

	public void removeNode(int node) {
		
		boolean estaN = nodos.contains(node);
		int index;
		Edge arco;
		
		if ( estaN ) {
			index = nodos.indexOf(node);
			nodos.remove(index);
			for ( int i = arcos.size()-1; i >= 0; i-- ) {
				arco = arcos.get(i);
				if ( arco.getN1() == node || arco.getN2() == node ) {
					arcos.remove(arco);
				}				
			}
			logger.info("Se eliminó el nodo " + node + " y todos sus arcos incidentes y emergentes.");
		}
		else {
			logger.warning("El nodo " + node + " no pertenece al grafo.");
		}
	
	}

	public void removeEdge(int node1, int node2) {

		boolean estaN1 = nodos.contains(node1);
		boolean estaN2 = nodos.contains(node2);
		boolean encontro = false;
		int i = 0;
		
		if ( estaN1 && estaN2 ) {
			while( i < arcos.size() && !encontro ) {
				if ( arcos.get(i).getN1() == node1 && arcos.get(i).getN2() == node2 ) {
					encontro = true;
					arcos.remove(i);
					logger.info("Se eliminó el arco del nodo " + node1 + " al nodo " + node2 + ".");
				}
				i++;
			}
			if ( !encontro )
				logger.warning("El arco del nodo " + node1 + " al nodo " + node2 + " no pertenece al grafo.");
		}
		else {
			if ( !estaN1 && estaN2 )
				logger.warning("El nodo " + node1 + " no pertenece al grafo.");
			else {
				if ( estaN1 && !estaN2 )
					logger.warning("El nodo " + node2 + " no pertenece al grafo.");
				else
					logger.warning("Los nodos " + node1 + " y " + node2 + " no pertenecen al grafo.");
			}
		}
		
	}

}
