package view;

import model.Encounter;


import javax.swing.*;
import java.awt.*;

final public class StoryPanel extends JPanel  {

    /**
     * This is the block of text which tells the story.
     */
    private JTextArea storyBlock;

    /**
     * This is the block of text which asks the player a question.
     */
    private JTextArea questionBlock;

    /**
     * This is the block containing all the choice buttons the player has.
     */
    private JPanel choicesBlock;

    private Encounter encounter;

    private JPanel inventoryBlock;

    /**
     * This constructor creates a new StoryPanel from a given Encounter.
     * @param enc The Encounter to be loaded into the new panel.
     */
    public StoryPanel(Encounter enc) {
        storyBlock = new JTextArea(enc.getStory());
        questionBlock = new JTextArea(enc.getQuestion());
        choicesBlock = new JPanel();
        encounter = enc;
        inventoryBlock = new JPanel();
        setUpChoices(enc);
        setUp();
    }

    private void setUpChoices(Encounter enc) {
        for (int i = 0; i < enc.getChoices().getCount(); i++) {
            choicesBlock.add(enc.getChoices().get(i));
        }
    }

    /**
     * This method is called by the constructor in order to further customize the look and feel of the StoryPanel.
     */
    private void setUp() {
        this.setBackground(Color.BLACK);
        // The blocks are stacked one atop the other in the StoryPanel.
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Don't make the printed text editable.
        storyBlock.setEditable(false);
        questionBlock.setEditable(false);
        // Make text how I want it.
        storyBlock.setFont(new Font("Courier New", Font.PLAIN, 20));
        storyBlock.setBackground(Color.BLACK);
        storyBlock.setForeground(Color.GREEN);
        storyBlock.setMargin(new Insets(10, 10, 10, 10));

        questionBlock.setFont(new Font("Courier New", Font.PLAIN, 20));
        questionBlock.setBackground(Color.BLACK);
        questionBlock.setForeground(Color.WHITE);
        questionBlock.setMargin(new Insets(10, 10, 10, 10));

        choicesBlock.setLayout(new GridLayout(encounter.getChoices().getCount(), 1));
        for (int i = 0; i < encounter.getChoices().getCount(); i++) {
            JButton button = encounter.getChoices().get(i);
            button.setFont(new Font("Courier New", Font.PLAIN, 20));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.GREEN);
        }
        setUpInventoryButton();
        //Add each block to the proper spot on the panel.
        add(inventoryBlock);
        add(storyBlock);
        add(questionBlock);
        add(choicesBlock);
    }

    public void setUpInventoryButton() {

    }
}
