import javax.swing.SwingUtilities;
import gui.Window;

public class PromptAction {
    private String promptActionMessage;
    private int goldChange;
    private int[] villageVoterChange;
    private int[] reporterNotHereChange;
    
    public PromptAction(String message, int goldChange, int[] villageVoterChange, int[] reporterNotHereChange) {
        this.promptActionMessage = message;
        this.goldChange = goldChange;
        this.villageVoterChange = villageVoterChange;
        this.reporterNotHereChange = reporterNotHereChange;
    }

    // Getter and Setter for promptActionMessage
    public String getPromptActionMessage() {
        return promptActionMessage;
    }

    public void setPromptActionMessage(String promptActionMessage) {
        this.promptActionMessage = promptActionMessage;
    }

    // Getter and Setter for goldChange
    public int getGoldChange() {
        return goldChange;
    }

    public void setGoldChange(int goldChange) {
        this.goldChange = goldChange;
    }

    // Getter and Setter for villageVoterChange
    public int[] getVillageVoterChange() {
        return villageVoterChange;
    }

    public void setVillageVoterChange(int[] villageVoterChange) {
        this.villageVoterChange = villageVoterChange;
    }

    // Getter and Setter for reporterNotHereChange
    public int[] getReporterNotHereChange() {
        return reporterNotHereChange;
    }

    public void setReporterNotHereChange(int[] reporterNotHereChange) {
        this.reporterNotHereChange = reporterNotHereChange;
    }
}