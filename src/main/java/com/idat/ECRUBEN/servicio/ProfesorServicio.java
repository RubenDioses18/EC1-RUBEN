package com.idat.ECRUBEN.servicio;

import java.util.List;

import com.idat.ECRUBEN.dto.ProfesorDTORequest;
import com.idat.ECRUBEN.dto.ProfesorDTOResponse;


public interface ProfesorServicio {
	
	public void guardarProfesor(ProfesorDTORequest profesor);
	public void editarProfesor(ProfesorDTORequest profesor);
	
	public void eliminarProfesor(Integer id);
	
	public List<ProfesorDTOResponse> listarProfesor();
	public ProfesorDTOResponse obtenerProfesorId(Integer id);	


}
