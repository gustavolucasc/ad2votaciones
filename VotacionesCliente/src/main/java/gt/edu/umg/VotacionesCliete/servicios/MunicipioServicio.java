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
import gt.edu.umg.VotacionesCliete.dao.Municipio;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MunicipioServicio {
    private static final String BASEURL="http://ad2spring:9000/municipio/";
    private static  ConeccionRestApi coneccionRestApi= new ConeccionRestApi();
    
    
    public MunicipioServicio() {
       
    }
          
    //Covert json string to class object
    private static List<Municipio> toEntityMunicipios(String jsonString)
    {
        List<Municipio> resultado; 
        try{
            Gson gson = new GsonBuilder().create();
            Municipio[] municipios  = gson.fromJson(jsonString, Municipio[].class);            
            resultado = (List<Municipio>) Arrays.asList(municipios);
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return resultado;
    }   
     
    
    
       public static List <Municipio> getMunicipios() throws UnsupportedEncodingException
    {
        String jsonResult=getMunicipioJsonString(0);
       List<Municipio>  municipios;
        municipios=toEntityMunicipios(jsonResult);
        return municipios ;
    }
       
   
    
       
    //Covert json string to class object
    private static Municipio toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            Municipio municipio = gson.fromJson(jsonString, Municipio.class);            
            return municipio;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static Municipio getMunicipio(int  municipio) throws UnsupportedEncodingException
    {
        String jsonResult=getMunicipioJsonString(municipio);
        Municipio municipioObject = null;
        if (municipio !=0) municipioObject=toEntity(jsonResult);
        return municipioObject;
    }   
    
    private static String getMunicipioJsonString(int municipio) throws RuntimeException, UnsupportedEncodingException {
        String resultado;
        
        //define a variable to store the weather api url and set beijing as it's default value
        String Url = BASEURL; //default value hard-coded 'beijing' 
        //should be stored in config file

        if (municipio != 0) {
            Url = BASEURL + URLEncoder.encode(Integer.toString(municipio), "utf-8");
        }
        
        resultado = coneccionRestApi.getJsonString(Url);

        return resultado;
    }

    public static String toJson (Municipio municipio){
       String resultado;
       
       Gson gson = new GsonBuilder().create();
       
       resultado = gson.toJson(municipio);
       
       return resultado;
    }
    
    public static void crearMunicipio(Municipio municipio){
        String  Url;
        String resultado;
         Url = BASEURL + "crear";
        
        String jsonInputString;
        jsonInputString = toJson (municipio);
        
        try {
            resultado = coneccionRestApi.postJsonString(Url,jsonInputString);
        } catch (RuntimeException ex) {
            Logger.getLogger(MunicipioServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MunicipioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
