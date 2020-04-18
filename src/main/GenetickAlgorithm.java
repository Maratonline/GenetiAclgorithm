package main;

import calculation.FormulaDevice;
import config.Parametr;
import genom.Genom;
import interfaces.FormulaDevicable;

import java.util.HashMap;
import java.util.Map;

public class GenetickAlgorithm {
    Parametr parametr = null;
    private FormulaDevicable formulaDevice = new FormulaDevice();

    public void addAtribut(Parametr parametr) {this.parametr = parametr;}
    public void addFormul(Parametr parametr) {this.parametr = parametr;}

    public void creatAlgorithm(){
        parametr.getFormulaList().forEach(formula -> {
            Genom<Integer> genom = new Genom<>();
            genom.setAtribut("a", 4);
            genom.setAtribut("b", 7);
            System.out.println(formulaDevice.parce((Parametr.Formula) formula, genom));
        });
    }


}
