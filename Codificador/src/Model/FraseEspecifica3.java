
package Model;

import java.util.ArrayList;

/**
Frase con consecutivos y duplciados permitidos
 */
public class FraseEspecifica3 extends Frase{
    
    public FraseEspecifica3(Alfabeto alfabeto, int longitud){
        super (alfabeto, longitud);
    }

    @Override
    public String generarFrase() {
        String fraseFinal="";
        int random;
        ArrayList<String> listaSimbolos=this.getAlfabeto().getList();
        
        random = (int) (Math.random()*listaSimbolos.size());

        for (int i=0; i<this.getLongitud(); i++){       
            fraseFinal = fraseFinal.concat(listaSimbolos.get(random));
        }    
        return fraseFinal;
    }
    
}
