import config.Parametr;

import java.util.HashMap;
import java.util.Map;

public class GenetickAlgorithm {
    Parametr parametr = null;

    public GenetickAlgorithm(){
    }

    public void addAtribut(Parametr parametr){
        this.parametr = parametr;
    }
    public void addFormul(Parametr parametr){
        this.parametr = parametr;
    }

    public void creatAlgorithm(){
        parametr.getFormulaList().forEach(formula -> {

        });
    }

    public class Genom{
        Map<String, Integer> formulsAtribut = new HashMap<>();

        public void createAlgorithm(String formula){

        }

    }
}
