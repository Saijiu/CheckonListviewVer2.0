package com.moi.showstateapplication;

/**
 * Created by moi on 2015/3/28.
 */
public class Postion {

    private static Postion mPostion;

    private static int postion;

    private Postion() {

    }

    public static Postion getInstance() {
        if (mPostion == null) {
            synchronized (Postion.class) {
                if (mPostion == null) {
                    mPostion = new Postion();
                }
            }
        }
        return  mPostion;
    }

    public static int getPostion() {
        return postion;
    }

    public static void setPostion(int postion) {
        Postion.postion = postion;
    }


}
