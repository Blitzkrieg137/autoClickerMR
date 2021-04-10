package bots;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import focus.WindowsFocus;
import focus.WindowsFocusImpl;
import me.coley.simplejna.Keyboard;
import me.coley.simplejna.hook.key.KeyEventReceiver;
import me.coley.simplejna.hook.key.KeyHookManager;

public class TestBotMacros {



    public static void testFocusMovement(){
        WindowsFocus windowsFocus = new WindowsFocusImpl();
        windowsFocus.getMapleOnFocus();
    }

    public static void main( String[] args ) {
        testFocusMovement();
    }


}




