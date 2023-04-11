package story.snowy_mountains.inn.chat;

import model.AbstractInncounter;

public final class NorthernKeepChatInncounter extends AbstractInncounter {

    public NorthernKeepChatInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Barkeep: You've chosen an odd path if you're headed to the Northern Keep.\n");
        sb.append("Barkeep: Although I reckon it'll be a two or three day journey, if you know what you're doing.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Barkeep: Say, what brings you seeking out a castle full of bandits anyway?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Tell the truth.", new BarkeepGiftInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        addProgressButton("\"None of your business!\"", new OffendBarkeepInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
    }
}
