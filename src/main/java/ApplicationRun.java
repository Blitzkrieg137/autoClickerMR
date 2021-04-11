import inputdetection.DetectKeyboardInput;
import inputdetection.DetectKeyboardInputImpl;
import movements.BasicMovements;
import movements.BasicMovementsImpl;

import static java.awt.event.KeyEvent.VK_F12;
import static java.awt.event.KeyEvent.VK_LEFT;

public class ApplicationRun {



    public static void main(String[] args) throws InterruptedException {

/*        WindowsFocus windowsFocus = new WindowsFocusImpl();
        BasicMovements basicMovements = new BasicMovementsImpl();


        windowsFocus.getMapleOnFocus();
        basicMovements.holdButton(KeyEvent.VK_LEFT, 2);
        basicMovements.pressButtonOnce(VK_RIGHT);*/


        DetectKeyboardInput detectKeyboardInput = new DetectKeyboardInputImpl();
        BasicMovements basicMovements = new BasicMovementsImpl();






        for (int i = 0; i<=4; i++){
            basicMovements.walkRightWithSkill(994, 422, 870, 394, -10066347, -6702132);
            basicMovements.walkLeftWithSkill(348, 455, 202, 506, -2250019, -10066347);
        }



    }
}
