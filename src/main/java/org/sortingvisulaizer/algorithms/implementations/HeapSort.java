package org.sortingvisulaizer.algorithms.implementations;

import org.sortingvisulaizer.VisualizerFrame;
import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;
import org.sortingvisulaizer.util.Util;

import java.util.stream.IntStream;

import static org.sortingvisulaizer.util.Util.swap;

public class HeapSort implements SortingAlgorithm {


    private final int[] array;
    private final VisualizerFrame visualizer;

    public HeapSort(int size, VisualizerFrame visualizer) {
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
        heapSort(array);
    }

    @Override
    public int[] getArray() {
        return this.array;
    }

    public void heapSort(int[] a) {
        int size = a.length;

        buildMaxHeap(a, size);
        for (int i = size - 1; i > 0; i--) {
            swap(a, 0, i);
            maxHeapify(a, 0, i);
        }
    }

    private void buildMaxHeap(int[] a, int size) {
        for (int i = size / 2 - 1; i >= 0; i--)
            maxHeapify(a, i, size);
    }

    private void maxHeapify(int[] a, int node, int size) {
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        int largest = node;

        if (left < size && a[left] > a[largest])
            largest = left;
        if (right < size && a[right] > a[largest])
            largest = right;

        if (largest != node) {
            swap(a, largest, node);
            maxHeapify(a, largest, size);
            visualizer.reDrawArray(array, left, right);
        }
    }
}
