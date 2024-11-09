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

    public void addPromptAction(String message, int goldChange, int[] villageVoterChange, int[] reporterNotHereChange) {
        promptActions.add(new PromptAction(message, goldChange, villageVoterChange, reporterNotHereChange));
    }

    public List<PromptAction> getPromptActions() {
        
    }
}