package main;

import calculation.CalculatorBigDecimal;
import config.Parametr;
import genom.Genom;
import calculation.Calculatable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenetickAlgorithm<N extends Number> {


    private Map<String, Genom<N>> bestGenom = new HashMap<>();
    private Map<String, Genom<N>> previousGenoms = new HashMap<>();

    Map<String, Parametr<N>.Atribut<N>> atributMap = null;
    List<Parametr.Atribut> atributsList = null;
    private Calculatable calculator;
    private Genom<N> previosgenom = null;
    private Parametr<N> parametr = null;


    //Todo once, it should to chouse which type of calcualtor to create
    GenetickAlgorithm() {
        calculator = new CalculatorBigDecimal();
//    else
//        calculator = new Calculator<N>();

    }

    public void addAtribut(Parametr parametr) {
        this.parametr = parametr;
    }

    public void addFormul(Parametr parametr) {
        this.parametr = parametr;
    }

    private Genom<N> preparetGenerator() {
        previosgenom = new Genom<N>();
        atributMap = parametr.getAtributMap();
        atributsList = (List<Parametr.Atribut>) parametr.getAtributList();

        for (Map.Entry<String, Parametr<N>.Atribut<N>> entry : atributMap.entrySet()) {
            previosgenom.setAtribut(entry.getKey(), entry.getValue().getMin());
        }
        return previosgenom;
    }

    public Parametr<N> getParametr() {
        if (parametr == null) {
            parametr = new Parametr<N>();
            parametr.setLicnkToCreatedParametr(parametr);
        }
        return parametr;
    }

    public void creatAlgorithm() {
        preparetGenerator();
        parametr.getFormulaList().forEach(formula -> {
            System.out.println(calculator.parce(formula, previosgenom));
            calculator.parce(formula, previosgenom);
            bestGenom.put(formula.getName(), previosgenom);
        });

        parametr.getFormulaList().forEach(formula -> {
            Genom<N> currentGenom = modificator();
            System.out.println(calculator.parce(formula, currentGenom));
            bestGenom.put(formula.getName(), currentGenom);
        });

        for (Map.Entry<String, Genom<N>> entry : bestGenom.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, N> entyAtr : entry.getValue().getAtributsMap().entrySet())
                System.out.println(entyAtr.getKey() + " " + entyAtr.getValue());

        }
    }

    private Genom<N> modificator() {
        Genom<N> genom = new Genom<N>();

        for (Map.Entry<String, N> entry : previosgenom.getAtributsMap().entrySet()) {
            Parametr<N>.Atribut<N> currentAtribut = atributMap.get(entry.getKey());
            Float newValue = entry.getValue().floatValue();
            if (newValue < currentAtribut.getMax().floatValue())
                newValue += currentAtribut.getRage().floatValue();
            genom.setAtribut(entry.getKey(), (N) newValue);
        }

        return genom;
    }


}
