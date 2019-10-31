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
public class MesaReceptora implements Serializable{

  
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 8998790162038716560L;


 
  private int		mesaReceptora;
  
  
  
  private int	cantidadVotantes;
  

 
  private CentroVotacion		CentroVotacion;

	public MesaReceptora() {
		
	}

	public int getMesaReceptora() {
		return mesaReceptora;
	}

	public void setMesaReceptora(int mesaReceptora) {
		this.mesaReceptora = mesaReceptora;
	}

	public int getCantidadVotantes() {
		return cantidadVotantes;
	}

	public void setCantidadVotantes(int cantidadVotantes) {
		this.cantidadVotantes = cantidadVotantes;
	}

	public CentroVotacion getCentroVotacion() {
		return CentroVotacion;
	}

	public void setCentroVotacion(CentroVotacion centroVotacion) {
		CentroVotacion = centroVotacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CentroVotacion == null) ? 0 : CentroVotacion.hashCode());
		result = prime * result + cantidadVotantes;
		result = prime * result + mesaReceptora;
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
		MesaReceptora other = (MesaReceptora) obj;
		if (CentroVotacion == null) {
			if (other.CentroVotacion != null)
				return false;
		} else if (!CentroVotacion.equals(other.CentroVotacion))
			return false;
		if (cantidadVotantes != other.cantidadVotantes)
			return false;
		if (mesaReceptora != other.mesaReceptora)
			return false; 
		return true;
	}
	  
	
  
}
