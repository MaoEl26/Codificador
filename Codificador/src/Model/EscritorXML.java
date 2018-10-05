package Model;

import Controller.DTOAlgoritmos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class EscritorXML implements IEscritor{

    String modo;
    String fecha;
    String hora;
    Calendar calendario;
    
    XMLOutputFactory  factory;
    XMLStreamWriter writer;
    
    FileWriter fw;
    
    @Override
    public void escribirSalida(DTOAlgoritmos dtoAlgoritmos) {
        if (dtoAlgoritmos.isModoCodificacion()){
                modo = "Codificación";
            }else{
                modo = "Decodificacón";
            }
        calendario = Calendar.getInstance();

        String ruta = "../Codificador/Logs/"+modo+".xml";
        
        try{  
            fw = new FileWriter(ruta, true);
        }catch(IOException e){
            System.out.println("(No se encontró el fichero para generar el pdf)" 
                        + e);
        }
        try{
            factory = XMLOutputFactory.newInstance();
            writer = factory.createXMLStreamWriter(fw);
            writer.writeStartDocument("Algoritmos de Codificacion/Decodificacion \n");
            
            fecha = Integer.toString(calendario.get(Calendar.DATE))+"/"+
                    Integer.toString(calendario.get(Calendar.MONTH))+"/"+
                    Integer.toString(calendario.get(Calendar.YEAR))+"\n";
            
            hora =  Integer.toString(calendario.get(Calendar.HOUR))+":"+
                    Integer.toString(calendario.get(Calendar.MINUTE))+"\n";
   
            writer.writeStartElement("fecha");
            writer.writeCharacters(fecha);
            writer.writeEndElement();
            
            writer.writeStartElement("hora");
            writer.writeCharacters(hora);
            writer.writeEndElement();
            
            writer.writeStartElement("frase");
            writer.writeCharacters(dtoAlgoritmos.getFraseActual()+"\n");
            writer.writeEndElement();
            
            for (int i = 0; i < dtoAlgoritmos.getListaSalidas().size(); i++) {
                writer.writeStartElement("algoritmo");
                writer.writeCharacters(dtoAlgoritmos.getListaAlgoritmosSolicitados().get(i)+"\n");
                
                writer.writeStartElement("modo");
                writer.writeCharacters(modo+"\n");
                writer.writeEndElement();
                
                writer.writeStartElement("salida");
                writer.writeCharacters(dtoAlgoritmos.getListaSalidas().get(i)+"\n");
                writer.writeEndElement();
                
                writer.writeEndElement();
            }
            writer.writeCharacters("\n");
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            fw.close();
        }
        catch (IOException | XMLStreamException ex) {
            Logger.getLogger(EscritorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
