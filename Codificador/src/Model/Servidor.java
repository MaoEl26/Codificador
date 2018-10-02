/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.net.*;
import java.io.*;

/**
 *
 * @author reese
 */
public class Servidor implements Runnable{
    
    ServerSocket server;
    Socket socket;
    private static Servidor instancia;
    
    int puerto = 9090;
    DataOutputStream salida;
    BufferedReader entrada;
    
    boolean estadoServidor = true;
    
    private Servidor() { }
    
    public static synchronized Servidor getInstance() {
        if (instancia == null)
            instancia = new Servidor();
        return instancia;
    }
    
    public void iniciar(){
        
        Thread hilo = new Thread(this);
        hilo.start();
        
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(puerto);
            socket = new Socket();
            
            while(estadoServidor){    
                socket = server.accept();

                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msj = entrada.readLine();
                System.out.println(msj);
                salida = new DataOutputStream(socket.getOutputStream());
                salida.writeUTF("Recibido!");
                socket.close();
                
            
                if(msj.equalsIgnoreCase("salir")){
                    server.close();
                    break;
                }
            }
            
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
    
    public void cambiarEstadoServer(){
        estadoServidor = !estadoServidor;
    }
    
}
