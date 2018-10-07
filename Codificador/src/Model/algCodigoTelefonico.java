package Model;

import Controller.DTOAlgoritmos;
import java.util.ArrayList;

public class algCodigoTelefonico extends Algoritmo{

    ArrayList<String> salidas;
    String textoSalida="";
    String textoEntrada = "";
    String ArraytextoCambio[];
    
    private static boolean estado = true;
    
    @Override
    public void codificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Codificar algCodigoTelefonico*/
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
        int num = 0;
        int ind = 2;
        int a = 0;
        int b = 0;
        
        for (int i = 0; i < textoEntrada.length(); i++) {
            //textoSalida+= new StringBuilder(ArraytextoCambio[i]).reverse().toString()+" ";
            System.out.println("Trabajando con la letra: " + textoEntrada.charAt(i));
            
             if (textoEntrada.charAt(i) == ' ')
             {
                 textoSalida += "*";
             }
            
            if (1 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 3) // Posición impar....
            {
                a = 2;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 1)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 2)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 3)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
            } 
            
            if (4 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 6) // Posición impar....
            {
                a = 3;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 4)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 5)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 6)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
            } 
            
             if (7 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 9) // Posición impar....
            {
                a = 4;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 7)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 8)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 9)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
            } 
            
             if (10 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 12) // Posición impar....
            {
                a = 5;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 10)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 11)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 12)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
            } 
             
            if (13 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 15) // Posición impar....
            {
                a = 6;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 13)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 14)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 15)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
            } 
            
            if (16 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 19) // Posición impar....
            {
                a = 7;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 16)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 17)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 18)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 19)
                {
                    b = 4;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                
            } 
            if (20 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 22) // Posición impar....
            {
                a = 8;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 20)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 21)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 22)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
            } 
            
            if (23 <= getindex(textoEntrada.charAt(i),alfabeto) && getindex(textoEntrada.charAt(i),alfabeto) <= 26) // Posición impar....
            {
                a = 9;
                
                if (getindex(textoEntrada.charAt(i),alfabeto) == 23)
                {
                    b = 1;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i), alfabeto) == 24)
                {
                    b = 2;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 25)
                {
                    b = 3;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
                if (getindex(textoEntrada.charAt(i),alfabeto) == 26)
                {
                    b = 4;
                    textoSalida += a + "" + b;
                    textoSalida += ' ';
                }
            } 
        }
        salidas.add(textoSalida);
    }
    
    public int getindex (Character letra, Alfabeto alfabeto)
    {
        int x = 0;
        
         for(int i = 0; i < alfabeto.getList().size(); i++) {
             if (alfabeto.getList().get(i) == String.valueOf(letra))
             {
                 x = i;
             }
         }
        return x;
    }

    
    @Override
    public void decodificar(DTOAlgoritmos dtoAlgortimo, Alfabeto alfabeto) {
        /*Metodo de Decodificar algCodigoTelefonico*/
        salidas = dtoAlgortimo.getListaSalidas();
        textoEntrada = dtoAlgortimo.getFraseActual();
        ArraytextoCambio = textoEntrada.split(" ");
       
        int numero = 0;
        int a = numero / 10;
        int b = numero % 10;
        
        for (int i = 0; i < ArraytextoCambio.length; i++) {
            if (ArraytextoCambio[i].contains("*"))
             {
                 textoSalida += " ";
                 ArraytextoCambio[i].replaceAll("[^A-Za-z_0-9]", "");
                 numero = Integer.parseInt(ArraytextoCambio[i]);
             }
            
            numero = Integer.parseInt(ArraytextoCambio[i]);
            System.out.println("Llegó el codigo: " + numero);
            a = numero / 10;
            b = numero % 10;
            System.out.println("Parte A: " + a);
            System.out.println("Parte B: " + b);
           // textoSalida+= new StringBuilder(ArraytextoCambio[i]).reverse().toString()+" ";
            
            if (a == 2)
            {
                if (b == 1)
                {
                    textoSalida += "a";
                }
                if (b == 2)
                {
                    textoSalida += "b";
                }
                if (b == 3)
                {
                    textoSalida += "c";
                }
                
            }
            if (a == 3)
            {
                if (b == 1)
                {
                    textoSalida += "d";
                }
                if (b == 2)
                {
                    textoSalida += "e";
                }
                if (b == 3)
                {
                    textoSalida += "f";
                }
            }
            if (a == 4)
            {
                if (b == 1)
                {
                    textoSalida += "g";
                }
                if (b == 2)
                {
                    textoSalida += "h";
                }
                if (b == 3)
                {
                    textoSalida += "i";
                }
                
            }
            if (a == 5)
            {
                if (b == 1)
                {
                    textoSalida += "j";
                }
                if (b == 2)
                {
                    textoSalida += "k";
                }
                if (b == 3)
                {
                    textoSalida += "l";
                }
                
            }
            if (a == 6)
            {
                if (b == 1)
                {
                    textoSalida += "m";
                }
                if (b == 2)
                {
                    textoSalida += "n";
                }
                if (b == 3)
                {
                    textoSalida += "o";
                }
                
            }
            if (a == 7)
            {
                if (b == 1)
                {
                    textoSalida += "p";
                }
                if (b == 2)
                {
                    textoSalida += "q";
                }
                if (b == 3)
                {
                    textoSalida += "r";
                }
                if (b == 4)
                {
                    textoSalida += "s";
                }
                
            }
            if (a == 8)
            {
                if (b == 1)
                {
                    textoSalida += "t";
                }
                if (b == 2)
                {
                    textoSalida += "u";
                }
                if (b == 3)
                {
                    textoSalida += "v";
                }
                
            }
            if (a == 9)
            {
                if (b == 1)
                {
                    textoSalida += "w";
                }
                if (b == 2)
                {
                    textoSalida += "x";
                }
                if (b == 3)
                {
                    textoSalida += "y";
                }
                if (b == 4)
                {
                    textoSalida += "z";
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
