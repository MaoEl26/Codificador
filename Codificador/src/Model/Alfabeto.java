package Model;

import java.util.ArrayList;

public class Alfabeto {
    
    private int identificadorAlfabeto;
    private String nombreAlfabeto;
    private ArrayList<String> listaSimbolosAlfabeto;

    public Alfabeto(int identificadorAlfabeto, String nombreAlfabeto, ArrayList<String> listaSimbolosAlfabeto) {
        this.identificadorAlfabeto = identificadorAlfabeto;
        this.nombreAlfabeto = nombreAlfabeto;
        this.listaSimbolosAlfabeto = listaSimbolosAlfabeto;
    }
    
    public boolean validarAlfabeto(Alfabeto alfabeto, String frase){
        
        /*Crear funcion que valide la frase*/
        
        return true;
    }

    public int getIdentificadorAlfabeto() {
        return identificadorAlfabeto;
    }

    public void setIdentificadorAlfabeto(int identificadorAlfabeto) {
        this.identificadorAlfabeto = identificadorAlfabeto;
    }

    public String getNombreAlfabeto() {
        return nombreAlfabeto;
    }

    public void setNombreAlfabeto(String nombreAlfabeto) {
        this.nombreAlfabeto = nombreAlfabeto;
    }

    public ArrayList<String> getList() {
        return listaSimbolosAlfabeto;
    }

    public void setList(ArrayList<String> listaSimbolosAlfabeto) {
        this.listaSimbolosAlfabeto = listaSimbolosAlfabeto;
    }
    
    
    
    

 


}