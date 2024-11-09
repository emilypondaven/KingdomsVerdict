package gui;

import javax.swing.*;

import logic.Player;
import logic.Prompt;
import logic.PromptAction;
import logic.Village;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceScreen extends JPanel {
    JPanel topPanel,choiceScreenPanel, currentVotesPanel, villagePopulationPanel, promptPanel, buttonPanel, villageDescriptionPanel;
    JLabel promptLabel, currentVotesLabel, villagePopulationLabel, villageDescriptionLabel;
    JButton prompt1Button, prompt2Button, prompt3Button;

    public void createScreen(JDialog window, Prompt prompt, Player player, Village village) {

        // Create a panel for the top section with current votes and village population
        topPanel = new JPanel(new GridLayout(3, 1));  // Use GridLayout to stack the votes and population vertically
        topPanel.setBackground(Color.WHITE);

        currentVotesPanel = createPanel(topPanel, 250, 200, 700, 50);  // Adjusted size for a smaller display
        currentVotesLabel = createLabel(currentVotesPanel, "Total votes: " + Player.getVoteCount(), Color.BLACK);

        villagePopulationPanel = createPanel(topPanel, 250, 200, 700, 50);  // Adjusted size for a smaller display
        villagePopulationLabel = createLabel(villagePopulationPanel, "Village population:L " + village.getPopulation(), Color.BLACK);

        villageDescriptionPanel = createPanel(topPanel, 250, 200, 700, 50);  // Adjusted size for a smaller display
        villageDescriptionLabel = createLabel(villagePopulationPanel, "Village description: " + village.getDescription(), Color.BLACK);

        // Create a panel for the center section (prompt)
        promptPanel = new JPanel();
        promptLabel = createLabel(promptPanel, prompt.getPromptMessage(), Color.BLACK);
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 24));  // Make the prompt text larger
        promptPanel.setBackground(Color.WHITE);
        window.getContentPane().add(promptPanel, BorderLayout.CENTER);

        // Create a panel for the bottom section (buttons)
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical alignment of buttons
        // buttonPanel.setLayout(new FlowLayout(1000, 20, FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        // Add spacing between buttons with rigid area
        int buttonSpacing = 10;
        Color greenColor = new Color(125, 181, 81);
        // Add the buttons with spacing in between
        prompt1Button = createButton(window, buttonPanel, player, prompt.getPromptAction(0), greenColor, Color.WHITE);
        buttonPanel.add(prompt1Button);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonSpacing))); // Add vertical spacing
        prompt2Button = createButton(window, buttonPanel, player, prompt.getPromptAction(1), greenColor, Color.WHITE);
        buttonPanel.add(prompt2Button);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, buttonSpacing))); // Add vertical spacing
        prompt3Button = createButton(window, buttonPanel, player, prompt.getPromptAction(2), greenColor, Color.WHITE);
        buttonPanel.add(prompt3Button);

        window.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        window.getContentPane().add(topPanel, BorderLayout.NORTH);
        // window.pack();
        window.setVisible(true);
        window.revalidate();
        window.repaint();
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

    private JButton createButton(JDialog window, JPanel panel, Player player, PromptAction prompt, Color backgroundColor, Color textColor) {
        JButton button = new JButton(prompt.getPromptActionMessage());
        button.setBackground(backgroundColor);
        button.setForeground(textColor);

        button.setFocusPainted(false);
        // Add the action listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to be performed when the button is clicked
                player.gameTurn(prompt);
                window.dispose();
            }
        });
        
        panel.add(button);
        return button;
    }
}
