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
            setPrompts(1),
            "These are environmentalists who love magic and witches. \n They really care about nature and ensuring that people won't abuse the earth",
            100
        );

        Village village2 = new Village(
            "Common Folk",
            setPrompts(2),
            "They are hard working labourers who desire more jobs, a higher standard of living and higher wages.\n They want the rich to be taxed (especially the nobles in vilage 3) more and they want less classism.\n They are scared of magic and witches. \n Remember this is the biggest village",
            300
        );

        Village village3 = new Village(
            "Nobles",
            setPrompts(3),
            "They are very rich and powerful people who want lower taxes. \n They feel threatened by witches",
            100
        );

        Village village4 = new Village(
            "The Outlaws",
            setPrompts(4),
            "This has a high population of outlawed villagers due to their differences.\n These include criminals, adventurers and magicians.\n They love chaos and they love to do favours for a reward",
            100
        );
    }

    public List<Prompt> setPrompts(int villageNum) {
        List<Prompt> prompts = new ArrayList<>();
        switch (villageNum) {
            case 1:
                Prompt prompt1 = new Prompt("The farmers from the common folk village are using up too much water.");
                prompt1.addPromptAction(
                    "Kill farmers from common folk village and steal their gold",
                    30,
                    new int[] {30, -40, 0, 0},
                    new int[] {0, 40, 0, 0},
                    new int[] {0, -30, 0, 0},
                    new String[] {"The kingdom's reporter announced to the commonfolk that you killed their farmers. \n They were not happy about that", "You killed the farmers and stole their gold but no commonfolk knows about it..."}

                );
                prompt1.addPromptAction(
                    "Make the promise",
                    0,
                    new int[] {20, -10, 0, 0},
                    new int[] {0, 10, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The kingdom's reporter announced to the commonfolk that you promised to talk their jobs away. \n They were not happy about that", "The climate change spiritualist are happy about the promise but the commonfolk no nothing about the promise..."}

                );
                prompt1.addPromptAction(
                    "Refuse to help",
                    0,
                    new int[] {-20, 30, 0, 0},
                    new int[] {0, -30, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The kingdom's reporter announced to the commonfolk that you wanted the farmers to keep their jobs. \n They were ecstatic", "The commonfolk don't know about your refusal."}
                );
                prompts.add(prompt1);
                
                Prompt prompt2= new Prompt("");
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompts.add(prompt2);

                Prompt prompt3 = new Prompt("");
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );

                prompts.add(prompt3);
                
            case 2:
            Prompt prompt1 = new Prompt("The farmers in another village are using up too much water.");
                prompt1.addPromptAction(

                );
                prompt1.addPromptAction(

                );
                prompt1.addPromptAction(

                );
                prompts.add(prompt1);
                
                Prompt prompt2= new Prompt("The farmers in another village are using up too much water.");
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompts.add(prompt2);

                Prompt prompt3 = new Prompt("The farmers in another village are using up too much water.");
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );
                
                prompts.add(prompt3);

            case 3:
            Prompt prompt1 = new Prompt("The farmers in another village are using up too much water.");
                prompt1.addPromptAction(

                );
                prompt1.addPromptAction(

                );
                prompt1.addPromptAction(

                );
                prompts.add(prompt1);
                
                Prompt prompt2= new Prompt("The farmers in another village are using up too much water.");
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompts.add(prompt2);

                Prompt prompt3 = new Prompt("The farmers in another village are using up too much water.");
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );
                
                prompts.add(prompt3);

            case 4:
            Prompt prompt1 = new Prompt("The farmers in another village are using up too much water.");
                prompt1.addPromptAction(

                );
                prompt1.addPromptAction(

                );
                prompt1.addPromptAction(

                );
                prompts.add(prompt1);
                
                Prompt prompt2= new Prompt("The farmers in another village are using up too much water.");
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompt2.addPromptAction(

                );
                prompts.add(prompt2);

                Prompt prompt3 = new Prompt("The farmers in another village are using up too much water.");
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );
                prompt3.addPromptAction(

                );
                
                prompts.add(prompt3);
        
            return prompts;
            
        }
    }
}
