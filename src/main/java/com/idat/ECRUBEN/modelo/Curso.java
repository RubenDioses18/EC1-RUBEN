package com.idat.ECRUBEN.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="Curso")
@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
	private String descripcion;
	private Integer idMalla;
	
	
	@ManyToMany(mappedBy = "curso", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Profesor> profesor = new ArrayList<Profesor>();
	
	
	
	
	@JoinColumn(name = "id_malla", nullable = false, unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_malla) references mallacuricular(id_malla)"))
	@ManyToOne	
	private MallaCuricular mallacuricular;
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	

}
