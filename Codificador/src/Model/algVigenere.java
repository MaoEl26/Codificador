package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

public class algVigenere extends Algoritmo{

    ArrayList<String> salidas;
    String textoSalida="";
    String textoEntrada = "";
    String ArraytextoCambio[];
    int key = 0;
    int b = key % 10;
    int a = key / 10;
    int ind = 2;
    
    private static boolean estado = true;
    
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Codificar Vigenere*/
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
       // ArraytextoCambio = textoEntrada.split(" ");
        
        for (int i = 0; i < textoEntrada.length(); i++) {
            //textoSalida+= new StringBuilder(ArraytextoCambio[i]).reverse().toString()+" ";
            boolean bandera = true;
            
            if (ind % 2 != 0 && textoEntrada.charAt(i) != ' ' && bandera) // Posición impar....
            {
                //textoSalida += alfabeto.getList().get(getindice(textoEntrada.charAt(i), alfabeto) + b);
                int indicewsuma = getindicev(textoEntrada.charAt(i), alfabeto, b) + b;
                textoSalida += alfabeto.getList().get(indicewsuma);
            /*    System.out.println("---------------------------------------------- 1 ----------------------------------");
                System.out.println("El indice con la suma es: " + indicewsuma);
                System.out.println("La letra resultante es: " + valor_letras.get(indicewsuma));
                System.out.println("-----------------------------------------------------------------------------------");
            */  ind = 2;
                bandera = false;
            }

            if (ind % 2 == 0 && textoEntrada.charAt(i) != ' ' && bandera) //Posición par...
            {
             //   textoSalida += alfabeto.getList().get(getindice(textoEntrada.charAt(i), alfabeto) + a);
                int indicewsuma = getindicev(textoEntrada.charAt(i), alfabeto, a) + a;
                textoSalida += alfabeto.getList().get(indicewsuma);
           /*   System.out.println("---------------------------------------------- 2 -----------------------------------");
                System.out.println("El indice con la suma es: " + indicewsuma);
                System.out.println("La letra resultante es: " + alfabeto.getList().get(indicewsuma));
                System.out.println("-----------------------------------------------------------------------------------");
            */  ind = 1;
                bandera = false;
            }
            
            if (textoEntrada.charAt(i) == ' ' && bandera)
                {
                   
                    textoSalida += ' ';
                    ind = 2;
                    bandera = false;
                    
                   
                }
            
        }
        salidas.add(textoSalida);
    }
    
    public int getindicev (Character letra , Alfabeto alfabeto, int key)
    {
        int x = 0;
        int margen = 0;
        
         for(int i = 0; i < alfabeto.getList().size(); i++) {
             margen = i + key;
             if (alfabeto.getList().get(i) == String.valueOf(letra))
             {
                 if (margen > alfabeto.getList().size() - 1)
                 {
                     x = margen - alfabeto.getList().size();
                 }
                 else
                 {
                    x = i;
                 }
                 //System.out.println("El indice de la letra " + letra + " es -> " + x);
             }
         }
        return x;
    }
    

    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Decodificar Vigenere*/
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ind = 2;
        
        
        for (int i = 0; i < ArraytextoCambio.length; i++) {
           // textoSalida+= new StringBuilder(ArraytextoCambio[i]).reverse().toString()+" ";
            boolean bandera = true;
            
            if (ind % 2 != 0 && textoEntrada.charAt(i) != ' ' && bandera) // Posición impar....
                {
                int indicewsuma = getindicev(textoEntrada.charAt(i), alfabeto, b) - b;
                textoSalida += alfabeto.getList().get(indicewsuma);
           /*   System.out.println("---------------------------------------------- 1 ----------------------------------");
                System.out.println("El indice con la suma es: " + indicewsuma);
                System.out.println("La letra resultante es: " + valor_letras.get(indicewsuma));
                System.out.println("-----------------------------------------------------------------------------------");
           */   ind = 2;
                bandera = false;
                }
             
            if (ind % 2 == 0 && textoEntrada.charAt(i) != ' ' && bandera) //Posición par...
                {
                int indicewsuma = getindicev(textoEntrada.charAt(i), alfabeto, a) - a;
                textoSalida += alfabeto.getList().get(indicewsuma);
            /*  System.out.println("---------------------------------------------- 2 -----------------------------------");
                System.out.println("El indice con la suma es: " + indicewsuma);
                System.out.println("La letra resultante es: " + valor_letras.get(indicewsuma));
                System.out.println("-----------------------------------------------------------------------------------");
            */  ind = 1;
                bandera = false;
                }
            
            if (textoEntrada.charAt(i) == ' ' && bandera)
                {
                 //   System.out.println("------------------------------------ espacio --------------------------------");
                    textoSalida += ' ';
                    ind = 2;
                    bandera = false;
                    
                   
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
