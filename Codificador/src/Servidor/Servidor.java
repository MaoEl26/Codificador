/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import java.net.*;
import java.io.*;

/**
 *
 * @author reese
 */
public class Servidor {
    
    ServerSocket server;
    Socket socket;
    int puerto = 9090;
    DataOutputStream salida;
    BufferedReader entrada;
    
    public void iniciar(){
        try {
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket = server.accept();
            
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msj = entrada.readLine();
            System.out.println(msj);
            salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("Recibido!");
            socket.close();
        } catch (Exception e) {
        
        }
    }
}
