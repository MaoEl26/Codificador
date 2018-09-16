package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

public class CodigoTelefonico extends Algoritmo{

    ArrayList<String> salidas;
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Codificar CodigoTelefonico*/
        salidas = dtoAlgortimo.getListaSalidas();
        salidas.add("Codificador Códiogo Telefónico");
        dtoAlgortimo.setListaSalidas(salidas);
    }

    
    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Decodificar CodigoTelefonico*/
        salidas = dtoAlgortimo.getListaSalidas();
        salidas.add("Decodificador Código Telefónico");
        dtoAlgortimo.setListaSalidas(salidas);
    }
    
}
