package inputdetection;

import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

public class DetectKeyboardInputImpl implements DetectKeyboardInput{

    public static final int KEYEVENTF_KEYDOWN = 0;
    public static final int KEYEVENTF_KEYUP = 2;

    @Override
    public boolean isKeyDown(int vkCode) {
        return isKeyDownImpl(vkCode);
    }

    /**
     * Check if a key is pressed.
     *
     * @param vkCode
     *            Key-code. For example: <i>KeyEvent.VK_SHIFT </i>
     *
     * @return {@code true} if key is down. False otherwise.
     */
    private boolean isKeyDownImpl(int vkCode) {
        short state = User32.INSTANCE.GetAsyncKeyState(vkCode);
        // check most-significant bit for non-zero.
        return (0x1 & (state >> (Short.SIZE - 1))) != 0;
    }

    /**
     * Sends a key-down input followed by a key-up input for the given character
     * value c.
     *
     * @param c
     */
    public static void pressKey(int c) {
        WinUser.INPUT input = new WinUser.INPUT();
        input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        input.input.setType("ki");
        input.input.ki.wScan = new WinDef.WORD(0);
        input.input.ki.time = new WinDef.DWORD(0);
        input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        input.input.ki.wVk = new WinDef.WORD(c);
        input.input.ki.dwFlags = new WinDef.DWORD(KEYEVENTF_KEYDOWN);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
        input.input.ki.wVk = new WinDef.WORD(c);
        input.input.ki.dwFlags = new WinDef.DWORD(KEYEVENTF_KEYUP);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
    }

    /**
     * Sends a key-down input for the given character value c.
     *
     * @param c
     */
    public static void sendKeyDown(int c) {
        WinUser.INPUT input = new WinUser.INPUT();
        input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        input.input.setType("ki");
        input.input.ki.wScan = new WinDef.WORD(0);
        input.input.ki.time = new WinDef.DWORD(0);
        input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        input.input.ki.wVk = new WinDef.WORD(c);
        input.input.ki.dwFlags = new WinDef.DWORD(KEYEVENTF_KEYDOWN);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
    }

    /**
     * Sends a key-up input for the given character value c.
     *
     * @param c
     */
    public static void sendKeyUp(int c) {
        WinUser.INPUT input = new WinUser.INPUT();
        input.type = new WinDef.DWORD(WinUser.INPUT.INPUT_KEYBOARD);
        input.input.setType("ki");
        input.input.ki.wScan = new WinDef.WORD(0);
        input.input.ki.time = new WinDef.DWORD(0);
        input.input.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
        input.input.ki.wVk = new WinDef.WORD(c);
        input.input.ki.dwFlags = new WinDef.DWORD(KEYEVENTF_KEYUP);
        User32.INSTANCE.SendInput(new WinDef.DWORD(1), (WinUser.INPUT[]) input.toArray(1), input.size());
    }


}
