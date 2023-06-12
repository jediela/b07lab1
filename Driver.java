import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));
        
        double[] c1 = {6, 0, 0, 5};
        int[] e1 = {0, 1, 2, 3};
        Polynomial p1 = new Polynomial(c1, e1);
        
        double[] c2 = {0, -2, 0, 0, -9};
        int[] e2 = {0, 1, 2, 4, 5};
        Polynomial p2 = new Polynomial(c2, e2);
        
        Polynomial s = p1.add(p2);
        
        System.out.println("-----Result of adding-----");
        System.out.println("Coef: "+Arrays.toString(s.coefficients));
        System.out.println("Exponents: "+Arrays.toString(s.exponents));
        System.out.println();
        
        System.out.println("s(1.2) = " + s.evaluate(1.2));
        
        if (s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");

        Polynomial product = p1.multiply(p2);
        System.out.println("\n-----Result of multiply-----");
        System.out.println("Coef: "+Arrays.toString(product.coefficients));
        System.out.println("Exponents: "+Arrays.toString(product.exponents));
        System.out.println();
    
    }
}