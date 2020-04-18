package config;

import java.util.ArrayList;
import java.util.List;

public class Parametr <N extends Number> {

    private Parametr parametr = null;
    private List<Atribut> atributList = new ArrayList<>();
    private List<Formula> formulaList = new ArrayList<>();


    public void setLicnkToCreatedParametr(Parametr<N> parametr){
        this.parametr = parametr;
    }

    /**
     * @param name String
     * @return Atribut
     */
    public Atribut createAtribut(String name) {
        Atribut atribut = new Atribut(name);
        atributList.add(atribut);
        return atribut;
    }

    /**
     * @param name String
     * @param formulaStr String
     * @return Formula
     */
    public Formula setFormula(String name, String formulaStr) {
        Formula formula = new Formula(name,formulaStr);
        formulaList.add(formula);
        return formula;
    }

    public List<Atribut> getAtributList() {
        return atributList;
    }

    public List<Formula> getFormulaList() {
        return formulaList;
    }

    public class Formula {
        private String name, formula;
        private int bestResult;
        boolean bestResultMin, bestResultMax = false;

        private Formula(String name, String formula) {
            this.formula = formula;
        }

        public String getName() {
            return name;
        }

        public String getFormula() {
            return formula;
        }

        public int getBestResult() {
            return bestResult;
        }

        public Parametr bestResultMax(){
            bestResultMax = true;
            return parametr;
        }
        public Parametr bestResultMin(){
            bestResultMin = true;
            return parametr;
        }
        public Parametr setBestResult(int bestResult){
            this.bestResult = bestResult;
            return parametr;
        }

    }

    public class Atribut<N> {
        private String name;
        private N min, max, rage;


        public Atribut(String name) {
            this.name = name;
        }

        public Atribut setMin(N min) {
            this.min = min;
            System.out.println("ATRIBUT min" + min);
            return this;
        }

        public Atribut setMax(N max) {
            this.max = max;
            System.out.println("ATRIBUT max" + max);
            return this;
        }

        public Atribut setRage(N rage) {
            this.rage = rage;
            System.out.println("ATRIBUT rage" + rage);
            return this;
        }

        public Parametr end() {
            return parametr;
        }
    }


}
