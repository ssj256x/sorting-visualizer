package org.sortingvisulaizer.algorithms.implementations;

import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;
import org.sortingvisulaizer.VisualizerFrame;
import org.sortingvisulaizer.util.Util;

import java.util.Random;
import java.util.stream.IntStream;

import static org.sortingvisulaizer.util.Util.swap;

public class BubbleSort implements SortingAlgorithm {

    private final int[] array;
    private final VisualizerFrame visualizer;

    public BubbleSort(int size, VisualizerFrame visualizer) {
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
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
                visualizer.reDrawArray(array, j, j + 1);
            }
            if (!swapped) break;
        }
    }

    @Override
    public int[] getArray() {
        return this.array;
    }
}
