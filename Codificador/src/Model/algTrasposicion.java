package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

public class algTrasposicion extends Algoritmo{

    ArrayList<String> salidas;
    String textoSalida="";
    String textoEntrada = "";
    String ArraytextoCambio[];
    
    private static boolean estado = true;
    
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Codificar Traspocision*/
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
        for (int i = 0; i < ArraytextoCambio.length; i++) {
            textoSalida+= new StringBuilder(ArraytextoCambio[i]).reverse().toString()
                    +" ";
        }
        salidas.add(textoSalida);
        
    }

    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Decodificar algTrasposicion*/
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
        for (int i = 0; i < ArraytextoCambio.length; i++) {
            textoSalida+= new StringBuilder(ArraytextoCambio[i]).reverse().toString()
                    +" ";
        }
        salidas.add(textoSalida);        
        dtoAlgortimo.setListaSalidas(salidas);
    }
    
    @Override
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
    @Override
    public boolean getEstado(){
        return estado;
    }
}
