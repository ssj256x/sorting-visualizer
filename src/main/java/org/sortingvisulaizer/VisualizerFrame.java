package org.sortingvisulaizer;

import org.sortingvisulaizer.algorithms.interfaces.SortingAlgorithm;

import javax.swing.*;
import java.awt.*;

import static org.sortingvisulaizer.util.Util.sleep;
import static org.visualizer.Util.map;

public class VisualizerFrame extends JPanel {


    private final int width;
    private final int height;
    private int working;
    private int comparing;
    private int reading;
    private int[] arrayToDraw;

    public VisualizerFrame() {
        int fps = 60;
        this.width = 800;
        this.height = 400;

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void reDrawArray(int[] array, int working, int comparing) {
        this.working = working;
        this.comparing = comparing;
        this.arrayToDraw = array;
        repaint();
        sleep(1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int barWidth = width / arrayToDraw.length;
        int x = 1;

        for (int i = 0; i < arrayToDraw.length; i++) {
            g.setColor(Color.WHITE);

            if (i == working) g.setColor(Color.GREEN);
            if (i == comparing) g.setColor(Color.RED);

            int barHeight = map(arrayToDraw[i], 1, arrayToDraw.length, 1, height);


//            g.fillRect(x, height - barHeight, barWidth, (barHeight + 1) - barHeight);
            g.fillRect(x, height - barHeight, barWidth, barHeight);
            g.setColor(Color.BLACK);
//            g.drawRect(x, height - barHeight, barWidth, barHeight);

            x += barWidth;
        }
    }
}
