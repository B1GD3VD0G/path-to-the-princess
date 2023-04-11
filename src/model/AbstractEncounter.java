package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;

/**
 * This is the parent class of all Encounters in the game.
 * An Encounter consists of a story, question, and choices.
 * An Encounter is dependent upon the inventory of the player upon arriving at this Encounter.
 */
public abstract class AbstractEncounter implements Encounter {

    /**
     * The inventory of the player when they enter the Encounter.
     * The inventory is important in making sure the proper choices are presented.
     * Inventory is passed in as a parameter during construction.
     */
    protected Inventory inventory;

    /**
     * The multi-line story which describes to the player where they are in the game.
     * The story's text can be affected by the inventory of the player upon entering this Encounter.
     */
    protected String story;

    /**
     * The question asking the player which choice they would like to make.
     */
    protected String question;

    /**
     * The choices that the player has in order to progress to the next Encounter.
     * The choices may be affected by the inventory of the player upon entering this Encounter.
     */
    protected SLL<JButton> choices;

    /**
     * When the buttons are pressed, this sends a message with information to the GUI.
     */
    protected PropertyChangeSupport pcs;

    protected boolean hasDied;

    protected boolean isLoaded;

    public AbstractEncounter() {
        this.inventory = new Inventory();
        this.story = "";
        this.question = "";
        this.choices = new SLL<>();
        this.pcs = new PropertyChangeSupport(this);
        hasDied = false;
        isLoaded = false;
    }

    /**
     * If an inventory is initiated without an inventory, this will update the fields to reflect the inventory.
     * @param inv The Inventory to be loaded into the Encounter.
     */
    public void loadInventory(Inventory inv) {
        if (!isLoaded) {
            this.inventory = inv;
            setStory();
            setQuestion();
            setChoices();
            isLoaded = true;
        }
        else {
            throw new IllegalArgumentException("This Encounter has already been loaded with an Inventory!");
        }
    }

    @Override
    public final String getStory() {
        return this.story;
    }

    @Override
    public final String getQuestion() {
        return this.question;
    }

    @Override
    public final SLL<JButton> getChoices() {
        return this.choices;
    }

    @Override
    public final void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    /**
     * This method will add a new button in choices which leads the player to a new Encounter.
     * @param buttonText The text to be displayed on the button, explaining the choice to the player.
     * @param nextEncounter The next Encounter to be displayed.
     */
    protected final void addProgressButton(String buttonText, Encounter nextEncounter) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(inventory);
                pcs.firePropertyChange(PROGRESS, inventory, nextEncounter);
            }
        });
        choices.addRear(button);
    }

    protected final void addDisabledProgressButton(String buttonText, Encounter nextEncounter) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(inventory);
                pcs.firePropertyChange(PROGRESS, inventory, nextEncounter);
            }
        });
        choices.addRear(button);
        button.setEnabled(false);
    }

    /**
     * This method is called when an item is purchased for gold and added to the player's Inventory.
     * @param buttonText The text to be displayed on the button, explaining the choice.
     * @param nextEncounter The next Encounter to be displayed.
     * @param item The item to be added to the Inventory.
     * @param cost The cost of the new item.
     */
    protected final void addBuyButton(String buttonText, Encounter nextEncounter, String item, int cost) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.collect(item);
                inventory.pay(cost);
                System.out.println(inventory);
                pcs.firePropertyChange(PROGRESS, inventory, nextEncounter);
            }
        });
        choices.addRear(button);
    }

    protected final void addTradeArmorButton(String buttonText, Encounter nextEncounter, String armor) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inventory.contains(Inventory.LEATHER_ARMOR)) {
                    inventory.drop(Inventory.LEATHER_ARMOR);
                }
                else if (inventory.contains(Inventory.SHROUDED_ROBES)) {
                    inventory.drop(Inventory.SHROUDED_ROBES);
                }
                else if (inventory.contains(Inventory.METAL_ARMOR)) {
                    inventory.drop(Inventory.METAL_ARMOR);
                }
                else if (inventory.contains(Inventory.WARM_COAT)) {
                    inventory.drop(Inventory.WARM_COAT);
                }
                inventory.collect(armor);
                System.out.println(inventory);
                pcs.firePropertyChange(PROGRESS, inventory, nextEncounter);
            }
        });
        choices.addRear(button);
    }

    protected final void addTradeWeaponButton(String buttonText, Encounter nextEncounter, String weapon) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inventory.contains(Inventory.BOW_AND_ARROWS)) {
                    inventory.drop(Inventory.BOW_AND_ARROWS);
                }
                else if (inventory.contains(Inventory.BATTLEAXE)) {
                    inventory.drop(Inventory.BATTLEAXE);
                }
                else if (inventory.contains(Inventory.SWORD_AND_SHIELD)) {
                    inventory.drop(Inventory.SWORD_AND_SHIELD);
                }
                inventory.collect(weapon);
                System.out.println(inventory);
                pcs.firePropertyChange(PROGRESS, inventory, nextEncounter);
            }
        });
        choices.addRear(button);
    }

    protected final void addPayButton(String buttonText, Encounter nextEncounter, int goldPieces) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.pay(goldPieces);
                System.out.println(inventory);
                pcs.firePropertyChange(PROGRESS, inventory, nextEncounter);
            }
        });
        choices.addRear(button);
    }

    /**
     * This method will add the quit and restart buttons to the choices of the Encounter.
     */
    protected final void addGameOverButtons() {
        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pcs.firePropertyChange(RESTART, null, null);
            }
        });
        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pcs.firePropertyChange(QUIT, null, null);
            }
        });
        choices.addRear(restart);
        choices.addRear(quit);
    }

    /**
     * This method is called by the constructor in order to set the story for the encounter.
     */
    protected abstract void setStory();

    /**
     * This method is called by the constructor in order to set the question.
     */
    protected abstract void setQuestion();

    /**
     * This method is called by the constructor in order to set the choices.
     */
    protected abstract void setChoices();
}
