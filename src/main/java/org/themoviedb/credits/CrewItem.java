package org.themoviedb.credits;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CrewItem{

	@JsonProperty("gender")
	private int gender;

	@JsonProperty("credit_id")
	private String creditId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("profile_path")
	private Object profilePath;

	@JsonProperty("id")
	private int id;

	@JsonProperty("department")
	private String department;

	@JsonProperty("job")
	private String job;

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

	public void setProfilePath(Object profilePath){
		this.profilePath = profilePath;
	}

	public Object getProfilePath(){
		return profilePath;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDepartment(String department){
		this.department = department;
	}

	public String getDepartment(){
		return department;
	}

	public void setJob(String job){
		this.job = job;
	}

	public String getJob(){
		return job;
	}

	@Override
 	public String toString(){
		return 
			"CrewItem{" + 
			"gender = '" + gender + '\'' + 
			",credit_id = '" + creditId + '\'' + 
			",name = '" + name + '\'' + 
			",profile_path = '" + profilePath + '\'' + 
			",id = '" + id + '\'' + 
			",department = '" + department + '\'' + 
			",job = '" + job + '\'' + 
			"}";
		}
}