import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Math math = new Math();

        double [] A = {3,3};
        double [] B = {1,4};
        double [] C = {4,7};
        double [] U = {3,3,2};
        double [] V = {1,4,4};
        double [] W = {4,7,5};
        double [] S = {4,3,-5};

        System.out.println("A + B");
        System.out.println(Arrays.toString(A)+" + "+Arrays.toString(B)+" = "+Arrays.toString(math.sum(A,B)));
        System.out.println("A - B");
        System.out.println(Arrays.toString(A)+" - "+Arrays.toString(B)+" = "+Arrays.toString(math.subtract(A,B)));
        System.out.println("7 * (A + C)");
        System.out.println(Arrays.toString(math.multiply(7,math.sum(A,C))));
        System.out.println("[7 * (A + B)] - C");
        System.out.println(Arrays.toString(math.multiplyScalarByVector(7,math.sum(A,B),C)));
        System.out.println("R = || 4(A) + 5(B) - C||");
        System.out.println(math.magnitud(4,A,5,B,C));

        System.out.println("R = ||[(4(U) * 2(V)) C] x W||");
        System.out.println(math.magnitudR3(U,V,S,W));

    }
}
