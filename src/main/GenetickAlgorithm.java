package main;

import calculation.CalculatorBigDecimal;
import calculation.Predictor;
import config.Parametr;
import genom.Genom;
import calculation.Calculatable;

import java.math.BigDecimal;
import java.math.BigInteger;
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
    private Predictor<N> predictor = null;
    private BigInteger possibleIterations;


    //Todo once, it should to chouse which type of calcualtor to create
    GenetickAlgorithm() {
        predictor = new Predictor<>();
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
        possibleIterations = predictor.predictIterations(parametr);
        preparetGenerator();
        parametr.getFormulaList().forEach(formula -> {
            calculator.parce(formula, previosgenom);
            bestGenom.put(formula.getName(), previosgenom);
        });


    }

    private void findGenom(){

        while(possibleIterations.compareTo(BigInteger.ZERO) == 0)
        parametr.getFormulaList().forEach(formula -> {
            Genom<N> currentGenom = modificator();
            bestGenom.put(formula.getName(), currentGenom);
        });
    }

    private void forTest(){
        //for test
        for (Map.Entry<String, Genom<N>> entry : bestGenom.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, N> entyAtr : entry.getValue().getAtributsMap().entrySet())
                System.out.println(entyAtr.getKey() + " " + entyAtr.getValue());

        }
    }




}
