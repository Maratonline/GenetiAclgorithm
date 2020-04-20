package genom;

import java.util.HashMap;
import java.util.Map;

public class Genom <T extends Number> {
    Map<String, T> formulsAtributs = new HashMap<>();



    public T getAtributValue(String atributName){
        return formulsAtributs.get(atributName);
    }

    public Map<String, T> getAtributsMap(){
        return formulsAtributs;
    }

    public void setAtribut(String atributName, T atributValue){
        formulsAtributs.put(atributName, atributValue);
    }
}
