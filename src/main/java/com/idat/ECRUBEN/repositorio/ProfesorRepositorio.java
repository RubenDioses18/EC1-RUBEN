package com.idat.ECRUBEN.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ECRUBEN.modelo.Profesor;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer> {

}
