package org.themoviedb.config;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Config{

	@JsonProperty("images")
	private Images images;

	@JsonProperty("change_keys")
	private List<String> changeKeys;

	public void setImages(Images images){
		this.images = images;
	}

	public Images getImages(){
		return images;
	}

	public void setChangeKeys(List<String> changeKeys){
		this.changeKeys = changeKeys;
	}

	public List<String> getChangeKeys(){
		return changeKeys;
	}

	@Override
 	public String toString(){
		return 
			"Config{" + 
			"images = '" + images + '\'' + 
			",change_keys = '" + changeKeys + '\'' + 
			"}";
		}
}