package com.idat.ECRUBEN.servicio;

import java.util.List;

import com.idat.ECRUBEN.dto.MallaCuricularDTORequest;
import com.idat.ECRUBEN.dto.MallaCuricularDTOResponse;

public interface MallaCuricularServicio {
	
	public void guardarMallaCuricular(MallaCuricularDTORequest mallacuricular);
	public void editarMallaCuricular(MallaCuricularDTORequest mallacuricular);
	
	public void eliminarMallaCuricular(Integer id);
	
	public List<MallaCuricularDTOResponse> listarMallaCuricular();
	public MallaCuricularDTOResponse obtenerMallaCuricularId(Integer id);	


}
