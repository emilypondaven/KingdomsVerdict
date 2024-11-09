import javax.swing.*;

import logic.Player;
import logic.PromptAction;
import logic.Village;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceScreen {
    JPanel choiceScreenPanel, currentVotesPanel, villagePopulationPanel, promptPanel, buttonPanel, villageDescriptionPanel;
    JLabel promptLabel, currentVotesLabel, villagePopulationLabel, villageDescriptionLabel;
    JButton prompt1Button, prompt2Button, prompt3Button;

    public void createScreen(JFrame window, String prompt, PromptAction promptAction1, PromptAction promptAction2, PromptAction promptAction3, Player player, Village village) {
        window.setLayout(new BorderLayout());  // Set the overall layout to BorderLayout for easier positioning

        // Create a panel for the top section with current votes and village population
        JPanel topPanel = new JPanel(new GridLayout(3, 1));  // Use GridLayout to stack the votes and population vertically
        topPanel.setBackground(Color.WHITE);

        currentVotesPanel = createPanel(topPanel, 250, 200, 700, 50);  // Adjusted size for a smaller display
        currentVotesLabel = createLabel(currentVotesPanel, "Total votes: " + Player.getVoteCount(), Color.BLACK);

        villagePopulationPanel = createPanel(topPanel, 250, 200, 700, 50);  // Adjusted size for a smaller display
        villagePopulationLabel = createLabel(villagePopulationPanel, "Village population:L " + village.getPopulation(), Color.BLACK);

        villageDescriptionPanel = createPanel(topPanel, 250, 200, 700, 50);  // Adjusted size for a smaller display
        villageDescriptionLabel = createLabel(villagePopulationPanel, "Village description: " + village.getDescription(), Color.BLACK);

        window.add(topPanel, BorderLayout.NORTH);

        // Create a panel for the center section (prompt)
        promptPanel = new JPanel();
        promptLabel = createLabel(promptPanel, prompt, Color.BLACK);
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 24));  // Make the prompt text larger
        promptPanel.setBackground(Color.WHITE);
        window.add(promptPanel, BorderLayout.CENTER);

        // Create a panel for the bottom section (buttons)
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));  // Use FlowLayout to center the buttons horizontally
        buttonPanel.setBackground(Color.WHITE);

        prompt1Button = createButton(buttonPanel, player, promptAction1, Color.GREEN, Color.WHITE);
        prompt2Button = createButton(buttonPanel, player, promptAction2, Color.GREEN, Color.WHITE);
        prompt3Button = createButton(buttonPanel, player, promptAction3, Color.GREEN, Color.WHITE);

        window.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createPanel(JPanel parentPanel, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);  // You can adjust these values as needed
        parentPanel.add(panel);
        return panel;
    }

    private JLabel createLabel(JPanel panel, String text, Color textColor) {
        JLabel label = new JLabel(text);
        label.setForeground(textColor);
        panel.add(label);
        return label;
    }

    private JButton createButton(JPanel panel, Player player, PromptAction prompt, Color backgroundColor, Color textColor) {
        JButton button = new JButton(prompt.getPostActionMessage());
        button.setBackground(backgroundColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        // Add the action listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when the button is clicked
                player.gameTurn(prompt);
            }
        });
        
        panel.add(button);
        return button;
    }
}
