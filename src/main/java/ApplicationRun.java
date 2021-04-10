import bots.TestBotMacros;
import focus.WindowsFocus;
import focus.WindowsFocusImpl;
import movements.BasicMovements;
import movements.BasicMovementsImpl;
import processfind.ProcessHandling;
import processfind.ProcessHandlingImpl;

import java.awt.event.KeyEvent;

public class ApplicationRun {



    public static void main(String[] args) {

        WindowsFocus windowsFocus = new WindowsFocusImpl();
        windowsFocus.getMapleOnFocus();


        /*TestBotMacros testBotMacros = new TestBotMacros();
        testBotMacros.testFocusMovement();*/

        //basicMovements basicMovements = new BasicMovementsImpl();
        //basicMovements.createRobot();
        //basicMovements.holdButton(KeyEvent.VK_LEFT, 5);
        //basicMovements.pressButtonOnce(66);

        System.exit(1);

    }
}
