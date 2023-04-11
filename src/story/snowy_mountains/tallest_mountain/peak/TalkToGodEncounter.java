package story.snowy_mountains.tallest_mountain.peak;

import model.AbstractEncounter;
import model.Inventory;
import story.snowy_mountains.tallest_mountain.peak.FlyToKeepEncounter;

public final class TalkToGodEncounter extends AbstractEncounter {

    public TalkToGodEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("The dragon steps to the side, clearing the path to the shrine.\n");
        sb.append("You approach the shrine.\n");
        sb.append("You aren't usually religious, but you kneel down and pray the best you know how.\n");
        sb.append("After five or so minutes, the statue starts to glow.\n");
        sb.append("You hear a strong, ethereal voice that seems to be coming from inside your head.\n\n");
        sb.append("Kyr: Brave knight! You have pleased my precious dragon.\n");
        sb.append("Kyr: You have climbed the highest mountain in the realm.\n");
        sb.append("Kyr: And you have prayed to me, Kyr, God of Time.\n");
        sb.append("Kyr: I give to you, mighty knight, that which you seek.\n");
        sb.append("Kyr: A staff, with the power to stop time for a brief instance.\n");
        sb.append("Kyr: But beware!\n");
        sb.append("Kyr: You may use this staff but once, then it will return to me in the immortal plane.\n");
        sb.append("Kyr: Best of luck! I will be watching over you.\n");
        inventory.collect(Inventory.STAFF);
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "A staff materializes at the base of the shrine.\n" +
                "You pick it up. It feels as if it weighs nothing at all.";

    }

    @Override
    protected void setChoices() {
        addProgressButton("Fantastic!", new FlyToKeepEncounter());
    }
}
