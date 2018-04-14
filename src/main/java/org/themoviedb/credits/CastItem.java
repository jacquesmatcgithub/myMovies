package org.themoviedb.credits;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CastItem{

	@JsonProperty("cast_id")
	private int castId;

	@JsonProperty("character")
	private String character;

	@JsonProperty("gender")
	private int gender;

	@JsonProperty("credit_id")
	private String creditId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("profile_path")
	private String profilePath;

	@JsonProperty("id")
	private int id;

	@JsonProperty("order")
	private int order;

	public void setCastId(int castId){
		this.castId = castId;
	}

	public int getCastId(){
		return castId;
	}

	public void setCharacter(String character){
		this.character = character;
	}

	public String getCharacter(){
		return character;
	}

	public void setGender(int gender){
		this.gender = gender;
	}

	public int getGender(){
		return gender;
	}

	public void setCreditId(String creditId){
		this.creditId = creditId;
	}

	public String getCreditId(){
		return creditId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProfilePath(String profilePath){
		this.profilePath = profilePath;
	}

	public String getProfilePath(){
		return profilePath;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}

	@Override
 	public String toString(){
		return 
			"CastItem{" + 
			"cast_id = '" + castId + '\'' + 
			",character = '" + character + '\'' + 
			",gender = '" + gender + '\'' + 
			",credit_id = '" + creditId + '\'' + 
			",name = '" + name + '\'' + 
			",profile_path = '" + profilePath + '\'' + 
			",id = '" + id + '\'' + 
			",order = '" + order + '\'' + 
			"}";
		}
}