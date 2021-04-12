import imagedetection.DetectCharacterByImage;
import imagedetection.DetectCharacterByImageImpl;
import inputdetection.DetectKeyboardInput;
import inputdetection.DetectKeyboardInputImpl;
import movements.BasicMovements;
import movements.BasicMovementsImpl;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import java.sql.Time;
import java.util.Date;

import static java.awt.event.KeyEvent.VK_F12;
import static java.awt.event.KeyEvent.VK_LEFT;

public class ApplicationRun {



    public static void main(String[] args) throws InterruptedException {

/*        WindowsFocus windowsFocus = new WindowsFocusImpl();
        BasicMovements basicMovements = new BasicMovementsImpl();


        windowsFocus.getMapleOnFocus();
        basicMovements.holdButton(KeyEvent.VK_LEFT, 2);
        basicMovements.pressButtonOnce(VK_RIGHT);*/


        BasicMovements basicMovements = new BasicMovementsImpl();
        DetectKeyboardInput detectKeyboardInput = new DetectKeyboardInputImpl();

        Date date = new Date();
        System.out.println(date);


        for (int i = 0; i<=10; i++){
                //LOWER STAGE
                basicMovements.walkRightWithSkill(730, 380, 200, 100, "right.png");
                basicMovements.walkLeftWithSkill(165, 415, 150, 45, "left.png");


                basicMovements.walkRightUntilRope(457, 600, 200, 200, "HeadBishop1.png");
                    if (i % 2 == 1) {
                        //CLIMB UP
                        basicMovements.climbUpRope();
                    } else {
                        //BUFF AND CLIMB UP
                        basicMovements.buffAndClimbUpRope();
                    }

                //UPPER STAGE
                basicMovements.walkRightWithSkill(730, 220, 80, 100, "rightUp.png");
                basicMovements.walkLeftWithSkill(350, 510, 80, 100, "leftUp.png");

                //JUMP DOWN
                Thread.sleep(1500);
                basicMovements.jumpDown();
        }
        //GET SAFE
        basicMovements.walkRightUntilRope(457, 600, 200, 200, "HeadBishop1.png");

        Date date2 = new Date();
        System.out.println("BOT ENDE!");
        System.out.println("TIMESTAMPS: " + date);
        System.out.println("TIMESTAMPS: " + date2);

        //Canvas canvas1 = new DesktopCanvas();
        //canvas1.addBox(new DesktopScreenRegion(730,220,80,100)).display(10);



        //REPEAT ALL

        System.exit(0);

    }
}
