/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.VotacionesCliete.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author glucas
 */
public class ConeccionRestApi {

    public ConeccionRestApi() {
    }
    
    
    //Get the weather of the specific city
    public  String getJsonString(String _Url) throws RuntimeException, UnsupportedEncodingException{  
        
     StringBuilder strBuf = new StringBuilder();  
        
        HttpURLConnection conn=null;
        BufferedReader reader=null;
        try{  
            //Declare the connection to weather api url
            URL url = new URL(_Url);  
            conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //conn.setRequestProperty("apikey",apiKey);
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                              + conn.getResponseCode());
            }
            
	    reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String output = null;  
            while ((output = reader.readLine()) != null)  
                strBuf.append(output);  
            
        }catch(MalformedURLException e) {  
            e.printStackTrace();   
        }catch(IOException e){  
            e.printStackTrace();   
        }
        finally
        {
            if(reader!=null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
            {
                conn.disconnect();
            }
        }

        return strBuf.toString();  
    }
    
    public  String postJsonString(String _Url,String jsonInputString) throws RuntimeException, UnsupportedEncodingException{  
        
     StringBuilder strBuf = new StringBuilder();  
        
        HttpURLConnection conn=null;
        BufferedReader reader=null;
        try{  
            //Declare the connection to weather api url
            URL url = new URL(_Url);  
            conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json;");
            
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            //conn.setRequestProperty("apikey",apiKey);
            
            conn.setDoOutput(true);
            
            OutputStream os = conn.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
            
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP POST Request Failed with Error code : "
                              + conn.getResponseCode());
            }
            
	    reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String output = null;  
            while ((output = reader.readLine()) != null)  
                strBuf.append(output);  
            
        }catch(MalformedURLException e) {  
            e.printStackTrace();   
        }catch(IOException e){  
            e.printStackTrace();   
        }
        finally
        {
            if(reader!=null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
            {
                conn.disconnect();
            }
        }

        return strBuf.toString();  
    }

    
}
