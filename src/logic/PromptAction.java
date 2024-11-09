package logic;
import javax.swing.SwingUtilities;
import gui.Window;

public class PromptAction {
    private String promptActionMessage;
    private int goldChange;
    private int[] villageVoterChange;
    private int[] reporterReportingChange;
    private String[] postActionMessages; //1st item is if the reporter is reporting, 2nd item is the message if it isn't
    
    public PromptAction(String message, int goldChange, int[] villageVoterChange, int[] reporterNotHereChange, String[] postActionMessages) {
        this.promptActionMessage = message;
        this.goldChange = goldChange;
        this.villageVoterChange = villageVoterChange;
        this.reporterReportingChange = reporterNotHereChange;
        this.postActionMessages = postActionMessages;
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