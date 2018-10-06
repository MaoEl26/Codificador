package Model;

import java.util.ArrayList;

public class Alfabeto {
    
    private int identificadorAlfabeto;
    private String nombreAlfabeto;
    private boolean estado;
    private ArrayList<String> listaSimbolosAlfabeto;

    public Alfabeto(int identificadorAlfabeto, String nombreAlfabeto, boolean estado, ArrayList<String> listaSimbolosAlfabeto) {
        this.identificadorAlfabeto = identificadorAlfabeto;
        this.nombreAlfabeto = nombreAlfabeto;
        this.estado = estado;
        this.listaSimbolosAlfabeto = listaSimbolosAlfabeto;
    }
    
    public boolean validarAlfabeto(Alfabeto alfabeto, String frase){
        
        /*Valida si la frase contiene solo caracteres del alfabeto en uso*/
        boolean bandera = true;
        for( char c : frase.toCharArray()){
            if ( !listaSimbolosAlfabeto.contains(Character.toString(c)) ){
                bandera = false;
            }
        }
        
        return bandera;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
        return this.listaSimbolosAlfabeto;
    }

    public void setList(ArrayList<String> listaSimbolosAlfabeto) {
        this.listaSimbolosAlfabeto = listaSimbolosAlfabeto;
    }
    
    
    
    

 


}