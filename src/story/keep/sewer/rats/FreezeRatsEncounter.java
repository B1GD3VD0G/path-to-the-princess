package story.keep.sewer.rats;

import model.AbstractEncounter;
import story.keep.sewer.BlackChestEncounter;

public final class FreezeRatsEncounter extends AbstractEncounter {

    public FreezeRatsEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You use the staff of freeze time on the rats.\n");
        sb.append("You kill them both while they are defenseless.\n");
    }

    @Override
    protected void setQuestion() {
        question = "Your staff fades away and returns to Kyr in the immortal plane.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Phew!", new BlackChestEncounter());
    }
}
