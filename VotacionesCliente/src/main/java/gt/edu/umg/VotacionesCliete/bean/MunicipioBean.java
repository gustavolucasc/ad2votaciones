/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.bean;

import gt.edu.umg.VotacionesCliete.dao.Municipio;
import gt.edu.umg.VotacionesCliete.servicios.MunicipioServicio;

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
public class MunicipioBean {

    /**
     * Creates a new instance of MunicipioBean
     */
    
    private List <Municipio> municipios=new ArrayList();
    
    private Municipio municipio = new Municipio();
   
    
    public MunicipioBean() {
   
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ArrayList<Municipio> municipio) {
        this.municipios = municipios;
    }

   

    public void poblarMunicipios(){
     try {
            this.municipios = MunicipioServicio.getMunicipios();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void agregarMunicipioPrueba(){
        
         municipio.setNombre("municipio de prueba");
        
         MunicipioServicio.crearMunicipio(municipio);
        
        
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    
}
