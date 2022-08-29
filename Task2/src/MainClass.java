import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {

        int[] array = {5,6,3,2,5,1,4,9};
        printArray(array);
        System.out.println();
        mergeSort(array, 0, array.length - 1);
        printArray(array);

        assert Arrays.equals(array, new int[] {1,2,3,4,5,5,6,9}) : "ожидался массив: {1,2,3,4,5,5,6,9}";

    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void mergeSort(int[] array, int begin, int end) {

        if (begin >= end) {
            return;
        }

        int middle = (begin + end) / 2;
        mergeSort(array, begin, middle);
        mergeSort(array, middle+1, end);
        merge(array, begin, middle, end);
    }

    private static void merge(int[] array, int begin, int middle, int end) {

        int i = begin;
        int j = middle + 1;
        int k = 0;
        int[] tempArray = new int[end - begin + 1];

        while (i <= middle && j <= end) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            }
            else {
                tempArray[k++] = array[j++];
            }
        }

        while (i <= middle) {
            tempArray[k++] = array[i++];
        }

        while (j <= end) {
            tempArray[k++] = array[j++];
        }

        int x = 0;
        for(int m = begin; m < end + 1; m++) {
            array[m] = tempArray[x++];
        }
    }
}
