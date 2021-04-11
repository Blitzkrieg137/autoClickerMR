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


    public static void main(String[] args) {
        //Canvas canvas1 = new DesktopCanvas();
       // canvas1.addBox(new DesktopScreenRegion(430,600,200,200)).display(100);


    }

    @Override
    public boolean detectCharacterByImage(int endX, int endY, int xWidth, int yWidth, String imageName) {
        return detectCharacterImpl(endX, endY, xWidth, yWidth, imageName);
    }

    private boolean detectCharacterImpl(int endX, int endY, int xWidth, int yWidth, String imageName) {
        try {
        //create ScreenRegion to search for image
        ScreenRegion s = new DesktopScreenRegion(endX, endY, xWidth, yWidth);

        //create URL from image path
        String path = URLDecoder.decode("file:///C:/Users/T/Desktop/MapleBotImages/" + imageName, "UTF-8");
        URL imageURL = new URL(path);
        Target imageTarget = new ImageTarget(imageURL);

        //search for image
        ScreenRegion r = s.wait(imageTarget,10000);

        // Display "" next to the found target for 3 seconds
        /*Canvas canvas = new DesktopCanvas();
        canvas.addBox(new DesktopScreenRegion(endX,endY,xWidth,120)).display(3);
        canvas.addLabel(r, "Position here").display(3);*/
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    return true;
    }



}
