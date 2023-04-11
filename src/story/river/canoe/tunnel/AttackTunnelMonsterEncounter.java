package story.river.canoe.tunnel;

import model.AbstractEncounter;
import model.Inventory;
import story.river.canoe.CanoeExitEncounter;

public final class AttackTunnelMonsterEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        if(!inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("You reach for your weapon.\n");
            sb.append("You feel the creature's breath on your ear, so you strike there.\n");
            sb.append("You hear a grunt, then feel this creature shatter into a million " +
                    "pieces right next to you.\n");
            sb.append("The light flickers back on, and you continue to row through the tunnel" +
                    "as fast as you can.\n");
            sb.append("You make it through to the other side of the tunnel after what feels " +
                    "like a million years.");
        }
        else {
            sb.append("You reach for your sack of arrows.\n");
            sb.append("You feel the creature's breath on your ear, so you strike there.\n");
            sb.append("The arrow pierces its skin. Now you have angered it.\n");
            sb.append("The light bulb flicks back on and you see a man made of stone " +
                    "right in front of your face.\n");
            sb.append("The man opens his mouth, displaying 200 sharp teeth.\n");
            sb.append("He bites into your skull.\n");
            hasDied = true;
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "You are safe.";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Phew!", new CanoeExitEncounter());
        }
    }
}
