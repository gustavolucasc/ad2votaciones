/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.bean;

import gt.edu.umg.VotacionesCliete.dao.MesaReceptora;
import gt.edu.umg.VotacionesCliete.servicios.MesaReceptoraServicio;

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
public class MesaReceptoraBean {

    /**
     * Creates a new instance of MesaReceptoraBean
     */
    
    private List <MesaReceptora> mesaReceptoras=new ArrayList();
    
    private MesaReceptora mesaReceptora = new MesaReceptora();
   
    
    public MesaReceptoraBean() {
   
    }

    public List<MesaReceptora> getMesaReceptoras() {
        return mesaReceptoras;
    }

    public void setMesaReceptoras(ArrayList<MesaReceptora> mesaReceptora) {
        this.mesaReceptoras = mesaReceptoras;
    }

   

    public void poblarMesaReceptoras(){
     try {
            this.mesaReceptoras = MesaReceptoraServicio.getMesaReceptoras();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void agregarMesaReceptoraPrueba(){
        
         
        
         MesaReceptoraServicio.crearMesaReceptora(mesaReceptora);
        
        
    }

    public MesaReceptora getMesaReceptora() {
        return mesaReceptora;
    }

    public void setMesaReceptora(MesaReceptora mesaReceptora) {
        this.mesaReceptora = mesaReceptora;
    }
    
    
}
