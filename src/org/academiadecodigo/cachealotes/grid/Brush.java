package org.academiadecodigo.cachealotes.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class Brush extends Grid {

    private Rectangle brush;


    public Brush(int cols, int rows) {
        super(cols, rows);
        brush = new Rectangle(getColToX(cols/2), getRowToY(rows/2), cellSize, cellSize);
        brush.setColor(Color.RED);
        brush.fill();
    }

    public void moveUP() {
        if (brush.getY() <= Grid.PADDING) {
            return;
        }
        brush.translate(0, -cellSize);

    }

    public void moveDown() {
        if (brush.getY() + cellSize >= getRowToY(getRows())) {
            return;
        }
        brush.translate(0, +cellSize);

    }

    public void moveLeft() {
        if (brush.getX() <= PADDING) {
            return;
        }
        brush.translate(-cellSize, 0);

    }

    public void moveRight() {
        if (brush.getX() + cellSize >= getColToX(cols)) {
            return;
        }
        brush.translate(cellSize, 0);

    }
    public void paint() {
        int col = getXtoCol(brush.getX());
        int row = getYtoRow(brush.getY());


       if (grid[col][row].isFilled()) {
            grid[col][row].delete();
            grid[col][row].draw();
            return;
        }
        grid[col][row].fill();
    }

    public void clear() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[col][row].delete();
                grid[col][row].draw();
            }
        }
    }

    public void load() {
        clear();
        // create a new file reader
        FileReader reader = null;
        try {
            reader = new FileReader("grid.txt");

            // wrap the file reader using a buffered reader
            BufferedReader bReader = new BufferedReader(reader);

            String line = "";
            int row = 0;
            // using the buffered reader we can read lines
            while ((line = bReader.readLine()) != null) {

                System.out.println();
                String[] splitTheLine = line.split(" ");

                for (int col = 0; col < cols; col++) {

                    if (splitTheLine[col].equals("0")) {
                        grid[col][row].draw();

                    } else {
                        grid[col][row].setColor(Color.BLACK);
                        grid[col][row].fill();
                    }

                }

                row++;

            }

            try {
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void save() {
        // create a new file writer
        FileWriter writer = null;
        try {
            writer = new FileWriter("grid.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // wrap the file writer using a buffered writer
        BufferedWriter bWriter = new BufferedWriter(writer);
        String text = "";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[col][row].isFilled()) {
                    text += "1 ";
                } else {
                    text += "0 ";
                }
            }
            text = text + "\n";
        }

        //add text to buffer
        try {
            bWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bWriter.flush(); // if the buffer is not full, flush will force disk write
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bWriter.close(); // auto-flush is done on close
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
