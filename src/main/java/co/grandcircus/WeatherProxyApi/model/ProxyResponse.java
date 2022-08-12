package co.grandcircus.WeatherProxyApi.model;

import java.util.List;

public class ProxyResponse {
	private List<ProxyPeriod> periods;
	private Stats stats;
	
	public List<ProxyPeriod> getPeriods() {
		return periods;
	}
	public void setPeriods(List<ProxyPeriod> periods) {
		this.periods = periods;
	}
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}
}
