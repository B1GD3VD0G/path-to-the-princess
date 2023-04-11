package view;

import model.Inventory;
import model.Encounter;
import story.introduction.kingdom.InstructionEncounter;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class GUI implements PropertyChangeListener {

    final private JFrame frame;

    final private StoryPanel panel;

    final private Encounter encounter;

    public GUI() {
        frame = new JFrame("\"Path to the Princess\" by The Booligans");
        encounter = new InstructionEncounter();
        encounter.loadInventory(new Inventory());
        encounter.addPropertyChangeListener(this);
        panel = new StoryPanel(encounter);
        start();
    }

    public GUI(Encounter enc) {
        frame = new JFrame("\"Path to the Princess\" by The Booligans");
        encounter = enc;
        encounter.addPropertyChangeListener(this);
        panel = new StoryPanel(encounter);
        start();
    }

    private void start() {
        //Program terminates when the X button is clicked.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Try setting the look and feel of the frame.
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final ClassNotFoundException | InstantiationException | IllegalAccessException
                       | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        final double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        final double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        final Dimension frameSize = new Dimension( (int) screenWidth * 2 / 3,
                (int) screenHeight * 2 / 3);
        frame.setSize(frameSize);
        frame.setLocationRelativeTo(null);
        //panel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * This is what the GUI is programmed to do when it hears an event from a button.
     * If the property name is PROGRESS, it will create a new GUI with a new Encounter (pce.newValue).
     * If the property name is QUIT, it will call System.exit().
     * If the property name is RESTART, it will create a new GUI with a new InstructionEncounter(new Inventory())
     * @param pce A PropertyChangeEvent describing the event source and the property that has changed.
     * @throws IllegalArgumentException if name or new value of pce are unexpected.
     */
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce.getPropertyName().equals(Encounter.PROGRESS)) {
            // This means we need to proceed to a new Encounter.
            // In a PROGRESS event, getNewValue() should be an Encounter, and getOldValue should be an inventory.
            // I need to load the inventory into the encounter, then start up a new GUI with the new Encounter.
            // NOTE: If I were to preload the inventory into the encounter, the whole rest of the game would be loaded
            // every time a button is pressed.

            // Throw an exception if new value isn't an Encounter.
            if (pce.getNewValue() instanceof Encounter) {
                // Save it to load and use later.
                Encounter newEnc = (Encounter) pce.getNewValue();

                // Throw an exception if old value isn't an Inventory.
                if (pce.getOldValue() instanceof Inventory) {
                    // Load new inventory into newEnc.
                    newEnc.loadInventory((Inventory) pce.getOldValue());
                    // Initialize the new GUI.
                    GUI newGUI = new GUI(newEnc);
                    // Get rid of this GUI (but don't end the program!)
                    frame.dispose();
                    // Show the new GUI.
                    newGUI.start();
                }
                else {
                    throw new IllegalArgumentException("PROGRESS event has an invalid old value! (Should be Inventory)");
                }
            }
            else {
                throw new IllegalArgumentException("PROGRESS event has an invalid new value! (Should be Encounter)");
            }
        }
        else if (pce.getPropertyName().equals(Encounter.RESTART)) {
            // This means we need to start the game over. Load new GUI with new InstructionEncounter(new Inventory()).
            GUI newGUI = new GUI();
            frame.dispose();
            newGUI.start();
        }
        else if (pce.getPropertyName().equals(Encounter.QUIT)) {
            // This means we're going to stop the program.
            frame.dispose();
            System.exit(0);
        }
        else {
            throw new IllegalArgumentException("Unexpected name for PropertyChangeEvent!");
        }
    }
}
