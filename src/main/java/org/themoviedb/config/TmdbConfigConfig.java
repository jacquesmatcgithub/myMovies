package org.themoviedb.config;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TmdbConfigConfig {

	@JsonProperty("images")
	private TmdbConfigImages tmdbConfigImages;

	@JsonProperty("change_keys")
	private List<String> changeKeys;

	public void setTmdbConfigImages(TmdbConfigImages tmdbConfigImages){
		this.tmdbConfigImages = tmdbConfigImages;
	}

	public TmdbConfigImages getTmdbConfigImages(){
		return tmdbConfigImages;
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
			"TmdbConfigConfig{" +
			"tmdbConfigImages = '" + tmdbConfigImages + '\'' +
			",change_keys = '" + changeKeys + '\'' + 
			"}";
		}
}