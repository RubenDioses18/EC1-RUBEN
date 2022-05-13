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

import com.idat.ECRUBEN.dto.UniversidadDTORequest;
import com.idat.ECRUBEN.dto.UniversidadDTOResponse;
import com.idat.ECRUBEN.modelo.Universidad;
import com.idat.ECRUBEN.servicio.UniversidadServicio;

@RestController
@RequestMapping("universidad/v1")
public class UniversidadControlador {
	
	@Autowired
	private UniversidadServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UniversidadDTOResponse>> listarUniversidad(){
		return new ResponseEntity<List<UniversidadDTOResponse>>(servicio.listarUniversidad(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UniversidadDTORequest universidad){
		
		servicio.guardarUniversidad(universidad);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<UniversidadDTOResponse> listarPorId(@PathVariable Integer id){
		
		UniversidadDTOResponse u = servicio.obtenerUniversidadId(id);
		if (u != null) {
			return new ResponseEntity<UniversidadDTOResponse>(u, HttpStatus.OK);			
		}
		return new ResponseEntity<UniversidadDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody UniversidadDTORequest universidad){
		
		UniversidadDTOResponse u = servicio.obtenerUniversidadId(universidad.getIdUniversidadDTO());
		
		if (u != null) {
			servicio.editarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path =  "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UniversidadDTOResponse u = servicio.obtenerUniversidadId(id);
		if (u != null) {
			servicio.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
