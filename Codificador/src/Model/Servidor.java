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
public class Servidor{
    
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
            // detectar lo que le enviaron...
            if (objeto.getAccion() == TipoAccion.REGISTRAR_USUARIO){
                String elLogin=(String) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion REGISTRAR USUARIO.."+ elLogin);
                objeto.setDatoSalida(adm.registrar(elLogin));
            }
            if (objeto.getAccion() == TipoAccion.DESACTIVAR_USUARIO){
                String elLogin=(String) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion DESACTIVAR USUARIO.."+ elLogin);
                objeto.setDatoSalida(adm.desactivar(elLogin));
            }
            
             if (objeto.getAccion() == TipoAccion.REVISAR_USUARIO){
                String elLogin=(String) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion REVISAR USUARIO.."+ elLogin);
                objeto.setDatoSalida(adm.revisar(elLogin));
            }

             
             if (objeto.getAccion() == TipoAccion.ENVIAR_ARCHIVO){
                ArrayList losDatos =(ArrayList) objeto.getDatoEntrada();
                log.setText(log.getText()+ "\nAtendiendo peticion ENVIAR ARCHIVO ..");
                String [] nArchivo = ((String)losDatos.get(0)).split("\\");
                log.setText(log.getText()+ "\nrecibio archivo "+ nArchivo[nArchivo.length-1]);
                objeto.setDatoSalida(Boolean.TRUE);
            }
             
             

           flujoSalida.writeObject(objeto);
        } catch (IOException ex) {
            System.out.println("Problemas leyendo o escribiendo en el flujo entrada/salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problemas en la conversion del objeto recibido...");
        }
    }
    
    public void cambiarEstadoServer(){
        estadoServidor = !estadoServidor;
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
    
    
}
