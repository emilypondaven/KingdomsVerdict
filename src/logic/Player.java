package logic;

import gui.GameView;

public class Player {
    public static final String PLAYER_IMAGE_STRING = "sprite.png";
    //Moves by 4px each.
    private int MOVEMENT_SPEED = 4;
    private int x, y;
    private int width, height;

    private static int gold = 100;
    private static boolean reporterReporting = true;

    public Player() {
        x = 0;
        y = 0;
        width = 80;
        height = 80;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    protected void changeX(int direction) {
        if (direction > 0) {
            x = x + MOVEMENT_SPEED;
            if ((x + width) > GameView.DEFAULT_DIMENSIONS.getWidth()) {
                x = (int) GameView.DEFAULT_DIMENSIONS.getWidth() - width;
            }
        }
        else if (direction < 0) {
            x = x - MOVEMENT_SPEED;
            if (x < 0) x = 0;
        }
    }

    protected void changeY(int direction) {
        if (direction > 0) {
            y = y + MOVEMENT_SPEED;
            if ((y + height) > GameView.DEFAULT_DIMENSIONS.getHeight()) {
                y = (int) GameView.getInstance().getSize().getHeight() - height;
            }
            System.out.println(y);
        }
        else if (direction < 0) {
            y = y - MOVEMENT_SPEED;
            if (y < 0) y = 0;
        }
    }

    // Getter for gold
    public int getGold() {
        return gold;
    }

    // Method to increase gold by a specific amount (you could also use a "change" method if you'd prefer)
    public static void changeGold(int amount) {
        gold += amount;
    }

    // Getter for reporterReporting
    public static boolean isReporterReporting() {
        return reporterReporting;
    }

    // Setter for reporterReporting
    public static void setreporterReporting(boolean reporterReportingValue) {
        reporterReporting = reporterReportingValue;
    }
}
