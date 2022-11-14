package com.jutta.utils;

import com.jutta.obj.DeineObj;
import com.jutta.obj.GameObj;
import com.jutta.obj.ShitObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public static Image bgImag = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    public static Image bossImag = Toolkit.getDefaultToolkit().getImage("imgs/boss.jpg");
    public static Image boomImag = Toolkit.getDefaultToolkit().getImage("imgs/boom/1.jpg");
    public static Image mineImag = Toolkit.getDefaultToolkit().getImage("imgs/mine.jpg");

    public static Image shitImag = Toolkit.getDefaultToolkit().getImage("imgs/shit.png");

    public static Image deineImag = Toolkit.getDefaultToolkit().getImage("imgs/deine.png");


    public static List<GameObj> gameObjList = new ArrayList<>();

    public static List<GameObj> boObjList = new ArrayList<>();

    public static List<ShitObj> shitObjList = new ArrayList<>();

    public static List<DeineObj> deineObjList = new ArrayList<>();







}
