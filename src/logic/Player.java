package logic;

import java.awt.Image;
import java.awt.image.BufferedImage;

import gui.GameView;
import io.Resources;

public class Player {
    //Moves by 4px each.
    private int MOVEMENT_SPEED = 4;
    private int x, y;
    private int width, height;

    private int gold = 100;
    private boolean reportReporting = true;
    private Direction currentDirection;
    private boolean idle = true;

    enum Direction {
        UP,
        SIDE,
        DOWN
    }

    public Player() {
        x = 0;
        y = 0;
        width = 60;
        height = 84;
        currentDirection = Direction.DOWN;
        playerImageString = "Player_D_Idle.png";
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    protected void changeX(int direction) {
        idle = false;
        currentDirection = Direction.SIDE;
        playerImageString = "Player_S_Walk.png";
        // System.out.println("Updated");
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
        else idle = true;
    }

    protected void changeY(int direction) {
        idle = false;
        if (direction > 0) {
            y = y + MOVEMENT_SPEED;
            if ((y + height) > GameView.DEFAULT_DIMENSIONS.getHeight()) {
                y = (int) GameView.getInstance().getSize().getHeight() - height;
            }
            currentDirection = Direction.DOWN;
            playerImageString = "Player_D_Walk.png";
        }
        else if (direction < 0) {
            y = y - MOVEMENT_SPEED;
            if (y < 0) y = 0;
            currentDirection = Direction.UP;
            playerImageString = "Player_U_Walk.png";
        }
        else idle = true;
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

    public String playerImageString;
    private int animationStage = 0;

    public Image getPlayerSprite() {
        if (idle) {
            System.out.println("IDLE");
            switch (currentDirection) {
                case DOWN:
                    playerImageString = "Player_D_Idle.png";
                    break;
                case UP:
                    playerImageString = "Player_U_Idle.png";
                    break;
                case SIDE:
                    playerImageString = "Player_S_Idle.png";
                    break; 
                default:
                    break;
            }
        }
        BufferedImage image = Resources.getImage(playerImageString);
        int spriteWidth = 48;
        animationStage = (animationStage + 1) % (image.getWidth() / spriteWidth);
        // System.err.println("animation stage " + animationStage);
        return image.getSubimage(14 + animationStage * spriteWidth, 5, 20, 28).getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
