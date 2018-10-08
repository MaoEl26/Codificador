package Model;


public class FraseFactory implements FraseFactoryMethod{
    
    public Frase createFrase(int tipo, Alfabeto alfabeto, int longitud){
        switch (tipo) {
            case 1:
            {
                return new FraseEspecifica1(alfabeto, longitud);
            }
            case 2:
            {
                return new FraseEspecifica2(alfabeto, longitud);
            }
            default:
            {
                return new FraseEspecifica3(alfabeto, longitud);
            }
        }
    }
    
}
