package com.idat.ECRUBEN.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ECRUBEN.dto.MallaCuricularDTORequest;
import com.idat.ECRUBEN.dto.MallaCuricularDTOResponse;
import com.idat.ECRUBEN.dto.ProfesorDTORequest;
import com.idat.ECRUBEN.dto.ProfesorDTOResponse;
import com.idat.ECRUBEN.servicio.MallaCuricularServicio;
import com.idat.ECRUBEN.servicio.ProfesorServicio;

@RestController
@RequestMapping("malla/m1")
public class MallaCuricularControlador {
	
	@Autowired
	private MallaCuricularServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaCuricularDTOResponse>> listarMallaCuricular(){
		return new ResponseEntity<List<MallaCuricularDTOResponse>>(servicio.listarMallaCuricular(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCuricularDTORequest mallacuricular){
		
		servicio.guardarMallaCuricular(mallacuricular);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<MallaCuricularDTOResponse> listarPorId(@PathVariable Integer id){
		
		MallaCuricularDTOResponse p = servicio.obtenerMallaCuricularId(id);
		if (p != null) {
			return new ResponseEntity<MallaCuricularDTOResponse>(p, HttpStatus.OK);			
		}
		return new ResponseEntity<MallaCuricularDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody MallaCuricularDTORequest mallacuricular){
		
		MallaCuricularDTOResponse m = servicio.obtenerMallaCuricularId(mallacuricular.getIdMallaDTO());
		
		if (m != null) {
			servicio.editarMallaCuricular(mallacuricular);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path =  "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		MallaCuricularDTOResponse m = servicio.obtenerMallaCuricularId(id);
		if (m != null) {
			servicio.eliminarMallaCuricular(id);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}


}
