/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.servicios;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import gt.edu.umg.VotacionesCliete.dao.Departamento;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartamentoServicio {
    private static final String BASEURL="http://ad2spring:9000/departamento/";
    private static  ConeccionRestApi coneccionRestApi= new ConeccionRestApi();
    
    
    public DepartamentoServicio() {
       
    }
          
    //Covert json string to class object
    private static List<Departamento> toEntityDepartamentos(String jsonString)
    {
        List<Departamento> resultado; 
        try{
            Gson gson = new GsonBuilder().create();
            Departamento[] departamentos  = gson.fromJson(jsonString, Departamento[].class);            
            resultado = (List<Departamento>) Arrays.asList(departamentos);
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return resultado;
    }   
     
    
    
       public static List <Departamento> getDepartamentos() throws UnsupportedEncodingException
    {
        String jsonResult=getDepartamentoJsonString(0);
       List<Departamento>  departamentos;
        departamentos=toEntityDepartamentos(jsonResult);
        return departamentos ;
    }
       
   
    
       
    //Covert json string to class object
    private static Departamento toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            Departamento departamento = gson.fromJson(jsonString, Departamento.class);            
            return departamento;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static Departamento getDepartamento(int  departamento) throws UnsupportedEncodingException
    {
        String jsonResult=getDepartamentoJsonString(departamento);
        Departamento departamentoObject = null;
        if (departamento !=0) departamentoObject=toEntity(jsonResult);
        return departamentoObject;
    }   
    
    private static String getDepartamentoJsonString(int departamento) throws RuntimeException, UnsupportedEncodingException {
        String resultado;
        
        //define a variable to store the weather api url and set beijing as it's default value
        String Url = BASEURL; //default value hard-coded 'beijing' 
        //should be stored in config file

        if (departamento != 0) {
            Url = BASEURL + URLEncoder.encode(Integer.toString(departamento), "utf-8");
        }
        
        resultado = coneccionRestApi.getJsonString(BASEURL);

        return resultado;
    }

    public static String toJson (Departamento departamento){
       String resultado;
       
       Gson gson = new GsonBuilder().create();
       
       resultado = gson.toJson(departamento);
       
       return resultado;
    }
    
    public static void crearDepartamento(Departamento departamento){
        String  Url;
        String resultado;
         Url = BASEURL + "crear";
        
        String jsonInputString;
        jsonInputString = toJson (departamento);
        
        try {
            resultado = coneccionRestApi.postJsonString(Url,jsonInputString);
        } catch (RuntimeException ex) {
            Logger.getLogger(DepartamentoServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DepartamentoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
