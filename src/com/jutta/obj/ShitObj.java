package com.jutta.obj;

import com.jutta.GameWin;

import java.awt.*;

public class ShitObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public ShitObj() {
        super();
    }

    public ShitObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -= speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
