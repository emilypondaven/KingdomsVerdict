package logic;
import java.util.ArrayList;
import java.util.List;

public class Village {
    private String name;
    private List<Prompt> prompts = new ArrayList<>();
    private int population;
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
