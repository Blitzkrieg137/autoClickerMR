import bots.TestBotMacros;
import focus.WindowsFocus;
import focus.WindowsFocusImpl;
import movements.BasicMovements;
import movements.BasicMovementsImpl;
import processfind.ProcessHandling;
import processfind.ProcessHandlingImpl;

import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_RIGHT;

public class ApplicationRun {



    public static void main(String[] args) {

        WindowsFocus windowsFocus = new WindowsFocusImpl();
        BasicMovements basicMovements = new BasicMovementsImpl();


        windowsFocus.getMapleOnFocus();
        basicMovements.holdButton(KeyEvent.VK_LEFT, 2);
        basicMovements.pressButtonOnce(VK_RIGHT);

        System.exit(0);

    }
}
