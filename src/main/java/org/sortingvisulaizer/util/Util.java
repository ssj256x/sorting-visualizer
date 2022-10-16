package org.sortingvisulaizer.util;

import java.util.Random;

public class Util {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scramble(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int a = Math.abs(random.nextInt()) % array.length;
            int b = Math.abs(random.nextInt()) % array.length;
            swap(array, a, b);
        }
    }
}
