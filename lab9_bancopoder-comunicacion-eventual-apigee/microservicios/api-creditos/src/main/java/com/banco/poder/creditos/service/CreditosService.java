package com.banco.poder.creditos.service;

import com.banco.poder.creditos.modelo.CreditosDto;
import com.banco.poder.creditos.modelo.SaldoDto;

public interface CreditosService {

	CreditosDto obtenerById(String id);

	CreditosDto modificar(String id, CreditosDto creditosDto);

	CreditosDto guardar(CreditosDto creditosDto);

	void borrar(String id);

	SaldoDto obtenerSaldo(String idCredito);

}
