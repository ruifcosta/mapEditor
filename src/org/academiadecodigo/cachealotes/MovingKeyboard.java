package org.academiadecodigo.cachealotes;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MovingKeyboard implements KeyboardHandler {

    Grid grid;


    public MovingKeyboard(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                grid.moveUP();
                break;

            case KeyboardEvent.KEY_DOWN:
                grid.moveDown();
                break;

            case KeyboardEvent.KEY_LEFT:
                grid.moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:
                grid.moveRight();
                break;
            case KeyboardEvent.KEY_SPACE:
                grid.paint();
                break;
            case KeyboardEvent.KEY_C:
                grid.clear();
                break;
            case KeyboardEvent.KEY_L:
                grid.load();
                break;

        }
    }
}
