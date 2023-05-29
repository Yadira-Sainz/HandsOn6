public class VectorOperations {
     public static Vector sum(Vector vector, Vector vector1) {
        double[] result = new double[vector.getArray().length];
        for (int i = 0; i < vector.getArray().length; i++) {
            result[i] = vector.getArray()[i] + vector1.getArray()[i];
        }
        return new Vector2D(result);
    }

     public static Vector subtract(Vector vector, Vector vector1) {
        double [] result = new double[vector.getArray().length];
        for (int i = 0; i < vector.getArray().length; i++) {
            result[i] = vector.getArray()[i] - vector1.getArray()[i];
        }
        return new Vector2D(result);
    }

     public static double normVector(Vector A) {
        double sum = 0;
        for (int i = 0; i < A.getArray().length; i++) {
            sum += java.lang.Math.pow(A.getArray()[i], 2);
        }
        return java.lang.Math.sqrt(sum);
    }

    public static Vector multiply(double scalar, Vector vector) {
        double[] result = new double[vector.getArray().length];
        for (int i = 0; i < vector.getArray().length; i++) {
            result[i] = scalar * vector.getArray()[i];
        }
        return  new Vector2D(result);
    }

     public static double magnitud(double scalar, Vector A, double scalar1, Vector B, Vector C) {
        Vector result = subtract(sum(multiply(scalar, A), multiply(scalar1, B)), C);
        return normVector(result);
    }

     public static double magnitudR3(int scalar1, int scalar2,Vector U, Vector V, Vector S, Vector W) {
        Vector A = multiply(scalar1, U);
        Vector B = multiply(scalar2, V);
        Vector D = multiply(DotProduct.dotProduct(A, B), S);
        Vector G = CrossProduct.crossProduct(D, W);
        return normVector(G);
    }
}

