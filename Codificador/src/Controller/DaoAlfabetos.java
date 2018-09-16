package Controller;

import Model.Alfabeto;
import java.util.ArrayList;


public class DaoAlfabetos {

   private static ArrayList<Alfabeto> listaAlfabetos = new ArrayList<Alfabeto>(); //Variable con todos los alfabetos creados

    public DaoAlfabetos() {
    }
  
   
   /*Funcion para obtener todos los alfabetos creados*/
    public ArrayList<Alfabeto> getListaAlfabetos() {
        return listaAlfabetos;
    } 
    
    /*Funciones de transaccionalidad sobre alfabetos*/
    public void actualizarAlfabeto(Alfabeto alfabeto){
        
    }
    
    /*Funcion que crea un alfabeto y lo mantiene guardado en la lista de alfabetos*/
    public void crearAlfabeto(int identificador, String nombre, ArrayList<String> listaSimbolos){
        Alfabeto alfabeto = new Alfabeto(identificador, nombre, listaSimbolos);
        listaAlfabetos.add(alfabeto);
    }
    
    public void modificarAlfabeto(Alfabeto alfabeto){
        
    }
    
    public void eliminarAlfabeto(Alfabeto alfabeto){
        
    }
    
    
   
   
    
}
