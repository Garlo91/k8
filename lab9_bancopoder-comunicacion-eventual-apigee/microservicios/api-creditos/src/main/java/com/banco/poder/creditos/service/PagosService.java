package com.banco.poder.creditos.service;

import com.banco.poder.creditos.modelo.DetallePagosDto;
import com.banco.poder.creditos.modelo.PagosDto;

public interface PagosService {

	DetallePagosDto obtenerDetalle(String id);

	PagosDto obtenerById(String idCredito);

	PagosDto guardar(PagosDto pagosDto);
}
