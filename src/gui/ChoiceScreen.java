package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.Player;
import logic.Prompt;
import logic.PromptAction;
import logic.Village;

public class ChoiceScreen extends JPanel {
    static JPanel topPanel, currentVotesPanel, villagePopulationPanel, promptPanel, buttonPanel, villageDescriptionPanel;
    static JLabel promptLabel, currentVotesLabel, villagePopulationLabel;
    static JTextArea villageDescriptionLabel;  // Change to JTextArea for multiline text
    static JButton prompt1Button, prompt2Button, prompt3Button;

    public static void createScreen(JDialog window, Prompt prompt, Player player, Village village) {

        // Create the main content panel (use BoxLayout to vertically arrange components)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // Use BorderLayout for flexible layout

        // Create a panel for the top section with current votes and village population
        topPanel = new JPanel(new GridLayout(3, 1));  // Use GridLayout to stack the votes and population vertically
        topPanel.setBackground(Color.WHITE);

        // Current Votes
        currentVotesPanel = createPanel(topPanel);
        currentVotesLabel = createLabel(currentVotesPanel, "Total votes: " + Player.getVoteCount(), Color.BLACK);

        // Village Population
        villagePopulationPanel = createPanel(topPanel);
        villagePopulationLabel = createLabel(villagePopulationPanel, "Village population: " + village.getPopulation(), Color.BLACK);

        // Village Description
        villageDescriptionPanel = createPanel(topPanel);
        villageDescriptionLabel = createMultilineLabel(village.getDescription()); // Set the description text as multiline
        villageDescriptionPanel.add(new JScrollPane(villageDescriptionLabel)); // Add JTextArea in JScrollPane for scrolling

        // Add topPanel to the main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Create a panel for the center section (prompt)
        promptPanel = new JPanel();
        promptLabel = createLabel(promptPanel, prompt.getPromptMessage(), Color.BLACK);
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 24));  // Make the prompt text larger
        promptPanel.setBackground(Color.WHITE);
        mainPanel.add(promptPanel, BorderLayout.CENTER);

        // Create a panel for the bottom section (buttons)
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical alignment of buttons
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

        // Add buttonPanel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the content pane for the dialog and show it
        window.setContentPane(mainPanel);  // Replace previous content with the new content
        // window.setLocationRelativeTo(null);  // Optional: Center the window on the screen
        window.setVisible(true);
    }

    private static JPanel createPanel(JPanel parentPanel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        parentPanel.add(panel);
        return panel;
    }

    private static JLabel createLabel(JPanel panel, String text, Color textColor) {
        JLabel label = new JLabel(text);
        label.setForeground(textColor);
        panel.add(label);
        return label;
    }

    private static JTextArea createMultilineLabel(String text) {
        JTextArea textArea = new JTextArea(text); // Create a JTextArea with the provided description text
        textArea.setSize(new Dimension(800,200));
        textArea.setEditable(false);  // Make the text area non-editable
        textArea.setLineWrap(true);   // Enable line wrapping for long text
        textArea.setWrapStyleWord(true); // Ensure it wraps at word boundaries
        textArea.setBackground(Color.WHITE); // Set background color for text area
        textArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Optional: Set font and size
        textArea.setMargin(new Insets(5, 5, 5, 5)); // Add padding inside the text area
        return textArea;
    }

    private static JButton createButton(JDialog window, JPanel panel, Player player, PromptAction prompt, Color backgroundColor, Color textColor) {
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
                window.dispose();  // Close the dialog after action is performed
            }
        });
        
        panel.add(button);
        return button;
    }
}

/* package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logic.Player;
import logic.Prompt;
import logic.PromptAction;
import logic.Village;

public class ChoiceScreen extends JPanel {
    static JPanel topPanel, currentVotesPanel, villagePopulationPanel, promptPanel, buttonPanel, villageDescriptionPanel;
    static JLabel promptLabel, currentVotesLabel, villagePopulationLabel, villageDescriptionLabel;
    static JButton prompt1Button, prompt2Button, prompt3Button;

    public static void createScreen(JDialog window, Prompt prompt, Player player, Village village) {

        // Create the main content panel (use BoxLayout to vertically arrange components)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // Use BorderLayout for flexible layout

        // Create a panel for the top section with current votes and village population
        topPanel = new JPanel(new GridLayout(3, 1));  // Use GridLayout to stack the votes and population vertically
        topPanel.setBackground(Color.WHITE);

        // Current Votes
        currentVotesPanel = createPanel(topPanel);
        currentVotesLabel = createLabel(currentVotesPanel, "Total votes: " + Player.getVoteCount(), Color.BLACK);

        // Village Population
        villagePopulationPanel = createPanel(topPanel);
        villagePopulationLabel = createLabel(villagePopulationPanel, "Village population: " + village.getPopulation(), Color.BLACK);

        // Village Description
        villageDescriptionPanel = createPanel(topPanel);
        villageDescriptionLabel = createLabel(villageDescriptionPanel, "Village description: " + village.getDescription(), Color.BLACK);

        // Add topPanel to the main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Create a panel for the center section (prompt)
        promptPanel = new JPanel();
        promptLabel = createLabel(promptPanel, prompt.getPromptMessage(), Color.BLACK);
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 24));  // Make the prompt text larger
        promptPanel.setBackground(Color.WHITE);
        mainPanel.add(promptPanel, BorderLayout.CENTER);

        // Create a panel for the bottom section (buttons)
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical alignment of buttons
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

        // Add buttonPanel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the content pane for the dialog and show it
        window.setContentPane(mainPanel);  // Replace previous content with the new content
        window.setSize(800, 600);  // Optional: Set a fixed size for the dialog
        window.setLocationRelativeTo(null);  // Optional: Center the window on the screen
        window.setVisible(true);
    }

    private static JPanel createPanel(JPanel parentPanel) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        parentPanel.add(panel);
        return panel;
    }

    private static JLabel createLabel(JPanel panel, String text, Color textColor) {
        JLabel label = new JLabel(text);
        label.setForeground(textColor);
        panel.add(label);
        return label;
    }

    private static JButton createButton(JDialog window, JPanel panel, Player player, PromptAction prompt, Color backgroundColor, Color textColor) {
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
                window.dispose();  // Close the dialog after action is performed
            }
        });
        
        panel.add(button);
        return button;
    }
} */