package logic;

public class GameEnv {
    //HAve a way of representing entitites
    //Most logical decisions will happen here
    private Player player;

    public GameEnv() {
        player = new Player();
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerX() {
        return player.getX();
    }

    public int getPlayerY() {
        return player.getY();
    }

    public void movePlayerX(int direction) {
        player.changeX(direction);
    }

    public void movePlayerY(int direction) {
        player.changeY(direction);
    }

    public void setupGame() {
        setupPrompts();
    }

    private void setupPrompts() {
        
    }

}
