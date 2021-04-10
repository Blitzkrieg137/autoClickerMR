package focus;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public class WindowsFocusImpl implements WindowsFocus{


    public void getMapleOnFocus() {
        getMapleOnFocus1();
    }

    public void getMapleOnFocus1(){
        setFocusToWindowsApp();
    }


    /**
     * Sets focus to a running windows application Windows Application. If the
     * handle of the desired application is not found then nothing happens.<pre>
     *
     * <b>Example Usage 1:</b>
     *
     *      setFocusToWindowsApp("Untitled - Notepad");
     *
     * <b>Example Usage 2:</b>
     *
     *      setFocusToWindowsApp("Untitled - Notepad", 1);</pre>
     *
     * @param applicationTitle (String) The title contained upon the application's
     * Window Title Bar.<br>
     *
     * @param windowState (Optional - Integer - Default is 0) By default when the
     * desired application window is set to show to the forefront on screen it is
     * displayed in its Normal window state (not maximized or minimized). If a value
     * of 1 is supplied then the windows is brought to the forefront in its Maximized
     * state. If 2 is supplied then the window is set to is Minimized state.<pre>
     *
     *      0   Normal (default)
     *      1   Maximized
     *      2   Minimized</pre><br>
     *
     * A value supplied that is less that 0 or greater than 2 is automatically changed
     * to 0 (Normal State).
     *                    int state = User32.SW_SHOWNORMAL; //default window state (Normal)
     *         if (windowState.length > 0) {
     *             state = windowState[0];
     *             switch(state) {
     *                 default:
     *                 case 0:
     *                     state = User32.SW_SHOWNORMAL;
     *                     break;
     *                 case 1:
     *                     state = User32.SW_SHOWMAXIMIZED;
     *                     break;
     *                 case 2:
     *                     state = User32.SW_SHOWMINIMIZED;
     *                     break;
     *             }
     *         }
     *
     *         User32 user32 = User32.INSTANCE;
     *         WinDef.HWND hWnd = user32.FindWindow(null, applicationTitle);
     *         if (user32.IsWindowVisible(hWnd)) {
     *             user32.ShowWindow(hWnd, state); //.SW_SHOW);
     *             user32.SetForegroundWindow(hWnd);
     *             user32.SetFocus(hWnd);
     *         }
     */
    public void setFocusToWindowsApp() {
        // Loop all windows
        User32.INSTANCE.EnumWindows((hWnd, data ) -> {
            char[] name = new char[512];

            User32.INSTANCE.GetWindowText( hWnd, name, name.length );
            // Find window with title starting with downcase "MapleRoyals" string
            if (Native.toString(name).startsWith("MapleRoyals")) {
                // Bring the window to the front
                User32.INSTANCE.SetForegroundWindow(hWnd);
                User32.INSTANCE.SetFocus(hWnd);
                System.out.println("found MapleRoyals Window");
                return false; // Found
            }
            System.out.println("keep searching");
            return true; // Keep searching
        }, null );
    }




}
