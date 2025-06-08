package main.models.entities;

public class UbsDistancia {
	private Ubs ubs;
	private Double distancia;
	
	
	public Ubs getUbs() {
		return ubs;
	}
	public void setUbs(Ubs ubs) {
		this.ubs = ubs;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	@Override
	public String toString() {
		return "UbsDistancia [ubs=" + ubs + ", distancia=" + distancia + "]";
	}
}
