package org.academiadecodigo.cachealotes.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.Arrays;

public class Grid {

    Rectangle[][] grid;
    int cols;
    int rows;
    int cellSize = 20;
    public static final int PADDING = 10;


    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.init();
    }

    public void init() {
        grid = new Rectangle[cols][rows];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[col][row] = new Rectangle(cellSize * col + PADDING, cellSize * row + PADDING, cellSize, cellSize);
                grid[col][row].draw();
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

    public void setGrid(Rectangle[][] grid) {
        this.grid = grid;
    }

    public Rectangle[][] getGrid() {
        return grid;
    }



}
