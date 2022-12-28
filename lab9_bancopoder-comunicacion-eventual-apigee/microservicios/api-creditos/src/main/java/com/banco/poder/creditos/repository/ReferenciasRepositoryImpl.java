package com.banco.poder.creditos.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.banco.poder.creditos.SpringJdbcDao;
import com.banco.poder.creditos.modelo.ReferenciasDto;

@Repository
public class ReferenciasRepositoryImpl extends SpringJdbcDao implements ReferenciasRepository {

	private String qryBuscarById = "SELECT * FROM credito_referencias WHERE ID = ? AND ID_CREDITO = ? ";
	private String qryTodo = "SELECT * FROM credito_referencias WHERE ID_CREDITO = ? ";
	private String qryInsert = "INSERT INTO credito_referencias (id,id_credito,nombre,apellidos,tipo_referencia,anios_conocimiento) VALUES(?,?,?,?,?,?)";
	private String qryDelete = "DELETE FROM credito_referencias WHERE id_credito = ?";

	@Override
	public ReferenciasDto persistir(String idCredito, ReferenciasDto referenciasDto) {

		referenciasDto.setId(generadorLlaves());

		jdbcTemplate.update(qryInsert, referenciasDto.getId(), idCredito, referenciasDto.getNombre(),
				referenciasDto.getApellidos(), referenciasDto.getTipoReferencia(),
				referenciasDto.getAniosConocimiento());

		return buscarById(referenciasDto.getId(), idCredito);
	}

	@Override
	public ReferenciasDto buscarById(String id, String idCredito) {

		try {
			return jdbcTemplate.queryForObject(qryBuscarById, new Object[] { id, idCredito },
					BeanPropertyRowMapper.newInstance(ReferenciasDto.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<ReferenciasDto> buscarTodo(String id) {
		return jdbcTemplate.query(qryTodo, new Object[] { id },
				BeanPropertyRowMapper.newInstance(ReferenciasDto.class));
	}

	@Override
	public void eliminar(String idCredito) {
		jdbcTemplate.update(qryDelete, idCredito);
	}

}
