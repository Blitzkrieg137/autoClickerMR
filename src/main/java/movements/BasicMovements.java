package movements;

public interface BasicMovements {

    void holdButton(int keyToHold, double secondsToHoldKey);
    void pressButtonOnce(int keyToPress);
    void walkRightWithSkill(int endX, int endY, int xWidth, int yWidth, String imageName);
    void walkLeftWithSkill(int endX, int endY, int xWidth, int yWidth, String imageName);
    void walkRightUntilRope(int endX, int endY, int xWidth, int yWidth, String imageName);
    void buffAndClimbUpRope();
    void climbUpRope();
    void jumpDown();

}
