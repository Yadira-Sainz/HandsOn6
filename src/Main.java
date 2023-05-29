import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Vector A = new Vector2D(3,3);
        Vector B = new Vector2D(1,4);
        Vector C = new Vector2D(4,7);

        Vector U = new Vector3D(3,3,2);
        Vector V = new Vector3D(1,4,4);
        Vector W = new Vector3D(4,7,5);
        Vector S = new Vector3D(4,3,-5);

        System.out.println("A + B");
        System.out.println(Arrays.toString(A.getArray())+" + "+Arrays.toString(B.getArray())+" = " + Arrays.toString(VectorOperations.sum(A,B).getArray()));
        System.out.println("A - B");
        System.out.println(Arrays.toString(A.getArray())+" - "+Arrays.toString(B.getArray())+" = "+Arrays.toString(VectorOperations.subtract(A,B).getArray()));
        System.out.println("7 * (A + C)");
        System.out.println(Arrays.toString(VectorOperations.multiply(7,VectorOperations.sum(A,C)).getArray()));
        System.out.println("[7 * (A + B)] - C");
        System.out.println(Arrays.toString(VectorProduct.multiplyScalarByVector(7,VectorOperations.sum(A,B),C).getArray()));
        System.out.println("R = || 4(A) + 5(B) - C||");
        System.out.println(VectorOperations.magnitud(4,A,5,B,C));

        System.out.println("R = ||[(4(U) * 2(V)) S] x W||");
        System.out.println(VectorOperations.magnitudR3(4,2,U,V,S,W));

        MainVectorOperationsGUI.main(args);

    }
}
