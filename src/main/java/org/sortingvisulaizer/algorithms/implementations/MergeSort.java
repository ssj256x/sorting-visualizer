package org.sortingvisulaizer.algorithms.implementations;

import org.sortingvisulaizer.VisualizerFrame;
import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;
import org.sortingvisulaizer.util.Util;

import java.util.Random;
import java.util.stream.IntStream;

import static org.sortingvisulaizer.util.Util.swap;

public class MergeSort implements SortingAlgorithm {

    private final int[] array;
    private final VisualizerFrame visualizer;

    public MergeSort(int size, VisualizerFrame visualizer) {
        this.array = IntStream.range(1, size + 1).toArray();
        this.visualizer = visualizer;
        init();
    }

    @Override
    public void init() {
        Util.scramble(array);
    }
    @Override
    public int[] getArray() {
        return this.array;
    }

    @Override
    public void sort() {
        mergeSort(0, array.length - 1);
    }

    public void mergeSort(int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            merge(start, mid, end);
        }
    }

    public void merge(int start, int mid, int end) {
        int start2 = mid + 1;

        // If the direct merge is already sorted
        if (array[mid] <= array[start2]) {
            return;
        }

        // Two pointers to maintain start
        // of both arrays to merge
        while (start <= mid && start2 <= end) {

            // If element 1 is in right place
            if (array[start] <= array[start2]) {
                start++;
                continue;
            }

            int value = array[start2];
            int index = start2;

            // Shift all the elements between element 1
            // element 2, right by 1.
            while (index != start) {
                array[index] = array[index - 1];
                index--;
            }
            array[start] = value;

            // Update all the pointers
            start++;
            mid++;
            start2++;

            visualizer.reDrawArray(array, start, end);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
