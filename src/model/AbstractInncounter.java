package model;

/**
 * An Inncounter is an Encounter that takes place in the inn!
 * Why? Because there are 4 fields that only matter inside the inn.
 */
public abstract class AbstractInncounter extends AbstractEncounter {

    /** This is true if the player is drunk. The player can only get drunk by ordering TWO mugs of mead. */
    protected boolean isDrunk;

    /** This is true if the barkeep has invited the player to share their room. Can be revoked if barkeepIsOffended. */
    protected boolean barkeepIsSeduced;

    /** This is true if the barkeep has been offended. After offending the barkeep it cannot be undone, and it will
     * no longer be possible to seduce the barkeep.*/
    protected boolean barkeepIsOffended;

    /** Standard room cost is 50 gold. Raised to 75 if barkeep is offended, and if barkeep was seduced before being
     * offended, raised to 100. */
    protected int roomCost;

    /**
     * This constructor is used to create a new Inncounter. The parameters are initialized by the
     * SnowyIntroductionEncounter all as false, and later the parameters are passed to later Inncounters
     * until you leave the inn.
     * @param isDrunk if the player is drunk.
     * @param barkeepIsSeduced if the player has seduced the barkeep.
     * @param barkeepIsOffended if the player has offended the barkeep.
     * @param roomCost the price to buy a room for the night, if the barkeep has not been seduced.
     */
    public AbstractInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super();
        this.isDrunk = isDrunk;
        this.barkeepIsSeduced = barkeepIsSeduced;
        this.barkeepIsOffended = barkeepIsOffended;
        this.roomCost = roomCost;
    }
}
