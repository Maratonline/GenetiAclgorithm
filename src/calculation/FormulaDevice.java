package calculation;

import config.Parametr;
import interfaces.FormulaDevicable;

public class FormulaDevice implements FormulaDevicable {
    private Parametr parametr;

    @Override
    public void parce(Parametr parametr) {
        parametr.getFormulaList().forEach(formula ->
                formulaCalculation(formula)
        );
    }

    private void formulaCalculation(Parametr.Formula formula) {
        char[] formulaChar = formula.getFormula().toCharArray();
        char firstElement;
        char secondElement;
        int power = 0;
        for (char element : formulaChar) {
            if (Character.isDigit(element))
                power = (int) element;
            else if (Character.isLetter(element))
                firstElement = element;
            switch (element) {
                case '+':
                    System.out.println("plus");
                    break;
                case '-':
                    System.out.println("plus");
                    break;
                case '*':
                    System.out.println("plus");
                    break;
                case '/':
                    System.out.println("plus");
                    break;
                case '^':
                    System.out.println("plus");
                    break;
            }
        }
    }
    

}
