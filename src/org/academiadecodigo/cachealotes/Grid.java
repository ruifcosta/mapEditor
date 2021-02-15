package org.academiadecodigo.cachealotes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class Grid {

    private Rectangle[][] grid;
    private int cols;
    private int rows;
    private int cellSize = 20;
    private static final int PADDING = 10;
    private Rectangle car;

    public Grid(int cols, int rows) {
        grid = new Rectangle[cols][rows];
        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[j][i] = new Rectangle(cellSize * j + PADDING, cellSize * i + PADDING, cellSize, cellSize);
                grid[j][i].draw();
            }
        }
        car = new Rectangle(110, 110, cellSize, cellSize);
        car.setColor(Color.RED);
        car.fill();
    }

    public void clear() {

        // create a new file reader
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

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (grid[j][i].isFilled()) {
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

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[j][i].delete();
                grid[j][i].draw();
            }
        }
    }

    public int getCols() {
        return cols;
    }


    public int getRows() {
        return rows;
    }

    public int getColToX(int col) {
        return col * cellSize + PADDING;
    }


    public int getRowToY(int row) {
        return row * cellSize + PADDING;
    }

    public int getXtoCol(int x) {
        return (x - PADDING) / cellSize;
    }


    public int getYtoRow(int y) {
        return (y - PADDING) / cellSize;
    }

    public void moveUP() {
        if (car.getY() <= PADDING) {
            return;
        }
        car.translate(0, -cellSize);

    }

    public void moveDown() {
        if (car.getY() + cellSize >= getRowToY(getRows())) {
            return;
        }
        car.translate(0, +cellSize);

    }

    public void moveLeft() {
        if (car.getX() <= PADDING) {
            return;
        }
        car.translate(-cellSize, 0);

    }

    public void moveRight() {
        if (car.getX() + cellSize >= getColToX(cols)) {
            return;
        }
        car.translate(cellSize, 0);

    }

    public void paint() {
        int col = getXtoCol(car.getX());
        int row = getYtoRow(car.getY());
        grid[col][row].fill();
    }

    public void load() {
        // create a new file reader
        FileReader reader = null;
        try {
            reader = new FileReader("grid.txt");

            // wrap the file reader using a buffered reader
            BufferedReader bReader = new BufferedReader(reader);

            String line = "";
            int row = 0;
            // using the buffered reader we can read lines
            while ((line = bReader.readLine()) == null) {

                System.out.println();
                String[] splitTheLine = line.split(" ");

                for (int col = 0; col < cols; col++) {

                    if (splitTheLine[col].equals("0")) {
                        grid[col][row].draw();

                    } else {
                        System.out.println(col + "   " + row);
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

}
