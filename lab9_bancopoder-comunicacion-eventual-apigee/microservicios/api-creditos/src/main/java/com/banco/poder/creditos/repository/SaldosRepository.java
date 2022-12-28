package com.banco.poder.creditos.repository;

import com.banco.poder.creditos.modelo.SaldoDto;

public interface SaldosRepository {

	SaldoDto findById(String id);

}
