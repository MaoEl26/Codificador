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
public class algPalabraClave extends Algoritmo{
    
    ArrayList<String> salidas;
    //public ArrayList<Character> valor_letras = new ArrayList<>();
    String textoSalida="";
    String textoEntrada = "";
    String ArraytextoCambio[];
    
    
    
    private static boolean estado = true;
    
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
                
               if (String.valueOf(textoEntrada.charAt(i)).equals(String.valueOf(' ')))
                {
                    System.out.println("---------------------------espacio-------------------------------------");
                    textoSalida += ' ';
                    i++;
                    j = 0;
                }
                 
                margen = getindice(textoEntrada.charAt(i), alfabeto) + getindice(PalabraClave.charAt(j),alfabeto);
                
                if (margen > alfabeto.getList().size() - 2)
                {
                    textoSalida += getlet(margen - 26, alfabeto);
                    j = j + 1;
                    
                }
                
                if (margen < alfabeto.getList().size() - 2)
                {
                    textoSalida += getlet(margen, alfabeto);
                    j = j + 1;
                    
                }
                
                
           
            
        }
    }
        salidas.add(textoSalida);
        dtoAlgortimo.setListaSalidas(salidas);
        
    }
    
    public int getindice (Character letra, Alfabeto alfabeto)
    {
        int valor = 0; 
        
        for(int x = 0; x < alfabeto.getList().size(); x++) {
            
       // System.out.println(al.get(x));
            if (String.valueOf(letra).equals(alfabeto.getList().get(x)))
            {
                valor = x;
                System.out.println("Se obtuvo el indice: " + valor + " de la letra ->" + alfabeto.getList().get(x));
            }
        
        }
        
        
        return valor;
    }
    
    public String getlet (int num, Alfabeto alfabeto)
    {
        
        
        String valor = ""; 
        
        for(int x=0; x < alfabeto.getList().size(); x++) {
            
             
             if (x == num)
             {
                 valor = alfabeto.getList().get(x);
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
             
                margen = 0;
                boolean bandera = true;
            
            
                if (j >= PalabraClave.length())
                {
                    j = 0;
                   
                }
                
               if (String.valueOf(textoEntrada.charAt(i)).equals(String.valueOf(' ')))
                {
                    textoSalida += ' ';
                    i++;
                    j = 0;
                }
                 
                margen = getindice(textoEntrada.charAt(i), alfabeto) - getindice(PalabraClave.charAt(j), alfabeto);
                System.out.println("Margen antes: " + margen);
                
                if (margen < 0 && bandera)
                {
                    margen = margen + alfabeto.getList().size() - 2;
                    System.out.println("Margen despues: " + margen);
                   
                    textoSalida += getlet(margen, alfabeto);
                    System.out.println("----------------------------------------------------------------------------");
                    j = j + 1;
                    bandera = !bandera;
                    
                }
                
                if (margen >= 0 && bandera)
                {
                    textoSalida += getlet(margen, alfabeto);
                    j = j + 1;
                    System.out.println("----------------------------------------------------------------------------");
                    bandera = !bandera;
                    
                    
                }
               
        }
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
