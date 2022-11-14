package com.jutta.obj;

import com.jutta.GameWin;
import com.jutta.utils.GameUtils;

import java.awt.*;

public class DeineObj extends GameObj {
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public DeineObj() {
        super();
    }

    public DeineObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        for (ShitObj shitObj : GameUtils.shitObjList) {
            if (this.getRec().intersects(shitObj.getRec())) {
                shitObj.setX(-100);
                shitObj.setY(200);
                this.x = -100;
                this.y = 200;
                GameUtils.boObjList.add(shitObj);
                GameUtils.boObjList.add(this); // TODO 为啥这样就是消失了：因为出框了
            }
        }

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

}
