package org.sortingvisulaizer;

import org.sortingvisulaizer.algorithms.implementations.*;
import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Sorting Simulation");

        VisualizerFrame visualizerFrame = new VisualizerFrame();

        window.add(visualizerFrame);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

//        SortingAlgorithm algorithm = new BubbleSort(50, visualizerFrame);
//        SortingAlgorithm algorithm = new InsertionSort(150, visualizerFrame);
//        SortingAlgorithm algorithm = new SelectionSort(150, visualizerFrame);
//        SortingAlgorithm algorithm = new CountingSort(150, visualizerFrame);
//        SortingAlgorithm algorithm = new QuickSort(550, visualizerFrame);
        SortingAlgorithm algorithm = new MergeSort(800, visualizerFrame);
//        SortingAlgorithm algorithm = new HeapSort(250, visualizerFrame);
        algorithm.sort();
    }
}
