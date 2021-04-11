package movements;

import focus.WindowsFocus;
import focus.WindowsFocusImpl;
import inputdetection.DetectKeyboardInput;
import inputdetection.DetectKeyboardInputImpl;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;


public class BasicMovementsImpl implements BasicMovements {
    static Robot bot;

    static {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void holdButton(int keyToHold, double secondsToHold) {
        holdButtonImpl(keyToHold,secondsToHold);
    }

    public void pressButtonOnce(int keyToPress) {
        pressButtonOnceImpl(keyToPress);
    }

    @Override
    public void walkRightWithSkill(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2) throws InterruptedException {
        walkRightWithSkillImpl(endX, endY, endX2, endY2, getPixelColorValue, getPixelColorValue2);
    }

    @Override
    public void walkLeftWithSkill(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2) throws InterruptedException {
        walkLeftWithSkillImpl(endX, endY, endX2, endY2, getPixelColorValue, getPixelColorValue2);

    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i<=4; i++){

        //walkRightWithSkillImpl(994, 422, 870, 394, -10066347, -6702132);
        //walkLeftWithSkill();
        }
//Buffs after 4 circle


    }


    private void holdButtonImpl(int keyToHold, double secondsToHoldKey) {
        try {
            double endTime = System.currentTimeMillis() + secondsToHoldKey* 1000;
            while (System.currentTimeMillis() < endTime) {
                bot.keyPress(keyToHold);
                Thread.sleep(10);
                bot.keyRelease(keyToHold);
            }
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void pressButtonOnceImpl(int keyToPress){
        try {
            bot.keyPress(keyToPress);
            Thread.sleep(10);
            bot.keyRelease(keyToPress);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //walk right until given end values are found
    private void walkRightWithSkillImpl(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2) throws InterruptedException {
        DetectKeyboardInput detectKeyboardInput= new DetectKeyboardInputImpl();
        while (!detectKeyboardInput.isKeyDown(VK_F12)) {
            if (movementRight( endX, endY, endX2, endY2, getPixelColorValue, getPixelColorValue2)){
                System.out.println("reached destination");
                break;
            }else {
                bot.keyPress(VK_RIGHT);
                Thread.sleep(800);
                bot.keyPress(VK_A);
                Thread.sleep(10);
                bot.keyPress(VK_S);
                Thread.sleep(10);
                bot.keyRelease(VK_RIGHT);


                bot.keyRelease(VK_A);
                bot.keyRelease(VK_S);
                Thread.sleep(10);
            }
        }
        System.out.println("PRESSED F12");

    }


    public static boolean movementRight(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2){
        //stop when get to endX
        int endRgbXY = bot.getPixelColor(endX, endY).getRGB();
        System.out.println(endRgbXY);

        int endRgbXY2 = bot.getPixelColor(endX2, endY2).getRGB();
        System.out.println(endRgbXY);

        if (endRgbXY == getPixelColorValue && endRgbXY2 == getPixelColorValue2){
            return true;
        }
        else{
            return false;
        }
    }

    //walk left until given end values are found
    private void walkLeftWithSkillImpl(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2) throws InterruptedException {
        DetectKeyboardInput detectKeyboardInput= new DetectKeyboardInputImpl();
        while (!detectKeyboardInput.isKeyDown(VK_F12)) {
            if (movementLeft( endX, endY, endX2, endY2, getPixelColorValue, getPixelColorValue2)){
                System.out.println("reached destination");
                break;
            }else {
                bot.keyPress(VK_LEFT);
                Thread.sleep(800);
                bot.keyPress(VK_A);
                Thread.sleep(10);
                bot.keyPress(VK_S);
                Thread.sleep(10);
                bot.keyRelease(VK_LEFT);


                bot.keyRelease(VK_A);
                bot.keyRelease(VK_S);
                Thread.sleep(10);
            }
        }
        System.out.println("PRESSED F12");

    }


    public static boolean movementLeft(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2){
        //stop when get to endX
        int endRgbXY = bot.getPixelColor(endX, endY).getRGB();
        System.out.println(endRgbXY);

        int endRgbXY2 = bot.getPixelColor(endX2, endY2).getRGB();
        System.out.println(endRgbXY);

        if (endRgbXY == getPixelColorValue && endRgbXY2 == getPixelColorValue2){
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
RGB: -10066347

Physical: {X=994,Y=422}
Scaled: {X=994,Y=422}
Relative: {X=719,Y=-371}
Dpi: 96
Raw Dpi: 81
Dpi Scaling: 1
Dpi Ratio: 1,19
Screen Resolution: {Width=1920, Height=1080}
Pixel Color: #666655

RGB: -6702132
Physical: {X=870,Y=394}
Scaled: {X=870,Y=394}
Relative: {X=595,Y=-399}
Dpi: 96
Raw Dpi: 81
Dpi Scaling: 1
Dpi Ratio: 1,19
Screen Resolution: {Width=1920, Height=1080}
Pixel Color: #99BBCC

UlU LINKES HAUS ROT
RGB: -10070767

Physical: {X=348,Y=455}
Scaled: {X=348,Y=455}
Relative: {X=-675,Y=-337}
Dpi: 96
Raw Dpi: 81
Dpi Scaling: 1
Dpi Ratio: 1,19
Screen Resolution: {Width=1920, Height=1080}
Pixel Color: #DDAADD

RGB: -7842509
Physical: {X=202,Y=506}
Scaled: {X=202,Y=506}
Relative: {X=-821,Y=-286}
Dpi: 96
Raw Dpi: 81
Dpi Scaling: 1
Dpi Ratio: 1,19
Screen Resolution: {Width=1920, Height=1080}
Pixel Color: #666655

    */


 }
