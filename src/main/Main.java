package main;

import config.Parametr;
import main.GenetickAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {

         test();

        //forTest();

    }

    public static void test() {
        GenetickAlgorithm genetickAlgorithm = new GenetickAlgorithm();
        Parametr parametr = Parametr.init();
        // a = 4   b = 7
        genetickAlgorithm.addFormul(parametr.setFormula("Sqare", "a * b + -10 ^ 3").bestResultMax());
        genetickAlgorithm.addFormul(parametr.setFormula("Length", "a ^ 2 + b ^ 2 + 15").bestResultMin());
        genetickAlgorithm.addAtribut(parametr.createAtribut("a").setMin(1.0).setMax(20.0).setRage(0.1).end());
        genetickAlgorithm.addAtribut(parametr.createAtribut("b").setMin(1.0).setMax(20.0).setRage(0.1).end());
        genetickAlgorithm.creatAlgorithm();
    }

    public static void forTest() {
    float fl = 0000.00001f;
    double dg = 000.01d;
//        System.out.println(checkNuber(dg, fl));
    }



    /**
     * i have got to create a tringl with the biggest square
     * but the shortest sum of line
     * so my formuls:
     *
     * Atributs(Amin: 1, Amax: 20, bMin: 1, bMax: 20)
     * Name: Square, formula: a*b, betsResult: 50
     * Name: Length, formula: a^2+b^2=#, bestRuslt: 4
     */


}
