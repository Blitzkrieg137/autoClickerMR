package movements;

public interface BasicMovements {

    void holdButton(int keyToHold, double secondsToHoldKey);
    void pressButtonOnce(int keyToPress);
    void walkRightWithSkill(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2) throws InterruptedException;
    void walkLeftWithSkill(int endX, int endY, int endX2, int endY2, int getPixelColorValue, int getPixelColorValue2) throws InterruptedException;

}
