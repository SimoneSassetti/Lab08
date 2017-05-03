package it.polito.tdp.borders.model;

public class Border {
	private int codPaese1;
	private int codPaese2;
	public Border(int codPaese1, int codPaese2) {
		super();
		this.codPaese1 = codPaese1;
		this.codPaese2 = codPaese2;
	}
	public int getCodPaese1() {
		return codPaese1;
	}
	public void setCodPaese1(int codPaese1) {
		this.codPaese1 = codPaese1;
	}
	public int getCodPaese2() {
		return codPaese2;
	}
	public void setCodPaese2(int codPaese2) {
		this.codPaese2 = codPaese2;
	}
}
