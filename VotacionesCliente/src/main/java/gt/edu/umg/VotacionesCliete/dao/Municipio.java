/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.dao;

/**
 *
 * @author glucas
 */
import java.io.Serializable;



public class Municipio implements Serializable{

 
  /**
	 * 
	 */
	private static final long serialVersionUID = 7078433048164006017L;

  
  private int		municipio;
  
  
  private String	nombre;
  
 
  private Distrito		distrito;
  
 
  private Departamento		departamento;
  
public Municipio() {
	
}
  



public Municipio(int municipio,  String nombre, Distrito distrito, Departamento departamento) {
	super();
	this.municipio = municipio;
	this.nombre = nombre;
	this.distrito = distrito;
	this.departamento = departamento;
}




public int getMunicipio() {
	return municipio;
}


public void setMunicipio(int municipio) {
	this.municipio = municipio;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public Distrito getDistrito() {
	return distrito;
}


public void setDistrito(Distrito distrito) {
	this.distrito = distrito;
}




public Departamento getDepartamento() {
	return departamento;
}




public void setDepartamento(Departamento departamento) {
	this.departamento = departamento;
}




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
	result = prime * result + ((distrito == null) ? 0 : distrito.hashCode());
	result = prime * result + municipio;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	return result;
}




@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Municipio other = (Municipio) obj;
	if (departamento == null) {
		if (other.departamento != null)
			return false;
	} else if (!departamento.equals(other.departamento))
		return false;
	if (distrito == null) {
		if (other.distrito != null)
			return false;
	} else if (!distrito.equals(other.distrito))
		return false;
	if (municipio != other.municipio)
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}


  
  
  
}