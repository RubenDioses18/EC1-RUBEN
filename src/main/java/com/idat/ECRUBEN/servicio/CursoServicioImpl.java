package com.idat.ECRUBEN.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ECRUBEN.dto.CursoDTORequest;
import com.idat.ECRUBEN.dto.CursoDTOResponse;
import com.idat.ECRUBEN.dto.ProfesorDTOResponse;
import com.idat.ECRUBEN.modelo.Curso;
import com.idat.ECRUBEN.modelo.Profesor;
import com.idat.ECRUBEN.repositorio.CursoRepository;


@Service
public class CursoServicioImpl implements CursoServicio {
	
	@Autowired
	public CursoRepository repositorio;

	@Override
	public void guardarCurso(CursoDTORequest curso) {
		Curso c = new Curso();
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		repositorio.save(c);


	}

	@Override
	public void editarCurso(CursoDTORequest curso) {
		Curso c = new Curso();
		c.setCurso(curso.getCursoDTO());
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		repositorio.saveAndFlush(c);

	}

	@Override
	public void eliminarCursor(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<CursoDTOResponse> listarCurso() {
		List<CursoDTOResponse> lista = new ArrayList<CursoDTOResponse>();
		
		CursoDTOResponse c = null;
		
		for (Curso curso : repositorio.findAll()) {			
		
			c.setCursoDTO(curso.getCurso());
			c.setDescripcionDTO(curso.getDescripcion());
			c.setIdCursoDTO(curso.getIdCurso());
		
		lista.add(c);		
		}
		return lista;
	}

	@Override
	public CursoDTOResponse obtenerCursorId(Integer id) {
		Curso curso = repositorio.findById(id).orElse(null);
		
		CursoDTOResponse c = new CursoDTOResponse();
		
		c.setCursoDTO(curso.getCurso());
		c.setDescripcionDTO(curso.getDescripcion());
		c.setIdCursoDTO(curso.getIdCurso());
		
		return (c);
	}

}
