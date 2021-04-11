package bots;

import focus.WindowsFocus;
import focus.WindowsFocusImpl;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;


public class TestBotMacros {



    static Robot bot;

    static {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void testFocusMovement(){
        WindowsFocus windowsFocus = new WindowsFocusImpl();
        windowsFocus.getMapleOnFocus();
    }

    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive)
            return true;
        else
            return false;
    }










}




