package Model;

import Controller.DTOAlgoritmos;
import java.io.Serializable;


public abstract class Algoritmo implements Serializable{
    
    public abstract void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto);
    public abstract void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto);
    public abstract boolean getEstado();
    public abstract void setEstado(boolean estado);
}
