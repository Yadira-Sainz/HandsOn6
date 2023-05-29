public class CrossProduct {
     public static Vector crossProduct(Vector A, Vector B) {
        double[] C = new double[3];
        C[0] = A.getArray()[1] * B.getArray()[2] - A.getArray()[2] * B.getArray()[1];
        C[1] = A.getArray()[2] * B.getArray()[0] - A.getArray()[0] * B.getArray()[2];
        C[2] = A.getArray()[0] * B.getArray()[1] - A.getArray()[1] * B.getArray()[0];
        return new Vector3D(C);
    }
}
