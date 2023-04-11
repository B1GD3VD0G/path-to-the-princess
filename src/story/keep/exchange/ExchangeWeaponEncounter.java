package story.keep.exchange;

import model.AbstractEncounter;
import model.Inventory;


public final class ExchangeWeaponEncounter extends AbstractEncounter {

    public ExchangeWeaponEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        story = "";
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to exchange your weapon?";
    }

    @Override
    protected void setChoices() {
        String weapon = inventory.getWeapon();
        if (!inventory.contains(Inventory.BOW_AND_ARROWS)) {
            addTradeWeaponButton("Trade your weapon for the bow and arrows.", new ExchangeArmorEncounter(), Inventory.BOW_AND_ARROWS);
        }
        if (!inventory.contains(Inventory.BATTLEAXE)) {
            addTradeWeaponButton("Trade your weapon for the battleaxe.", new ExchangeArmorEncounter(), Inventory.BATTLEAXE);
        }
        if (!inventory.contains(Inventory.SWORD_AND_SHIELD)) {
            addTradeWeaponButton("Trade your weapon for the sword and shield.", new ExchangeArmorEncounter(), Inventory.SWORD_AND_SHIELD);
        }
        addProgressButton("Keep the " + weapon + ".", new ExchangeArmorEncounter());
    }
}