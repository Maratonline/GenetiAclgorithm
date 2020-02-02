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

//        test04();

    }



    private static void test02() {
        Interpreter.Expr expr = Interpreter.parse("w x z * *");
        Map<String, Integer> context = Map.of("w", 5, "x", 10, "z", 42);
        int result = expr.interpret(context);
        System.out.println(result);    // -27
    }

    private static void test04() {
        Interpretation interpretation = new Interpretation();
        Map<Character, Integer> arguments = new HashMap<>();
        arguments.put('a', 5);
        arguments.put('b', 8);
//        arguments.put('c', 2);
//        arguments.put('d', 2);
        interpretation.setArguments(arguments);
        interpretation.parse("a^2*b");
    }


    private static void test01() {
        String formula = "a*b";
        String formula1 = "a^2+b^2=#";
        Map<Character, Integer> arguments = new HashMap<>();
        arguments.put('a', 5);
        arguments.put('и', 8);

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
