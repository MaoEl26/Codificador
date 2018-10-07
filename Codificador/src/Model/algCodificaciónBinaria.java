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
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(1))
            {
                textoSalida+= "00000" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(2))
            {
                textoSalida+= "00001" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(3))
            {
                textoSalida+= "00010" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(4))
            {
                textoSalida+= "00011" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(5))
            {
                textoSalida+= "00100" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(6))
            {
                textoSalida+= "00101" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(7))
            {
                textoSalida+= "00110" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(8))
            {
                textoSalida+= "00111" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(9))
            {
                textoSalida+= "01000" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(10))
            {
                textoSalida+= "01001" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(11))
            {
                textoSalida+= "01010" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(12))
            {
                textoSalida+= "01011" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(13))
            {
                textoSalida+= "01100" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(14))
            {
                textoSalida+= "01101" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(15))
            {
                textoSalida+= "01110" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(16))
            {
                textoSalida+= "01111" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(17))
            {
                textoSalida+= "10000" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(18))
            {
                textoSalida+= "10001" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(19))
            {
                textoSalida+= "10010" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(20))
            {
                textoSalida+= "10011" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(21))
            {
                textoSalida+= "10100" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(22))
            {
                textoSalida+= "10101" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(23))
            {
                textoSalida+= "10110" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(24))
            {
                textoSalida+= "10111" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(25))
            {
                textoSalida+= "11000" + " ";
            }
            
            if (String.valueOf(textoEntrada.charAt(i)) == alfabeto.getList().get(26))
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
           
           if (ArraytextoCambio[i] == "00000")
           {
               textoSalida += alfabeto.getList().get(1);
           }
           
           if (ArraytextoCambio[i] == "00001")
           {
               textoSalida += alfabeto.getList().get(2);
           }
           
           if (ArraytextoCambio[i] == "00010")
           {
               textoSalida += alfabeto.getList().get(3);
           }
           
           if (ArraytextoCambio[i] == "00011")
           {
               textoSalida += alfabeto.getList().get(4);
           }
           
           if (ArraytextoCambio[i] == "00100")
           {
               textoSalida += alfabeto.getList().get(5);
           }
           
           if (ArraytextoCambio[i] == "00101")
           {
               textoSalida += alfabeto.getList().get(6);
           }
           
           if (ArraytextoCambio[i] == "00110")
           {
               textoSalida += alfabeto.getList().get(7);
           }
           
           if (ArraytextoCambio[i] == "00111")
           {
               textoSalida += alfabeto.getList().get(8);
           }
           
           if (ArraytextoCambio[i] == "01000")
           {
               textoSalida += alfabeto.getList().get(9);
           }
           
           if (ArraytextoCambio[i] == "01001")
           {
               textoSalida += alfabeto.getList().get(10);
           }
           
           if (ArraytextoCambio[i] == "01010")
           {
               textoSalida += alfabeto.getList().get(11);
           }
           
           if (ArraytextoCambio[i] == "01011")
           {
               textoSalida += alfabeto.getList().get(12);
           }
           
           if (ArraytextoCambio[i] == "01100")
           {
               textoSalida += alfabeto.getList().get(13);
           }
           
           if (ArraytextoCambio[i] == "01101")
           {
               textoSalida += alfabeto.getList().get(14);
           }
           
           if (ArraytextoCambio[i] == "01110")
           {
               textoSalida += alfabeto.getList().get(15);
           }
           
           if (ArraytextoCambio[i] == "01111")
           {
               textoSalida += alfabeto.getList().get(16);
           }
           
           if (ArraytextoCambio[i] == "10000")
           {
               textoSalida += alfabeto.getList().get(17);
           }
           
           if (ArraytextoCambio[i] == "10001")
           {
               textoSalida += alfabeto.getList().get(18);
           }
           
           if (ArraytextoCambio[i] == "10010")
           {
               textoSalida += alfabeto.getList().get(19);
           }
           
           if (ArraytextoCambio[i] == "10011")
           {
               textoSalida += alfabeto.getList().get(20);
           }
           
           if (ArraytextoCambio[i] == "10100")
           {
               textoSalida += alfabeto.getList().get(21);
           }
           
           if (ArraytextoCambio[i] == "10101")
           {
               textoSalida += alfabeto.getList().get(22);
           }
           
           if (ArraytextoCambio[i] == "10110")
           {
               textoSalida += alfabeto.getList().get(23);
           }
           
           if (ArraytextoCambio[i] == "10111")
           {
               textoSalida += alfabeto.getList().get(24);
           }
           
           if (ArraytextoCambio[i] == "11000")
           {
               textoSalida += alfabeto.getList().get(25);
           }
           
           if (ArraytextoCambio[i] == "11001")
           {
               textoSalida += alfabeto.getList().get(26);
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
