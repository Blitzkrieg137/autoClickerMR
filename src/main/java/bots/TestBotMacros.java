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

    public static void main( String[] args ) throws InterruptedException {
        //holdButtonUntilPixelDetectImpl(VK_RIGHT,10);
        //checkColorByPosxPosy( 191, 545);

        //movementRight(135, 552, 514, 552);
        showPixelColorRGB(348, 455);
        showPixelColorRGB(202, 506);
    }


    private static void holdButtonUntilPixelDetectImpl(int keyToHold, double secondsToHoldKey) throws InterruptedException {
        double endTime = System.currentTimeMillis() + secondsToHoldKey* 1000;
        while (System.currentTimeMillis() < endTime) {
            System.out.println(movementRight( 514, 552));
            if (movementRight( 514, 552)){
                break;
            }else {
                bot.keyPress(keyToHold);
            }
        }
        System.out.println("reached destination");
        bot.keyRelease(keyToHold);

    }

    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive)
            return true;
        else
            return false;
    }

    //check between range 40x40 x - / y +
    public static boolean checkColorByPosxPosy(int startX , int startY, int endX, int endY){
        List<Integer> list = new ArrayList<>();
        int startRgbXY = bot.getPixelColor(startX, startY).getRGB();

        //find x colors
        for (int i = 1; i <= 40; i++){
            list.add(bot.getPixelColor(endX - i, endY).getRGB());
        }
        for (int i = 1; i <= 40; i++){
            list.add(bot.getPixelColor(endX, endY + i).getRGB());
        }
        //System.out.println("show me all RGB in List: " + list);
        if (list.contains(startRgbXY)){
            System.out.println("found pixels in list");
            System.out.println(startRgbXY);
            System.out.println(list.size());
        }



        if (list.contains(startRgbXY)){
            return true; //found color
        }else{
            return false ;
        }
    }

    public static boolean movementRight(int endX, int endY){
        //stop when get to endX
        int endRgbXY = bot.getPixelColor(endX, endY).getRGB();
        int whiteFace = -1;

        if (endRgbXY == whiteFace){
            return true;
        }
        else{
            return false;
        }
    }

    public static void showPixelColorRGB(int endX, int endY){
        System.out.println(bot.getPixelColor(endX, endY).getRGB());
    }



    /*
UlU RECHTES HAUS BLAU
RGB: -8947866

Physical: {X=756,Y=150}
Scaled: {X=756,Y=150}
Relative: {X=481,Y=-642}
Dpi: 96
Raw Dpi: 81
Dpi Scaling: 1
Dpi Ratio: 1,19
Screen Resolution: {Width=1920, Height=1080}
Pixel Color: #CCCCCC

UlU LINKES HAUS ROT
RGB: -3372852

Physical: {X=385,Y=585}
Scaled: {X=385,Y=585}
Relative: {X=110,Y=-207}
Dpi: 96
Raw Dpi: 81
Dpi Scaling: 1
Dpi Ratio: 1,19
Screen Resolution: {Width=1920, Height=1080}
Pixel Color: #CC88CC

    */

}




