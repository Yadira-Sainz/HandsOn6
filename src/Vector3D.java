import java.util.Arrays;

public class Vector3D implements Vector{
        private double[] array;

        public Vector3D(int x, int y, int z) {
            this.array = new double[3];
            this.array[0] = x;
            this.array[1] = y;
            this.array[2] = z;
        }

    public Vector3D(double[] result) {
        this.setArray(result);
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public double[] getArray() {
            return this.array;
        }

    @Override
    public String toString() {
        return "Vector3D{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}



