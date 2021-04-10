package movements;

import focus.WindowsFocus;
import focus.WindowsFocusImpl;

import java.awt.*;


public class BasicMovementsImpl implements BasicMovements {
    static Robot bot = null;


    public void createRobot() {
        createMovementRobotImpl();
    }

    public void holdButton(int keyToHold, double secondsToHold) {
        holdButtonImpl(keyToHold,secondsToHold);
    }

    public void pressButtonOnce(int keyToPress) {
        pressButtonOnceImpl(keyToPress);
    }


    private static void createMovementRobotImpl() {
        try {
            bot = new Robot();
        } catch (Exception failed) {
            System.err.println("Failed instantiating Robot: " + failed);
        }
    }

    private void holdButtonImpl(int keyToHold, double secondsToHoldKey) {
        try {
            WindowsFocus windowsFocus = new WindowsFocusImpl();
            double endTime = System.currentTimeMillis() + secondsToHoldKey* 1000;
            while (System.currentTimeMillis() < endTime) {
                windowsFocus.getMapleOnFocus();
                bot.keyPress(keyToHold);
                Thread.sleep(10);
                bot.keyRelease(keyToHold);
            }
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



 }
