public class Digital {
    public static void main(String[] arg) {
        int n = 10000000;
        int digitsNumber = 0;
        if (n > 0)
            digitsNumber = n - n / 10;
        System.out.println(digitsNumber);
    }
}
