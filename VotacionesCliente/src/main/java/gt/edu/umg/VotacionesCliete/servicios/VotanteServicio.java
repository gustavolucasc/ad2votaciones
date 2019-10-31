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
import gt.edu.umg.VotacionesCliete.dao.Votante;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VotanteServicio {
    private static final String BASEURL="http://ad2spring:9000/votante/";
    private static  ConeccionRestApi coneccionRestApi= new ConeccionRestApi();
    
    
    public VotanteServicio() {
       
    }
          
    //Covert json string to class object
    private static List<Votante> toEntityVotantes(String jsonString)
    {
        List<Votante> resultado; 
        try{
            Gson gson = new GsonBuilder().create();
            Votante[] votantes  = gson.fromJson(jsonString, Votante[].class);            
            resultado = (List<Votante>) Arrays.asList(votantes);
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return resultado;
    }   
     
    
    
       public static List <Votante> getVotantes() throws UnsupportedEncodingException
    {
        String jsonResult=getVotanteJsonString(0);
       List<Votante>  votantes;
        votantes=toEntityVotantes(jsonResult);
        return votantes ;
    }
       
   
    
       
    //Covert json string to class object
    private static Votante toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            Votante votante = gson.fromJson(jsonString, Votante.class);            
            return votante;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static Votante getVotante(int  votante) throws UnsupportedEncodingException
    {
        String jsonResult=getVotanteJsonString(votante);
        Votante votanteObject = null;
        if (votante !=0) votanteObject=toEntity(jsonResult);
        return votanteObject;
    }   
    
    private static String getVotanteJsonString(int votante) throws RuntimeException, UnsupportedEncodingException {
        String resultado;
        
        //define a variable to store the weather api url and set beijing as it's default value
        String Url = BASEURL; //default value hard-coded 'beijing' 
        //should be stored in config file

        if (votante != 0) {
            Url = BASEURL + URLEncoder.encode(Integer.toString(votante), "utf-8");
        }
        
        resultado = coneccionRestApi.getJsonString(Url);

        return resultado;
    }

    public static String toJson (Votante votante){
       String resultado;
       
       Gson gson = new GsonBuilder().create();
       
       resultado = gson.toJson(votante);
       
       return resultado;
    }
    
    public static void crearVotante(Votante votante){
        String  Url;
        String resultado;
         Url = BASEURL + "crear";
        
        String jsonInputString;
        jsonInputString = toJson (votante);
        
        try {
            resultado = coneccionRestApi.postJsonString(Url,jsonInputString);
        } catch (RuntimeException ex) {
            Logger.getLogger(VotanteServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(VotanteServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
