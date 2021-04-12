import imagedetection.DetectCharacterByImage;
import imagedetection.DetectCharacterByImageImpl;
import inputdetection.DetectKeyboardInput;
import inputdetection.DetectKeyboardInputImpl;
import movements.BasicMovements;
import movements.BasicMovementsImpl;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

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

        for (int i = 0; i<=4; i++){


        //LOWER STAGE
        basicMovements.walkRightWithSkill(730, 600, 200, 200, "right.png");
        basicMovements.walkLeftWithSkill(0, 600, 200, 200, "left.png");

        basicMovements.walkRightUntilRope(457,600, 200,200, "HeadBishop1.png");

        //BUFF AND GO UP
        basicMovements.buffAndClimbUpRope();
        //START RIGHT / LEFT WALK SEQUENCE
        basicMovements.walkRightWithSkill(730, 444, 200, 200, "right.png");
        basicMovements.walkLeftWithSkill(0, 444, 200, 200, "left.png");
        //JUMP DOWN
        Thread.sleep(1500);
        basicMovements.jumpDown();
        }


        //DetectCharacterByImage detectCharacterByImage = new DetectCharacterByImageImpl();
        //detectCharacterByImage.detectCharacterWalkRightLeft(420,551,135,15, "HeadBishop1.png");
        //Canvas canvas1 = new DesktopCanvas();
        //canvas1.addBox(new DesktopScreenRegion(420,400,200,190)).display(100);

        //BasicMovementsImpl basicMovements1 = new BasicMovementsImpl();
        //basicMovements1.checkIfOnRope();
        //REPEAT ALL

        System.exit(0);

    }
}
