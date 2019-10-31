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
import gt.edu.umg.VotacionesCliete.dao.MesaReceptora;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MesaReceptoraServicio {
    private static final String BASEURL="http://ad2spring:9000/mesaReceptora/";
    private static  ConeccionRestApi coneccionRestApi= new ConeccionRestApi();
    
    
    public MesaReceptoraServicio() {
       
    }
          
    //Covert json string to class object
    private static List<MesaReceptora> toEntityMesaReceptoras(String jsonString)
    {
        List<MesaReceptora> resultado; 
        try{
            Gson gson = new GsonBuilder().create();
            MesaReceptora[] mesaReceptoras  = gson.fromJson(jsonString, MesaReceptora[].class);            
            resultado = (List<MesaReceptora>) Arrays.asList(mesaReceptoras);
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return resultado;
    }   
     
    
    
       public static List <MesaReceptora> getMesaReceptoras() throws UnsupportedEncodingException
    {
        String jsonResult=getMesaReceptoraJsonString(0);
       List<MesaReceptora>  mesaReceptoras;
        mesaReceptoras=toEntityMesaReceptoras(jsonResult);
        return mesaReceptoras ;
    }
       
   
    
       
    //Covert json string to class object
    private static MesaReceptora toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            MesaReceptora mesaReceptora = gson.fromJson(jsonString, MesaReceptora.class);            
            return mesaReceptora;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static MesaReceptora getMesaReceptora(int  mesaReceptora) throws UnsupportedEncodingException
    {
        String jsonResult=getMesaReceptoraJsonString(mesaReceptora);
        MesaReceptora mesaReceptoraObject = null;
        if (mesaReceptora !=0) mesaReceptoraObject=toEntity(jsonResult);
        return mesaReceptoraObject;
    }   
    
    private static String getMesaReceptoraJsonString(int mesaReceptora) throws RuntimeException, UnsupportedEncodingException {
        String resultado;
        
        //define a variable to store the weather api url and set beijing as it's default value
        String Url = BASEURL; //default value hard-coded 'beijing' 
        //should be stored in config file

        if (mesaReceptora != 0) {
            Url = BASEURL + URLEncoder.encode(Integer.toString(mesaReceptora), "utf-8");
        }
        
        resultado = coneccionRestApi.getJsonString(Url);

        return resultado;
    }

    public static String toJson (MesaReceptora mesaReceptora){
       String resultado;
       
       Gson gson = new GsonBuilder().create();
       
       resultado = gson.toJson(mesaReceptora);
       
       return resultado;
    }
    
    public static void crearMesaReceptora(MesaReceptora mesaReceptora){
        String  Url;
        String resultado;
         Url = BASEURL + "crear";
        
        String jsonInputString;
        jsonInputString = toJson (mesaReceptora);
        
        try {
            resultado = coneccionRestApi.postJsonString(Url,jsonInputString);
        } catch (RuntimeException ex) {
            Logger.getLogger(MesaReceptoraServicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MesaReceptoraServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
