package story.river.on_foot.trolls;

import model.AbstractEncounter;

public final class PayTrollsEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("You give the troll your gold.\n");
        sb.append("The trolls allow you to cross the bridge.\n");
        sb.append("When you get to the other side, a gate comes down in front of you.\n");
        sb.append("As you go to turn around, another gate closes you in.\n");
        sb.append("You turn right; another gate comes down.\n");
        sb.append("You go left, and another. You are trapped.\n");
        sb.append("You hear the trolls laughing in the distance.\n");
        sb.append("You've been tricked by the trolls! You are stuck with no way out.\n");
        sb.append("You sit in the enclosure and slowly starve to death.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = GAME_OVER;
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
