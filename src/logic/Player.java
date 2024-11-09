package logic;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;

import gui.GameView;
import io.Resources;

public class Player {
    //Moves by 4px each.
    private int MOVEMENT_SPEED = 4;
    private int x, y;
    private int width, height;

    private static int gold = 100;
    private static boolean reporterReporting = true;
    private Direction currentDirection;
    private boolean idle = true;
    private static int voteCount = 80;
    private static int totalPopulation = 400;

    enum Direction {
        UP,
        SIDE,
        DOWN
    }

    public Player() {
        width = 40;
        height = 56;
        x = (int) GameView.DEFAULT_DIMENSIONS.getWidth() / 2 - width;
        y = (int) GameView.DEFAULT_DIMENSIONS.getHeight() / 2 - height;
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

    // Method to increase gold by a specific amount (you could also use a "change" method if you'd prefer)
    public static void changeGold(int amount) {
        gold += amount;
    }

    // Getter for reporterReporting
    public static boolean isReporterReporting() {
        return reporterReporting;
    }

    // Setter for reportReporting
    public static void setReportReporting(boolean reportReporting) {
        reporterReporting = reportReporting;
    }

    // Method to toggle reportReporting (change from true to false or false to true)
    public static void toggleReportReporting() {
        reporterReporting = !reporterReporting;
    }

    public String playerImageString;
    public BufferedImage currentImage = null;
    private int animationStage = 0;
    private static final int SPRITE_WIDTH = 48;

    public Image getPlayerSprite() {
        if (idle) {
            // System.out.println("IDLE");
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
        currentImage = image;
        // System.err.println("animation stage " + animationStage);
        try {
            // System.out.println(animationStage);
            return image.getSubimage(14 + animationStage * SPRITE_WIDTH, 5, 20, 28).getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }
        catch (RasterFormatException e) {
            animationStage = 0;
            return getPlayerSprite();
        } 
    }

    public void setIdle() {
        // animationStage = 0;
        idle = true;
    }

    public void updateAnimationStage() {
        // if (animationStage > (currentImage.getWidth() / SPRITE_WIDTH)) animationStage = 0;
        animationStage = (animationStage + 1) % (currentImage.getWidth() / SPRITE_WIDTH);
    }

    //NEED TO DISPLAY THE STRING RETURNED HERE
    public String action(PromptAction action) {
        changeGold(action.getGoldChange());
        changeVillageVotes(action.getVillageVoterChange());
        changePopultion(action.getVillageVoterChange());

        return action.getPromptActionMessage();
    }

    public void changeVillageVotes(int[] changesInVotes) {
        for (int k = 0 ; k < 4; k++) {
            (GameEnv.villages.get(k)).changeVillageVote(changesInVotes[k]);
        }
    }

    public void changePopultion(int[] changesInPopulation) {
        for (int k = 0 ; k < 4; k++) {
            (GameEnv.villages.get(k)).changePopulation(changesInPopulation[k]);
        }
    }

    public boolean allVillagesDead() {
        for (int k = 0 ; k < 4; k++) {
            if (!(GameEnv.villages.get(k)).getVillageDead()) {
                return false;
            }
        }
        return true;
    }

    public void gameTurn(PromptAction action){
        String message = action.getPromptActionMessage()
        action(action);
        updateVoteCount();
        updateTotalPopulation();
    }

    public static int getVoteCount() {
        return voteCount;
    }

    public void updateVoteCount() {
        int total = 0;
        for (int k = 0 ; k < 4; k++) {
            total = total + (GameEnv.villages.get(k)).getVillageVotes();
        }
        voteCount = total;
    }

    public static int getTotalPopulation() {
        return totalPopulation;
    }

    public void updateTotalPopulation() {
        int total = 0;
        for (int k = 0 ; k < 4; k++) {
            total = total + (GameEnv.villages.get(k)).getPopulation();
        }
        totalPopulation = total;
    }
}
