package com.idat.ECRUBEN.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ECRUBEN.modelo.Universidad;

@Repository
public interface UniversidadRepositorio extends JpaRepository<Universidad, Integer> {
	
	
}
