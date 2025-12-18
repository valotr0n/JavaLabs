public class GeometricMeanOfNegatives {
    public static void main(String[] args) {
        int array[] = {5,12,-15,-20,55,128,13,-7,10,11,99,-25,-136,78,66,16,88,-29,100,20};
        int product = 1;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                product *= array[i];
                count++;
            }
        }
        double geometricMean = Math.pow(product, 1.0/count);
        geometricMean = -geometricMean;
        System.out.println(geometricMean);
    }
}
