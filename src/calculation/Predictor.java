package calculation;

import config.Parametr;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Predictor<N extends Number> {


    public BigInteger predictIterations(Parametr<N> parametr){
        BigDecimal currentNumber = new BigDecimal(1.0);
        for (Parametr<N>.Atribut<N> atribut :  parametr.getAtributList()) {
            float cutrent = (atribut.getMax().floatValue()- atribut.getMin().floatValue()) / atribut.getRage().floatValue();
            currentNumber = currentNumber.multiply(BigDecimal.valueOf(Math.ceil(cutrent)));
        }

        return currentNumber.toBigInteger();
    }
}
