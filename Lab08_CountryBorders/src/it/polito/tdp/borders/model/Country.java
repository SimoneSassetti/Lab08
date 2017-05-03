package it.polito.tdp.borders.model;

import java.util.*;

public class Country {
	private String abbr;
	private int codice;
	private String nomeStato;
	
	private List<Country> listaConfinanti;
	
	public Country(String abbr, int codice, String nomeStato) {
		super();
		this.abbr = abbr;
		this.codice = codice;
		this.nomeStato = nomeStato;
		listaConfinanti=new ArrayList<Country>();
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getNomeStato() {
		return nomeStato;
	}
	public void setNomeStato(String nomeStato) {
		this.nomeStato = nomeStato;
	}
	public void setConfinanti(List<Country> confinanti){
		listaConfinanti.addAll(confinanti);
	}
	public int numConfinanti(){
		return listaConfinanti.size();
	}
	@Override
	public String toString() {
		return nomeStato;
	}	
}
