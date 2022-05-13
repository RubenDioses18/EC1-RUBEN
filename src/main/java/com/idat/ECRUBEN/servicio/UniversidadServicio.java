package com.idat.ECRUBEN.servicio;

import java.util.List;

import com.idat.ECRUBEN.dto.UniversidadDTORequest;
import com.idat.ECRUBEN.dto.UniversidadDTOResponse;


public interface UniversidadServicio {
	
	public void guardarUniversidad(UniversidadDTORequest universidad);
	public void editarUniversidad(UniversidadDTORequest universidad);
	
	public void eliminarUniversidad(Integer id);
	
	public List<UniversidadDTOResponse> listarUniversidad();
	public UniversidadDTOResponse obtenerUniversidadId(Integer id);	


}
