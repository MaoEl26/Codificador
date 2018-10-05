package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import Controller.DTOAlgoritmos;
import java.util.Calendar;

public class EscritorTxt implements IEscritor{
    
    String modo;
    String fecha;
    String hora;
    Calendar calendario;
    File file;
    
    @Override
    public void escribirSalida(DTOAlgoritmos dtoAlgoritmos) {
        if (dtoAlgoritmos.isModoCodificacion()){
                modo = "Codificación";
            }else{
                modo = "Decodificacón";
            }
        calendario = Calendar.getInstance();

        String ruta = "../Codificador/Logs/"+modo+".txt";
        try{
            file= new File(ruta);
            //file.
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
           
            BufferedWriter bw = new BufferedWriter(fw);
            
        fecha = "Fecha: "+Integer.toString(calendario.get(Calendar.DATE))+"/"+
                        Integer.toString(calendario.get(Calendar.MONTH))+"/"+
                        Integer.toString(calendario.get(Calendar.YEAR));
        bw.write(fecha);
        bw.newLine();
        hora =  "Hora: "+Integer.toString(calendario.get(Calendar.HOUR))+":"+
                        Integer.toString(calendario.get(Calendar.MINUTE));
        bw.write(hora);
        bw.newLine();
        bw.write("Frase: "+dtoAlgoritmos.getFraseActual());
        bw.newLine();
        
        for (int i = 0; i < dtoAlgoritmos.getListaSalidas().size(); i++) {
            bw.write("Algoritmo: "+dtoAlgoritmos.getListaAlgoritmosSolicitados().get(i));
            bw.newLine();
            bw.write("Modo: "+modo);
            bw.newLine();
            bw.write(dtoAlgoritmos.getListaSalidas().get(i));
            bw.newLine();
       }
            bw.close();
        }catch(Exception e){
            System.out.println("(No se encontró el fichero para generar el pdf)" 
                        + e);
        }
    }
    
}
