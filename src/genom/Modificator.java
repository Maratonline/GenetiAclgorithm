package genom;

import calculation.Calculatable;
import calculation.CalculatorBigDecimal;
import config.Parametr;

public class Modificator<N extends Number> {
    private Genom<N> bestResult;
    private Genom<N> currentGen;

    private Calculatable calculator;
    private Parametr parametr = null;

    //Todo once, it should to chouse which type of calcualtor to create
    Modificator(){
        calculator = new CalculatorBigDecimal();
//    else
//        calculator = new Calculator<N>();
    }

    public void renner(){

    }
}
