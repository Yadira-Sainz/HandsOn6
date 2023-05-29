public class DotProduct {
     public static double dotProduct(Vector A, Vector B) {
        double sum = 0;
        for (int i = 0; i < A.getArray().length; i++) {
            sum += A.getArray()[i] * B.getArray()[i];
        }
        return sum;
    }
}
