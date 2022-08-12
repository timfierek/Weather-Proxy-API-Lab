package co.grandcircus.WeatherProxyApi.model;

public class ProxyPeriod extends PeriodForecast{

	private int temperatureCelcius;

	public int getTemperatureCelcius() {
		return temperatureCelcius;
	}

	public void setTemperatureCelcius(int temperatureCelcius) {
		this.temperatureCelcius = temperatureCelcius;
	}
}
