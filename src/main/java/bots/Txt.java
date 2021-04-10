package bots;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class Txt {

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

/*
    public static void main(String[] args){

        //virtual-key code
        int WM_KEYDOWN = 0x0100;
        int WM_KEYUP = 0x0101;
        int WM_CHAR = 0x0102;

        //Keyboard Scan Code Specification
        int wPARAMDown = 0x5A;
        int wPARAMChar = 0x7A;




        int VK_A = 0x5A;
        String windowName = "test.txt - Editor";
        String windowName2 = "test.txt";

        WinDef.WPARAM wPARAM = new WinDef.WPARAM(VK_A);
        WinDef.LPARAM lPARAM = new WinDef.LPARAM(0x002C0001);

       // WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null,windowName); // window title

        WinDef.HWND hWindowHandle = User32.INSTANCE.FindWindow(null, windowName2);

        WinDef.HWND EditClass = User32.INSTANCE.FindWindowEx(hWindowHandle, null,"Edit" , null);

        User32.INSTANCE.SendMessage(EditClass, WM_KEYDOWN, wPARAM, lPARAM);
        User32.INSTANCE.SendMessage(EditClass, WM_CHAR, wPARAM, lPARAM);
        User32.INSTANCE.SendMessage(EditClass, WM_KEYUP, wPARAM, lPARAM);



        *//*LPCSTR Target_window_Name = "Untitled - Notepad"; //<- Has to match window name
        HWND hWindowHandle = FindWindow(NULL,Target_window_Name);
        HWND EditClass = FindWindowEx(hWindowHandle, NULL, "Edit", NULL);

        SendMessage(EditClass,WM_KEYDOWN,0x5A,0x002C0001);
        SendMessage(EditClass,WM_CHAR,0x7A,0x002C0001);
        SendMessage(EditClass,WM_KEYUP,0x5A,0xC02C0001);*//*



    }*/


  /*  private static void sendInputToWindow(WinDef.HWND editorWindowHandle, char[] password) throws InterruptedException {
        User32.INSTANCE.ShowWindow(editorWindowHandle, WinUser.SW_HIDE);
        User32.INSTANCE.SetForegroundWindow(editorWindowHandle);
        User32.INSTANCE.SetFocus(editorWindowHandle);

        //F7 KEY SENT
        WinDef.WPARAM wparam = new WinDef.WPARAM("F7_VIRTUAL_KEY");
        WinDef.LPARAM lparam = new WinDef.LPARAM(0);
        //log.debug("SENDING F7");
        User32.INSTANCE.SendMessage(editorWindowHandle, WinUser.WM_KEYDOWN, wparam, lparam);
        Thread.sleep(1000);
        //log.debug("SENDING PASSWORD");
        // PASSWORD SENT
        User32.INSTANCE.SendMessage(editorWindowHandle, WinUser.WM_CHAR, new WinDef.WPARAM(password[0]), lparam);
        User32.INSTANCE.SendMessage(editorWindowHandle, WinUser.WM_CHAR, new WinDef.WPARAM(password[1]), lparam);
        User32.INSTANCE.SendMessage(editorWindowHandle, WinUser.WM_CHAR, new WinDef.WPARAM(password[2]), lparam);
        User32.INSTANCE.SendMessage(editorWindowHandle, WinUser.WM_CHAR, new WinDef.WPARAM(password[3]), lparam);
        Thread.sleep(500);
        //log.debug("SENDING ENTER");
        // ENTER KEY SENT
        User32.INSTANCE.SendMessage(editorWindowHandle, WinUser.WM_KEYDOWN, new WinDef.WPARAM("ENTER_KEY"), lparam);
    }*/

    public static void main(String[] args) {


    User32.INSTANCE.EnumWindows(( hWnd, data ) -> {
        char[] name = new char[512];



        User32.INSTANCE.GetWindowText( hWnd, name, name.length );

        // Find window with title starting with downcase "keyb" string
        if (Native.toString(name).startsWith("*test")) {
            // Bring the window to the front
            System.out.println("found window");
            User32.INSTANCE.SetForegroundWindow(hWnd);
//CONTENT
            User32.INSTANCE.ShowWindow(hWnd, WinUser.SW_HIDE);
            User32.INSTANCE.SetForegroundWindow(hWnd);
            User32.INSTANCE.SetFocus(hWnd);

            WinDef.WPARAM wPARAM = new WinDef.WPARAM(0x02);
            WinDef.LPARAM lparam = new WinDef.LPARAM(0x002C0001);


            int WM_KEYDOWN = 0x0100;
            int WM_KEYUP = 0x0101;
            int WM_CHAR = 0x0102;

            User32.INSTANCE.SendMessage(hWnd, WinUser.WM_KEYDOWN, new WinDef.WPARAM(0x02), lparam);
            User32.INSTANCE.SendMessage(hWnd, WinUser.WM_CHAR, new WinDef.WPARAM(0x02), lparam);
            User32.INSTANCE.SendMessage(hWnd, WinUser.WM_KEYUP, new WinDef.WPARAM(0x02), lparam);

            User32.INSTANCE.ShowWindow(hWnd, WinUser.SW_SHOW);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//CONTENT
                       System.out.println("Make sure maple is in focus...");
                    try {
        Thread.sleep(2000);
    } catch (Throwable ex) {
        System.out.println("Interrupted");
    }

//    WinDef.DWORD sentInputs = User32.INSTANCE.SendInput(
//            new WinDef.DWORD(inputArray.length),
//            inputArray,
//            inputArray[0].size()
//
//
//    );

            User32.INSTANCE.SendMessage(hWnd, WinUser.WM_KEYDOWN, new WinDef.WPARAM(0x5A), lparam);
            User32.INSTANCE.SendMessage(hWnd, WinUser.WM_CHAR, new WinDef.WPARAM(0x5A), lparam);
            User32.INSTANCE.SendMessage(hWnd, WinUser.WM_KEYUP, new WinDef.WPARAM(0x5A), lparam);

                    return false; // Found
}
        return true; // Keep searching
                }, null );



//end psvm
}



}
