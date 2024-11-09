package logic;

public class Player {
    public static final String PLAYER_IMAGE_STRING = "sprite.png";

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
}
