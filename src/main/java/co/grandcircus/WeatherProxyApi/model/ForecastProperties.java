package co.grandcircus.WeatherProxyApi.model;

import java.util.List;

public class ForecastProperties {
	private List<PeriodForecast> periods;

	public List<PeriodForecast> getPeriods() {
		return periods;
	}

	public void setPeriods(List<PeriodForecast> periods) {
		this.periods = periods;
	}
}
