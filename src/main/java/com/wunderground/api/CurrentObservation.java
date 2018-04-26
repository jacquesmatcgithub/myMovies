package com.wunderground.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CurrentObservation{

	@JsonProperty("nowcast")
	private String nowcast;

	@JsonProperty("temp_c")
	private double tempC;

	@JsonProperty("observation_epoch")
	private String observationEpoch;

	@JsonProperty("temp_f")
	private double tempF;

	@JsonProperty("wind_kph")
	private double windKph;

	@JsonProperty("wind_mph")
	private double windMph;

	@JsonProperty("wind_degrees")
	private int windDegrees;

	@JsonProperty("temperature_string")
	private String temperatureString;

	@JsonProperty("weather")
	private String weather;

	@JsonProperty("feelslike_string")
	private String feelslikeString;

	@JsonProperty("precip_today_metric")
	private String precipTodayMetric;

	@JsonProperty("precip_1hr_string")
	private String precip1hrString;

	@JsonProperty("icon_url")
	private String iconUrl;

	@JsonProperty("image")
	private Image image;

	@JsonProperty("UV")
	private String uV;

	@JsonProperty("station_id")
	private String stationId;

	@JsonProperty("local_epoch")
	private String localEpoch;

	@JsonProperty("local_tz_short")
	private String localTzShort;

	@JsonProperty("wind_dir")
	private String windDir;

	@JsonProperty("precip_1hr_metric")
	private String precip1hrMetric;

	@JsonProperty("pressure_in")
	private String pressureIn;

	@JsonProperty("local_tz_long")
	private String localTzLong;

	@JsonProperty("wind_gust_mph")
	private String windGustMph;
//	private int windGustMph;

	@JsonProperty("windchill_string")
	private String windchillString;

	@JsonProperty("wind_gust_kph")
	private String windGustKph;
//	private int windGustKph;

	@JsonProperty("wind_string")
	private String windString;

	@JsonProperty("local_time_rfc822")
	private String localTimeRfc822;

	@JsonProperty("visibility_km")
	private String visibilityKm;

	@JsonProperty("relative_humidity")
	private String relativeHumidity;

	@JsonProperty("pressure_mb")
	private String pressureMb;

	@JsonProperty("observation_time_rfc822")
	private String observationTimeRfc822;

	@JsonProperty("precip_1hr_in")
	private String precip1hrIn;

	@JsonProperty("feelslike_c")
	private String feelslikeC;

	@JsonProperty("observation_time")
	private String observationTime;

	@JsonProperty("feelslike_f")
	private String feelslikeF;

	@JsonProperty("history_url")
	private String historyUrl;

	@JsonProperty("windchill_f")
	private String windchillF;

	@JsonProperty("windchill_c")
	private String windchillC;

	@JsonProperty("precip_today_string")
	private String precipTodayString;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("precip_today_in")
	private String precipTodayIn;

	@JsonProperty("solarradiation")
	private String solarradiation;

	@JsonProperty("observation_location")
	private ObservationLocation observationLocation;

	@JsonProperty("dewpoint_f")
	private int dewpointF;

	@JsonProperty("display_location")
	private DisplayLocation displayLocation;

	@JsonProperty("dewpoint_string")
	private String dewpointString;

	@JsonProperty("pressure_trend")
	private String pressureTrend;

	@JsonProperty("dewpoint_c")
	private int dewpointC;

	@JsonProperty("estimated")
	private Estimated estimated;

	@JsonProperty("forecast_url")
	private String forecastUrl;

	@JsonProperty("local_tz_offset")
	private String localTzOffset;

	@JsonProperty("heat_index_f")
	private String heatIndexF;

	@JsonProperty("heat_index_c")
	private String heatIndexC;

	@JsonProperty("ob_url")
	private String obUrl;

	@JsonProperty("heat_index_string")
	private String heatIndexString;

	@JsonProperty("visibility_mi")
	private String visibilityMi;

	public void setNowcast(String nowcast){
		this.nowcast = nowcast;
	}

	public String getNowcast(){
		return nowcast;
	}

	public void setTempC(double tempC){
		this.tempC = tempC;
	}

	public double getTempC(){
		return tempC;
	}

	public void setObservationEpoch(String observationEpoch){
		this.observationEpoch = observationEpoch;
	}

	public String getObservationEpoch(){
		return observationEpoch;
	}

	public void setTempF(double tempF){
		this.tempF = tempF;
	}

	public double getTempF(){
		return tempF;
	}

	public void setWindKph(double windKph){
		this.windKph = windKph;
	}

	public double getWindKph(){
		return windKph;
	}

	public void setWindMph(double windMph){
		this.windMph = windMph;
	}

	public double getWindMph(){
		return windMph;
	}

	public void setWindDegrees(int windDegrees){
		this.windDegrees = windDegrees;
	}

	public int getWindDegrees(){
		return windDegrees;
	}

	public void setTemperatureString(String temperatureString){
		this.temperatureString = temperatureString;
	}

	public String getTemperatureString(){
		return temperatureString;
	}

	public void setWeather(String weather){
		this.weather = weather;
	}

	public String getWeather(){
		return weather;
	}

	public void setFeelslikeString(String feelslikeString){
		this.feelslikeString = feelslikeString;
	}

	public String getFeelslikeString(){
		return feelslikeString;
	}

	public void setPrecipTodayMetric(String precipTodayMetric){
		this.precipTodayMetric = precipTodayMetric;
	}

	public String getPrecipTodayMetric(){
		return precipTodayMetric;
	}

	public void setPrecip1hrString(String precip1hrString){
		this.precip1hrString = precip1hrString;
	}

	public String getPrecip1hrString(){
		return precip1hrString;
	}

	public void setIconUrl(String iconUrl){
		this.iconUrl = iconUrl;
	}

	public String getIconUrl(){
		return iconUrl;
	}

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setUV(String uV){
		this.uV = uV;
	}

	public String getUV(){
		return uV;
	}

	public void setStationId(String stationId){
		this.stationId = stationId;
	}

	public String getStationId(){
		return stationId;
	}

	public void setLocalEpoch(String localEpoch){
		this.localEpoch = localEpoch;
	}

	public String getLocalEpoch(){
		return localEpoch;
	}

	public void setLocalTzShort(String localTzShort){
		this.localTzShort = localTzShort;
	}

	public String getLocalTzShort(){
		return localTzShort;
	}

	public void setWindDir(String windDir){
		this.windDir = windDir;
	}

	public String getWindDir(){
		return windDir;
	}

	public void setPrecip1hrMetric(String precip1hrMetric){
		this.precip1hrMetric = precip1hrMetric;
	}

	public String getPrecip1hrMetric(){
		return precip1hrMetric;
	}

	public void setPressureIn(String pressureIn){
		this.pressureIn = pressureIn;
	}

	public String getPressureIn(){
		return pressureIn;
	}

	public void setLocalTzLong(String localTzLong){
		this.localTzLong = localTzLong;
	}

	public String getLocalTzLong(){
		return localTzLong;
	}

	public void setWindGustMph(String windGustMph){
		this.windGustMph = windGustMph;
	}

	public String getWindGustMph(){
		return windGustMph;
	}

	public void setWindchillString(String windchillString){
		this.windchillString = windchillString;
	}

	public String getWindchillString(){
		return windchillString;
	}

	public void setWindGustKph(String windGustKph){
		this.windGustKph = windGustKph;
	}

	public String getWindGustKph(){
		return windGustKph;
	}

	public void setWindString(String windString){
		this.windString = windString;
	}

	public String getWindString(){
		return windString;
	}

	public void setLocalTimeRfc822(String localTimeRfc822){
		this.localTimeRfc822 = localTimeRfc822;
	}

	public String getLocalTimeRfc822(){
		return localTimeRfc822;
	}

	public void setVisibilityKm(String visibilityKm){
		this.visibilityKm = visibilityKm;
	}

	public String getVisibilityKm(){
		return visibilityKm;
	}

	public void setRelativeHumidity(String relativeHumidity){
		this.relativeHumidity = relativeHumidity;
	}

	public String getRelativeHumidity(){
		return relativeHumidity;
	}

	public void setPressureMb(String pressureMb){
		this.pressureMb = pressureMb;
	}

	public String getPressureMb(){
		return pressureMb;
	}

	public void setObservationTimeRfc822(String observationTimeRfc822){
		this.observationTimeRfc822 = observationTimeRfc822;
	}

	public String getObservationTimeRfc822(){
		return observationTimeRfc822;
	}

	public void setPrecip1hrIn(String precip1hrIn){
		this.precip1hrIn = precip1hrIn;
	}

	public String getPrecip1hrIn(){
		return precip1hrIn;
	}

	public void setFeelslikeC(String feelslikeC){
		this.feelslikeC = feelslikeC;
	}

	public String getFeelslikeC(){
		return feelslikeC;
	}

	public void setObservationTime(String observationTime){
		this.observationTime = observationTime;
	}

	public String getObservationTime(){
		return observationTime;
	}

	public void setFeelslikeF(String feelslikeF){
		this.feelslikeF = feelslikeF;
	}

	public String getFeelslikeF(){
		return feelslikeF;
	}

	public void setHistoryUrl(String historyUrl){
		this.historyUrl = historyUrl;
	}

	public String getHistoryUrl(){
		return historyUrl;
	}

	public void setWindchillF(String windchillF){
		this.windchillF = windchillF;
	}

	public String getWindchillF(){
		return windchillF;
	}

	public void setWindchillC(String windchillC){
		this.windchillC = windchillC;
	}

	public String getWindchillC(){
		return windchillC;
	}

	public void setPrecipTodayString(String precipTodayString){
		this.precipTodayString = precipTodayString;
	}

	public String getPrecipTodayString(){
		return precipTodayString;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setPrecipTodayIn(String precipTodayIn){
		this.precipTodayIn = precipTodayIn;
	}

	public String getPrecipTodayIn(){
		return precipTodayIn;
	}

	public void setSolarradiation(String solarradiation){
		this.solarradiation = solarradiation;
	}

	public String getSolarradiation(){
		return solarradiation;
	}

	public void setObservationLocation(ObservationLocation observationLocation){
		this.observationLocation = observationLocation;
	}

	public ObservationLocation getObservationLocation(){
		return observationLocation;
	}

	public void setDewpointF(int dewpointF){
		this.dewpointF = dewpointF;
	}

	public int getDewpointF(){
		return dewpointF;
	}

	public void setDisplayLocation(DisplayLocation displayLocation){
		this.displayLocation = displayLocation;
	}

	public DisplayLocation getDisplayLocation(){
		return displayLocation;
	}

	public void setDewpointString(String dewpointString){
		this.dewpointString = dewpointString;
	}

	public String getDewpointString(){
		return dewpointString;
	}

	public void setPressureTrend(String pressureTrend){
		this.pressureTrend = pressureTrend;
	}

	public String getPressureTrend(){
		return pressureTrend;
	}

	public void setDewpointC(int dewpointC){
		this.dewpointC = dewpointC;
	}

	public int getDewpointC(){
		return dewpointC;
	}

	public void setEstimated(Estimated estimated){
		this.estimated = estimated;
	}

	public Estimated getEstimated(){
		return estimated;
	}

	public void setForecastUrl(String forecastUrl){
		this.forecastUrl = forecastUrl;
	}

	public String getForecastUrl(){
		return forecastUrl;
	}

	public void setLocalTzOffset(String localTzOffset){
		this.localTzOffset = localTzOffset;
	}

	public String getLocalTzOffset(){
		return localTzOffset;
	}

	public void setHeatIndexF(String heatIndexF){
		this.heatIndexF = heatIndexF;
	}

	public String getHeatIndexF(){
		return heatIndexF;
	}

	public void setHeatIndexC(String heatIndexC){
		this.heatIndexC = heatIndexC;
	}

	public String getHeatIndexC(){
		return heatIndexC;
	}

	public void setObUrl(String obUrl){
		this.obUrl = obUrl;
	}

	public String getObUrl(){
		return obUrl;
	}

	public void setHeatIndexString(String heatIndexString){
		this.heatIndexString = heatIndexString;
	}

	public String getHeatIndexString(){
		return heatIndexString;
	}

	public void setVisibilityMi(String visibilityMi){
		this.visibilityMi = visibilityMi;
	}

	public String getVisibilityMi(){
		return visibilityMi;
	}

	@Override
 	public String toString(){
		return 
			"CurrentObservation{" + 
			"nowcast = '" + nowcast + '\'' + 
			",temp_c = '" + tempC + '\'' + 
			",observation_epoch = '" + observationEpoch + '\'' + 
			",temp_f = '" + tempF + '\'' + 
			",wind_kph = '" + windKph + '\'' + 
			",wind_mph = '" + windMph + '\'' + 
			",wind_degrees = '" + windDegrees + '\'' + 
			",temperature_string = '" + temperatureString + '\'' + 
			",weather = '" + weather + '\'' + 
			",feelslike_string = '" + feelslikeString + '\'' + 
			",precip_today_metric = '" + precipTodayMetric + '\'' + 
			",precip_1hr_string = '" + precip1hrString + '\'' + 
			",icon_url = '" + iconUrl + '\'' + 
			",image = '" + image + '\'' + 
			",uV = '" + uV + '\'' + 
			",station_id = '" + stationId + '\'' + 
			",local_epoch = '" + localEpoch + '\'' + 
			",local_tz_short = '" + localTzShort + '\'' + 
			",wind_dir = '" + windDir + '\'' + 
			",precip_1hr_metric = '" + precip1hrMetric + '\'' + 
			",pressure_in = '" + pressureIn + '\'' + 
			",local_tz_long = '" + localTzLong + '\'' + 
			",wind_gust_mph = '" + windGustMph + '\'' + 
			",windchill_string = '" + windchillString + '\'' + 
			",wind_gust_kph = '" + windGustKph + '\'' + 
			",wind_string = '" + windString + '\'' + 
			",local_time_rfc822 = '" + localTimeRfc822 + '\'' + 
			",visibility_km = '" + visibilityKm + '\'' + 
			",relative_humidity = '" + relativeHumidity + '\'' + 
			",pressure_mb = '" + pressureMb + '\'' + 
			",observation_time_rfc822 = '" + observationTimeRfc822 + '\'' + 
			",precip_1hr_in = '" + precip1hrIn + '\'' + 
			",feelslike_c = '" + feelslikeC + '\'' + 
			",observation_time = '" + observationTime + '\'' + 
			",feelslike_f = '" + feelslikeF + '\'' + 
			",history_url = '" + historyUrl + '\'' + 
			",windchill_f = '" + windchillF + '\'' + 
			",windchill_c = '" + windchillC + '\'' + 
			",precip_today_string = '" + precipTodayString + '\'' + 
			",icon = '" + icon + '\'' + 
			",precip_today_in = '" + precipTodayIn + '\'' + 
			",solarradiation = '" + solarradiation + '\'' + 
			",observation_location = '" + observationLocation + '\'' + 
			",dewpoint_f = '" + dewpointF + '\'' + 
			",display_location = '" + displayLocation + '\'' + 
			",dewpoint_string = '" + dewpointString + '\'' + 
			",pressure_trend = '" + pressureTrend + '\'' + 
			",dewpoint_c = '" + dewpointC + '\'' + 
			",estimated = '" + estimated + '\'' + 
			",forecast_url = '" + forecastUrl + '\'' + 
			",local_tz_offset = '" + localTzOffset + '\'' + 
			",heat_index_f = '" + heatIndexF + '\'' + 
			",heat_index_c = '" + heatIndexC + '\'' + 
			",ob_url = '" + obUrl + '\'' + 
			",heat_index_string = '" + heatIndexString + '\'' + 
			",visibility_mi = '" + visibilityMi + '\'' + 
			"}";
		}
}