package Model;

import Controller.DTOAlgoritmos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.util.Calendar;

public class EscritorPDF implements IEscritor{
    
    String modo;
    String fecha;
    String hora;
    
    Paragraph horaParagraph,fechaParagraph,horaParagraph1,modoParagraph,fraseParagraph;
    
    @Override
    public void escribirSalida(DTOAlgoritmos dtoAlgoritmos) {
        if (dtoAlgoritmos.isModoCodificacion()){
                modo = "Codificación";
            }else{
                modo = "Decodificacón";
            }
        String ruta = "/Escritorio/"+modo+".pdf";
        File file = new File(ruta);
        try{
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream(file));
            }catch(FileNotFoundException fileNotFoundException){
                System.out.println("(No se encontró el fichero para generar el pdf)" 
                        + fileNotFoundException);
            }
            document.open();
            Calendar calendario = Calendar.getInstance();
            fecha = "Fecha: "+Integer.toString(calendario.get(Calendar.DATE))+"/"+
                            Integer.toString(calendario.get(Calendar.MONTH))+"/"+
                            Integer.toString(calendario.get(Calendar.YEAR));
            fechaParagraph = new Paragraph(fecha);
            hora =  "Hora: "+Integer.toString(calendario.get(Calendar.HOUR))+":"+
                            Integer.toString(calendario.get(Calendar.MINUTE));
            horaParagraph = new Paragraph(hora);
            fraseParagraph = new Paragraph("Frase: "+dtoAlgoritmos.getFraseActual());
            document.addTitle("Algoritmos de "+modo);
            document.add(fechaParagraph);
            document.add(horaParagraph);
            document.add(fraseParagraph);
            
            for (int i = 0; i < dtoAlgoritmos.getListaSalidas().size(); i++) {
                document.add(new Paragraph("Algoritmo: "+
                        dtoAlgoritmos.getListaAlgoritmosSolicitados().get(i)));
                document.add(new Paragraph("Modo: "+modo));
                document.add(new Paragraph(dtoAlgoritmos.getListaSalidas().get(i)));
           }
            
            document.close();
        }catch(DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
}
