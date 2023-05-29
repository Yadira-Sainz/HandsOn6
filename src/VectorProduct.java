public class VectorProduct{

     public static Vector multiplyScalarByVector(double scalar, Vector vector, Vector vector1) {
        Vector r = VectorOperations.multiply(scalar, vector);
        Vector result = VectorOperations.subtract(r, vector1);
        return result;
    }

}
