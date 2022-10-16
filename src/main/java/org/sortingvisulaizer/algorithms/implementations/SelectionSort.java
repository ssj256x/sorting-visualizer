package org.sortingvisulaizer.algorithms.implementations;

import org.sortingvisulaizer.VisualizerFrame;
import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;
import org.sortingvisulaizer.util.Util;

import java.util.stream.IntStream;

public class SelectionSort implements SortingAlgorithm {

    private final int[] array;
    private final VisualizerFrame visualizer;

    public SelectionSort(int size, VisualizerFrame visualizer) {
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
        int min;

        for(int i = 0; i < n - 1; i++) {
            min = i;
            for(int j = i + 1; j < n; j++) {
                if(array[j] < array[min])
                    min = j;
                visualizer.reDrawArray(array, min, j - 1);
            }
            int t = array[i];
            array[i] = array[min];
            array[min] = t;
        }
//        visualizer.reDrawArray(array, min, i);
    }

    @Override
    public int[] getArray() {
        return this.array;
    }
}
