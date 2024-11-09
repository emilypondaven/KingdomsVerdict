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
        Prompt prompt1;
        Prompt prompt2;
        Prompt prompt3;
        switch (villageNum) {
            case 1:
                prompt1 = new Prompt("The farmers from the common folk village are using up too much water.");
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
                
                prompt2= new Prompt("They recently heard about the benefits of renewable energy from a foreign wizard. He offered to build a solar farm for 20 gold.");
                prompt2.addPromptAction(
                    "Sounds like a good idea. Let's build some solar panels!",
                    -20,
                    new int[] {30, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"You build a solar farm and all the spiritualists were happy.", "You build a solar farm and all the spiritualists were happy."}
                );
                prompt2.addPromptAction(
                    "Build a coal factory instead since it's cheaper. Only 5 gold!",
                    -5,
                    new int[] {-50, 80, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The commonfolk heard about the factory jobs and moves to the climate change spritualist village", "No one was willing to work in your coal factory since the commonfolk didn't hear about it"}
                );
                prompt2.addPromptAction(
                    "That's too much gold. Refuse!!",
                    0,
                    new int[] {-5, 0, 0, -10},
                    new int[] {0, 0, 0, 10},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The reporter reported to outlaws that you refused service from a wizard. They now think you're a wizadist and that you committed a hate crime", "You refused to pay for a solar farm and the spiritualists were not too happy"}
                );
                prompts.add(prompt2);

                prompt3 = new Prompt("They want to ban fire magic. They argue it's polluting their kingdom");
                prompt3.addPromptAction(
                    "Promise to ban fire magic once you're king",
                    0,
                    new int[] {30, 0, 0, -20},
                    new int[] {0, 0, 0, 20},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The spiritualists are happy with your promise but the outlaws aren't happy with your promise after hearing it from the reporter.", "The spiritualists are happy with your promise"}
                );
                prompt3.addPromptAction(
                    "Kill the fire magicians so fire magic is banned forever",
                    0,
                    new int[] {45, 0, 0, -20},
                    new int[] {0, 0, 0, 20},
                    new int[] {0, 0, 0, -15},
                    new String[] {"You killed the fire maigicians and the outlaws weren't happy about that but the spiritualists are very happy with your commitement", "You killed the fire magicians but no outlaws know"}
                );
                prompt3.addPromptAction(
                    "Argue that fire magic isn't bad for pollution",
                    0,
                    new int[] {-10, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The spiritualists disagreed", "The spiritualists disagreed"}
                );

                prompts.add(prompt3);
                break;
            case 2:
                prompt1 = new Prompt("The commonfolk want to raise taxes on the rich.");
                prompt1.addPromptAction(
                    "Raise the taxes!",
                    0,
                    new int[] {-10, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The noble's heard that you're taking money from them. You're losing their votes!", "You're safe... the nobles heard nothing."}
                );
                prompt1.addPromptAction(
                    "Pay Robin Hood 5 golds to steal from the nobles and give to the commonfolks",
                    5,
                    new int[] {-10, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"Uh oh! The nobles found out and you lost some of their votes", "The nobles didn't hear about your decisions and the commonfolks are super happy."}
                );
                prompt1.addPromptAction(
                    "Refuse raising taxes as this would anger the nobles",
                    0,
                    new int[] {-10, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The nobles were very happy and you gained some of their votes", "The nobles didn't hear about your decisions and the commonfolks are angry."}
                );
                prompts.add(prompt1);
                
                prompt2= new Prompt("They want their children to be more educated so they want to build a new school.");
                prompt2.addPromptAction(
                    "Pay 30 golds to build the school",
                    -30,
                    new int[] {-10, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The children of the village were so excited", "The children of the village were so excited"}
                );
                prompt2.addPromptAction(
                    "Take some wizards from the outlaws and pay them to teach the children",
                    0,
                    new int[] {-10, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The outlaws were angered that their villagers were taken but the commonfolks were satisfied", "The outlaws didn't notice the missing words."}
                );
                prompt2.addPromptAction(
                    "Way too expensive!!",
                    0,
                    new int[] {-10, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new int[] {0, 0, 0, 0},
                    new String[] {"The children are disappointed :(", "The children are disappointed :("}
                );
                prompts.add(prompt2);

                prompt3 = new Prompt("They want to build a new healthcare system for their village.");
                prompt3.addPromptAction(
                    "Pay 50 golds to start a new healthcare system inspired by Medicare-for-All",
                    -50,
                    new int[] {10, 50, 10, 10},
                    new int[] {-10, 0, -10, -10},
                    new int[] {0, 0, 0, 0},
                    new String[] {"Everyone in the kingdom is very happy with your contribution", "The commonfolk are very happy"}
                );
                prompt3.addPromptAction(
                    "Force the healing wizards to move from the outlaw town into the commonfolk town",
                    0,
                    new int[] {0, 50, 0, -10},
                    new int[] {0, 0, 0, 10},
                    new int[] {0, 10, 0, -10},
                    new String[] {"The wizards reluctantly moved and the outlaws are not too happy but the commonfolk appreciate your help", "The outlaws didn't notice the missing wizards as no one was able to report the news of your actions"}
                );
                prompt3.addPromptAction(
                    "Kill and rob the sick people to then use some of the gold pay for a hospital",
                    30,
                    new int[] {-5, -10, 0, 0},
                    new int[] {5, 0, 0, 0},
                    new int[] {0, -30, 0, 0},
                    new String[] {"The spiritualists and commonfolk were furious with your decision", "The commonfolk were not happy with your decision"}
                );
                
                prompts.add(prompt3);
                break;
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
