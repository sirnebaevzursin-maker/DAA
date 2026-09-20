package algorithms;
import utils.Metrics;
import java.util.Random;

public class QuickSort {
    private static Random random = new Random();
    public static void sort(int[] array, Metrics metrics) {
        quickSort(array, 0, array.length - 1, 1, metrics);

    }

    private static void quickSort(
            int[] array,
            int left,
            int right,
            int depth,
            Metrics metrics) {

        while(left < right) {

            metrics.updateDepth(depth);

            int[] parts = partition(array, left, right, metrics);
            int leftSize = parts[0] - left;
            int rightSize = right - parts[1];

            if(leftSize < rightSize) {

                quickSort(array, left, parts[0] - 1, depth + 1, metrics);

                left = parts[1] + 1;

            }
            else {

                quickSort(array, parts[1] + 1, right, depth + 1, metrics);

                right = parts[0] - 1;

            }

        }

    }

    private static int[] partition(
            int[] array,
            int left,
            int right,
            Metrics metrics) {

        int pivotIndex = left + random.nextInt(right - left + 1);

        int pivot = array[pivotIndex];

        int temp = array[pivotIndex];
        array[pivotIndex] = array[right];
        array[right] = temp;

        int less = left;
        int current = left;
        int greater = right;
        while(current <= greater) {

            metrics.comparisons++;
            if(array[current] < pivot) {
                swap(array, less, current);
                less++;
                current++;

            }
            else if(array[current] > pivot) {

                swap(array, current, greater);

                greater--;

            }

            else {

                current++;

            }

        }

        return new int[]{less, greater};

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}