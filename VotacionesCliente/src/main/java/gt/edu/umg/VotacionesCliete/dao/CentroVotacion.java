/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.dao;

import java.io.Serializable;

/**
 *
 * @author glucas
 */
public class CentroVotacion implements Serializable{

  
  /**
	 * 
	 */
	private static final long serialVersionUID = 5988376471548748889L;

 
  private int		centroVotacion;
  

  private String	direccion;
  
 
  private int	cantidadMesasReceptoras;
  


  private Municipio		municipio;

	public CentroVotacion() {
		
	}
	  
	public CentroVotacion(int centroVotacion,  String direccion,  int cantidadMesasReceptoras,
			Municipio municipio) {
		super();
		this.centroVotacion = centroVotacion;
		this.direccion = direccion;
		this.cantidadMesasReceptoras = cantidadMesasReceptoras;
		this.municipio = municipio;
	}

	public int getCentroVotacion() {
		return centroVotacion;
	}

	public void setCentroVotacion(int centroVotacion) {
		this.centroVotacion = centroVotacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantidadMesasReceptoras() {
		return cantidadMesasReceptoras;
	}

	public void setCantidadMesasReceptoras(int cantidadMesasReceptoras) {
		this.cantidadMesasReceptoras = cantidadMesasReceptoras;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidadMesasReceptoras;
		result = prime * result + centroVotacion;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
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
		CentroVotacion other = (CentroVotacion) obj;
		if (cantidadMesasReceptoras != other.cantidadMesasReceptoras)
			return false;
		if (centroVotacion != other.centroVotacion)
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		return true;
	}
  
  
}
