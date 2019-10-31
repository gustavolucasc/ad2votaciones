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

public class Distrito implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4959769902439268748L;

    private int distrito;

    private String nombre;

    private int cantidadNoDiputados;

    public Distrito() {
    }

    public Distrito(int distrito, String nombre, int cantidadNoDiputados) {
        super();
        this.distrito = distrito;
        this.nombre = nombre;
        this.cantidadNoDiputados = cantidadNoDiputados;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadNoDiputados() {
        return cantidadNoDiputados;
    }

    public void setCantidadNoDiputados(int cantidadNoDiputados) {
        this.cantidadNoDiputados = cantidadNoDiputados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cantidadNoDiputados;
        result = prime * result + distrito;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Distrito other = (Distrito) obj;
        if (cantidadNoDiputados != other.cantidadNoDiputados) {
            return false;
        }
        if (distrito != other.distrito) {
            return false;
        }
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }
}
