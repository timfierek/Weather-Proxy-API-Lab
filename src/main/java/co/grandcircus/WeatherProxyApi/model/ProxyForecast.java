package co.grandcircus.WeatherProxyApi.model;

import java.util.List;

public class ProxyForecast {
	private ProxyProperties properties;
	
	public ProxyProperties getProperties() {
		return properties;
	}

	public void setProperties(ProxyProperties properties) {
		this.properties = properties;
	}

	public class ProxyProperties {
		private List<ProxyPeriod> periods;

		public List<ProxyPeriod> getPeriods() {
			return periods;
		}

		public void setPeriods(List<ProxyPeriod> periods) {
			this.periods = periods;
		}
	}
}
