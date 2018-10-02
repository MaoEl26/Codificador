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
public class Cliente {
    
    Socket socket;
    String ip = "127.0.0.1";
    int puerto = 9090;
    BufferedReader entrada, teclado;
    PrintStream salida;
    
    public void inicio(){
        try {
            socket = new Socket(ip, puerto);
            entrada = new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            String tec = teclado.readLine();
            salida = new PrintStream(socket.getOutputStream());
            salida.println(tec);
            String msj = entrada.readLine();
            System.out.println(msj);
            
            entrada.close();
            salida.close();
            teclado.close();
            socket.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}


