package imagedetection;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public interface DetectCharacterByImage {

    boolean detectCharacterByImage(int endX, int endY, int xWidth, int yWidth, String imageName);

}
