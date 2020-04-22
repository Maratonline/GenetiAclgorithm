package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parametr <N extends Number> {

    private Parametr parametr = null;
    private List<Atribut<N>> atributList = new ArrayList<>();
    private List<Formula> formulaList = new ArrayList<>();
    private Map<String, Atribut<N>> atributMap = new HashMap<>();


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
        atributMap.put(name, atribut);
        return atribut;
    }

    public Map<String, Atribut<N>> getAtributMap(){
        return atributMap;
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

    public List<Atribut<N>> getAtributList() {
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
            this.name = name;
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
            return this;
        }

        public Atribut setMax(N max) {
            this.max = max;
            return this;
        }

        public Atribut setRage(N rage) {
            this.rage = rage;
            return this;
        }
        public String getName(){
            return name;
        }

        public N getRage(){
            return rage;
        }

        public N getMax(){
            return max;
        }

        public N getMin(){
            return min;
        }

        public Parametr end() {
            return parametr;
        }
    }


}
