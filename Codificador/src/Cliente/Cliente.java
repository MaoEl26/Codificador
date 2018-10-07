/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Controller.DTOAlgoritmos;
import Controller.OBJComunicacion;
import java.net.*;
import java.io.*;

/**
 *
 * @author reese
 */
public class Cliente {
    
    private   String HOST =  "localhost";
    private    int PUERTO = 9090;

    private InputStream conexionEntrada;
    private ObjectInputStream flujoLectura;

    private OutputStream conexionSalida;
    private ObjectOutputStream flujoEscritura;
    
    public OBJComunicacion conecteServidor(OBJComunicacion objeto) throws UnknownHostException{
        try {
            
            Socket cliente = new Socket(HOST, PUERTO);
            
            //Establece mecanismo de comunicacion con el servidor - Lectura..
            System.out.println("Estableciendo comunicacion de lectura con el server...");
            conexionEntrada = cliente.getInputStream();
            flujoLectura = new ObjectInputStream(conexionEntrada);
            
            System.out.println("Estableciendo comunicacion de escritura con el server...");
            conexionSalida = cliente.getOutputStream();
            flujoEscritura = new ObjectOutputStream(conexionSalida);
            System.out.println("voy2");
            // procesar la gestion a solicitar
            flujoEscritura.writeObject(objeto);
            flujoEscritura.flush();
            
            // recupera la respuesta del servidor...
            objeto = (OBJComunicacion) flujoLectura.readObject();

            flujoEscritura.close();
            flujoLectura.close();
            cliente.close();
            
        } catch (ClassNotFoundException  ex) {
            System.out.println("Conectandose a un servidor desconocido");
        }
        catch (UnknownHostException ex) {
            System.out.println("Conectandose a un servidor desconocido");
        } catch (IOException ex) {
            System.out.println("Problemas con los flujos de entrada / salida");
        }



        return objeto;
    }
    
}


