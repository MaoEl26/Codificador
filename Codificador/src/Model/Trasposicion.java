package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

public class Trasposicion extends Algoritmo{

    ArrayList<String> salidas;
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Codificar Traspocision*/
        salidas = dtoAlgortimo.getListaSalidas();
        salidas.add("Aquí Codifica Trasposición");
        dtoAlgortimo.setListaSalidas(salidas);
    }

    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Decodificar Trasposicion*/
        salidas = dtoAlgortimo.getListaSalidas();
        salidas.add("Aqui Decodifica Trasposición");
        dtoAlgortimo.setListaSalidas(salidas);
    }
    
}
