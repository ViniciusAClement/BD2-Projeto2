package main.models.entities;

public class LocalizacaoUser {
	public String country;
    public String regionName;
    public String city;
    public String isp;
    public String query;
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
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	@Override
	public String toString() {
		return "LocalizacaoUser [country=" + country + ", regionName=" + regionName + ", city=" + city + ", isp=" + isp
				+ ", query=" + query + ", latitude=" + lat + ", longitude=" + lon + "]";
	}
	
    
    
}
