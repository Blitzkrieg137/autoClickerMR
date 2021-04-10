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

    public static void main( String[] args )
    {

        while(true){
            // Loop all windows
            User32.INSTANCE.EnumWindows((hWnd, data ) -> {
            char[] name = new char[512];

            User32.INSTANCE.GetWindowText( hWnd, name, name.length );

                // Find window with title starting with downcase "keyb" string
                if (Native.toString(name).startsWith("MapleR")) {
                    // Bring the window to the front
                    //User32.INSTANCE.SetForegroundWindow(hWnd);

                    int KEYEVENT_SCANCODE = 0x0008;
                    int KEYEVENT_UP = 0x0002;

                    WinUser.INPUT[] inputArray = (WinUser.INPUT[]) new WinUser.INPUT().toArray(4);
//WORKS
                    //User32.INSTANCE.ShowWindow(hWnd, WinUser.SW_HIDE);
                    User32.INSTANCE.SetForegroundWindow(hWnd);
                    User32.INSTANCE.SetFocus(hWnd);

                    inputArray[0].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
                    inputArray[0].input.setType("ki");
                    inputArray[0].input.ki.time = new WinDef.DWORD(0);
                    inputArray[0].input.ki.wVk = new WinDef.WORD(0); //using scancodes instead
                    inputArray[0].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
                    inputArray[0].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE);
                    inputArray[0].input.ki.wScan = new WinDef.WORD(0x02);

                    //User32.INSTANCE.SetForegroundWindow(hWnd);
                    //User32.INSTANCE.SetFocus(hWnd);

                    inputArray[1].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
                    inputArray[1].input.setType("ki");
                    inputArray[1].input.ki.time = new WinDef.DWORD(0);
                    inputArray[1].input.ki.wVk = new WinDef.WORD(0); //using scancodes instead
                    inputArray[1].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
                    inputArray[1].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE | KEYEVENT_UP);
                    inputArray[1].input.ki.wScan = new WinDef.WORD(0x02);

        /*inputArray[2].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        inputArray[2].input.setType("ki");
        inputArray[2].input.ki.time = new WinDef.DWORD(0);
        inputArray[2].input.ki.wVk  = new WinDef.WORD(0); //using scancodes instead
        inputArray[2].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        inputArray[2].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE);
        inputArray[2].input.ki.wScan = new WinDef.WORD(0x02);

        inputArray[3].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        inputArray[3].input.setType("ki");
        inputArray[3].input.ki.time = new WinDef.DWORD(0);
        inputArray[3].input.ki.wVk  = new WinDef.WORD(0); //using scancodes instead
        inputArray[3].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        inputArray[3].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE | KEYEVENT_UP);
        inputArray[3].input.ki.wScan = new WinDef.WORD(0x02);*/

                    System.out.println("Make sure maple is in focus...");
                    try {
                        Thread.sleep(2000);
                    } catch (Throwable ex) {
                        System.out.println("Interrupted");
                    }
                  //  WinDef.HWND fgWindow = User32.INSTANCE.GetActiveWindow();
                   // User32.INSTANCE.SetForegroundWindow(fgWindow);


                    User32.INSTANCE.SetForegroundWindow(hWnd);
                    //User32.INSTANCE.SetFocus(hWnd);
                    WinDef.DWORD sentInputs = User32.INSTANCE.SendInput(
                            new WinDef.DWORD(inputArray.length),
                            inputArray,
                            inputArray[0].size()
                    );
                    //1User32.INSTANCE.SetForegroundWindow(hWnd);
                    //User32.INSTANCE.SetFocus(hWnd);
                    System.out.println("Sent Input Count: " + sentInputs.intValue());



                    return false; // Found
                }
        return true; // Keep searching
    }, null );



}}


