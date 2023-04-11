package story.keep.final_battle;

import model.AbstractEncounter;
import story.keep.final_battle.hide.*;

public final class MeetPrincessEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You examine the room carefully.\n");
        sb.append("You see the princess, trapped in a jail cell.\n");
        sb.append("There is nobody else there at the moment.\n");
        sb.append("You approach the princess.\n");
        sb.append("\n");
        sb.append("Princess: Oh, Sir Longwood how glad I am to see you!\n");
        sb.append("Princess: The bandit chief is crazy!\n");
        sb.append("Princess: He has kidnapped me and asked me to be his wife!\n");
        sb.append("Princess: He thinks that if I marry him, he will become king!\n");
        sb.append("Princess: As if I would ever marry that disgusting scoundrel!\n");
        sb.append("Princess: Oh please, Sir Longwood, take me back home!\n");
        sb.append("Princess: The bandit chief keeps the key on his person at all times!\n");
        sb.append("Princess: I know he will be back in here to try and convince me to marry him.\n");
        sb.append("Princess: Hide, Sir Longwood, and when he comes back, get the key and save me!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Where will you hide?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Hide under the table.", new HideUnderTableEncounter());
        addProgressButton("Hide in the vacant cell.", new HideInCellEncounter());
        addProgressButton("Do not hide.", new DoNotHideEncounter());
    }
}
