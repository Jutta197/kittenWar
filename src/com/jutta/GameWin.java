package com.jutta;

import com.jutta.obj.BgObj;
import com.jutta.obj.CatObj;
import com.jutta.obj.DeineObj;
import com.jutta.obj.ShitObj;
import com.jutta.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {

    static int state = 0;

    Image offScreenImage = null;
    int width = 600;
    int height = 600;

    int count = 1;

    BgObj bgObj = new BgObj(GameUtils.bgImag, 0, -400, 2);

    CatObj mineObj = new CatObj(GameUtils.mineImag, 290, 550, 20, 30, 0, this);


    public void launch() {
        this.setVisible(true);

        this.setSize(width, height);

        this.setLocationRelativeTo(null);

        this.setTitle("KITTEN WAR");

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(mineObj);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                    repaint();
                }
            }
        });
        while (true) {
            if (state == 1) {
                createObj();
                repaint();
            }
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, width, height);

        if (state == 0) {
            gImage.drawImage(GameUtils.bgImag, 0, 0, null);
            gImage.drawImage(GameUtils.bossImag, 220, 120, null);
            gImage.drawImage(GameUtils.boomImag, 270, 350, null);
            gImage.setColor(Color.yellow);
            gImage.setFont(new Font("TimesNewRoman", Font.BOLD, 40));
            gImage.drawString("tap to begin", 180, 300);
        }

        if (state == 1) {
            for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }



        }
        g.drawImage(offScreenImage, 0, 0, null);
        count++;


    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }

    void createObj() {
        if (count % 4 == 0) {
            GameUtils.shitObjList.add(new ShitObj(GameUtils.shitImag, mineObj.getX() + 20, mineObj.getY() - 20, 20, 20, 15, this));
            GameUtils.gameObjList.add(GameUtils.shitObjList.get(GameUtils.shitObjList.size() - 1));
        }

        if (count % 20 == 0) {
            GameUtils.deineObjList.add(new DeineObj(GameUtils.deineImag,(int)(Math.random()*12)*50,0,50,60,5,this));
            GameUtils.gameObjList.add(GameUtils.deineObjList.get(GameUtils.deineObjList.size()-1));
            GameUtils.shitObjList.add(new ShitObj(GameUtils.shitImag, mineObj.getX() + 20, mineObj.getY() - 20, 25, 25, 15, this));
            GameUtils.gameObjList.add(GameUtils.shitObjList.get(GameUtils.shitObjList.size() - 1)); // TODO 为啥这里要-1
        }

    }




}
