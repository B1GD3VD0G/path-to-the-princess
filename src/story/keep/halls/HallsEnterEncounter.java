package story.keep.halls;

import model.AbstractEncounter;
import model.Inventory;

public final class HallsEnterEncounter extends AbstractEncounter {

    public HallsEnterEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("The castle gates creak open as you enter.\n");
        sb.append("An overwhelming eerie feeling overcomes you.\n");
        sb.append("You do not see anyone around as you walk along the path to the door.\n");
        sb.append("It seems strange, but then again, this is a castle full of bandits.\n");
        sb.append("Right as you get to the door, a man jumps out and tries to attack you.\n");
        if(!inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("You pull out your weapon and swing just at the right time.\n");
            sb.append("The man falls to the ground, severely injured.\n");
            sb.append("That was a close one!\n");
        }
        else {
            sb.append("You reach for your bow and arrow, but it's too late.\n");
            sb.append("The man strikes you with his axe before you can cock a bow.\n");
            sb.append("You lie on the ground, severely injured.\n");
            sb.append("The man takes one more jab at you, and you die.\n");
            sb.append("You were so close!\n");
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
            question = "That was a close one!";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Phew!", new WhichWayEncounter());
        }
    }
}
