package Controller;

import View.Administrador;
import Model.Alfabeto;
import Model.Algoritmo;
import Model.algCodificaciónBinaria;
import Model.algVigenere;
import Model.algTrasposicion;
import Model.algCodigoTelefonico;
import Model.EscritorPDF;
import Model.EscritorTxt;
import Model.EscritorXML;
import Model.Frase;
import Model.FraseFactory;
import Model.FraseFactoryMethod;
import Model.algPalabraClave;
import java.util.ArrayList;


public class Controlador {
    
    private Alfabeto alfabetoActual; //Variable que almacenara el alfabeto actual con el que se esta trabajando
    private ArrayList<Alfabeto> listaAlfabetos; //Lista de los alfabetos que hay en memoria
    private Administrador admin;

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
        
        ArrayList<String> formato = dtoAlgoritmos.getTipoSalida();
        for (int i = 0; i < formato.size(); i++) {
            
        /*Switch que maneja cada tipo de salida segun se especifique*/
            switch (formato.get(i)){
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
    }
    
    public ArrayList obtenerAlgoritmos(){
        admin = new Administrador();
        ArrayList<Algoritmo> array = admin.getAlgoritmos();
//        for(Algoritmo ar : array){
//            System.out.println(ar.getClass().getName());
//        }
        return array;
    }
    
    public ArrayList obtenerTipoSalida(){
        admin = new Administrador();
        ArrayList<String> array = admin.getTipoSalidas();
        return array;
    }
    
            
            

    /*Funcion para procesar la peticion*/
    public void procesarPeticion(DTOAlgoritmos dtoAlgoritmos, DTOFrase dtoFrase){
        cargarAlfabetos();
        predefinirAlfabeto(dtoAlgoritmos);
        boolean validacionAlfabeto = alfabetoActual.validarAlfabeto(alfabetoActual, dtoAlgoritmos.getFraseActual());
        if (!validacionAlfabeto){
            /*Frase invalida*/
            
        }
        
        /*Proceso de obtencion de la frase*/
        /*String frase;
        switch (dtoFrase.getTipoFrase()){    
            case 4:
                dtoAlgoritmos.setFraseActual(dtoFrase.getFrase());
                break;
            default:
                FraseFactoryMethod fabrica = (FraseFactoryMethod) new FraseFactory();
                Frase fraseTemp = fabrica.createFrase(dtoFrase.getTipoFrase(), alfabetoActual, dtoFrase.getLongitudFrase());
                frase = fraseTemp.generarFrase();        
        }*/
        /*Proceso de Codificacion/Decodificacion*/
        ArrayList<Algoritmo> listaAlgoritmosSolicitados = dtoAlgoritmos.getListaAlgoritmosSolicitados();
        boolean modoCodificacion = dtoAlgoritmos.isModoCodificacion();
        //algoritmos.get(0).getClass().getSimpleName() para obtener las instancias
        for (int i=0; i<listaAlgoritmosSolicitados.size(); i++){
            
            Algoritmo peticion = listaAlgoritmosSolicitados.get(i);
            if (modoCodificacion){
                peticion.codificar(dtoAlgoritmos, alfabetoActual);
            }
            else{
                peticion.decodificar(dtoAlgoritmos, alfabetoActual);
            }
        }  
        escribir(dtoAlgoritmos);
    }

}