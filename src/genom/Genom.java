package genom;

import java.util.HashMap;
import java.util.Map;

public class Genom <T extends Number> {
    Map<String, T> formulsAtributs = new HashMap<>();
    Map<String, T> atributRages = new HashMap<>();


    public T getAtributValue(String atributName){
        return formulsAtributs.get(atributName);
    }

    public void setAtribut(String atributName, T atributValue, T atributsRage){
        formulsAtributs.put(atributName, atributValue);
        atributRages.put(atributName, atributsRage);
    }
}
