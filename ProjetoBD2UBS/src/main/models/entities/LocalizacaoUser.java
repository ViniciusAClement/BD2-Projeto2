package main.models.entities;

public class LocalizacaoUser {
	public String country;
    public String regionName;
    public String city;
    public String rua;
    public String bairro;
    public String lat;
    public String lon;
    
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Double getLat() {
		String teste = lat;
		teste.replace(",", ".");
		Double formatado = Double.parseDouble(lat);
		return formatado;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public Double getLon() {
		String teste = lon;
		teste.replace(",", ".");
		Double formatado = Double.parseDouble(lon);
		return formatado;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	@Override
	public String toString() {
		return "LocalizacaoUser [country=" + country + ", regionName=" + regionName + ", city=" + city + ", rua=" + rua + ", bairro=" + bairro + ", lat=" + lat + ", lon=" + lon + "]";
	}
	
	
    
    
}
