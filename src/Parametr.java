import java.util.ArrayList;
import java.util.List;

public class Parametr {
    private final int CREATING_CODE = 3453;
    private static Parametr parametr = null;
    private List<Atribut> atributList = new ArrayList<>();
    private List<Formula> formulaList = new ArrayList<>();


    public static Parametr init() {
        if (parametr == null)
            parametr = new Parametr(3453);
        return parametr;
    }

    public Parametr(){
        createExecption();
    }
    public Parametr(int creatingCode){
        if (creatingCode != CREATING_CODE)
      createExecption();
    }

    private void createExecption(){
        System.out.println("You cant create instance of this object! Use method init");
        throw new RuntimeException();
    }

    public Atribut createAtribut(String name) {
        Atribut atribut = new Atribut(name);
        atributList.add(atribut);
        return atribut;
    }

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
        private Object bestResult;
        boolean bestResultMin, bestResultMax = false;

        public Formula(String name, String formula) {
            this.formula = formula;
        }
        public Parametr bestResultMax(){
            bestResultMax = true;
            return parametr;
        }
        public Parametr bestResultMin(){
            bestResultMin = true;
            return parametr;
        }
        public Parametr setBestResult(Object bestResult){
            this.bestResult = bestResult;
            return parametr;
        }


    }

    public class Atribut {
        private String name;
        private Object min, max;

        public Atribut(String name) {
            this.name = name;
        }

        public Atribut setMin(Object min) {
            this.min = min;
            System.out.println("ATRIBUT min" + min);
            return this;
        }

        public Atribut setMax(Object max) {
            this.max = max;
            System.out.println("ATRIBUT max" + max);
            return this;
        }

        public Parametr end() {
            return parametr;
        }
    }


}
