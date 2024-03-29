
package View;

import Controller.DaoAlfabetos;
import java.io.*;
import java.util.ArrayList;

public class main {
    static DaoAlfabetos daoAlfabetos = new DaoAlfabetos();
    static GUI gui;
    static Administrador admin;
    public static void main(String[] args) {
        
        /*Variables que se obtienen del archivo*/
        String identificador = "";
        String nombre = "";
        String estado = "";
        ArrayList<String> lista;//Lista para almacenar caracteres
        
        /*Leer archivo para cargar los alfabetos*/
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("Alfabetos.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
                lista = new ArrayList<>();
                int contadorPtComa = 0;
                for(int n=0; n<linea.length(); n++){
                    String letra = linea.substring(n, n+1);
                    switch (letra){   
                        case ";":
                            contadorPtComa++;
                            break;
                        case " ":
                            break;
                        default:
                            switch(contadorPtComa){
                                case 0:
                                    identificador = identificador.concat(letra);
                                    break;
                                case 1:
                                    nombre = nombre.concat(letra);
                                    break;
                                case 2:
                                    estado = estado.concat(letra);
                                    break;
                                case 3:
                                    lista.add(letra);
                                    break;
                            }
                    }
                }
                
                boolean habilitado = !"0".equals(estado);                        
                
                /*Dao que agrega uno a uno los alfabetos*/
                boolean ret;
                ret = daoAlfabetos.crearAlfabeto(Integer.parseInt(identificador), nombre, habilitado, lista);
                contadorPtComa=0;
                identificador = "";
                nombre = "";
                estado = "";
            }          
        }
        catch(IOException e){
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (IOException e2){ 
           }
        }
        //newConsola();
        newAdmin();
        //newGui();
    }
private static void newConsola(){
    Consola consola1 = new Consola();
    consola1.empezarPrograma();
}    

public static void newGui(){
            gui = new GUI();
            gui.inicioDao(daoAlfabetos);
            gui.start();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);   
            }
        });
}
    
private static void newAdmin(){
    admin = new Administrador();
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        admin.setVisible(true);
    }
    });
}
}
