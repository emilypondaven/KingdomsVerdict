package logic;
import javax.swing.SwingUtilities;
import gui.Window;
import java.util.ArrayList;
import java.util.List;

public class Prompt {
    private String promptMessage;
    private List<PromptAction> promptActions = new ArrayList<>(); 

    public Prompt(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public void addPromptAction(String message, int goldChange, int[] villageVoterChange, int[] reporterNotHereChange, int[] villagerPopulationChange, String[] postActionMessages) {
        promptActions.add(new PromptAction(message, goldChange, villageVoterChange, reporterNotHereChange, villagerPopulationChange, postActionMessages));
    }

    public List<String> getPromptActionMessages() {
        List<String> promptActionMessages = new ArrayList<>();
        for (int i=0; i<3; i++) {
            promptActionMessages.add(promptActions.get(i).getPromptActionMessage());
        }
        return promptActionMessages;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public PromptAction gePromptAction(int k) {
        return promptActions.get(k);
    }
}