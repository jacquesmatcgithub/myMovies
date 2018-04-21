package com.wunderground.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Features{

	@JsonProperty("conditions")
	private int conditions;

	public void setConditions(int conditions){
		this.conditions = conditions;
	}

	public int getConditions(){
		return conditions;
	}

	@Override
 	public String toString(){
		return 
			"Features{" + 
			"conditions = '" + conditions + '\'' + 
			"}";
		}
}