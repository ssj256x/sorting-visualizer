package org.sortingvisulaizer.algorithms.implementations;

import org.sortingvisulaizer.VisualizerFrame;
import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;
import org.sortingvisulaizer.util.Util;

import java.util.stream.IntStream;

import static org.sortingvisulaizer.util.Util.swap;

public class QuickSort implements SortingAlgorithm {

    private final int[] array;
    private final VisualizerFrame visualizer;

    public QuickSort(int size, VisualizerFrame visualizer) {
        this.array = IntStream.range(1, size + 1).toArray();
        this.visualizer = visualizer;
        init();
    }

    @Override
    public void init() {
        Util.scramble(array);
    }

    @Override
    public void sort() {
        quickSort(array, 0, array.length - 1);
    }

    @Override
    public int[] getArray() {
        return new int[0];
    }

    public int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
                visualizer.reDrawArray(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
