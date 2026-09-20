package algorithms;
import utils.Metrics;
public class MergeSort {
    private static final int CUTOFF = 15;
    public static void sort(int[] array, Metrics metrics) {
        int[] buffer = new int[array.length];
        mergeSort(array, buffer, 0, array.length - 1, 1, metrics);
    }
    private static void mergeSort(
            int[] array,
            int[] buffer,
            int left,
            int right,
            int depth,
            Metrics metrics) {

        metrics.updateDepth(depth);
        if(left >= right) {
            return;
        }

        if(right - left + 1 <= CUTOFF) {

            insertionSort(array, left, right, metrics);

            return;
        }

        int middle = (left + right) / 2;
        mergeSort(array, buffer, left, middle, depth + 1, metrics);
        mergeSort(array, buffer, middle + 1, right, depth + 1, metrics);
        merge(array, buffer, left, middle, right, metrics);

    }

    private static void merge(
            int[] array,
            int[] buffer,
            int left,
            int middle,
            int right,
            Metrics metrics) {


        for(int i = left; i <= right; i++) {

            buffer[i] = array[i];

        }

        int i = left;
        int j = middle + 1;
        int k = left;


        while(i <= middle && j <= right) {

            metrics.comparisons++;
            if(buffer[i] <= buffer[j]) {

                array[k] = buffer[i];
                i++;

            }
            else {

                array[k] = buffer[j];
                j++;

            }

            k++;

        }



        while(i <= middle) {

            array[k] = buffer[i];

            i++;
            k++;

        }



        while(j <= right) {

            array[k] = buffer[j];

            j++;
            k++;

        }
    }

    private static void insertionSort(
            int[] array,
            int left,
            int right,
            Metrics metrics) {

        for(int i = left + 1; i <= right; i++) {


            int value = array[i];

            int j = i - 1;

            while(j >= left && array[j] > value) {


                metrics.comparisons++;

                array[j + 1] = array[j];

                j--;

            }

            array[j + 1] = value;

        }

    }

}