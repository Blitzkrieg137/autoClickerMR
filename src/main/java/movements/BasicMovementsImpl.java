package movements;

import focus.WindowsFocus;
import focus.WindowsFocusImpl;
import imagedetection.DetectCharacterByImage;
import imagedetection.DetectCharacterByImageImpl;
import inputdetection.DetectKeyboardInput;
import inputdetection.DetectKeyboardInputImpl;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;


public class BasicMovementsImpl implements BasicMovements {
    static Robot bot;
    DetectKeyboardInput detectKeyboardInput = new DetectKeyboardInputImpl();
    DetectCharacterByImage detectCharacterByImage = new DetectCharacterByImageImpl();

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
    public void walkRightWithSkill(int endX, int endY, int xWidth, int yWidth, String imageName) {
        walkRightWithSkillImpl(endX, endY, xWidth, yWidth, imageName);
    }

    @Override
    public void walkLeftWithSkill(int endX, int endY, int xWidth, int yWidth, String imageName) {
        walkLeftWithSkillImpl(endX, endY, xWidth, yWidth, imageName);

    }

    @Override
    public void walkRightUntilRope(int endX, int endY, int xWidth, int yWidth, String imageName) {
        walkRightUntilRopeImpl(endX,endY,xWidth,yWidth,imageName);
    }

    @Override
    public void buffAndClimbUpRope() {
        buffAndClimbUpRopeImpl();
    }

    @Override
    public void climbUpRope() {
        climbUpRopeImpl();
    }


    @Override
    public void jumpDown() {
        jumpDownImpl();
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

    private static void pressButtonOnceImpl(int keyToPress){
        try {
            bot.keyPress(keyToPress);
            Thread.sleep(10);
            bot.keyRelease(keyToPress);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //walk right and jump on rope
    private void walkRightUntilRopeImpl(int endX, int endY, int xWidth, int yWidth, String imageName) {
        try {
            while (!detectKeyboardInput.isKeyDown(VK_F12)) {
                while (!detectCharacterByImage.detectCharacterWalkRightLeft(endX, endY, xWidth, yWidth, imageName)) {
                    bot.keyPress(VK_RIGHT);
                    Thread.sleep(10);
                    System.out.println("walk right");

                }
                bot.keyRelease(VK_RIGHT);
                System.out.println("jump");
                bot.keyPress(VK_ALT);
                Thread.sleep(10);
                bot.keyPress(VK_UP);
                bot.keyRelease(VK_ALT);
                Thread.sleep(1000);
                bot.keyRelease(VK_UP);
                break;
            }
            System.out.println("check if on rope");
            checkIfOnRope();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Rope check
    private void checkIfOnRope() {
        DetectCharacterByImage detectCharacterByImage1 = new DetectCharacterByImageImpl();
        try {
        if (!detectCharacterByImage1.detectCharacterWalkRightLeft(420, 400, 200, 190, "HeadBishop1.png")) {
                bot.keyPress(VK_LEFT);
                Thread.sleep(100);
                bot.keyPress(VK_A);
                Thread.sleep(500);
                System.out.println("teleport left");

                bot.keyRelease(VK_A);
                bot.keyRelease(VK_LEFT);

            if (!detectCharacterByImage1.detectCharacterWalkRightLeft(420, 400, 200, 190, "HeadBishop1.png")){
            walkRightUntilRopeImpl(457,600, 200,200, "HeadBishop1.png");
            }
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //BUFF AND CLIMB ROPE
    private void buffAndClimbUpRopeImpl() {
        try {
            while (!detectKeyboardInput.isKeyDown(VK_F12)) {
                //BUFF
                pressButtonOnceImpl(VK_C);
                Thread.sleep(1000);
                pressButtonOnceImpl(VK_2);
                Thread.sleep(1000);
                pressButtonOnceImpl(VK_3);
                Thread.sleep(1000);
                pressButtonOnceImpl(VK_4);
                Thread.sleep(1000);
                pressButtonOnceImpl(VK_5);
                Thread.sleep(1000);
                bot.keyPress(VK_UP);
                Thread.sleep(2000);
                bot.keyRelease(VK_UP);

                break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //CLIMB ROPE
    private void climbUpRopeImpl() {
        try {
            while (!detectKeyboardInput.isKeyDown(VK_F12)) {
                //BUFF
                bot.keyPress(VK_UP);
                Thread.sleep(2000);
                bot.keyRelease(VK_UP);
                break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void jumpDownImpl(){
        try {
            while (!detectKeyboardInput.isKeyDown(VK_F12)) {
                //BUFF
                bot.keyPress(VK_DOWN);
                pressButtonOnceImpl(VK_ALT);
                Thread.sleep(1000);
                pressButtonOnceImpl(VK_ALT);
                Thread.sleep(500);
                pressButtonOnceImpl(VK_ALT);
                bot.keyRelease(VK_DOWN);
                break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //walk right until end values are found
    private void walkRightWithSkillImpl(int endX, int endY, int xWidth, int yWidth, String imageName) {
        try {
            while (!detectKeyboardInput.isKeyDown(VK_F12)) {
                if (detectCharacterByImage.detectCharacterWalkRightLeft(endX, endY, xWidth, yWidth, imageName)){
                    System.out.println("reached destination");
                    break;
                }
                bot.keyPress(VK_RIGHT);
                Thread.sleep(400);
                bot.keyPress(VK_A);
                Thread.sleep(10);
                bot.keyPress(VK_S);
                Thread.sleep(10);

                bot.keyRelease(VK_A);
                Thread.sleep(10);
                bot.keyRelease(VK_S);
                Thread.sleep(10);
                bot.keyRelease(VK_RIGHT);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //walk right until end values are found
    private void walkLeftWithSkillImpl(int endX, int endY, int xWidth, int yWidth, String imageName) {
        try {
            while (!detectKeyboardInput.isKeyDown(VK_F12)) {
                if (detectCharacterByImage.detectCharacterWalkRightLeft(endX, endY, xWidth, yWidth, imageName)){
                    System.out.println("reached destination");
                    break;
                }
                bot.keyPress(VK_LEFT);
                Thread.sleep(400);
                bot.keyPress(VK_A);
                Thread.sleep(10);
                bot.keyPress(VK_S);
                Thread.sleep(10);

                bot.keyRelease(VK_A);
                Thread.sleep(10);
                bot.keyRelease(VK_S);
                Thread.sleep(10);
                bot.keyRelease(VK_LEFT);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Deprecated
    private static void showPixelColorRGB(int endX, int endY){
        System.out.println(bot.getPixelColor(endX, endY).getRGB());
    }

 }
