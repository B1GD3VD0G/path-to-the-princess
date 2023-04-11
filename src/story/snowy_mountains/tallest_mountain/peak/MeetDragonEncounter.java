package story.snowy_mountains.tallest_mountain.peak;

import model.AbstractEncounter;

public final class MeetDragonEncounter extends AbstractEncounter {

    public MeetDragonEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("It takes all day, and all of your strength, but you finally make it to the top of the mountain.\n");
        sb.append("You are above the clouds. The view from up here is gorgeous!\n");
        sb.append("You see the Northern Keep down below, and suddenly it doesn't seem so far away.\n");
        sb.append("On top of the mountain, you see a shrine to the God of Time, Kyr.\n");
        sb.append("As you start to step toward the shrine, you hear a powerful gust of wind.\n");
        sb.append("Out of the clouds comes a giant dragon!\n");
        sb.append("He lands on the ground, between you and the shrine.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dragon: Greetings traveler.\n");
        sb.append("Dragon: It has been a long time since I've spoken with a human.\n");
        sb.append("Dragon: Tell me, what have you brought to me as an offering?\n");
        question = sb.toString();
    }

    @Override
    protected void setChoices() {
        addProgressButton("Give the dragon all of your gold.", new PayDragonEncounter());
        addProgressButton("Give the dragon the sapphire necklace.", new GiveDragonNecklaceEncounter());
    }
}
