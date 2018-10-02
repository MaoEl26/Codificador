package Model;

import Controller.DTOAlgoritmos;


public abstract class Algoritmo {
    
    public abstract void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto);
    public abstract void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto);
    public abstract boolean getEstado();
    public abstract void setEstado(boolean estado);
}
