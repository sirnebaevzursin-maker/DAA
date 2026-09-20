package utils;
import algorithms.MergeSort;
import algorithms.QuickSort;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Benchmark {
    private static final int[] SIZES = {
            1000,
            10000,
            100000,
            1000000
    };

    private static final int RUNS = 5;
    private static Random random = new Random();
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("results.csv");


        writer.write(
                "algorithm,input,n,time_ms,comparisons,max_depth\n"
        );

        for(int size : SIZES) {

            runBenchmark(
                    "random",
                    createRandomArray(size),
                    writer
            );


            runBenchmark(
                    "sorted",
                    createSortedArray(size),
                    writer
            );


            runBenchmark(
                    "duplicates",
                    createDuplicateArray(size),
                    writer
            );


        }

        writer.close();
        System.out.println("Benchmark completed");

    }

    private static void runBenchmark(
            String inputType,
            int[] array,
            FileWriter writer
    ) throws IOException {

        runMergeSort(
                inputType,
                array,
                writer
        );

        runQuickSort(
                inputType,
                array,
                writer
        );

    }

    private static void runMergeSort(
            String inputType,
            int[] array,
            FileWriter writer
    ) throws IOException {

        long[] times = new long[RUNS];

        long comparisons = 0;

        int depth = 0;

        for(int i = 0; i < RUNS; i++) {

            int[] copy = array.clone();

            Metrics metrics = new Metrics();

            metrics.startTimer();

            MergeSort.sort(copy, metrics);

            times[i] = metrics.getTime();
            comparisons = metrics.comparisons;

            depth = metrics.maxDepth;

        }
        long median = getMedian(times);

        writer.write(
                "MergeSort,"
                        + inputType + ","
                        + array.length + ","
                        + median + ","
                        + comparisons + ","
                        + depth
                        + "\n"
        );


    }

    private static void runQuickSort(
            String inputType,
            int[] array,
            FileWriter writer
    ) throws IOException {

        long[] times = new long[RUNS];

        long comparisons = 0;

        int depth = 0;

        for(int i = 0; i < RUNS; i++) {

            int[] copy = array.clone();

            Metrics metrics = new Metrics();

            metrics.startTimer();

            QuickSort.sort(copy, metrics);

            times[i] = metrics.getTime();

            comparisons = metrics.comparisons;

            depth = metrics.maxDepth;

        }

        long median = getMedian(times);

        writer.write(
                "QuickSort,"
                        + inputType + ","
                        + array.length + ","
                        + median + ","
                        + comparisons + ","
                        + depth
                        + "\n"
        );

    }

    private static long getMedian(long[] values) {
        Arrays.sort(values);
        return values[values.length / 2];

    }

    private static int[] createRandomArray(int n) {

        int[] array = new int[n];

        for(int i = 0; i < n; i++) {

            array[i] = random.nextInt();

        }

        return array;

    }

    private static int[] createSortedArray(int n) {
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {

            array[i] = i;

        }

        return array;

    }

    private static int[] createDuplicateArray(int n) {

        int[] array = new int[n];

        for(int i = 0; i < n; i++) {

            array[i] = random.nextInt(20);

        }
        return array;
    }
}