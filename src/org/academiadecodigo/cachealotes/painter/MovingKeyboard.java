package org.academiadecodigo.cachealotes.painter;

import org.academiadecodigo.cachealotes.grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MovingKeyboard implements KeyboardHandler {

    Painter painter;


    public MovingKeyboard(Painter painter) {
        this.painter = painter;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                painter.brush.moveUP();
                break;

            case KeyboardEvent.KEY_DOWN:
                painter.brush.moveDown();
                break;

            case KeyboardEvent.KEY_LEFT:
                painter.brush.moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:
                painter.brush.moveRight();
                break;
            case KeyboardEvent.KEY_SPACE:
                painter.paint();
                break;
            case KeyboardEvent.KEY_C:
                painter.clear();
                break;
            case KeyboardEvent.KEY_L:
                painter.load();
                break;
            case KeyboardEvent.KEY_S:
                painter.save();
                break;
            case KeyboardEvent.KEY_X:
                try {
                    boolean result= Files.deleteIfExists(Path.of("grid.txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
                break;

        }
    }
}
