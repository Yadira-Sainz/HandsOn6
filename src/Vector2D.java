import java.util.Arrays;

public class Vector2D implements Vector{
        private double[] array;

        public Vector2D(int x, int y) {
            this.array = new double[2];
            this.array[0] = x;
            this.array[1] = y;
        }

    public Vector2D(double[] result) {
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
        return "Vector2D{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}


