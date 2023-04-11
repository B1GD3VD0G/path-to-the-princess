package story.keep.halls.upstairs;

import model.AbstractEncounter;

public final class UpstairsLeftRightEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You go to the left.\n");
        sb.append("After about five paces, you reach the stair case.\n");
        sb.append("You walk up the stairs. At the top there is a hallway.\n");
        sb.append("You assume somewhere up here is where they are holding the princess.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which way would you like to go?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Go right.", new UpstairsChiefDoorEncounter());
        addProgressButton("Go left.", new UpstairsWrongDoorEncounter());
    }
}
