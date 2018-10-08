/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Controller.AccionesServidor;
import Controller.Controlador;
import Controller.DTOAlgoritmos;
import Controller.DTOFrase;
import Controller.OBJComunicacion;
import java.net.*;
import java.io.*;

/**
 *
 * @author reese
 */
public class Servidor implements Runnable{
    
    ServerSocket servidor;
    Socket cliente;
    int PUERTO = 9090;
    private static Servidor instancia;
    
    boolean estadoServidor = true;
    
    //DataOutputStream salida;
    //BufferedReader entrada;
    
    
    // la conexion de escritura del servidor
    private OutputStream conexionSalida;
    private ObjectOutputStream flujoSalida;

    // la conexion de lectura del servidor
    private InputStream conexionEntrada;
    private ObjectInputStream flujoEntrada;
    
    private Servidor() { }
    
    public static synchronized Servidor getInstance() {
        if (instancia == null)
            instancia = new Servidor();
        return instancia;
    }
    
    public void iniciar(){
        estadoServidor = true;
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    //iniciar server sin hilos
    public void iniciarServidor(){
        
        try {
            servidor = new ServerSocket(PUERTO);
            
            while(estadoServidor){
                System.out.println("Esperando una solicitud de un cliente...");
                cliente = servidor.accept();  // acepta la solicitud de un cliente

                System.out.println("Estableciendo canal de escritura...");
                // se establece el canal de comunicacion-Escritura
                conexionSalida =  cliente.getOutputStream();
                flujoSalida = new ObjectOutputStream(conexionSalida);

                System.out.println("Estableciendo canal de lectura ...");
                // se establece el canal de comunicacion-Lectura
                conexionEntrada = cliente.getInputStream();
                flujoEntrada = new ObjectInputStream(conexionEntrada);

                // atender la peticion...
                System.out.println("Atendiendo peticion...");
                
                procesePeticion();

                System.out.println("Desconectando...");
                
                flujoEntrada.close();
                flujoSalida.close();
                cliente.close();
            }
            
            servidor.close();
            
            
        } catch (IOException e) {
            System.out.println("Problemas creando el servidor en el puerto "+ PUERTO);
        }
        
    }
    
    private void procesePeticion() {
        try {
            
            OBJComunicacion objeto = (OBJComunicacion) flujoEntrada.readObject();
            
            DTOAlgoritmos dtoAlgoritmos = objeto.getDtoAlgoritmo();
            DTOFrase dtoFrase = objeto.getDtoFrase();
            Controlador controlador = new Controlador();
            
            /**
             * Llama al controlador dependiendo de la accion que quiera ejecutar
             * En el caso de procesarPeticion no setea nada en DatoSalida en el objeto comunicacion
             * En el caso de obtenerAlgoritmos y Alfabetos sí setea una lista de lo que se pide
             * en DatoSalida en el objeto de comunicacion
             */
            if (objeto.getAccion() == AccionesServidor.PROCESAR_PETICION_CODIFICAR){
                System.out.println("Procesando peticion PROCESAR PETICION CODIFICAR");
                controlador.procesarPeticion(dtoAlgoritmos, dtoFrase);
                // vuelvo asignar al objeto el resultado de dtoAlgoritmo que dio el controlador
                //para que ese resultado se pueda devolver en writeObject.
                objeto.setDtoAlgoritmo(dtoAlgoritmos);
            }
            
            if (objeto.getAccion() == AccionesServidor.OBTENER_ALGORITMOS){
                System.out.println("Procesando peticion OBTENER ALGORITMOS");
                objeto.setDatoSalida(controlador.obtenerAlgoritmos());
//                System.out.println("bien");
//                ArrayList<Algoritmo> array = (ArrayList<Algoritmo>)objeto.getDatoSalida();
//                for(Algoritmo ar : array){
//                    System.out.println(ar.getClass().getName());
//                }
            }
            
            if (objeto.getAccion() == AccionesServidor.OBTENER_TIPO_SALIDA){
                System.out.println("Procesando peticion OBTENER TIPO SALIDA");
                objeto.setDatoSalida(controlador.obtenerTipoSalida());
            }
            
            
            
            flujoSalida.writeObject(objeto);
            
            
        } catch (IOException ex) {
            System.out.println("Problemas leyendo o escribiendo en el flujo entrada/salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problemas en la conversion del objeto recibido...");
        }
    }
    
    public void cambiarEstadoServer(){
        System.out.println("Apagando Servidor...");
        estadoServidor = false;
        instancia = null;
        System.out.println("Servidor apagado");
        
    }

    //iniciar el server con hilos
    @Override
    public void run() {
        try {
            servidor = new ServerSocket(PUERTO);
            
            while(estadoServidor){
                System.out.println("Esperando una solicitud de un cliente...");
                cliente = servidor.accept();  // acepta la solicitud de un cliente

                System.out.println("Estableciendo canal de escritura...");
                // se establece el canal de comunicacion-Escritura
                conexionSalida =  cliente.getOutputStream();
                flujoSalida = new ObjectOutputStream(conexionSalida);

                System.out.println("Estableciendo canal de lectura ...");
                // se establece el canal de comunicacion-Lectura
                conexionEntrada = cliente.getInputStream();
                flujoEntrada = new ObjectInputStream(conexionEntrada);

                // atender la peticion...
                System.out.println("Atendiendo peticion...");
                
                procesePeticion();

                System.out.println("Desconectando...");
                
                flujoEntrada.close();
                flujoSalida.close();
                cliente.close();
            }
            
            servidor.close();
            System.out.println("Apagando el servidor");
            
            
        } catch (IOException e) {
            System.out.println("Problemas creando el servidor en el puerto "+ PUERTO);
        }
    }

    
}
