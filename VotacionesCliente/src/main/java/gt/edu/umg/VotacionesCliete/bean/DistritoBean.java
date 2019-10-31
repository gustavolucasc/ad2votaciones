/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.bean;

import gt.edu.umg.VotacionesCliete.dao.Distrito;
import gt.edu.umg.VotacionesCliete.servicios.DistritoServicio;

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
public class DistritoBean {

    /**
     * Creates a new instance of DistritoBean
     */
    
    private List <Distrito> distritos=new ArrayList();
    
    private Distrito distrito = new Distrito();
   
    
    public DistritoBean() {
   
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(ArrayList<Distrito> distrito) {
        this.distritos = distritos;
    }

   

    public void poblarDistritos(){
     try {
            this.distritos = DistritoServicio.getDistritos();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void agregarDistritoPrueba(){
        
         distrito.setNombre("distrito de prueba");
        
         DistritoServicio.crearDistrito(distrito);
        
        
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    
    
}
