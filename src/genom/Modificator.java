package genom;

import config.Parametr;

import java.util.*;

public class Modificator<N extends Number> {
    private Parametr parametr = null;
    private int atributsCount = 0;
    private int token = 0;
    private Parametr<N>.Atribut<N> lastAtribut = null;
    private List<Parametr<N>.Atribut<N> > atributList = null;
    private int atribListSize;
    private Deque<Parametr<N>.Atribut<N>> atributDeque;

    //ToDo протестировать
    public Modificator(Parametr<N> parametr) {
        this.parametr = parametr;
        atributList = parametr.getAtributList();
        atributDeque = new LinkedList<>(atributList);
        //atributDeque.addAll(atributList);
        atribListSize = atributList.size() - 1;
        token = atribListSize - 1;
        lastAtribut = atributList.get(atribListSize);
    }

    //old method
    public Genom<N> modificate3(Genom<N> address) {
        Float value = address.getAtributValue(lastAtribut.getName()).floatValue() + lastAtribut.getRage().floatValue();

        if (value < lastAtribut.getMax().floatValue()) {
            address.setAtribut(lastAtribut.getName(), (N) value);
            return address;
        } else {
            address.setAtribut(lastAtribut.getName(), lastAtribut.getMin());
            boolean correctToken = false;
            while (!correctToken) {
                Parametr<N>.Atribut<N> currentAtribut = atributList.get(token);
                Float newValue = address.getAtributValue(currentAtribut.getName()).floatValue() + currentAtribut.getRage().floatValue();
                if (newValue <= currentAtribut.getMax().floatValue()) {
                    address.setAtribut(currentAtribut.getName(), (N) newValue);
                    correctToken = true;
                } else if (address.getAtributValue(currentAtribut.getName()).floatValue() < currentAtribut.getMax().floatValue()) {
                    address.setAtribut(currentAtribut.getName(), currentAtribut.getMax());
                    correctToken = true;
                } else {
                    address.setAtribut(currentAtribut.getName(), currentAtribut.getMin());
                    token--;
                    if (token >= 0) {
                        currentAtribut = atributList.get(token);

                    } else
                        return null;
                }
            }

        }
        return address;
    }



    //new method
    public Genom<N> modificate2(Genom<N> address) {
        Float value = address.getAtributValue(lastAtribut.getName()).floatValue() + lastAtribut.getRage().floatValue();

        if (value < lastAtribut.getMax().floatValue()) {
            address.setAtribut(lastAtribut.getName(), (N) value);
            return address;
        } else {
            address.setAtribut(lastAtribut.getName(), lastAtribut.getMin());
            boolean correctToken = false;
            while (!correctToken) {
                Parametr.Atribut currentAtribut = atributList.get(token);
                if (!moreThanMx(currentAtribut))
                    correctToken = true;
                else
                    token--;
            }

        }
        return address;
    }

    public Genom<N> modificate(Genom<N> address) {
        Parametr<N>.Atribut<N> firstAtribut = atributDeque.getFirst();
        List<Parametr<N>.Atribut<N>> toSetNull = new ArrayList<>();
        Float value = address.getAtributValue(firstAtribut.getName()).floatValue() + firstAtribut.getRage().floatValue();

        if (value < firstAtribut.getMax().floatValue()) {
            address.setAtribut(firstAtribut.getName(), (N) value);
            return address;
        } else if (address.getAtributValue(firstAtribut.getName()).floatValue() < firstAtribut.getMax().floatValue()) {
            address.setAtribut(firstAtribut.getName(), firstAtribut.getMax());
            return address;
        } else {
            address.setAtribut(firstAtribut.getName(), firstAtribut.getMin());
            boolean scip = false;
   //------------------------------------------------------------------------------------------------------------------
            for (Parametr<N>.Atribut<N> currentAtribut : atributDeque) {
                if (scip) {
                    Float currentValue = address.getAtributValue(currentAtribut.getName()).floatValue() + currentAtribut.getRage().floatValue();
                    if (currentValue < currentAtribut.getMax().floatValue()) {
                        address.setAtribut(currentAtribut.getName(), (N) currentValue);
                        return address;
                    } else if (address.getAtributValue(currentAtribut.getName()).floatValue() < currentAtribut.getMax().floatValue()) {
                        address.setAtribut(currentAtribut.getName(), currentAtribut.getMax());
                        return address;
                    } else {
                        address.setAtribut(currentAtribut.getName(), currentAtribut.getMin());
                    }

                } else
                    scip = true;
            }
        }
        return address;
    }

    private boolean moreThanMx(Parametr<N>.Atribut<N> currentAtribut) {
        currentAtribut.getMax().floatValue();
        return false;
    }
}
