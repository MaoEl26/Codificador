package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

public class Trasposicion extends Algoritmo{

    ArrayList<String> salidas;
    String textoSalida="";
    String textoEntrada = "";
    String ArraytextoCambio[];
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
        /*Metodo de Decodificar Trasposicion*/
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
    
}
