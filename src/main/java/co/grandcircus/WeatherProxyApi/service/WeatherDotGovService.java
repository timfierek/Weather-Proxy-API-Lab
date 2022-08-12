package co.grandcircus.WeatherProxyApi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.WeatherProxyApi.model.ForecastResponse;
import co.grandcircus.WeatherProxyApi.model.GridPointResponse;
import co.grandcircus.WeatherProxyApi.model.PeriodForecast;
import co.grandcircus.WeatherProxyApi.model.ProxyForecast;
import co.grandcircus.WeatherProxyApi.model.ProxyPeriod;

@Service
public class WeatherDotGovService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public List<PeriodForecast> getPeriodForecast(String lat, String lon) {
		String coords = lat + "," + lon;
		String gridPointUrl = "https://api.weather.gov/points/" + coords;
		GridPointResponse gridPointInfo = restTemplate.getForObject(gridPointUrl, GridPointResponse.class);
		
		String forecastUrl = gridPointInfo.getProperties().getForecast();
		
		ForecastResponse forecast = restTemplate.getForObject(forecastUrl, ForecastResponse.class);
		
		return forecast.getProperties().getPeriods();
	}
	
	public List<ProxyPeriod> getExtendedPeriodForecast(String lat, String lon) {
		String coords = lat + "," + lon;
		String gridPointUrl = "https://api.weather.gov/points/" + coords;
		GridPointResponse gridPointInfo = restTemplate.getForObject(gridPointUrl, GridPointResponse.class);
		
		String forecastUrl = gridPointInfo.getProperties().getForecast();
		
		ProxyForecast forecast = restTemplate.getForObject(forecastUrl, ProxyForecast.class);
		
		List<ProxyPeriod> periods = forecast.getProperties().getPeriods();
		
		return periods;
	}
	
//	private List<PeriodForecast> getForecasts(String forecastUrl){
//		ForecastResponse forecast = restTemplate.getForObject(forecastUrl, ForecastResponse.class);
//		
//		return forecast.getProperties().getPeriods();
//	}
	
}
