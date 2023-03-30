public class Math {

    public double[] sum(double[] vector, double[] vector1) {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = vector[i] + vector1[i];
        }
        return result;
    }

    public double[] subtract(double[] vector, double[] vector1) {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = vector[i] - vector1[i];
        }
        return result;
    }

    public double[] multiply(double scalar, double[] vector) {
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = scalar * vector[i];
        }
        return result;
    }

    public double[] multiplyScalarByVector(double scalar, double[] vector, double[] vector1) {
        double[] r = multiply(scalar, vector);
        double[] result = subtract(r, vector1);
        return result;
    }

    public double normVector(double[] A){
        double sum = 0;
        for(int i = 0; i < A.length; i++){
            sum += java.lang.Math.pow(A[i], 2);
        }
        return java.lang.Math.sqrt(sum);
    }
    public double magnitud(double scalar, double[] A, double scalar1, double[] B, double[] C){
        double[] result = subtract(sum(multiply(scalar,A), multiply(scalar1,B)),C);
        return normVector(result);
    }

    public double dotProduct(double[] A, double[] B) {
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[i];
        }
        return sum;
    }

    public double[] crossProduct(double[] A, double[] B) {
        double[] C = new double[3];
        C[0] = A[1] * B[2] - A[2] * B[1];
        C[1] = A[2] * B[0] - A[0] * B[2];
        C[2] = A[0] * B[1] - A[1] * B[0];
        return C;
    }

    public double magnitudR3(double[] U, double[] V, double[] S, double[] W) {
        double[] A = multiply(4, U);
        double[] B = multiply(2, V);
        double[] D = multiply(dotProduct(A, B), S);
        double[] G = crossProduct(D, W);
        return normVector(G);
    }

}


