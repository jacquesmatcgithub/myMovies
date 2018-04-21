package com.wunderground.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class WeatherResponse{

	@JsonProperty("response")
	private Response response;

	@JsonProperty("current_observation")
	private CurrentObservation currentObservation;

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setCurrentObservation(CurrentObservation currentObservation){
		this.currentObservation = currentObservation;
	}

	public CurrentObservation getCurrentObservation(){
		return currentObservation;
	}

	@Override
 	public String toString(){
		return 
			"WeatherResponse{" + 
			"response = '" + response + '\'' + 
			",current_observation = '" + currentObservation + '\'' + 
			"}";
		}
}