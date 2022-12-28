package com.banco.poder.creditos.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.banco.poder.creditos.SpringJdbcDao;
import com.banco.poder.creditos.modelo.AprobacionDto;
@Repository
public class AprobacionesRepositoryImpl extends SpringJdbcDao implements AprobacionesRepository {

	private String qryInsert = "INSERT INTO credito_autorizaciones (id,id_credito,estatus,fecha,fecha_confirmacion) VALUES(?,?,?,?,?)";
	private String qrySelect = "SELECT * FROM credito_autorizaciones";
	private String qrySeletById = "SELECT * FROM credito_autorizaciones WHERE ID_CREDITO = ? limit 1";
	private String qryDelete = "DELETE FROM credito_autorizaciones WHERE ID_CREDITO = ? ";

	@Override
	public void persistir(AprobacionDto aprobacionDto) {

		aprobacionDto.setId(generadorLlaves());

		jdbcTemplate.update(qryInsert, aprobacionDto.getId(), aprobacionDto.getIdCredito(), aprobacionDto.getEstatus(),
				aprobacionDto.getFecha(), aprobacionDto.getFechaConfirmacion());

	}

	@Override
	public List<AprobacionDto> obtenerTodo() {
		try {
			return jdbcTemplate.query(qrySelect, new RowMapper<AprobacionDto>() {
				@Override
				public AprobacionDto mapRow(ResultSet rs, int rownumber) throws SQLException {
					AprobacionDto aprobacionDto = new AprobacionDto();
					aprobacionDto.setId(rs.getString("id"));
					aprobacionDto.setIdCredito(rs.getString("id_credito"));
					aprobacionDto.setFecha(rs.getString("fecha"));
					aprobacionDto.setFechaConfirmacion(rs.getString("fecha_confirmacion"));
					aprobacionDto.setEstatus(rs.getBoolean("estatus"));

					return aprobacionDto;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public AprobacionDto obtenerById(String idCredito) {
		try {
			return jdbcTemplate.queryForObject(qrySeletById, new Object[] { idCredito }, new RowMapper<AprobacionDto>() {
				@Override
				public AprobacionDto mapRow(ResultSet rs, int rownumber) throws SQLException {
					AprobacionDto aprobacionDto = new AprobacionDto();
					aprobacionDto.setId(rs.getString("id"));
					aprobacionDto.setIdCredito(rs.getString("id_credito"));
					aprobacionDto.setFecha(rs.getString("fecha"));
					aprobacionDto.setFechaConfirmacion(rs.getString("fecha_confirmacion"));
					aprobacionDto.setEstatus(rs.getBoolean("estatus"));

					return aprobacionDto;
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
