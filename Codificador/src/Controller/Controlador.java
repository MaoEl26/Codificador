package Controller;

import Model.Alfabeto;
import Model.Algoritmo;
import Model.Vigenere;
import Model.Trasposicion;
import Model.CodigoTelefonico;
import java.util.ArrayList;


public class Controlador {
    
    private Alfabeto alfabetoActual; //Variable que almacenara el alfabeto actual con el que se esta trabajando
    private ArrayList<Alfabeto> listaAlfabetos; //Lista de los alfabetos que hay en memoria

    public Controlador() {
    }
    
    /*Funcion que carga los alfabetos almacenados en el DAO Alfabetos*/
    private void cargarAlfabetos(){
        DaoAlfabetos daoAlfabetos = new DaoAlfabetos();
        listaAlfabetos = daoAlfabetos.getListaAlfabetos();
    }
    
    /*Funcion que setea la variable alfabeto acrual*/
    private void predefinirAlfabeto(DTOAlgoritmos dtoAlgoritmos){
        int identificadorAlfabeto = dtoAlgoritmos.getAlfabetoActual();
        for (int i=0; i<listaAlfabetos.size(); i++){
            if(listaAlfabetos.get(i).getIdentificadorAlfabeto()==identificadorAlfabeto){
                alfabetoActual=listaAlfabetos.get(i);
            }
        }
    }
    
    /*Funcion que escribe en el formato determinado*/
    private void escribir(DTOAlgoritmos dtoAlgoritmos){
        
        /*Funcion que manda a escribir en el formato que indique el dto*/
        
    }
    

    /*Funcion para procesar la peticion*/
    public void procesarPeticion(DTOAlgoritmos dtoAlgoritmos){
        cargarAlfabetos();
        predefinirAlfabeto(dtoAlgoritmos);
        boolean validacionAlfabeto = alfabetoActual.validarAlfabeto(alfabetoActual, dtoAlgoritmos.getFraseActual());
        if (!validacionAlfabeto){
            /*Frase invalida*/
        }
        
        
        /*Proceso de Codificacion/Decodificacion*/
        ArrayList<String> listaAlgoritmosSolicitados = dtoAlgoritmos.getListaAlgoritmosSolicitados();
        boolean modoCodificacion = dtoAlgoritmos.isModoCodificacion();
        
        for (int i=0; i<listaAlgoritmosSolicitados.size(); i++){
            
            switch (listaAlgoritmosSolicitados.get(i)){
                
                case "Vigenere":
                    Algoritmo peticionV = new Vigenere();
                    if (modoCodificacion){
                        peticionV.codificar(dtoAlgoritmos, alfabetoActual);
                    }
                    else{
                        peticionV.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break;
                case "Trasposicion":
                    Algoritmo peticionT = new Trasposicion();
                    if (modoCodificacion){
                        peticionT.codificar(dtoAlgoritmos, alfabetoActual);
                    }
                    else{
                        peticionT.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break;
                case "CodigoTelefonico":
                    Algoritmo peticionC = new CodigoTelefonico();
                    if (modoCodificacion){
                        peticionC.codificar(dtoAlgoritmos, alfabetoActual);
                    }
                    else{
                        peticionC.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break; 
                
            }
            
        }
        
        escribir(dtoAlgoritmos);
    }
    
   
    
    
    
}
