package imagedetection;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public class DetectCharacterByImageImpl implements DetectCharacterByImage{


    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        detectCharacterImpl();
    }

    @Override
    public void detectCharacter() throws MalformedURLException, UnsupportedEncodingException {
        detectCharacterImpl();
    }

    private static void detectCharacterImpl() throws MalformedURLException, UnsupportedEncodingException {
        // Create a screen region object that corresponds to the default monitor in full screen
        ScreenRegion s = new DesktopScreenRegion();

        String path = URLDecoder.decode("file:///C:/Users/T/Desktop/MapleBotImages/HeadBishop1.png", "UTF-8");
        System.out.println(new File(path).getPath());

        URL imageURL = new URL(path);

        Target imageTarget = new ImageTarget(imageURL);

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        ScreenRegion r = s.wait(imageTarget,5000);

        // Display "Hello World" next to the found target for 3 seconds
        Canvas canvas = new DesktopCanvas();
        canvas.addLabel(r, "Hello World").display(3);

    }

    private static void testMe() throws MalformedURLException {
        // Create a screen region object that corresponds to the default monitor in full screen
        ScreenRegion s = new DesktopScreenRegion();

        // Specify an image as the target to find on the screen
        URL imageURL = new URL("http://code.google.com/images/code_logo.gif");
        Target imageTarget = new ImageTarget(imageURL);

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        ScreenRegion r = s.wait(imageTarget,5000);

        // Display "Hello World" next to the found target for 3 seconds
        Canvas canvas = new DesktopCanvas();
        canvas.addLabel(r, "Hello World").display(3);

    }


}
