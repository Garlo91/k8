package com.banco.poder.creditos.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.banco.poder.creditos.SpringJdbcDao;
import com.banco.poder.creditos.modelo.CreditosDto;
import com.banco.poder.creditos.modelo.SucursalDto;

@Repository
public class CreditosRepositoryImpl extends SpringJdbcDao implements CreditosRepository {

	private String qryInsert = "INSERT INTO creditos (id_credito,fecha,id_pais,id_canal,id_sucursal,"
			+ "id_cliente,id_producto,monto,plazo) VALUES (?,?,?,?,?,?,?,?,?)";

	private String qryBuscarById = "SELECT a.*, b.nombre, b.telefono_sucursal, c.nombre as nombre_estado, d.nombre as nombre_minicipio FROM creditos a, catalogos_sucursal b, catalogos_estados c, catalogos_municipios d\n" + 
			" WHERE a.id_credito = ?" + 
			" AND a.id_sucursal = b.id\n" + 
			" AND b.id_estado_sucursal = c.id\n" + 
			" AND b.id_municipio_sucursal = d.id";

	private String qryBuscarTodo = "SELECT a.*, b.nombre, b.telefono_sucursal, c.nombre as nombre_estado, d.nombre as nombre_minicipio FROM creditos a, catalogos_sucursal b, catalogos_estados c, catalogos_municipios d\n" + 
			" WHERE a.id_sucursal = b.id\n" + 
			" AND b.id_estado_sucursal = c.id\n" + 
			" AND b.id_municipio_sucursal = d.id";

	private String qryUpdate = "UPDATE creditos set id_pais = ?, id_canal = ?, id_sucursal = ?, id_cliente = ?,"
			+ " id_producto = ?, monto = ?, plazo = ? WHERE id_credito = ?";

	private String qryDelete = "DELETE FROM creditos WHERE id_credito = ?";

	@Override
	public CreditosDto buscarById(String id) {
		try {

			return jdbcTemplate.queryForObject(qryBuscarById,new Object[] {id},new RowMapper<CreditosDto>() {
				@Override
				public CreditosDto mapRow(ResultSet rs, int rownumber) throws SQLException {
					CreditosDto creditosDto = new CreditosDto();
						creditosDto.setIdCredito(rs.getString("id_credito"));
						creditosDto.setCliente(rs.getString("id_cliente"));
						creditosDto.setFecha(rs.getString("fecha"));
						creditosDto.setPais(rs.getString("id_pais"));
						creditosDto.setCanal(rs.getString("id_canal"));
						
							SucursalDto sucursalDto = new SucursalDto();
								sucursalDto.setId(rs.getString("id_sucursal"));
								sucursalDto.setNombre(rs.getString("nombre"));
								sucursalDto.setEstado(rs.getString("nombre_estado"));
								sucursalDto.setMunicipio(rs.getString("nombre_minicipio"));
								sucursalDto.setTelefono(rs.getString("telefono_sucursal"));
							
							creditosDto.setSucursal(sucursalDto);
							
						creditosDto.setProducto(rs.getString("id_producto"));
						creditosDto.setMonto(rs.getDouble("monto"));
						creditosDto.setPlazo(rs.getInt("plazo"));
					return creditosDto;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public CreditosDto actualizar(String id, CreditosDto creditosDto) {

		jdbcTemplate.update(qryUpdate, creditosDto.getPais(), creditosDto.getCanal(),
				creditosDto.getSucursal().getId(), creditosDto.getCliente(), creditosDto.getProducto(),
				creditosDto.getMonto(), creditosDto.getPlazo(), id);

		
		return buscarById(id);
	}

	@Override
	public CreditosDto persistir(CreditosDto creditosDto) {

		creditosDto.setIdCredito(generadorLlaves());

		jdbcTemplate.update(qryInsert, creditosDto.getIdCredito(), creditosDto.getFecha(), creditosDto.getPais(),
				creditosDto.getCanal(), creditosDto.getSucursal().getId(), creditosDto.getCliente(),
				creditosDto.getProducto(), creditosDto.getMonto(), creditosDto.getPlazo());

		return buscarById(creditosDto.getIdCredito());
	}

	@Override
	public void eliminar(String id) {
		jdbcTemplate.update(qryDelete, id);
	}

	@Override
	public List<CreditosDto> buscarByIdTodo(String id) {
		try {
			return jdbcTemplate.query(qryBuscarTodo, new RowMapper<CreditosDto>() {
				@Override
				public CreditosDto mapRow(ResultSet rs, int rownumber) throws SQLException {
					CreditosDto creditosDto = new CreditosDto();
						creditosDto.setIdCredito(rs.getString("id_credito"));
						creditosDto.setCliente(rs.getString("id_cliente"));
						creditosDto.setFecha(rs.getString("fecha"));
						creditosDto.setPais(rs.getString("id_pais"));
						creditosDto.setCanal(rs.getString("id_canal"));
	
						SucursalDto sucursalDto = new SucursalDto();
						sucursalDto.setId(rs.getString("id_sucursal"));
						creditosDto.setSucursal(sucursalDto);
						creditosDto.setProducto(rs.getString("id_producto"));
						creditosDto.setMonto(rs.getDouble("monto"));
						creditosDto.setPlazo(rs.getInt("plazo"));
					return creditosDto;
				}
			});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
