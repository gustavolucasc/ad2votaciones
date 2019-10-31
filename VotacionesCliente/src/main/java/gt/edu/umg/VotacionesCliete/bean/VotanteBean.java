/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.bean;

import gt.edu.umg.VotacionesCliete.dao.Votante;
import gt.edu.umg.VotacionesCliete.servicios.VotanteServicio;

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
public class VotanteBean {

    /**
     * Creates a new instance of VotanteBean
     */
    
    private List <Votante> centroVotacions=new ArrayList();
    
    private Votante centroVotacion = new Votante();
   
    
    public VotanteBean() {
   
    }

    public List<Votante> getVotantes() {
        return centroVotacions;
    }

    public void setVotantes(ArrayList<Votante> centroVotacion) {
        this.centroVotacions = centroVotacions;
    }

   

    public void poblarVotantes(){
     try {
            this.centroVotacions = VotanteServicio.getVotantes();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void agregarVotantePrueba(){
        
         
        
         VotanteServicio.crearVotante(centroVotacion);
        
        
    }

    public Votante getVotante() {
        return centroVotacion;
    }

    public void setVotante(Votante centroVotacion) {
        this.centroVotacion = centroVotacion;
    }
    
    
}
