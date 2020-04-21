package genom;

import calculation.Calculatable;
import calculation.CalculatorBigDecimal;
import config.Parametr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Modificator<N extends Number> {
    private Parametr parametr = null;
    private int atributsCount = 0;
    private int token = 0;
    private Parametr<N>.Atribut<N> currentAtribut = null;
    private List<Parametr.Atribut> atributList = null;

//ToDo протестировать
    public Modificator(Parametr<N> parametr){
        this.parametr = parametr;
        atributList = (List<Parametr.Atribut>) parametr.getAtributList();
        currentAtribut = atributList.get(token);
    }

    public Genom<N> modificate(Genom<N> previousGenom){
        Genom<N> genom = new Genom<N>();
        for (Map.Entry<String, N> entry : previousGenom.getAtributsMap().entrySet())
            genom.setAtribut(entry.getKey(), entry.getValue());
        Float newValue = getNewValue(previousGenom.getAtributValue(currentAtribut.getName()).floatValue());

        genom.setAtribut(currentAtribut.getName(), (N) newValue);

        return genom;
    }
    private Float getNewValue(Float value){
        if (value < currentAtribut.getMax().floatValue())
            return value += currentAtribut.getRage().floatValue();
        else{
            token++;
            if (token > atributList.size())
                token = 0;
            currentAtribut = atributList.get(token);
            return currentAtribut.getMin().floatValue();
        }
    }

//    private void OldMethod(){
//        for (Map.Entry<String, N> entry : previosgenom.getAtributsMap().entrySet()) {
//            Parametr<N>.Atribut<N> currentAtribut = atributMap.get(entry.getKey());
//            Float newValue = entry.getValue().floatValue();
//
//            genom.setAtribut(entry.getKey(), (N) newValue);
//        }
//
//    }
}
