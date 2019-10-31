/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.bean;

import gt.edu.umg.VotacionesCliete.dao.Departamento;
import gt.edu.umg.VotacionesCliete.servicios.DepartamentoServicio;

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
public class DepartamentoBean {

    /**
     * Creates a new instance of DepartamentoBean
     */
    
    private List <Departamento> departamentos=new ArrayList();
    
    private Departamento departamento = new Departamento();
   
    
    public DepartamentoBean() {
   
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

   

    public void poblarDepartamentos(){
        
        try {
            this.departamentos = DepartamentoServicio.getDepartamentos();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void agregarDepartamentoPrueba(){
        
         departamento.setNombre("departamento de prueba");
        
         DepartamentoServicio.crearDepartamento(departamento);
        
        
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}
