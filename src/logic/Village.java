package logic;
import java.util.ArrayList;
import java.util.List;

public class Village {
    private String name;
    private List<Prompt> prompts = new ArrayList<Prompt>();
    private int population;
    private String description;
    private Boolean villageDead = false;
    private int villageVotes;
    protected int[][] villagePositions;

    public Village(String name, List<Prompt> prompts, String description, int population, int[][] villagePositions) {
        this.name = name;
        this.prompts = prompts;
        this.description = description;
        this.population = population;
        this.villagePositions = villagePositions;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void addPrompt(Prompt prompt) {
        prompts.add(prompt);
    }

    // If prompt is null, sprite should leave
    public Prompt getPrompt() {
        Prompt prompt = null;
        if (!prompts.isEmpty()) {
            prompt = prompts.get(0);
            prompts.remove(0);
        }
        return prompt;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // Finished all prompts or killed all villagers
    public void setVillageDead(boolean villageDead) {
        this.villageDead = villageDead;
    }

    public Boolean getVillageDead() {
        return villageDead;
    }

    public void setVillageVotes(int villageVotes) {
        this.villageVotes = villageVotes;
    }

    public int getVillageVotes() {
        return villageVotes;
    }

    public void changeVillageVote(int change) {
        villageVotes = villageVotes + change;
        if (villageVotes > population) {
            villageVotes = population;
        }
        if (villageVotes < 0) {
            villageVotes = 0;
        }
    }

    public void changePopulation(int change) {
        population = population + change;
        if (population <= 0) {
            population = 0;
            villageDead = true;
        }
    }
    public boolean inVillage(int x, int y) {
        if (x < villagePositions[0][0] || x > villagePositions[0][1]
            || y < villagePositions[1][0] || y > villagePositions[1][1]) {
            return false;
        }
        else return true;
    }
}
