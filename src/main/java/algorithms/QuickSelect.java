package algorithms;
import utils.Metrics;
import java.util.Random;

public class QuickSelect {

    private static Random random = new Random();

    public static int select(int[] array, int k, Metrics metrics) {

        if(array.length == 0) {

            throw new IllegalArgumentException("Array is empty");

        }

        if(k < 0 || k >= array.length) {

            throw new IllegalArgumentException("Invalid k value");

        }

        return quickSelect(array, 0, array.length - 1, k, 1, metrics);

    }

    private static int quickSelect(
            int[] array,
            int left,
            int right,
            int k,
            int depth,
            Metrics metrics) {

        metrics.updateDepth(depth);

        if(left == right) {

            return array[left];

        }

        int[] parts = partition(array,left,right,metrics);

        if(k < parts[0]) {

            return quickSelect(array,left,parts[0]-1,k,depth+1,metrics);

        }

        else if(k > parts[1]) {

            return quickSelect(array,parts[1]+1,right,k,depth+1,metrics);

        }

        else {

            return array[k];

        }

    }

    private static int[] partition(
            int[] array,
            int left,
            int right,
            Metrics metrics) {

        int pivotIndex = left + random.nextInt(right-left+1);

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
                swap(array,less,current);

                less++;
                current++;

            }

            else if(array[current] > pivot) {
                swap(array,current,greater);

                greater--;

            }

            else {

                current++;

            }

        }


        return new int[]{less,greater};

    }

    private static void swap(int[] array,int a,int b) {

        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;

    }

}