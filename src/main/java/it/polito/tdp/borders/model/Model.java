package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	BordersDAO dao = new BordersDAO();
	
	SimpleGraph<Country, DefaultEdge> grafo;
	
	List<Country> countries;
	
	public Model() {
		
	}
	
	public void creaGrafo(int anno) {
		grafo = new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
		// countries = dao.getCountryByYears(anno);

		for (Border b : dao.getCountryPairs(anno)) {
			grafo.addVertex(b.getC1());
			grafo.addVertex(b.getC2());
			grafo.addEdge(b.getC1(), b.getC2());
			aggiornaDegree();
		}
		countries = new ArrayList<>(grafo.vertexSet());
		
		System.out.println("ARCHI: ");
		System.out.println(grafo.edgeSet());
		System.out.println("\nVERTICI e grado: ");
		System.out.println(this.getV());
		System.out.println("NUM VERTICI:" + grafo.vertexSet().size());
		System.out.println("NUM ARCHI:" + grafo.edgeSet().size());
		System.out.println("NUM COMP CONNESSE:" + this.getNumberOfConnectedComponents());
	}
		
	public String getV() {
		String s = "";
		for (Country c : grafo.vertexSet()) {
			s += c.getNomeDegree();
		}
		return s;
	}

	public void aggiornaDegree() {
		for (Country c : grafo.vertexSet()) {
			c.setDegree(grafo.degreeOf(c));
		}
	}

	public int getNumberOfConnectedComponents() {
		if (grafo == null) {
			throw new RuntimeException("Grafo non esistente");
		}

		ConnectivityInspector<Country, DefaultEdge> ci = new ConnectivityInspector<Country, DefaultEdge>(grafo);
		return ci.connectedSets().size();
	}

	public List<Country> getCountries() {
		return countries;
	}
	
	public List<Country> doIteratore(Country start) {
		
		List<Country> result = new ArrayList<Country>();
		
		DepthFirstIterator<Country, DefaultEdge> it = new DepthFirstIterator<Country, DefaultEdge>(this.grafo, start);
		
		while(it.hasNext()) {
			result.add(it.next());
		}
		
		return result;
	}
	
}


