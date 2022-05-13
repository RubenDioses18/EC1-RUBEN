package com.idat.ECRUBEN.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ECRUBEN.dto.ProfesorDTORequest;
import com.idat.ECRUBEN.dto.ProfesorDTOResponse;
import com.idat.ECRUBEN.dto.UniversidadDTOResponse;
import com.idat.ECRUBEN.modelo.Profesor;
import com.idat.ECRUBEN.modelo.Universidad;
import com.idat.ECRUBEN.repositorio.ProfesorRepositorio;


@Service
public class ProfesorServicioImpl implements ProfesorServicio {
	
	@Autowired
	public ProfesorRepositorio repositorio;

	@Override
	public void guardarProfesor(ProfesorDTORequest profesor) {
		
		Profesor p = new Profesor();
		p.setProfesor(profesor.getProfesorDTO());
		p.setIdProfesor(profesor.getIdProfesorDTO());
		repositorio.save(p);


	}

	@Override
	public void editarProfesor(ProfesorDTORequest profesor) {
		Profesor p = new Profesor();
		p.setProfesor(profesor.getProfesorDTO());
		p.setIdProfesor(profesor.getIdProfesorDTO());
		repositorio.saveAndFlush(p);// TODO Auto-generated method stub

	}

	@Override
	public void eliminarProfesor(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<ProfesorDTOResponse> listarProfesor() {
		List<ProfesorDTOResponse> lista = new ArrayList<ProfesorDTOResponse>();
		
		ProfesorDTOResponse p = null;
		
		for (Profesor profesor : repositorio.findAll()) {			
		
		p.setProfesorDTO(profesor.getProfesor());
		p.setIdProfesorDTO(profesor.getIdProfesor());
		
		lista.add(p);		
		}
		return lista;
	}

	@Override
	public ProfesorDTOResponse obtenerProfesorId(Integer id) {
		
		Profesor profesor = repositorio.findById(id).orElse(null);
		
		ProfesorDTOResponse p = new ProfesorDTOResponse();
		
		p.setProfesorDTO(profesor.getProfesor());
		p.setIdProfesorDTO(profesor.getIdProfesor());
		
		return (p);
	}

}
