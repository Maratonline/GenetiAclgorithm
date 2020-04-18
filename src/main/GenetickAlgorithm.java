package main;

import calculation.CalculatorBigDecimal;
import config.Parametr;
import genom.Genom;
import calculation.Calculatable;

import java.util.HashMap;
import java.util.Map;

public class GenetickAlgorithm <N extends Number>  {

    private Calculatable calculator;
    private Parametr<N> parametr = null;
    private Map<String, Genom<N>> bestGenom = new HashMap<>();

    //Todo once, it should to chouse which type of calcualtor to create
     GenetickAlgorithm(){
        calculator = new CalculatorBigDecimal();
//    else
//        calculator = new Calculator<N>();
    }

    public void addAtribut(Parametr parametr){
        this.parametr = parametr;
    }
    public void addFormul(Parametr parametr){
        this.parametr = parametr;
    }

    public Parametr<N> getParametr(){
         if (parametr == null) {
             parametr = new Parametr<N>();
            parametr.setLicnkToCreatedParametr(parametr);
         }
         return parametr;
    }

    public void creatAlgorithm(){
        parametr.getFormulaList().forEach(formula -> {
            Genom genom = new Genom<N>();
            genom.setAtribut("a", 4, 4);
            genom.setAtribut("b", 7.0f, 0.5f);
            System.out.println(calculator.parce(formula, genom));
        });
    }

    private void modificator(){

    }


}
