package org.themoviedb.query;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class TmdbQueryResults {

	@JsonProperty("original_language")
	private String originalLanguage;

	@JsonProperty("imdb_id")
	private String imdbId;

	@JsonProperty("video")
	private boolean video;

	@JsonProperty("title")
	private String title;

	@JsonProperty("backdrop_path")
	private String backdropPath;

	@JsonProperty("revenue")
	private int revenue;

	@JsonProperty("genres")
	private List<TmdbQueryGenresItem> genres;

	@JsonProperty("popularity")
	private double popularity;

	@JsonProperty("production_countries")
	private List<TmdbQueryProductionCountriesItem> productionCountries;

	@JsonProperty("id")
	private int id;

	@JsonProperty("vote_count")
	private int voteCount;

	@JsonProperty("budget")
	private int budget;

	@JsonProperty("overview")
	private String overview;

	@JsonProperty("original_title")
	private String originalTitle;

	@JsonProperty("runtime")
	private int runtime;

	@JsonProperty("poster_path")
	private String posterPath;

	@JsonProperty("spoken_languages")
	private List<TmdbQuerySpokenLanguagesItem> spokenLanguages;

	@JsonProperty("production_companies")
	private List<TmdbQueryProductionCompaniesItem> productionCompanies;

	@JsonProperty("release_date")
	private String releaseDate;

	@JsonProperty("vote_average")
	private double voteAverage;

	@JsonProperty("belongs_to_collection")
	private TmdbQueryBelongsToCollection tmdbQueryBelongsToCollection;

	@JsonProperty("tagline")
	private String tagline;

	@JsonProperty("adult")
	private boolean adult;

	@JsonProperty("homepage")
	private String homepage;

	@JsonProperty("status")
	private String status;

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setImdbId(String imdbId){
		this.imdbId = imdbId;
	}

	public String getImdbId(){
		return imdbId;
	}

	public void setVideo(boolean video){
		this.video = video;
	}

	public boolean isVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBackdropPath(String backdropPath){
		this.backdropPath = backdropPath;
	}

	public String getBackdropPath(){
		return backdropPath;
	}

	public void setRevenue(int revenue){
		this.revenue = revenue;
	}

	public int getRevenue(){
		return revenue;
	}

	public void setGenres(List<TmdbQueryGenresItem> genres){
		this.genres = genres;
	}

	public List<TmdbQueryGenresItem> getGenres(){
		return genres;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setProductionCountries(List<TmdbQueryProductionCountriesItem> productionCountries){
		this.productionCountries = productionCountries;
	}

	public List<TmdbQueryProductionCountriesItem> getProductionCountries(){
		return productionCountries;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	public void setBudget(int budget){
		this.budget = budget;
	}

	public int getBudget(){
		return budget;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setRuntime(int runtime){
		this.runtime = runtime;
	}

	public int getRuntime(){
		return runtime;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}

	public void setSpokenLanguages(List<TmdbQuerySpokenLanguagesItem> spokenLanguages){
		this.spokenLanguages = spokenLanguages;
	}

	public List<TmdbQuerySpokenLanguagesItem> getSpokenLanguages(){
		return spokenLanguages;
	}

	public void setProductionCompanies(List<TmdbQueryProductionCompaniesItem> productionCompanies){
		this.productionCompanies = productionCompanies;
	}

	public List<TmdbQueryProductionCompaniesItem> getProductionCompanies(){
		return productionCompanies;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setVoteAverage(double voteAverage){
		this.voteAverage = voteAverage;
	}

	public double getVoteAverage(){
		return voteAverage;
	}

	public void setTmdbQueryBelongsToCollection(TmdbQueryBelongsToCollection tmdbQueryBelongsToCollection){
		this.tmdbQueryBelongsToCollection = tmdbQueryBelongsToCollection;
	}

	public TmdbQueryBelongsToCollection getTmdbQueryBelongsToCollection(){
		return tmdbQueryBelongsToCollection;
	}

	public void setTagline(String tagline){
		this.tagline = tagline;
	}

	public String getTagline(){
		return tagline;
	}

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	public void setHomepage(String homepage){
		this.homepage = homepage;
	}

	public String getHomepage(){
		return homepage;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"TmdbQueryResults{" +
			"original_language = '" + originalLanguage + '\'' + 
			",imdb_id = '" + imdbId + '\'' + 
			",video = '" + video + '\'' + 
			",title = '" + title + '\'' + 
			",backdrop_path = '" + backdropPath + '\'' + 
			",revenue = '" + revenue + '\'' + 
			",genres = '" + genres + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",production_countries = '" + productionCountries + '\'' + 
			",id = '" + id + '\'' + 
			",vote_count = '" + voteCount + '\'' + 
			",budget = '" + budget + '\'' + 
			",overview = '" + overview + '\'' + 
			",original_title = '" + originalTitle + '\'' + 
			",runtime = '" + runtime + '\'' + 
			",poster_path = '" + posterPath + '\'' + 
			",spoken_languages = '" + spokenLanguages + '\'' + 
			",production_companies = '" + productionCompanies + '\'' + 
			",release_date = '" + releaseDate + '\'' + 
			",vote_average = '" + voteAverage + '\'' + 
			",belongs_to_collection = '" + tmdbQueryBelongsToCollection + '\'' +
			",tagline = '" + tagline + '\'' + 
			",adult = '" + adult + '\'' + 
			",homepage = '" + homepage + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}