package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The Encounter interface defines methods which should be shared by all Encounters.
 */
public interface Encounter {

    /** This String is used as a name for PropertyChangeEvents when a player is to move on to a new Encounter. */
    String PROGRESS = "progress";

    /** This String is used as a name for PropertyChangeEvents when a player chooses to end the program. */
    String QUIT = "quit";

    /** This String is used as a name for PropertyChangeEvents when a player chooses to restart the game. */
    String RESTART = "restart";

    /** This String is used as the question when the player has died. */
    String GAME_OVER = "Game over.";

    /**
     * This method returns the story, to be printed on the text box of the StoryPanel.
     * @return story
     */
    String getStory();

    /**
     * This method returns the question, to be printed on the text box of the QuestionPanel.
     * @return question
     */
    String getQuestion();

    /**
     * This method returns the list of choices which the player has to choose from.
     * @return choices
     */
    SLL<JButton> getChoices();

    /**
     * This method adds a new listener to hear PropertyChangeEvents fired to the GUI by pressing buttons.
     * It is called by the GUI during construction passing itself in as a parameter.
     * @param pce The Component listening (Should always be the GUI).
     */
    void addPropertyChangeListener(PropertyChangeListener pce);

    void loadInventory(Inventory inv);
}
