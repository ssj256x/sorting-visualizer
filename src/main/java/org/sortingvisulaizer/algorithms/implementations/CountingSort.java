package org.sortingvisulaizer.algorithms.implementations;

import org.sortingvisulaizer.VisualizerFrame;
import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;
import org.sortingvisulaizer.util.Util;

import java.util.stream.IntStream;

public class CountingSort implements SortingAlgorithm {

    private final int[] array;
    private final VisualizerFrame visualizer;

    public CountingSort(int size, VisualizerFrame visualizer) {
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
        int max = Integer.MIN_VALUE;
        for (int n : array) max = Math.max(n, max);

        int[] count = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
            visualizer.reDrawArray(array, i, i);
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[j++] = i;
                visualizer.reDrawArray(array, i, j);
            }
        }
    }

    @Override
    public int[] getArray() {
        return new int[0];
    }
}
