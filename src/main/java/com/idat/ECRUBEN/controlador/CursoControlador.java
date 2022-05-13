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

import com.idat.ECRUBEN.dto.CursoDTORequest;
import com.idat.ECRUBEN.dto.CursoDTOResponse;
import com.idat.ECRUBEN.dto.ProfesorDTORequest;
import com.idat.ECRUBEN.dto.ProfesorDTOResponse;
import com.idat.ECRUBEN.modelo.Curso;
import com.idat.ECRUBEN.servicio.CursoServicio;
import com.idat.ECRUBEN.servicio.ProfesorServicio;

@RestController
@RequestMapping("curso/c1")
public class CursoControlador {
	
	@Autowired
	private CursoServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTOResponse>> listarCurso(){
		return new ResponseEntity<List<CursoDTOResponse>>(servicio.listarCurso(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody CursoDTORequest mallacuricular){
		
		servicio.guardarCurso(mallacuricular);
		return new  ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<CursoDTOResponse> listarPorId(@PathVariable Integer id){
		
		CursoDTOResponse p = servicio.obtenerCursorId(id);
		if (p != null) {
			return new ResponseEntity<CursoDTOResponse>(p, HttpStatus.OK);			
		}
		return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody CursoDTORequest mallacuricular){
		
		CursoDTOResponse p = servicio.obtenerCursorId(mallacuricular.getIdCursoDTO());
		
		if (p != null) {
			servicio.editarCurso(mallacuricular);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path =  "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		CursoDTOResponse c = servicio.obtenerCursorId(id);
		if (c!= null) {
			servicio.eliminarCursor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}


}
