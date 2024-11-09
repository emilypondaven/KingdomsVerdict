package logic;

public class Player {
    public static final String PLAYER_IMAGE_STRING = "sprite.png";
    //Moves by 4px each.
    private int MOVEMENT_SPEED = 4;
    private int x, y;

    private int gold = 100;
    private boolean reportReporting = true;

    public Player() {
        x = 0;
        y = 0;
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
        }
        else if (direction < 0) {
            x = x -MOVEMENT_SPEED;
        }
    }

    protected void changeY(int direction) {
        if (direction > 0) {
            y = y + MOVEMENT_SPEED;
        }
        else if (direction < 0) {
            y = y - MOVEMENT_SPEED;
        }
    }

    // Getter for gold
    public int getGold() {
        return gold;
    }

    // Setter for gold
    public void setGold(int gold) {
        this.gold = gold;
    }

    // Method to increase gold by a specific amount (you could also use a "change" method if you'd prefer)
    public void changeGold(int amount) {
        this.gold += amount;
    }

    // Getter for reportReporting
    public boolean isReportReporting() {
        return reportReporting;
    }

    // Setter for reportReporting
    public void setReportReporting(boolean reportReporting) {
        this.reportReporting = reportReporting;
    }

    // Method to toggle reportReporting (change from true to false or false to true)
    public void toggleReportReporting() {
        this.reportReporting = !this.reportReporting;
    }
}
