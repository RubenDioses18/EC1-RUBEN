package com.idat.ECRUBEN.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ECRUBEN.dto.UniversidadDTORequest;
import com.idat.ECRUBEN.dto.UniversidadDTOResponse;
import com.idat.ECRUBEN.modelo.Universidad;
import com.idat.ECRUBEN.repositorio.UniversidadRepositorio;


@Service
public class UniversidadServicioImpl implements UniversidadServicio {
	
	@Autowired
	public UniversidadRepositorio repositorio;

	@Override
	public void guardarUniversidad(UniversidadDTORequest universidad) {
		
		Universidad u = new Universidad();
		u.setUniversidad(universidad.getUniversidadDTO());
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		repositorio.save(u);

	}

	@Override
	public void editarUniversidad(UniversidadDTORequest universidad) {
		Universidad u = new Universidad();
		u.setUniversidad(universidad.getUniversidadDTO());
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		repositorio.saveAndFlush(u);

	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<UniversidadDTOResponse> listarUniversidad() {
		
		List<UniversidadDTOResponse> lista = new ArrayList<UniversidadDTOResponse>();
		
		UniversidadDTOResponse u = null;
		
		for (Universidad universidad : repositorio.findAll()) {			
		
		u.setUniversidadDTO(universidad.getUniversidad());
		u.setIdUniversidadDTO(universidad.getIdUniversidad());
		
		lista.add(u);		
		}
		return lista;
	}

	@Override
	public UniversidadDTOResponse obtenerUniversidadId(Integer id) {
		
		Universidad universidad = repositorio.findById(id).orElse(null);
		
		UniversidadDTOResponse u = new UniversidadDTOResponse();
		
		u.setUniversidadDTO(universidad.getUniversidad());
		u.setIdUniversidadDTO(universidad.getIdUniversidad());
		
		return (u);
	}

}
