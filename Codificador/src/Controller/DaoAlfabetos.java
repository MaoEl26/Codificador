package Controller;

import Model.Alfabeto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class DaoAlfabetos {

   private static ArrayList<Alfabeto> listaAlfabetos = new ArrayList<Alfabeto>(); //Variable con todos los alfabetos creados

    public DaoAlfabetos() {
    }
  
   /*Funcion para obtener todos los alfabetos creados*/
    public ArrayList<Alfabeto> getListaAlfabetos() {
        return listaAlfabetos;
    } 
      
    /*Funcion que crea un alfabeto y lo mantiene guardado en la lista de alfabetos*/
    public boolean crearAlfabeto(int identificador, String nombre, boolean estado, ArrayList<String> listaSimbolos){
        for (int i=0; i<listaAlfabetos.size(); i++){
            if(listaAlfabetos.get(i).getIdentificadorAlfabeto() == identificador || listaAlfabetos.get(i).getNombreAlfabeto() == nombre){
                return false;
            }
        }
        Alfabeto alfabeto = new Alfabeto(identificador, nombre, estado, listaSimbolos);
        listaAlfabetos.add(alfabeto);
        return true;
    }
    
    public boolean modificarAlfabeto(int identificador, String nombre, boolean estado, ArrayList<String> listaSimbolos){
        
        for (int i=0; i<listaAlfabetos.size(); i++){
            if(listaAlfabetos.get(i).getIdentificadorAlfabeto() == identificador){
                for (int j=0; j<listaAlfabetos.size();j++){
                    
                    if(listaAlfabetos.get(j).getIdentificadorAlfabeto() != identificador && listaAlfabetos.get(j).getNombreAlfabeto() == nombre){
                        return false;
                    }
                }
                listaAlfabetos.get(i).setNombreAlfabeto(nombre);
                listaAlfabetos.get(i).setEstado(estado);
                listaAlfabetos.get(i).setList(listaSimbolos);
                
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarAlfabeto(int identificador){
        for (int i=0; i<listaAlfabetos.size(); i++){
            if(listaAlfabetos.get(i).getIdentificadorAlfabeto() == identificador){
                listaAlfabetos.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void guardarAlfabetos(){
        try{
            File file = new File("Alfabetos.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaAlfabetos.size(); i++) {
                bw.write(listaAlfabetos.get(i).getIdentificadorAlfabeto()+";");
                bw.write(listaAlfabetos.get(i).getNombreAlfabeto()+";");
                if (listaAlfabetos.get(i).isEstado()){
                    bw.write("1;");
                }else{
                    bw.write("0;");
                }
                ArrayList<String> lista =listaAlfabetos.get(i).getList();
                for (int j = 0; j <lista.size(); j++) {
                    bw.write(lista.get(j)+" ");
                }
                bw.newLine();
            }
            bw.close();
            
        }catch(Exception e){
            System.out.println("Controller.DaoAlfabetos.guardarAlfabetos()");
        }
    }
    
   
   
    
}
