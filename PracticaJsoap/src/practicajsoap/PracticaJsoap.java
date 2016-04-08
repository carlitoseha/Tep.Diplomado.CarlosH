/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajsoap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author chernandez
 */
public class PracticaJsoap {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String url;
        
        System.out.println("Digite la URL:");
        Scanner dir = new Scanner(System.in); 
        url = dir.nextLine();
        
        Document doc = Jsoup.connect(url).get();
        
        
       //https://en.wikipedia.org/
        //Elements newsHeadlines = doc.select("#mp-itn b a");
        Elements todosElementos = doc.getAllElements();
        Elements numParrafos = doc.select("p");
        Elements numImagenes = doc.select("img");
        Elements numFormularios = doc.select("form");
        Elements numFormulariosInput = doc.select("form input");
      
           
        int NumeroLineas = 0;
        
        //Investigado de internet
        URL pagina = null;
        BufferedReader in = null;
 

            
        pagina = new URL(url);
        in = new BufferedReader(new InputStreamReader(pagina.openStream()));

        while ((in.readLine()) != null) {
            NumeroLineas++;
        }
        //Investigado de internet
        
        //todosElementos.text().
        System.out.println(todosElementos.size());
        System.out.println("Cantidad de lineas " + NumeroLineas);
        System.out.println("Cantidad de párrafos:"+ numParrafos.size());  
        System.out.println("Cantidad de imagenes:" + numImagenes.size());  
        System.out.println("Cantidad de formularios:"+ numFormularios.size());  
        System.out.println("Cantidad de entradas en los formularios:" + numFormulariosInput.size());  
        
    }
    
}
