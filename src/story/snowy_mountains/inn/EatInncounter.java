package story.snowy_mountains.inn;

import model.AbstractInncounter;
import model.Inventory;

public final class EatInncounter extends AbstractInncounter {

    public EatInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("The moment you open the doors to the inn you feel warm and safe.\n");
        sb.append("You step up to the bar.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Barkeep: Why, I haven't seen anyone new in these parts for ages!\n");
        sb.append("Barkeep: You look hungry.\n");
        question = sb.toString();
    }

    @Override
    protected void setChoices() {
        addBuyButton("Order bread loaf for 15 gold.", new DrinkInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost), Inventory.BREAD_LOAF, 15);
        addBuyButton("Order fruit pie for 20 gold.", new DrinkInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost), Inventory.FRUIT_PIE, 20);
        addBuyButton("Order salmon dinner for 50 gold.", new DrinkInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost), Inventory.SALMON_DINNER, 50);
    }
}
