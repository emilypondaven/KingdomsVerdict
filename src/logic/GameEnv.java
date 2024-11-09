package logic;

import java.util.ArrayList;
import java.util.List;

public class GameEnv {
    //HAve a way of representing entitites
    //Most logical decisions will happen here
    private Player player;
    private List<Village> villages = new ArrayList<>();

    public GameEnv() {
        player = new Player();

        // Add everything to the villages
        initialiseVillages();
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

    public void initialiseVillages() {
        Village village1 = new Village(
            "Climate Change Spiritualists",
            getPrompt(1),
            "These are environmentalists who love magic and witches. \n They really care about nature and ensuring that people won't abuse the earth",
            100
        );

        Village village2 = new Village(
            "Common Folk",
            getPrompt(2),
            "They are hard working labourers who desire more jobs, a higher standard of living and higher wages.\n They want the rich to be taxed (especially the nobles in vilage 3) more and they want less classism.\n They are scared of magic and witches. \n Remember this is the biggest village",
            300
        );

        Village village3 = new Village(
            "Nobles",
            getPrompt(3),
            "They are very rich and powerful people who want lower taxes. \n They feel threatened by witches",
            100
        );

        Village village4 = new Village(
            "The Outlaws",
            getPrompt(4),
            "This has a high population of outlawed villagers due to their differences.\n These include criminals, adventurers and magicians.\n They love chaos and they love to do favours for a reward",
            100
        );
    }

    public List<Prompt> getPrompt(int villageNum) {
        switch (villageNum) {
            case 1:
                
            case 2:
            case 3:
            case 4:
            
        }
    }
}
