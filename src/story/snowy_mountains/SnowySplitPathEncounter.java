package story.snowy_mountains;

import model.AbstractEncounter;
import model.Inventory;
import story.snowy_mountains.tallest_mountain.cave.MountainCaveEncounter;
import story.snowy_mountains.valley.ValleyGiantEncounter;

public final class SnowySplitPathEncounter extends AbstractEncounter {

    public SnowySplitPathEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Overnight it has snowed quite a bit.\n");
        sb.append("It is freezing outside, and an icicle the size of a foot hangs from the pergola.\n");
        if(inventory.contains(Inventory.SNOWSHOES)){
            sb.append("You feel thankful for your warm coat and your snowshoes.\n");
        }
        else {
            sb.append("You feel thankful for your warm coat.\n");
        }
        sb.append("You leave the borders of the village.\n");
        sb.append("Not a quarter mile before you you see the incline get very steep.\n");
        sb.append("You prepare yourself for a long and arduous climb.\n");
        sb.append("After many hours of climbing, you are at the top of the first little peak.\n");
        sb.append("The view is amazing!\n");
        sb.append("You decide to take a small break and take in the view.\n");
        sb.append("While you are sitting down, you see the clouds covering the peak of the highest mountain.\n");
        sb.append("You feel intimidated by the enormity of the mountain, but drawn to its strength.\n");
        sb.append("After a short break, you decide to resume your journey.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which way would you like to go?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("The long way, over the tallest mountain.", new MountainCaveEncounter());
        addProgressButton("The short way, through the valley.", new ValleyGiantEncounter());
    }
}
