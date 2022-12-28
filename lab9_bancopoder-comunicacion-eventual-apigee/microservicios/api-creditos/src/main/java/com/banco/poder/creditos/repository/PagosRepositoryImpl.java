package com.banco.poder.creditos.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.banco.poder.creditos.SpringJdbcDao;
import com.banco.poder.creditos.modelo.PagosDto;
@Repository
public class PagosRepositoryImpl extends SpringJdbcDao implements PagosRepository {

	private String qryInsert = "INSERT INTO credito_pagos (id,id_credito,id_concepto,importe,fecha) VALUES (?,?,?,?,?)";
	private String qrySelect = "SELECT * FROM credito_pagos a,  conceptos_pago b WHERE a.id_credito = ? AND a.id_concepto=b.id";
	private String qrySelectById = "SELECT * FROM credito_pagos a,  conceptos_pago b WHERE a.id = ? AND a.id_concepto=b.id";
	private String qryDelete = "DELETE FROM credito_pagos a WHERE a.id_credito";

	@Override
	public List<PagosDto> consultarTodo(String id) {
		try {

			return jdbcTemplate.query(qrySelect, new Object[] { id }, new RowMapper<PagosDto>() {
				@Override
				public PagosDto mapRow(ResultSet rs, int rownumber) throws SQLException {
					PagosDto pagosDto = new PagosDto();
					pagosDto.setIdPago(rs.getString("id"));
					pagosDto.setConcepto(rs.getString("nombre"));
					pagosDto.setImporte(rs.getDouble("importe"));
					pagosDto.setFecha(rs.getString("fecha"));
					pagosDto.setIdCredito(rs.getString("id_credito"));

					return pagosDto;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public PagosDto persistir(PagosDto pagosDto, String idCredito) {

		pagosDto.setIdPago(generadorLlaves());

		jdbcTemplate.update(qryInsert, pagosDto.getIdPago(), idCredito, pagosDto.getConcepto(), pagosDto.getImporte(),
				pagosDto.getFecha());

		return consultarById(pagosDto.getIdPago());
	}

	@Override
	public PagosDto consultarById(String id) {
		try {

			return jdbcTemplate.queryForObject(qrySelectById, new Object[] { id }, new RowMapper<PagosDto>() {
				@Override
				public PagosDto mapRow(ResultSet rs, int rownumber) throws SQLException {
					PagosDto pagosDto = new PagosDto();
					pagosDto.setIdPago(rs.getString("id"));
					pagosDto.setConcepto(rs.getString("nombre"));
					pagosDto.setImporte(rs.getDouble("importe"));
					pagosDto.setFecha(rs.getString("fecha"));
					pagosDto.setIdCredito(rs.getString("id_credito"));

					return pagosDto;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void eliminar(String idCredito) {
		jdbcTemplate.update(qryDelete, idCredito);
		
	}
}
