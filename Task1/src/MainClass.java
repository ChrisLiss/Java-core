
public class MainClass {

    public static void main(String[] args) {

        int[][] array = new int [5][5];

        System.out.println("Array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++)
            {
                array[i][j] = randomInt((j - 1) * array[0].length + i);
                System.out.print(array[i][j] + " ") ;
            }
            System.out.println();
        }

        System.out.println();
        findMinMaxAvg(array);

    }

    private static void findMinMaxAvg(int[][] array) {
        int min = array[0][0];
        int max = array[0][0];
        int sumArray = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++)
            {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
                if (array[i][j] > max) {
                    max = array[i][j];
                }
                sumArray += array[i][j];
            }
        }

        double avg = sumArray * 1.0 / (array.length * array[0].length);

        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("avg = " + avg);
    }

    private static int randomInt(int min) {
        int  max = 1000;
        long currentTime = System.currentTimeMillis();
        return (int) (currentTime % (max - min) + min);
    }

}