package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

public class Vigenere extends Algoritmo{

    ArrayList<String> salidas;
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Codificar Vigenere*/
        salidas = dtoAlgortimo.getListaSalidas();
        salidas.add("Codificador Vigenere");
        dtoAlgortimo.setListaSalidas(salidas);
    }

    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Decodificar Vigenere*/
        salidas = dtoAlgortimo.getListaSalidas();
        salidas.add("Decodificador Vigenere");
        dtoAlgortimo.setListaSalidas(salidas);
    }
    

    
}
