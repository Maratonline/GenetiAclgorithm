package calculation;

import config.Parametr;
import genom.Genom;
import main.GenetickAlgorithm;

public class Calculator<N extends  Number> implements Calculatable<N> {


    private Integer firstElement = null;
    private Integer secondElement = null;
    private Character operator = null;
    private boolean nexPower = false;

    private String[] stringFormulaPreparation(String formula) {
        return formula.split("[ ]");
    }

    @Override
    public N parce(Parametr.Formula formula, Genom genom) {
        String[] formulaChar = stringFormulaPreparation(formula.getFormula());
        boolean isPower = false;
        firstElement = null;
        secondElement = null;
        nexPower = false;
        operator = null;

        for (int i = 0; i < formulaChar.length; i++) {
            String element = formulaChar[i];
            if ((i + 1) < formulaChar.length && formulaChar[i + 1].equals("^"))
                nexPower = true;
            if (element.matches( ALL_DIGITALS)) {
                if (isPower) {
                    if (secondElement != null)
                        secondElement = calculate(secondElement, '^', Integer.parseInt(element));
                    else
                        firstElement = calculate(firstElement, '^', Integer.parseInt(element));
                    isPower = false;
                    nexPower = false;
                } else {
                    setArgument( Integer.parseInt(element));
                }
            } else if (element.matches("[a-zA-Z]+")) {
                setArgument((Integer) genom.getAtributValue(element));
            } else if (element.equals("^")) {
                isPower = true;
            } else if ("/*+-".contains(element))
                operator = element.toCharArray()[0];
            calculateIfPossible();
        }
       calculateIfPossible();
        return (N)firstElement;
    }

    private void setArgument(Integer element){
        if (firstElement == null)
            firstElement = element;
        else if (secondElement == null)
            secondElement = element;
    }
    private void calculateIfPossible(){
        if (secondElement != null && operator != null && !nexPower) {
            firstElement = calculate(firstElement, operator, secondElement);
            secondElement = null;
            operator = null;
        }
    }

    private Integer calculate(Integer arg1, char operator, Integer arg2) {
        switch (operator) {
            case '+':
                return arg1 + arg2;
            case '-':
                return arg1 - arg2;
            case '*':
                return arg1 * arg2;
            case '/':
                if (!hasNotNull(arg1, arg2))
                    return 0;
                return arg1 / arg2;
            case '^':
                Double res = Math.pow(arg1, arg2);
                return res.intValue();
        }
        return null;
    }

    /**
     * @param arg1 Object
     * @param arg2 Object
     * @return false if someone is null
     */
    private boolean hasNotNull(Object arg1, Object arg2) {
        if (arg1 != null && arg2 != null) {
            return isArgNull(arg1) && isArgNull(arg2);
        }
        return false;
    }

    private boolean isArgNull(Object arg) {
        String[] args = arg.toString().replace("-", "").split("[,.]");
        for (int i = 0; i < args.length; i++)
            if (!args[i].equals("0")) {
                return true;
            }
        return false;
    }

}
