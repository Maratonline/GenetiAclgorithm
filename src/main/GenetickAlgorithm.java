package main;

import calculation.FormulaDevice;
import config.Parametr;
import interfaces.FormulaDevicable;

import java.util.HashMap;
import java.util.Map;

public class GenetickAlgorithm {
    Parametr parametr = null;
    private FormulaDevicable formulaDevice = new FormulaDevice();

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
            Genom<Integer> genom = new Genom<>();
            genom.setAtribut("a", 4);
            genom.setAtribut("b", 7);
            System.out.println(formulaDevice.parce(formula, genom));
        });
    }

    public class Genom<T>{
        Map<String, T> formulsAtribut = new HashMap<>();

     public T getAtributValue(String atributName){
         return formulsAtribut.get(atributName);
     }

     public void setAtribut(String atributName, T atributValue){
         formulsAtribut.put(atributName, atributValue);
     }

    }
}
