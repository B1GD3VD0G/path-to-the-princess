package model;

import java.util.HashSet;

/**
 * This class carries the inventory of the player throughout the game.
 * This class is critical because the results of certain choices, as well as the availability of choices to begin with,
 * depend on the Inventory.
 */
public class Inventory {

    public static final String BOW_AND_ARROWS = "Bow and Arrows";
    public static final String BATTLEAXE = "Battleaxe";
    public static final String SWORD_AND_SHIELD = "Sword and Shield";
    public static final String METAL_ARMOR = "Metal Armor";
    public static final String LEATHER_ARMOR = "Leather Armor";
    public static final String SHROUDED_ROBES = "Shrouded Robes";
    public static final String ROPE = "Rope";
    public static final String STEAK = "Steak";
    public static final String DOG = "Dog Companion";
    public static final String WARM_COAT = "Warm Coat";
    public static final String BREAD_LOAF = "Bread Loaf";
    public static final String FRUIT_PIE = "Fruit Pie";
    public static final String SALMON_DINNER = "Salmon Dinner";
    public static final String SNOWSHOES = "Snowshoes";
    public static final String NECKLACE = "Silver Sapphire Necklace";
    public static final String STAFF = "Staff of Freeze Time";
    public static final String WIZARD = "Wizard Companion";
    public static final String EXCALIBUR = "Excalibur";
    public static final String FISHING_ROD = "Fishing Rod";
    public static final String RAW_FISH = "Raw Fish";
    public static final String COOKED_FISH = "Cooked Fish";

    /** A set of Strings representing an item available in the game. */
    HashSet<String> inventory;

    /** The number of gold pieces that the player is currently carrying. */
    int gold;

    /**
     * This initializes the Inventory of the player.
     * Sir Longwood awakens with 1200 gold pieces, but has been robbed of everything else.
     */
    public Inventory() {
        this.inventory = new HashSet<>();
        gold = 1200;
    }

    /**
     * This method will add a new item to the inventory.
     * @param item A string representation of the name of the item.
     */
    public void collect(String item) {
        this.inventory.add(item);
    }

    /**
     * This method will remove an item from the Inventory.
     * @param item The name of the item to be removed from the Inventory.
     */
    public void drop(String item) {
        this.inventory.remove(item);
    }

    public void pay(int goldPieces) {
        this.gold -= goldPieces;
        if (this.gold < 0) {
            throw new IllegalArgumentException("You cannot pay more gold than you have!");
        }
    }

    public int getGold() {
        return gold;
    }

    public void collect(int goldPieces) {
        this.gold += goldPieces;
    }

    /**
     * This method tells the user if the Inventory contains a certain item.
     * @param item The name of the item being searched for.
     * @return true if the String is present, else false.
     */
    public boolean contains(String item) {
        return (inventory.contains(item));
    }

    @Override
    public String toString() {
        return inventory.toString() + " gold: " + gold;
    }

    public String getWeapon() {
        if (contains(BOW_AND_ARROWS)) {
            return BOW_AND_ARROWS;
        }
        else if (contains(BATTLEAXE)) {
            return BATTLEAXE;
        }
        else {
            return SWORD_AND_SHIELD;
        }
    }

    public String getArmor() {
        if (contains(LEATHER_ARMOR)) {
            return LEATHER_ARMOR;
        }
        else if (contains(SHROUDED_ROBES)) {
            return SHROUDED_ROBES;
        }
        else if (contains(METAL_ARMOR)) {
            return METAL_ARMOR;
        }
        else {
            return WARM_COAT;
        }
    }
}
