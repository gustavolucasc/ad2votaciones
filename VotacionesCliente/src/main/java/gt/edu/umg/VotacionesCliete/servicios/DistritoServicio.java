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
import gt.edu.umg.VotacionesCliete.dao.Distrito;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistritoServicio {
    private static final String BASEURL="http://ad2spring:9000/distrito/";
    private static  ConeccionRestApi coneccionRestApi= new ConeccionRestApi();
    
    
    public DistritoServicio() {
       
    }
          
    //Covert json string to class object
    private static List<Distrito> toEntityDistritos(String jsonString)
    {
        List<Distrito> resultado; 
        try{
            Gson gson = new GsonBuilder().create();
            Distrito[] distritos  = gson.fromJson(jsonString, Distrito[].class);            
            resultado = (List<Distrito>) Arrays.asList(distritos);
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return resultado;
    }   
     
    
    
       public static List <Distrito> getDistritos() throws UnsupportedEncodingException
    {
        String jsonResult=getDistritoJsonString(0);
       List<Distrito>  distritos;
        distritos=toEntityDistritos(jsonResult);
        return distritos ;
    }
       
   
    
       
    //Covert json string to class object
    private static Distrito toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            Distrito distrito = gson.fromJson(jsonString, Distrito.class);            
            return distrito;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static Distrito getDistrito(int  distrito) throws UnsupportedEncodingException
    {
        String jsonResult=getDistritoJsonString(distrito);
        Distrito distritoObject = null;
        if (distrito !=0) distritoObject=toEntity(jsonResult);
        return distritoObject;
    }   
    
    private static String getDistritoJsonString(int distrito) throws RuntimeException, UnsupportedEncodingException {
        String resultado;
        
        //define a variable to store the weather api url and set beijing as it's default value
        String Url = BASEURL; //default value hard-coded 'beijing' 
        //should be stored in config file

        if (distrito != 0) {
            Url = BASEURL + URLEncoder.encode(Integer.toString(distrito), "utf-8");
        }
        
        resultado = coneccionRestApi.getJsonString(Url);

        return resultado;
    }

    public static String toJson (Distrito distrito){
       String resultado;
       
       Gson gson = new GsonBuilder().create();
       
       resultado = gson.toJson(distrito);
       
       return resultado;
    }
    
    public static void crearDistrito(Distrito distrito){
        String  Url;
        String resultado;
         Url = BASEURL + "crear";
        
        String jsonInputString;
        jsonInputString = toJson (distrito);
        
        try {
            resultado = coneccionRestApi.postJsonString(Url,jsonInputString);
        } catch (RuntimeException ex) {
            Logger.getLogger(DistritoServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DistritoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
