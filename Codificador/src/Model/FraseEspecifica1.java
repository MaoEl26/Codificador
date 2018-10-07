
package Model;

import java.util.ArrayList;

/*
Esta sera la frase sin repetidos ni duplicados
 */
public class FraseEspecifica1 extends Frase{
    
    public FraseEspecifica1(Alfabeto alfabeto, int longitud){
        super (alfabeto, longitud);
    }

    @Override
    public String generarFrase() {
        
        String fraseFinal="";
        int random;
        int random2;
        int bandera=0;
        ArrayList<String> listaSimbolos=this.getAlfabeto().getList();
        
        random = (int) (Math.random()*listaSimbolos.size());
        random2 = (int) (Math.random()*listaSimbolos.size());

        for (int i=0; i<this.getLongitud(); i++){       
            fraseFinal = fraseFinal.concat(listaSimbolos.get(random));
            while(bandera<100){
                if(fraseFinal.contains(listaSimbolos.get(random2)) || random2==random+1){
                    random2 = (int) (Math.random()*listaSimbolos.size());
                    bandera++;
                }
                else{
                    random=random2;
                    random2 = (int) (Math.random()*listaSimbolos.size());
                    bandera=0;
                    break;
                }            
            }
            if(bandera>=100){
                break;
            }
        }    
        return fraseFinal;
    }

}

