package tests;
import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.QuickSelect;
import utils.Metrics;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
public class AlgorithmTest {
    @Test
    public void testMergeSortCorrectness() {

        int[] array = {5, 2, 8, 1, 3};

        int[] expected = array.clone();

        Arrays.sort(expected);

        Metrics metrics = new Metrics();

        MergeSort.sort(array, metrics);

        assertArrayEquals(expected, array);

    }

    @Test
    public void testQuickSortCorrectness() {
        int[] array = {9, 4, 2, 7, 1};
        int[] expected = array.clone();

        Arrays.sort(expected);

        Metrics metrics = new Metrics();
        QuickSort.sort(array, metrics);

        assertArrayEquals(expected, array);

    }

    @Test
    public void testRandomArraysWithMergeSort() {

        Random random = new Random();

        for(int i = 0; i < 100; i++) {

            int size = random.nextInt(100) + 1;

            int[] array = new int[size];

            for(int j = 0; j < size; j++) {

                array[j] = random.nextInt(1000);

            }

            int[] expected = array.clone();
            Arrays.sort(expected);

            Metrics metrics = new Metrics();

            MergeSort.sort(array, metrics);

            assertArrayEquals(expected, array);

        }

    }

    @Test
    public void testQuickSelect() {

        Random random = new Random();

        for(int i = 0; i < 100; i++) {
            int size = random.nextInt(100) + 1;
            int[] array = new int[size];

            for(int j = 0; j < size; j++) {
                array[j] = random.nextInt(1000);

            }

            int[] sorted = array.clone();

            Arrays.sort(sorted);

            int k = random.nextInt(size);
            Metrics metrics = new Metrics();
            int result = QuickSelect.select(array, k, metrics);
            assertEquals(sorted[k], result);

        }
    }

    @Test
    public void testEmptyArrayQuickSelect() {
        int[] array = {};
        Metrics metrics = new Metrics();
        assertThrows(
                IllegalArgumentException.class,
                () -> QuickSelect.select(array,0,metrics)
        );


    }
    @Test
    public void testAllElementsEqual() {
        int[] array = {
                5,5,5,5,5
        };

        Metrics metrics = new Metrics();

        QuickSort.sort(array,metrics);

        for(int value : array){

            assertEquals(5,value);

        }

    }
    @Test
    public void testSingleElement() {
        int[] array = {10};
        Metrics metrics = new Metrics();
        MergeSort.sort(array,metrics);
        assertEquals(10,array[0]);

    }
}