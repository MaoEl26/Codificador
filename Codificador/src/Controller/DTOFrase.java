package Controller;

import java.io.Serializable;

public class DTOFrase implements Serializable{
    
    private String frase;
    private int longitudFrase;
    private int tipoFrase;

    public DTOFrase(String frase, int longitudFrase, int tipoFrase) {
        this.frase = frase;
        this.longitudFrase = longitudFrase;
        this.tipoFrase = tipoFrase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    
    
    
    public int getLongitudFrase() {
        return longitudFrase;
    }

    public void setLongitudFrase(int longitudFrase) {
        this.longitudFrase = longitudFrase;
    }

    public int getTipoFrase() {
        return tipoFrase;
    }

    public void setTipoFrase(int tipoFrase) {
        this.tipoFrase = tipoFrase;
    }
    
    
    
}
