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
public class Votante {



  
  private int		votante;
  
  private String nombre;
  
  
  private String direccion;
  
 
  private boolean haVotado=false;
  
  
  private String CUI;
  

  
  private Municipio		municipio;
  
  
  private MesaReceptora		mesaReceptora;

  public Votante() {
	
  }

public Votante(int votante,  String nombre,  String direccion,
		 boolean haVotado, String cUI, Municipio municipio, MesaReceptora mesaReceptora) {
	super();
	this.votante = votante;
	this.nombre = nombre;
	this.direccion = direccion;
	this.haVotado = haVotado;
	CUI = cUI;
	this.municipio = municipio;
	this.mesaReceptora = mesaReceptora;
}

public int getVotante() {
	return votante;
}

public void setVotante(int votante) {
	this.votante = votante;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public boolean isHaVotado() {
	return haVotado;
}

public void setHaVotado(boolean haVotado) {
	this.haVotado = haVotado;
}

public String getCUI() {
	return CUI;
}

public void setCUI(String cUI) {
	CUI = cUI;
}

public Municipio getMunicipio() {
	return municipio;
}

public void setMunicipio(Municipio municipio) {
	this.municipio = municipio;
}

public MesaReceptora getMesaReceptora() {
	return mesaReceptora;
}

public void setMesaReceptora(MesaReceptora mesaReceptora) {
	this.mesaReceptora = mesaReceptora;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((CUI == null) ? 0 : CUI.hashCode());
	result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
	result = prime * result + (haVotado ? 1231 : 1237);
	result = prime * result + ((mesaReceptora == null) ? 0 : mesaReceptora.hashCode());
	result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	result = prime * result + votante;
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
	Votante other = (Votante) obj;
	if (CUI == null) {
		if (other.CUI != null)
			return false;
	} else if (!CUI.equals(other.CUI))
		return false;
	if (direccion == null) {
		if (other.direccion != null)
			return false;
	} else if (!direccion.equals(other.direccion))
		return false;
	if (haVotado != other.haVotado)
		return false;
	if (mesaReceptora == null) {
		if (other.mesaReceptora != null)
			return false;
	} else if (!mesaReceptora.equals(other.mesaReceptora))
		return false;
	if (municipio == null) {
		if (other.municipio != null)
			return false;
	} else if (!municipio.equals(other.municipio))
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	if (votante != other.votante)
		return false;
	return true;
}

}
