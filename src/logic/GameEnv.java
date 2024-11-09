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
}
