
package View;

import Controller.DaoAlfabetos;
import java.util.ArrayList;

public class main {
    
    public static void main(String[] args) {

        /*Lista que contendra todos los simbolos del alfabeto que se va a utilizar*/
        ArrayList<String> lista = new ArrayList();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        lista.add("e");
        lista.add("f");
        lista.add("g");
        lista.add("h");
        lista.add("i");
        lista.add("j");
        lista.add("k");
        lista.add("l");
        lista.add("m");
        lista.add("o");
        lista.add("p");
        lista.add("q");
        lista.add("r");
        lista.add("s");
        lista.add("t");
        lista.add("u");
        lista.add("v");
        lista.add("w");
        lista.add("x");
        lista.add("y");
        lista.add("z");

        /*Se crea un objeto de tipo DaoAlfabetos para que cree y agregue el alfabeto*/
        DaoAlfabetos daoAlfabetos = new DaoAlfabetos();
        daoAlfabetos.crearAlfabeto(1, "predefinido", lista);
        
        /*Se crea el objeto de tipo consola que sera una de las interfaces graficas*/
        Consola consola1 = new Consola();
        consola1.empezarPrograma();
      
    }
    
}
