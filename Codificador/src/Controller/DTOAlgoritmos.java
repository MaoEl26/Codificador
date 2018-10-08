package Controller;

import Model.Algoritmo;
import java.io.Serializable;
import java.util.ArrayList;


public class DTOAlgoritmos implements Serializable{
    
    private int alfabetoActual;
    private String fraseActual;
    private ArrayList<Algoritmo> listaAlgoritmosSolicitados; 
    private ArrayList<String> listaSalidas;
    private boolean modoCodificacion;
    private ArrayList<String> tipoSalida;
 
    /*Constructor del DTO con todos sus valores*/
    public DTOAlgoritmos(int alfabetoActual, String fraseActual, 
            ArrayList<Algoritmo> listaAlgoritmosSolicitados, ArrayList<String> listaSalidas, 
            boolean modoCodificacion, ArrayList<String> tipoSalida) {
        this.alfabetoActual = alfabetoActual;
        this.fraseActual = fraseActual;
        this.listaAlgoritmosSolicitados = listaAlgoritmosSolicitados;
        this.listaSalidas = listaSalidas;
        this.modoCodificacion = modoCodificacion;
        this.tipoSalida = tipoSalida;
    }
    
    

    public int getAlfabetoActual() {
        return alfabetoActual;
    }

    public void setAlfabetoActual(int alfabetoActual) {
        this.alfabetoActual = alfabetoActual;
    }

    public String getFraseActual() {
        return fraseActual;
    }

    public void setFraseActual(String fraseActual) {
        this.fraseActual = fraseActual;
    }

    public ArrayList<Algoritmo> getListaAlgoritmosSolicitados() {
        return listaAlgoritmosSolicitados;
    }

    public void setListaAlgoritmosSolicitados(ArrayList<Algoritmo> listaAlgoritmosSolicitados) {
        this.listaAlgoritmosSolicitados = listaAlgoritmosSolicitados;
    }

    public ArrayList<String> getListaSalidas() {
        return listaSalidas;
    }

    public void setListaSalidas(ArrayList<String> listaSalidas) {
        this.listaSalidas = listaSalidas;
    }

    public boolean isModoCodificacion() {
        return modoCodificacion;
    }

    public void setModoCodificacion(boolean modoCodificacion) {
        this.modoCodificacion = modoCodificacion;
    }
    
    public ArrayList<String> getTipoSalida() {
        return tipoSalida;
    }

    public void setTipoSalida(ArrayList<String> tipoSalida) {
        this.tipoSalida = tipoSalida;
    }
}
