package it.polito.tdp.borders.model;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.*;
import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	UndirectedGraph<Country, DefaultEdge> grafo;
	List<Country> totPaesi;
	List<Border> listaBordi;
	public Model(){
		
	}

	public String creaGrafo(int anno) {
		BordersDAO dao=new BordersDAO();
		grafo = new SimpleGraph<Country,  DefaultEdge>(DefaultEdge.class);
		totPaesi=new ArrayList(dao.loadAllCountries());
		listaBordi=new ArrayList<Border>(dao.getCountryPairs(anno));
		
		for(Border b: listaBordi){
			Country c1=this.ricercaCountry(b.getCodPaese1());
			Country c2=this.ricercaCountry(b.getCodPaese2());
			grafo.addVertex(c1);
			grafo.addVertex(c2);
			grafo.addEdge(c1, c2);
		}
		String val="";
		for(Country c: grafo.vertexSet()){
			c.setConfinanti(Graphs.neighborListOf(grafo, c));
			val+=c.getNomeStato()+" numero stati confinanti: "+c.numConfinanti()+"\n";
		}
		ConnectivityInspector<Country, DefaultEdge> ci= new ConnectivityInspector<Country, DefaultEdge>(grafo);
		List<Set<Country>> listaComponentiConnesse=ci.connectedSets();
		val+="\nNumero componenti connesse:\n"+listaComponentiConnesse.size();
		return val;
	}
	
	private Country ricercaCountry(int codice){
		for(Country c: totPaesi){
			if(c.getCodice()==codice){
				return c;
			}
		}
		return null;
	}
}