/*   public static void main(String[] args) {
        // Loop all windows
        User32.INSTANCE.EnumWindows(( hWnd, data ) -> {
            char[] name = new char[512];

            User32.INSTANCE.GetWindowText( hWnd, name, name.length );

            // Find window with title starting with downcase "keyb" string
            if ( Native.toString( name ).startsWith( "*Neues" ) )
            {


                // Prepare input reference
                WinUser.INPUT input = new WinUser.INPUT(  );

                input.type = new WinDef.DWORD( WinUser.INPUT.INPUT_KEYBOARD );
                input.input.setType("ki"); // Because setting INPUT_INPUT_KEYBOARD is not enough: https://groups.google.com/d/msg/jna-users/NDBGwC1VZbU/cjYCQ1CjBwAJ
                input.input.ki.wScan = new WinDef.WORD( 0 );
                input.input.ki.time = new WinDef.DWORD( 0 );
                input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR( 0 );

                // Press "a"
                input.input.ki.wVk = new WinDef.WORD( 'A' ); // 0x41
                input.input.ki.dwFlags = new WinDef.DWORD( 0 );  // keydown

                User32.INSTANCE.SendInput( new WinDef.DWORD( 1 ), ( WinUser.INPUT[] ) input.toArray( 1 ), input.size() );

                // Release "a"
                input.input.ki.wVk = new WinDef.WORD( 'A' ); // 0x41
                input.input.ki.dwFlags = new WinDef.DWORD( 2 );  // keyup

                User32.INSTANCE.SendInput( new WinDef.DWORD( 1 ), ( WinUser.INPUT[] ) input.toArray( 1 ), input.size() );

                return false; // Found
            }

            return true; // Keep searching
        }, null );
    }*/





/*
    public static void main( String[] args )
    {
        int KEYEVENT_SCANCODE = 0x0008;
        int KEYEVENT_UP = 0x0002;

        WinUser.INPUT[] inputArray = (WinUser.INPUT[]) new WinUser.INPUT().toArray(4);

        inputArray[0].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        inputArray[0].input.setType("ki");
        inputArray[0].input.ki.time = new WinDef.DWORD(0);
        inputArray[0].input.ki.wVk  = new WinDef.WORD(0); //using scancodes instead
        inputArray[0].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        inputArray[0].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE);
        inputArray[0].input.ki.wScan = new WinDef.WORD(0x02);


        */
/*inputArray[1].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        inputArray[1].input.setType("ki");
        inputArray[1].input.ki.time = new WinDef.DWORD(0);
        inputArray[1].input.ki.wVk  = new WinDef.WORD(0); //using scancodes instead
        inputArray[1].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        inputArray[1].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE | KEYEVENT_UP);
        inputArray[1].input.ki.wScan = new WinDef.WORD(0x01);

        inputArray[2].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        inputArray[2].input.setType("ki");
        inputArray[2].input.ki.time = new WinDef.DWORD(0);
        inputArray[2].input.ki.wVk  = new WinDef.WORD(0); //using scancodes instead
        inputArray[2].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        inputArray[2].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE);
        inputArray[2].input.ki.wScan = new WinDef.WORD(0x02);

        inputArray[3].type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        inputArray[3].input.setType("ki");
        inputArray[3].input.ki.time = new WinDef.DWORD(0);
        inputArray[3].input.ki.wVk  = new WinDef.WORD(0); //using scancodes instead
        inputArray[3].input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        inputArray[3].input.ki.dwFlags = new WinDef.DWORD(KEYEVENT_SCANCODE | KEYEVENT_UP);
        inputArray[3].input.ki.wScan = new WinDef.WORD(0x02);*//*


        System.out.println("Make sure notepad is in focus...");
        try { Thread.sleep(1000); } catch (Throwable ex) { System.out.println("Interrupted"); }

        WinDef.DWORD sentInputs = User32.INSTANCE.SendInput(
                new WinDef.DWORD(inputArray.length),
                inputArray,
                inputArray[0].size()
        );

        System.out.println("Sent Input Count: " + sentInputs.intValue());
    }
*/








}




