package org.academiadecodigo.cachealotes;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;



public class Painter {
    Grid grid;



    public Painter(int col,int row) {
        this.grid = new Grid(col,row);
        grid.init();


    }

    public void init(){
        MovingKeyboard move = new MovingKeyboard(grid);
        Keyboard keyboard = new Keyboard(move);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(up);


        KeyboardEvent e = new KeyboardEvent();
        e.setKey(KeyboardEvent.KEY_DOWN);
        e.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(e);


        KeyboardEvent i = new KeyboardEvent();
        i.setKey(KeyboardEvent.KEY_LEFT);
        i.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(i);


        KeyboardEvent o = new KeyboardEvent();
        o.setKey(KeyboardEvent.KEY_RIGHT);
        o.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(o);

        KeyboardEvent u = new KeyboardEvent();
        u.setKey(KeyboardEvent.KEY_SPACE);
        u.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(u);

        KeyboardEvent b = new KeyboardEvent();
        b.setKey(KeyboardEvent.KEY_C);
        b.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(b);

        KeyboardEvent c = new KeyboardEvent();
        c.setKey(KeyboardEvent.KEY_L);
        c.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(c);

        KeyboardEvent d = new KeyboardEvent();
        d.setKey(KeyboardEvent.KEY_S);
        d.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(d);

        KeyboardEvent f = new KeyboardEvent();
        f.setKey(KeyboardEvent.KEY_X);
        f.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(f);
    }


}
