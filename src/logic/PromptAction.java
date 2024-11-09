package logic;
import javax.swing.SwingUtilities;
import gui.Window;

public class PromptAction {
    private String promptActionMessage;
    private int goldChange;
    private int[] villageVoterChange;
    private int[] reporterNotReportingChange;
    private int[] villagerPopulationChange;
    private String[] postActionMessages; //1st item is if the reporter is reporting, 2nd item is the message if it isn't
    
    public PromptAction(String message, int goldChange, int[] villageVoterChange, int[] reporterNotHereChange, int[] villagerPopulationChange, String[] postActionMessages) {
        this.promptActionMessage = message;
        this.goldChange = goldChange;
        this.villageVoterChange = villageVoterChange;
        this.reporterNotReportingChange = reporterNotHereChange;
        this.villagerPopulationChange = villagerPopulationChange;
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
    public int[] getreporterNotReportingChange() {
        return reporterNotReportingChange;
    }

    public void setreporterNotReportingChange(int[] reporterNotHereChange) {
        this.reporterNotReportingChange = reporterNotHereChange;
    }

    public String getPostActionMessage() {
        if (Player.isReporterReporting()) {
            return postActionMessages[0];
        } else {
            return postActionMessages[1];
        }
    } 
}