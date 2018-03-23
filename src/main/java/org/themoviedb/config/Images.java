package org.themoviedb.config;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Images{

	@JsonProperty("poster_sizes")
	private List<String> posterSizes;

	@JsonProperty("secure_base_url")
	private String secureBaseUrl;

	@JsonProperty("backdrop_sizes")
	private List<String> backdropSizes;

	@JsonProperty("base_url")
	private String baseUrl;

	@JsonProperty("logo_sizes")
	private List<String> logoSizes;

	@JsonProperty("still_sizes")
	private List<String> stillSizes;

	@JsonProperty("profile_sizes")
	private List<String> profileSizes;

	public void setPosterSizes(List<String> posterSizes){
		this.posterSizes = posterSizes;
	}

	public List<String> getPosterSizes(){
		return posterSizes;
	}

	public void setSecureBaseUrl(String secureBaseUrl){
		this.secureBaseUrl = secureBaseUrl;
	}

	public String getSecureBaseUrl(){
		return secureBaseUrl;
	}

	public void setBackdropSizes(List<String> backdropSizes){
		this.backdropSizes = backdropSizes;
	}

	public List<String> getBackdropSizes(){
		return backdropSizes;
	}

	public void setBaseUrl(String baseUrl){
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl(){
		return baseUrl;
	}

	public void setLogoSizes(List<String> logoSizes){
		this.logoSizes = logoSizes;
	}

	public List<String> getLogoSizes(){
		return logoSizes;
	}

	public void setStillSizes(List<String> stillSizes){
		this.stillSizes = stillSizes;
	}

	public List<String> getStillSizes(){
		return stillSizes;
	}

	public void setProfileSizes(List<String> profileSizes){
		this.profileSizes = profileSizes;
	}

	public List<String> getProfileSizes(){
		return profileSizes;
	}

	@Override
 	public String toString(){
		return 
			"Images{" + 
			"poster_sizes = '" + posterSizes + '\'' + 
			",secure_base_url = '" + secureBaseUrl + '\'' + 
			",backdrop_sizes = '" + backdropSizes + '\'' + 
			",base_url = '" + baseUrl + '\'' + 
			",logo_sizes = '" + logoSizes + '\'' + 
			",still_sizes = '" + stillSizes + '\'' + 
			",profile_sizes = '" + profileSizes + '\'' + 
			"}";
		}
}