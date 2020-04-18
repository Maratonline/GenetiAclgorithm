package genom;

import java.util.HashMap;
import java.util.Map;

public class Genom<T> {
    Map<String, T> formulsAtribut = new HashMap<>();

    public T getAtributValue(String atributName){
        return formulsAtribut.get(atributName);
    }

    public void setAtribut(String atributName, T atributValue){
        formulsAtribut.put(atributName, atributValue);
    }
}
