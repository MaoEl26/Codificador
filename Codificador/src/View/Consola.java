package View;

import Controller.Controlador;
import Controller.DTOAlgoritmos;
import Controller.DTOFrase;
import java.util.ArrayList;
import java.util.Scanner;

public class Consola {
        
    public void empezarPrograma(){
        
         
       /*Variables que almacenaran los datos que se ingresen*/ 
       
       boolean bandera = true;//Bandera para los switch
       
       int alfabeto; //Identificador del alfabeto
       String frase; //Frase a procesar
       
       String algoritmoSolicitado; //Letra indicadora del algortimo solicitado
       ArrayList<String> listaAlgoritmos = new ArrayList<>(); //Lista de algoritmos solicitados
       
       ArrayList<String> listaSalidas = new ArrayList<>();//Lista para las salidas
       
       String modo;
       boolean modoCodificacion = true;//Modo que operarara
       
       String salida;
       String tipoSalida=""; //Determina que tipo sera la salida (txt, pdf ...)
       
       /*Obtencion de los datos por la consola*/
       Scanner teclado = new Scanner(System.in);
       System.out.print("Introduzca el numero del alfabeto que desea: ");
       alfabeto = Integer.parseInt(teclado.nextLine());//Se guarda el identificador del alfabeto
       
       System.out.print("Introduzca la frase que desea procesar: ");
       frase = teclado.nextLine();//Se guarda la frase a procesar
       
       /*While que ira almacenando los algoritmos que se desea hacer a la frase*/
       while (bandera){
            System.out.print("Introduzca el algoritmo que desea realizar(V,T,C) o digite salir: ");
            algoritmoSolicitado = teclado.nextLine();//
            
            switch (algoritmoSolicitado){//Dependiendo de lo que se ingrese se ira almacenando en la lista     
                case "V":
                    listaAlgoritmos.add("Vigenere");
                    break;
                case "T":
                    listaAlgoritmos.add("Trasposicion");
                    break;
                case "C":
                    listaAlgoritmos.add("CodigoTelefonico");
                    break;
                case "salir":
                    bandera=false;
                    break;
                default:
                    System.out.println("Dato invalido.");
            }
       }
       
       bandera=true;
       
       while (bandera){//While para que indique el modo que quiera en cado de que indique algo invalido
            System.out.print("Introduzca el modo que desea procesar (C,D): ");
            modo = teclado.nextLine();
            
            switch (modo){     
                case "C":
                    modoCodificacion=true;
                    bandera=false;
                    break;
                case "D":
                    modoCodificacion=false;
                    bandera=false;
                    break;
                default:
                    System.out.println("Dato invalido.");
            }
       }
       bandera = true;
       while (bandera){//While para que indique el modo que quiera en cado de que indique algo invalido
            System.out.print("Introduzca el tipo que desea(t,p,x): ");
            salida = teclado.nextLine();
            
            switch (salida){     
                case "t":
                    tipoSalida="txt";
                    bandera=false;
                    break;
                case "p":
                    tipoSalida="pdf";
                    bandera=false;
                    break;
                case "x":
                    tipoSalida="xml";
                    bandera=false;
                    break;
                default:
                    System.out.println("Dato invalido.");
            }
       }

       /*Creacion del objeto DTO que ira de parametro con la informacion necesaria para codificar*/
       DTOAlgoritmos dtoAlgoritmos = new DTOAlgoritmos(alfabeto, frase, listaAlgoritmos, listaSalidas, modoCodificacion, tipoSalida);
       
       /*Se hara esto solo para probar*/
       DTOFrase dtoFrase = new DTOFrase ("", 0, 0);
       
       /*Creacion del controlador*/
       Controlador controlador = new Controlador();
       
       /*Procesamiento del programa*/
       //controlador.procesarPeticion(dtoAlgoritmos, dtoFrase);
    }
    
}