package Model;


public abstract class Frase {
    
    private Alfabeto alfabeto;
    private int longitud;

    public Frase(Alfabeto alfabeto, int longitud) {
        this.alfabeto = alfabeto;
        this.longitud = longitud;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    public abstract String generarFrase();

}
