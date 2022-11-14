package com.jutta.obj;

import com.jutta.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CatObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public CatObj() {
        super();
    }

    public CatObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                CatObj.super.x = e.getX() - 10;
                CatObj.super.y = e.getY() - 15;
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
