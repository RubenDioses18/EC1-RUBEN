package com.idat.ECRUBEN.servicio;

import java.util.List;

import com.idat.ECRUBEN.dto.CursoDTORequest;
import com.idat.ECRUBEN.dto.CursoDTOResponse;

public interface CursoServicio {
	
	public void guardarCurso(CursoDTORequest curso);
	public void editarCurso(CursoDTORequest curso);
	
	public void eliminarCursor(Integer id);
	
	public List<CursoDTOResponse> listarCurso();
	public CursoDTOResponse obtenerCursorId(Integer id);	


}
