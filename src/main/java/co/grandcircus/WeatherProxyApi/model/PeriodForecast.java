package co.grandcircus.WeatherProxyApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeriodForecast {
	
	@JsonProperty("number")
	private int periodNumber; 
	
	@JsonProperty("name")
	private String periodName;
	
	private String startTime;
	private String endTime;
	private boolean isDaytime;
	private int temperature;
	private String temperatureUnit;
	private String temperatureTrend;
	private String windSpeed;
	private String windDirection;
	
	@JsonProperty("icon")
	private String iconLink;
	
	private String shortForecast;
	private String detailedForecast;
	
	public int getPeriodNumber() {
		return periodNumber;
	}
	public void setPeriodNumber(int periodNumber) {
		this.periodNumber = periodNumber;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isDaytime() {
		return isDaytime;
	}
	public void setDaytime(boolean isDaytime) {
		this.isDaytime = isDaytime;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getTemperatureUnit() {
		return temperatureUnit;
	}
	public void setTemperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}
	public String getTemperatureTrend() {
		return temperatureTrend;
	}
	public void setTemperatureTrend(String temperatureTrend) {
		this.temperatureTrend = temperatureTrend;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public String getIconLink() {
		return iconLink;
	}
	public void setIconLink(String iconLink) {
		this.iconLink = iconLink;
	}
	public String getShortForecast() {
		return shortForecast;
	}
	public void setShortForecast(String shortForecast) {
		this.shortForecast = shortForecast;
	}
	public String getDetailedForecast() {
		return detailedForecast;
	}
	public void setDetailedForecast(String detailedForecast) {
		this.detailedForecast = detailedForecast;
	}
}
