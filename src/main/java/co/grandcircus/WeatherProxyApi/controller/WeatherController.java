package co.grandcircus.WeatherProxyApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.WeatherProxyApi.model.PeriodForecast;
import co.grandcircus.WeatherProxyApi.model.ProxyPeriod;
import co.grandcircus.WeatherProxyApi.model.ProxyResponse;
import co.grandcircus.WeatherProxyApi.model.Stats;
import co.grandcircus.WeatherProxyApi.service.WeatherDotGovService;

@RestController
public class WeatherController {
	@Autowired
	WeatherDotGovService weatherApiService;
	
	@GetMapping("/forecast")
	public List<PeriodForecast> getPeriodForecasts(@RequestParam String lat, @RequestParam String lon) { 
		return weatherApiService.getPeriodForecast(lat, lon);
	}
	
	@GetMapping("/forecast/plus")
	public ProxyResponse getExtendedForecast(@RequestParam String lat, @RequestParam String lon) {
		ProxyResponse response = new ProxyResponse();
		Stats stats = new Stats();
		response.setPeriods(weatherApiService.getExtendedPeriodForecast(lat, lon));
		
		double totalTemp = 0;
		ProxyPeriod hottest = response.getPeriods().get(0);
		ProxyPeriod coldest = response.getPeriods().get(0);
		
		for(ProxyPeriod p : response.getPeriods()) {
			totalTemp += p.getTemperature();
			
			// Check if current period is hottest or coldest
			if(p.getTemperature() > hottest.getTemperature()) {
				hottest = p;
			}
			if(p.getTemperature() < coldest.getTemperature()) {
				coldest = p;
			}
			
			// Set Celcius temp field
			double temp = p.getTemperature();
			temp = (temp - 32) * (5.0/9.0);
			temp = Math.round(temp);
			p.setTemperatureCelcius((int)temp);
		}
		
		// Calculate average temp
		double avgTemp = Math.round(totalTemp / response.getPeriods().size());
		
		stats.setAverageTemperature((int)avgTemp);
		stats.setHottestPeriod(hottest);
		stats.setColdestPeriod(coldest);
		
		response.setStats(stats);
		
		return response;
		
	}
}
