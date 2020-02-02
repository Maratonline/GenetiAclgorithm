import config.Parametr;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        RequestParam requestParam = new RequestParam();
        GenetickAlgorithm genetickAlgorithm = new GenetickAlgorithm();
        Parametr parametr = Parametr.init();
        genetickAlgorithm.addFormul(parametr.setFormula("Sqare", "a*b").bestResultMax());
        genetickAlgorithm.addFormul(parametr.setFormula("Length", "a^2+b^2=#").bestResultMin());
        genetickAlgorithm.addAtribut(parametr.createAtribut("a").setMin("1").setMax("20").end());
        genetickAlgorithm.addAtribut(parametr.createAtribut("b").setMin("1").setMax("20").end());

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
