/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

/**
 *
 * @author Gerardo Villalobos
 */
public class PalabraClave extends Algoritmo{
    
    ArrayList<String> salidas;
    public ArrayList<Character> valor_letras = new ArrayList<>();
    String textoSalida="";
    String textoEntrada = "";
    String ArraytextoCambio[];
    
    
    
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
        String PalabraClave = "tango";
        int margen = 0;
        int j = 0;
        
        
        if (PalabraClave.length() <= textoEntrada.length())
        {
        
        for (int i = 0; i < textoEntrada.length(); i++) {
            
            
                if (j >= PalabraClave.length())
                {
                    j = 0;
                   
                }
                
               if (textoEntrada.charAt(i) == ' ')
                {
                    textoSalida += ' ';
                    i++;
                    j = 0;
                }
                 
                margen = getindice((textoEntrada.charAt(i))) + getindice((PalabraClave.charAt(j)));
                
                if (margen > 26)
                {
                    textoSalida += getlet(margen - 26);
                    j = j + 1;
                    
                }
                
                if (margen < 26)
                {
                    textoSalida += getlet(margen);
                    j = j + 1;
                    
                }
                
                
           
            
        }
    }
        salidas.add(textoSalida);
        
    }
    
    public int getindice (Character letra)
    {
        valor_letras.clear();
        
        valor_letras.add('-');
        valor_letras.add('a');
        valor_letras.add('b');
        valor_letras.add('c');
        valor_letras.add('d');
        valor_letras.add('e');
        valor_letras.add('f');
        valor_letras.add('g');
        valor_letras.add('h');
        valor_letras.add('i');
        valor_letras.add('j');
        valor_letras.add('k');
        valor_letras.add('l');
        valor_letras.add('m');
        valor_letras.add('n');
        valor_letras.add('o');
        valor_letras.add('p');
        valor_letras.add('q');
        valor_letras.add('r');
        valor_letras.add('s');
        valor_letras.add('t');
        valor_letras.add('u');
        valor_letras.add('v');
        valor_letras.add('w');
        valor_letras.add('x');
        valor_letras.add('y');
        valor_letras.add('z');
        
        int valor = 0; 
        
        for(int x = 0; x < valor_letras.size(); x++) {
            
       // System.out.println(al.get(x));
            if (letra == valor_letras.get(x))
            {
                valor = x;
                System.out.println("Se obtuvo el indice: " + valor + " de la letra ->" + valor_letras.get(x));
            }
        
        }
        
        
        return valor;
    }
    
    public Character getlet (int num)
    {
        valor_letras.clear();
        
        valor_letras.add('-');
        valor_letras.add('a');
        valor_letras.add('b');
        valor_letras.add('c');
        valor_letras.add('d');
        valor_letras.add('e');
        valor_letras.add('f');
        valor_letras.add('g');
        valor_letras.add('h');
        valor_letras.add('i');
        valor_letras.add('j');
        valor_letras.add('k');
        valor_letras.add('l');
        valor_letras.add('m');
        valor_letras.add('n');
        valor_letras.add('o');
        valor_letras.add('p');
        valor_letras.add('q');
        valor_letras.add('r');
        valor_letras.add('s');
        valor_letras.add('t');
        valor_letras.add('u');
        valor_letras.add('v');
        valor_letras.add('w');
        valor_letras.add('x');
        valor_letras.add('y');
        valor_letras.add('z');
        
        Character valor = null; 
        
        for(int x=0; x < valor_letras.size(); x++) {
            
             
             if (x == num)
             {
                 valor = valor_letras.get(x);
                 System.out.println("Se obtuvo la letra: " + valor + " con el indice ->" + num);
             }
        }
        
        return valor;
    }
    
    
    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
        int margen = 0;
        int j = 0;
        String PalabraClave = "tango";
        
        
        if (PalabraClave.length() <= textoEntrada.length())
        {
        
        for (int i = 0; i < textoEntrada.length(); i++) {
            
            
                if (j >= PalabraClave.length())
                {
                    j = 0;
                   
                }
                
               if (textoEntrada.charAt(i) == ' ')
                {
                    textoSalida += ' ';
                    i++;
                    j = 0;
                }
                 
                margen = getindice((textoEntrada.charAt(i))) - getindice((PalabraClave.charAt(j)));
                
                if (margen < 0)
                {
                    textoSalida += getlet(margen + 26);
                    j = j + 1;
                    
                }
                
                if (margen > 0)
                {
                    textoSalida += getlet(margen);
                    j = j + 1;
                    
                }
               
        }
        }
        
        salidas.add(textoSalida);        
        dtoAlgortimo.setListaSalidas(salidas);
    }
    
}
