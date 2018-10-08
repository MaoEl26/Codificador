/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.io.Serializable;


/**
 *
 * @author ersolano
 */
public class OBJComunicacion implements Serializable{

    DTOAlgoritmos dtoAlgoritmo;
    DTOFrase dtoFrase;
    AccionesServidor Accion;
    Object datoSalida;

    public OBJComunicacion(DTOAlgoritmos dtoAlgoritmo, DTOFrase dtoFrase, AccionesServidor Accion) {
        this.dtoAlgoritmo = dtoAlgoritmo;
        this.dtoFrase = dtoFrase;
        this.Accion = Accion;
    }

    public OBJComunicacion(AccionesServidor Accion) {
        this.Accion = Accion;
    }
    
    public DTOAlgoritmos getDtoAlgoritmo() {
        return dtoAlgoritmo;
    }

    public void setDtoAlgoritmo(DTOAlgoritmos dtoAlgoritmo) {
        this.dtoAlgoritmo = dtoAlgoritmo;
    }

    public DTOFrase getDtoFrase() {
        return dtoFrase;
    }

    public void setDtoFrase(DTOFrase dtoFrase) {
        this.dtoFrase = dtoFrase;
    }

    public AccionesServidor getAccion() {
        return Accion;
    }

    public void setAccion(AccionesServidor Accion) {
        this.Accion = Accion;
    }

    public Object getDatoSalida() {
        return datoSalida;
    }

    public void setDatoSalida(Object datoSalida) {
        this.datoSalida = datoSalida;
    }

    
    
}
