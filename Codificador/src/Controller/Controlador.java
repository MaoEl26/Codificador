package Controller;

import Model.Alfabeto;
import Model.Algoritmo;
import Model.algCodificaciónBinaria;
import Model.algVigenere;
import Model.algTrasposicion;
import Model.algCodigoTelefonico;
import Model.EscritorPDF;
import Model.EscritorTxt;
import Model.EscritorXML;
import Model.algPalabraClave;
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
        
        String formato = dtoAlgoritmos.getTipoSalida();
        
        /*Switch que maneja cada tipo de salida segun se especifique*/
        switch (formato){
            
            case ("txt"):
                EscritorTxt salidaTxt = new EscritorTxt();
                salidaTxt.escribirSalida(dtoAlgoritmos);
                break;
            case ("pdf"):
                EscritorPDF salidaPDF = new EscritorPDF();
                salidaPDF.escribirSalida(dtoAlgoritmos);
                break;
            case ("xml"):
                EscritorXML salidaXML = new EscritorXML();
                salidaXML.escribirSalida(dtoAlgoritmos);
                break;
            
        }
        
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
                    Algoritmo peticionV = new algVigenere();
                    if (modoCodificacion){
                        peticionV.codificar(dtoAlgoritmos, alfabetoActual);
                    }
                    else{
                        peticionV.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break;
                case "Trasposicion":
                    Algoritmo peticionT = new algTrasposicion();
                    if (modoCodificacion){
                        peticionT.codificar(dtoAlgoritmos, alfabetoActual);
                    }
                    else{
                        peticionT.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break;
                case "CodigoTelefonico":
                    Algoritmo peticionC = new algCodigoTelefonico();
                    if (modoCodificacion){
                        peticionC.codificar(dtoAlgoritmos, alfabetoActual);
                    }
                    else{
                        peticionC.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break; 
                case "PalabraClave":
                    Algoritmo peticionP = new algPalabraClave();
                    if (modoCodificacion){
                        peticionP.codificar(dtoAlgoritmos, alfabetoActual);
                    }else{
                        peticionP.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break;
                case "CodificacionBin":
                    Algoritmo peticionB = new algCodificaciónBinaria();
                    if(modoCodificacion){
                        peticionB.codificar(dtoAlgoritmos, alfabetoActual);
                    }else{
                        peticionB.decodificar(dtoAlgoritmos, alfabetoActual);
                    }
                    break;
            }
        }
        
        
        escribir(dtoAlgoritmos);
    }

}