/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.dao;

import java.io.Serializable;


public class Departamento implements Serializable{

  /**
	 * 
	 */
	private static final long serialVersionUID = 5001755972235471268L;


 
  private int		departamento;
  private String	nombre;
  

public Departamento() {
	
}
  
public Departamento(int departamento,  String nombre) {
	super();
	this.departamento = departamento;
	this.nombre = nombre;
	//this.distrito = distrito;
}


public int getDepartamento() {
	return departamento;
}


public void setDepartamento(int departamento) {
	this.departamento = departamento;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + departamento;
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
	Departamento other = (Departamento) obj;
	if (departamento != other.departamento)
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}

}

