package story.snowy_mountains.valley;

import model.AbstractEncounter;

public final class ValleyGiantEncounter extends AbstractEncounter {

    public ValleyGiantEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You are grateful that you will be traveling downhill today.\n");
        sb.append("You start heading toward the valley, keeping a swift pace.\n");
        sb.append("You walk for a couple hours until you find yourself at the edge of a small cliff.\n");
        sb.append("You are pondering your options when the ground starts falling underneath you.\n");
        sb.append("You fall down to the ground, but the fresh snow protected you from taking damage.\n");
        sb.append("You look around you, and see that the landslide has caught the attention of a Frost Giant!\n");
        sb.append("The Frost Giant takes one look at you and starts licking his lips.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "What will you do?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Fight the giant!", new GiantFightEncounter());
        addProgressButton("Run away!", new GiantFleeEncounter());

    }
}
