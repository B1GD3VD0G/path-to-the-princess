package story.river.on_foot.cave;

import model.AbstractEncounter;
import story.river.on_foot.trolls.RiverTrollsEncounter;

public final class GhostLieEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("Ghost: You are a peasant man you say?\n");
        sb.append("Ghost: I was a peasant man too once, just trying to save up to build a home.\n");
        sb.append("Ghost: I stayed here while I was trying to save up.\n");
        sb.append("Ghost: But a knight came one night and killed me in my sleep!\n");
        sb.append("Ghost: All I had was what is in this chest.\n");
        sb.append("Ghost: So my spirit has stayed here for a hundred years.\n");
        sb.append("Ghost: Nobody has come into this cave since then.\n");
        sb.append("Ghost: I am feeling generous and want to help you out.\n");
        sb.append("Ghost: You may have my belongings and you can stay here for the night.\n");
        sb.append("Ghost: I am rather lonely.\n");
        sb.append("Ghost: I hope that you will save enough to build a home for yourself,\n");
        sb.append("Ghost: and that this gift will help you get started.\n");
        inventory.collect(200);
        sb.append("\n");
        sb.append("You sleep peacefully in the cave tonight.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You awaken in the morning feeling rested, and continue onward toward the princess.\n" +
        "Do you really feel no remorse for lying to that poor ghost?";

    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new RiverTrollsEncounter());
    }
}
