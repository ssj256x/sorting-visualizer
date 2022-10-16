package org.sortingvisulaizer.algorithms.implementations;

import org.sortingvisulaizer.VisualizerFrame;
import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;
import org.sortingvisulaizer.util.Util;

import java.util.stream.IntStream;

public class InsertionSort implements SortingAlgorithm {

    private final int[] array;
    private final VisualizerFrame visualizer;

    public InsertionSort(int size, VisualizerFrame visualizer) {
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
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
                visualizer.reDrawArray(array, j, i);
            }
            array[j] = temp;
        }
    }

    @Override
    public int[] getArray() {
        return this.array;
    }
}
