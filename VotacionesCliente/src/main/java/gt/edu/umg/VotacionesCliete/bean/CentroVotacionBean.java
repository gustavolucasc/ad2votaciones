/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.bean;

import gt.edu.umg.VotacionesCliete.dao.CentroVotacion;
import gt.edu.umg.VotacionesCliete.servicios.CentroVotacionServicio;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author glucas
 */
@ManagedBean
@RequestScoped
public class CentroVotacionBean {

    /**
     * Creates a new instance of CentroVotacionBean
     */
    
    private List <CentroVotacion> centroVotacions=new ArrayList();
    
    private CentroVotacion centroVotacion = new CentroVotacion();
   
    
    public CentroVotacionBean() {
   
    }

    public List<CentroVotacion> getCentroVotacions() {
        return centroVotacions;
    }

    public void setCentroVotacions(ArrayList<CentroVotacion> centroVotacion) {
        this.centroVotacions = centroVotacions;
    }

   

    public void poblarCentroVotacions(){
     try {
            this.centroVotacions = CentroVotacionServicio.getCentroVotacions();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void agregarCentroVotacionPrueba(){
        
         
        
         CentroVotacionServicio.crearCentroVotacion(centroVotacion);
        
        
    }

    public CentroVotacion getCentroVotacion() {
        return centroVotacion;
    }

    public void setCentroVotacion(CentroVotacion centroVotacion) {
        this.centroVotacion = centroVotacion;
    }
    
    
}
