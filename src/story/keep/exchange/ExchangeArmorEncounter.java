package story.keep.exchange;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.KeepSplitPathEncounter;

public final class ExchangeArmorEncounter extends AbstractEncounter {

    public ExchangeArmorEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        story = "";
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to trade your armor?";
    }

    @Override
    protected void setChoices() {
        String armor = inventory.getArmor();
        if (!inventory.contains(Inventory.LEATHER_ARMOR)) {
            addTradeArmorButton("Trade your armor for the leather armor.", new KeepSplitPathEncounter(), Inventory.LEATHER_ARMOR);
        }
        if (!inventory.contains(Inventory.SHROUDED_ROBES)) {
            addTradeArmorButton("Trade your armor for the shrouded robes.", new KeepSplitPathEncounter(), Inventory.SHROUDED_ROBES);
        }
        if (!inventory.contains(Inventory.METAL_ARMOR)) {
            addTradeArmorButton("Trade your armor for the metal armor.", new KeepSplitPathEncounter(), Inventory.METAL_ARMOR);
        }
        addProgressButton("Keep the " + armor + ".", new KeepSplitPathEncounter());
    }
}
