package main;

import calculation.CalculatorBigDecimal;
import calculation.Predictor;
import config.Parametr;
import genom.Genom;
import calculation.Calculatable;
import genom.Modificator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenetickAlgorithm<N extends Number> {

    private Calculatable calculator = null;
    private Genom<N> currentGenom = null;
    private Parametr<N> parametr = null;
    private Predictor<N> predictor = null;
    private Modificator<N> modificator = null;

    private Map<String, Genom<N>> bestGenom = new HashMap<>();
    private Map<String, Genom<N>> previousGenoms = new HashMap<>();
    private Map<String, Parametr<N>.Atribut<N>> atributMap = null;
    private List<Parametr<N>.Atribut<N>> atributsList = null;
    private List<Parametr<N>.Formula> formulaList = null;

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
        currentGenom = new Genom<N>();
        atributMap = parametr.getAtributMap();
        atributsList =  parametr.getAtributList();
        formulaList = parametr.getFormulaList();
        possibleIterations = predictor.predictIterations(parametr);
        modificator = new Modificator<>(parametr);
        for (Map.Entry<String, Parametr<N>.Atribut<N>> entry : atributMap.entrySet()) {
            currentGenom.setAtribut(entry.getKey(), entry.getValue().getMin());
        }
        return currentGenom;
    }

    protected Parametr<N> getParametr() {
        if (parametr == null) {
            parametr = new Parametr<N>();
            parametr.setLicnkToCreatedParametr(parametr);
        }
        return parametr;
    }

    public void creatAlgorithm() {
        preparetGenerator();
        parametr.getFormulaList().forEach(formula -> {
            calculator.parce(formula, currentGenom);
            bestGenom.put(formula.getName(), currentGenom);
        });
        findGenom();

    }

    private void findGenom() {
        int count = 0;
        while (possibleIterations.compareTo(BigInteger.ZERO) != 0) {
            currentGenom = modificator.modificate(currentGenom);
            System.out.println("count = " +count+ "   a " + currentGenom.getAtributValue("a") + " b" + currentGenom.getAtributValue("b") + " z" + currentGenom.getAtributValue("z")+ " y" + currentGenom.getAtributValue("y"));
            formulaList.forEach(formula -> {
                bestGenom.put(formula.getName(), currentGenom);
            });
            count++;
          possibleIterations = possibleIterations.subtract(BigInteger.valueOf(1));
        }
        System.out.println("The count is " + count);
    }

    private void forTest() {
        //for test
        for (Map.Entry<String, Genom<N>> entry : bestGenom.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, N> entyAtr : entry.getValue().getAtributsMap().entrySet())
                System.out.println(entyAtr.getKey() + " " + entyAtr.getValue());

        }
    }


}
