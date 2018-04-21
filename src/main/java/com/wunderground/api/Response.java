package com.wunderground.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("features")
	private Features features;

	@JsonProperty("version")
	private String version;

	@JsonProperty("termsofService")
	private String termsofService;

	public void setFeatures(Features features){
		this.features = features;
	}

	public Features getFeatures(){
		return features;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	public void setTermsofService(String termsofService){
		this.termsofService = termsofService;
	}

	public String getTermsofService(){
		return termsofService;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"features = '" + features + '\'' + 
			",version = '" + version + '\'' + 
			",termsofService = '" + termsofService + '\'' + 
			"}";
		}
}