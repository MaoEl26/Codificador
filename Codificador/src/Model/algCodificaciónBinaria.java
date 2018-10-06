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
public class algCodificaciónBinaria extends Algoritmo{
    
    ArrayList<String> salidas;
    String textoSalida="";
    String textoEntrada = "";
    String ArraytextoCambio[];
    
    private static boolean estado = true;
    
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
        
        for (int i = 0; i < textoEntrada.length(); i++) {
            
            System.out.println("Char " + i + " is " + textoEntrada.charAt(i));
            
            if (textoEntrada.charAt(i) == ' ')
            {
                textoSalida+= "*" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'a')
            {
                textoSalida+= "00000" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'b')
            {
                textoSalida+= "00001" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'c')
            {
                textoSalida+= "00010" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'd')
            {
                textoSalida+= "00011" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'e')
            {
                textoSalida+= "00100" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'f')
            {
                textoSalida+= "00101" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'g')
            {
                textoSalida+= "00110" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'h')
            {
                textoSalida+= "00111" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'i')
            {
                textoSalida+= "01000" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'j')
            {
                textoSalida+= "01001" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'k')
            {
                textoSalida+= "01010" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'l')
            {
                textoSalida+= "01011" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'm')
            {
                textoSalida+= "01100" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'n')
            {
                textoSalida+= "01101" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'o')
            {
                textoSalida+= "01110" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'p')
            {
                textoSalida+= "01111" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'q')
            {
                textoSalida+= "10000" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'r')
            {
                textoSalida+= "10001" + " ";
            }
            
            if (textoEntrada.charAt(i) == 's')
            {
                textoSalida+= "10010" + " ";
            }
            
            if (textoEntrada.charAt(i) == 't')
            {
                textoSalida+= "10011" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'u')
            {
                textoSalida+= "10100" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'v')
            {
                textoSalida+= "10101" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'w')
            {
                textoSalida+= "10110" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'x')
            {
                textoSalida+= "10111" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'y')
            {
                textoSalida+= "11000" + " ";
            }
            
            if (textoEntrada.charAt(i) == 'z')
            {
                textoSalida+= "11001" + " ";
            }
        }
        salidas.add(textoSalida);
        
    }
    
    
    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
        
        for (int i = 0; i < ArraytextoCambio.length; i++) {
           // textoSalida+= new StringBuilder(ArraytextoCambio[i]).reverse().toString()+" ";
           
           if (ArraytextoCambio[i] == "00000")
           {
               textoSalida += "a";
           }
           
           if (ArraytextoCambio[i] == "00001")
           {
               textoSalida += "b";
           }
           
           if (ArraytextoCambio[i] == "00010")
           {
               textoSalida += "c";
           }
           
           if (ArraytextoCambio[i] == "00011")
           {
               textoSalida += "d";
           }
           
           if (ArraytextoCambio[i] == "00100")
           {
               textoSalida += "e";
           }
           
           if (ArraytextoCambio[i] == "00101")
           {
               textoSalida += "f";
           }
           
           if (ArraytextoCambio[i] == "00110")
           {
               textoSalida += "g";
           }
           
           if (ArraytextoCambio[i] == "00111")
           {
               textoSalida += "h";
           }
           
           if (ArraytextoCambio[i] == "01000")
           {
               textoSalida += "i";
           }
           
           if (ArraytextoCambio[i] == "01001")
           {
               textoSalida += "j";
           }
           
           if (ArraytextoCambio[i] == "01010")
           {
               textoSalida += "k";
           }
           
           if (ArraytextoCambio[i] == "01011")
           {
               textoSalida += "l";
           }
           
           if (ArraytextoCambio[i] == "01100")
           {
               textoSalida += "m";
           }
           
           if (ArraytextoCambio[i] == "01101")
           {
               textoSalida += "n";
           }
           
           if (ArraytextoCambio[i] == "01110")
           {
               textoSalida += "o";
           }
           
           if (ArraytextoCambio[i] == "01111")
           {
               textoSalida += "p";
           }
           
           if (ArraytextoCambio[i] == "10001")
           {
               textoSalida += "r";
           }
           
           if (ArraytextoCambio[i] == "10010")
           {
               textoSalida += "s";
           }
           
           if (ArraytextoCambio[i] == "10011")
           {
               textoSalida += "t";
           }
           
           if (ArraytextoCambio[i] == "10100")
           {
               textoSalida += "u";
           }
           
           if (ArraytextoCambio[i] == "10101")
           {
               textoSalida += "v";
           }
           
           if (ArraytextoCambio[i] == "10110")
           {
               textoSalida += "w";
           }
           
           if (ArraytextoCambio[i] == "10111")
           {
               textoSalida += "x";
           }
           
           if (ArraytextoCambio[i] == "11000")
           {
               textoSalida += "y";
           }
           
           if (ArraytextoCambio[i] == "11001")
           {
               textoSalida += "z";
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
