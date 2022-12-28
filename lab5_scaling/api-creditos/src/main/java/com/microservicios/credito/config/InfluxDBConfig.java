package com.microservicios.credito.config;

import org.apache.log4j.Logger;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpointMetricReader;
import org.springframework.boot.actuate.metrics.writer.GaugeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

//@Configuration
public class InfluxDBConfig {

	private static final Logger log = Logger.getLogger(InfluxDBConfig.class);
	@Value("${influx.host}")
	String host;
	@Value("${influx.port}")
	Integer port;
	@Value("${influx.user}")
	String user;
	@Value("${influx.password}")
	String password;
	@Value("${influx.database}")
	String dbName;

	@Bean
	@ExportMetricWriter
	GaugeWriter influxMetricsWriter() {
		String connection = String.format("http://%s:%d", host, port);

		InfluxDB influxDB = InfluxDBFactory.connect(connection, user, password);

		try {
			if (!influxDB.databaseExists(dbName)) {
				influxDB.createDatabase(dbName);
			}
		} catch (Throwable t) {
			log.info(t.getMessage(), t);
		}

		influxDB.setDatabase(dbName);
		influxDB.setRetentionPolicy("autogen");
		influxDB.enableBatch(100, 30000, MILLISECONDS);

		return value -> {
			Point point = Point.measurement(value.getName()).time(value.getTimestamp().getTime(), MILLISECONDS)
					.addField("value", value.getValue()).build();
			influxDB.write(point);
			log.info("write(" + value.getName() + "): " + value.getValue());
		};
	}

	@Bean
	public MetricsEndpointMetricReader metricsEndpointMetricReader(final MetricsEndpoint metricsEndpoint) {
		return new MetricsEndpointMetricReader(metricsEndpoint);
	}
}
