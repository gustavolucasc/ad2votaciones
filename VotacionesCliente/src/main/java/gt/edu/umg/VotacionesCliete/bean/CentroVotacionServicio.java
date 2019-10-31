/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.bean;

import gt.edu.umg.VotacionesCliete.servicios.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import gt.edu.umg.VotacionesCliete.dao.CentroVotacion;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CentroVotacionServicio {
    private static final String BASEURL="http://ad2spring:9000/centroVotacion/";
    private static  ConeccionRestApi coneccionRestApi= new ConeccionRestApi();
    
    
    public CentroVotacionServicio() {
       
    }
          
    //Covert json string to class object
    private static List<CentroVotacion> toEntityCentroVotacions(String jsonString)
    {
        List<CentroVotacion> resultado; 
        try{
            Gson gson = new GsonBuilder().create();
            CentroVotacion[] centroVotacions  = gson.fromJson(jsonString, CentroVotacion[].class);            
            resultado = (List<CentroVotacion>) Arrays.asList(centroVotacions);
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return resultado;
    }   
     
    
    
       public static List <CentroVotacion> getCentroVotacions() throws UnsupportedEncodingException
    {
        String jsonResult=getCentroVotacionJsonString(0);
       List<CentroVotacion>  centroVotacions;
        centroVotacions=toEntityCentroVotacions(jsonResult);
        return centroVotacions ;
    }
       
   
    
       
    //Covert json string to class object
    private static CentroVotacion toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            CentroVotacion centroVotacion = gson.fromJson(jsonString, CentroVotacion.class);            
            return centroVotacion;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static CentroVotacion getCentroVotacion(int  centroVotacion) throws UnsupportedEncodingException
    {
        String jsonResult=getCentroVotacionJsonString(centroVotacion);
        CentroVotacion centroVotacionObject = null;
        if (centroVotacion !=0) centroVotacionObject=toEntity(jsonResult);
        return centroVotacionObject;
    }   
    
    private static String getCentroVotacionJsonString(int centroVotacion) throws RuntimeException, UnsupportedEncodingException {
        String resultado;
        
        //define a variable to store the weather api url and set beijing as it's default value
        String Url = BASEURL; //default value hard-coded 'beijing' 
        //should be stored in config file

        if (centroVotacion != 0) {
            Url = BASEURL + URLEncoder.encode(Integer.toString(centroVotacion), "utf-8");
        }
        
        resultado = coneccionRestApi.getJsonString(Url);

        return resultado;
    }

    public static String toJson (CentroVotacion centroVotacion){
       String resultado;
       
       Gson gson = new GsonBuilder().create();
       
       resultado = gson.toJson(centroVotacion);
       
       return resultado;
    }
    
    public static void crearCentroVotacion(CentroVotacion centroVotacion){
        String  Url;
        String resultado;
         Url = BASEURL + "crear";
        
        String jsonInputString;
        jsonInputString = toJson (centroVotacion);
        
        try {
            resultado = coneccionRestApi.postJsonString(Url,jsonInputString);
        } catch (RuntimeException ex) {
            Logger.getLogger(CentroVotacionServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CentroVotacionServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
