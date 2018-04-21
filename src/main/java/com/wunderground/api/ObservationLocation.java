package com.wunderground.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ObservationLocation{

	@JsonProperty("elevation")
	private String elevation;

	@JsonProperty("country")
	private String country;

	@JsonProperty("country_iso3166")
	private String countryIso3166;

	@JsonProperty("city")
	private String city;

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("state")
	private String state;

	@JsonProperty("full")
	private String full;

	@JsonProperty("longitude")
	private String longitude;

	public void setElevation(String elevation){
		this.elevation = elevation;
	}

	public String getElevation(){
		return elevation;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCountryIso3166(String countryIso3166){
		this.countryIso3166 = countryIso3166;
	}

	public String getCountryIso3166(){
		return countryIso3166;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setFull(String full){
		this.full = full;
	}

	public String getFull(){
		return full;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"ObservationLocation{" + 
			"elevation = '" + elevation + '\'' + 
			",country = '" + country + '\'' + 
			",country_iso3166 = '" + countryIso3166 + '\'' + 
			",city = '" + city + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",state = '" + state + '\'' + 
			",full = '" + full + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}