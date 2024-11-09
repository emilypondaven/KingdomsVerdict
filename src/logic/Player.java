package logic;

public class Player {
    public static final String PLAYER_IMAGE_STRING = "sprite.png";
    //Moves by 4px each.
    private int MOVEMENT_SPEED = 4;
    private int x, y;

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
}
