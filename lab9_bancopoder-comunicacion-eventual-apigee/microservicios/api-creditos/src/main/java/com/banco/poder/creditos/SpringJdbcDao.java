package com.banco.poder.creditos;

import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Jovani Arzate
 *
 */
public class SpringJdbcDao {

	protected UUID uuid;
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	public final void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public String generadorLlaves() {

		return String.valueOf(UUID.randomUUID());
	}

}
