package com.idat.ECRUBEN.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Universidad")
@Entity
public class Universidad implements Serializable{	
	
	
	private static final long serialVersionUID = -2743643041566802885L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversidad;
	private String Universidad;
	
	@OneToOne(mappedBy = "universidad")
	private MallaCuricular mallacuricular;
	

	public Universidad() {
		super();
	}
	public Integer getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public String getUniversidad() {
		return Universidad;
	}
	public void setUniversidad(String universidad) {
		Universidad = universidad;
	}
	
	

}
