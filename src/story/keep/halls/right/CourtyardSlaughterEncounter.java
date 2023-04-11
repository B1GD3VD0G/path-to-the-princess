package story.keep.halls.right;

import model.AbstractEncounter;

public final class CourtyardSlaughterEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You have made it past those bandits and continue walking along the hall.\n");
        sb.append("When you reach the end of the hall, there is a door.\n");
        sb.append("There is no place else to go, and you don't want to risk seeing another group of " +
                "bandits, so you enter the door instead of turning around.\n");
        sb.append("The door takes you into the courtyard of the castle.\n");
        sb.append("A whole bunch of bandits are out in their armor, practicing their battle skills.\n");
        sb.append("They see you walk out. Now is a perfect time for them to have some real practice!\n");
        sb.append("Several bandits charge at you. You die almost instantly.\n");
        sb.append("You were so close!\n");
        hasDied = true;
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
