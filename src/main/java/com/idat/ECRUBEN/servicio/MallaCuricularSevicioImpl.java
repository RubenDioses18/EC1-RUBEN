package com.idat.ECRUBEN.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.ECRUBEN.dto.MallaCuricularDTORequest;
import com.idat.ECRUBEN.dto.MallaCuricularDTOResponse;
import com.idat.ECRUBEN.modelo.MallaCuricular;
import com.idat.ECRUBEN.repositorio.MallaCuricularRepositorio;


@Service
public class MallaCuricularSevicioImpl implements MallaCuricularServicio {
	
	@Autowired
	public MallaCuricularRepositorio repositorio;

	@Override
	public void guardarMallaCuricular(MallaCuricularDTORequest mallacuricular) {
		
		MallaCuricular m = new MallaCuricular();
		m.setAnio(mallacuricular.getAnioDTO());
		m.setIdMalla(mallacuricular.getIdMallaDTO());
		repositorio.save(m);


	}

	@Override
	public void editarMallaCuricular(MallaCuricularDTORequest mallacuricular) {
		MallaCuricular p = new MallaCuricular();
		p.setAnio(mallacuricular.getAnioDTO());
		p.setIdMalla(mallacuricular.getIdMallaDTO());
		repositorio.saveAndFlush(p);

	}

	@Override
	public void eliminarMallaCuricular(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<MallaCuricularDTOResponse> listarMallaCuricular() {
		List<MallaCuricularDTOResponse> lista = new ArrayList<MallaCuricularDTOResponse>();
		
		MallaCuricularDTOResponse m = null;
		
		for (MallaCuricular mallacuricular : repositorio.findAll()) {			
		
		m.setAnioDTO(mallacuricular.getAnio());
		m.setIdMallaDTO(mallacuricular.getIdMalla());
		
		lista.add(m);		
		}
		return lista;
	}

	@Override
	public MallaCuricularDTOResponse obtenerMallaCuricularId(Integer id) {
		MallaCuricular mallacuricular = repositorio.findById(id).orElse(null);
		
		MallaCuricularDTOResponse m = new MallaCuricularDTOResponse();
		
		m.setAnioDTO(mallacuricular.getAnio());
		m.setIdMallaDTO(mallacuricular.getIdMalla());
		
		return (m);
	}

}
