package story.introduction.wolves;

import model.AbstractEncounter;
import model.Inventory;
import story.introduction.SplitPathEncounter;

public final class WolvesFightEncounter extends AbstractEncounter {

    public WolvesFightEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        if (inventory.contains(Inventory.BATTLEAXE)) {
            sb.append("You swing your axe at the first wolf.\n");
            sb.append("The axe lodges in its skull. You try to pull it out, but can't.\n");
            sb.append("A second wolf bites your leg.\n");
            if (inventory.contains(Inventory.SHROUDED_ROBES)) {
                sb.append("His teeth easily rip through your cloth leggings.\n");
                sb.append("You start losing blood in your leg, and you fall to the ground.\n");
                sb.append("The wolves now have two bodies to feast on.\n");
                hasDied = true;
            }
            else {
                sb.append("His fangs fail to pierce your armor, and you kick him away.\n");
                sb.append("The two remaining wolves walk in circles around you, snarling angrily.\n");
                sb.append("Both wolves jump at you simultaneously!\n");
                if (inventory.contains(Inventory.LEATHER_ARMOR)) {
                    sb.append("They knock you over, and you drop your battleaxe.\n");
                    sb.append("You try to grab for it, but you are too slow.\n");
                    sb.append("The wolves overpower you, and you bleed out.\n");
                    sb.append("The wolves now have two bodies to feast on.\n");
                    hasDied = true;
                }
                else {
                    sb.append("Your heavy metal armor keeps you from toppling over.\n");
                    sb.append("You swing your battleaxe at another wolf, and he dies.\n");
                    sb.append("The third wolf yelps loudly and runs away with its tail between its legs.\n");
                }
            }
        }
        else if (inventory.contains(Inventory.SWORD_AND_SHIELD)) {
            sb.append("You raise your shield to the three snarling wolves.\n");
            sb.append("The biggest of the three jumps at you, but you parry with your shield.\n");
            sb.append("You attack him as he stumbles, killing him instantly.\n");
            sb.append("Another wolf bites you in the leg when you are looking away.\n");
            if (inventory.contains(Inventory.SHROUDED_ROBES)) {
                sb.append("His teeth easily rip through your cloth leggings.\n");
                sb.append("You start losing blood in your leg, and you fall to the ground.\n");
                sb.append("The wolves now have two bodies to feast on.\n");
                hasDied = true;
            }
            else {
                sb.append("His teeth fail to pierce your armor, and you kick him away.\n");
                sb.append("The third wolf jumps at you, but you point your sword at him.\n");
                sb.append("Your sword stabs through the wolf, and he dies.\n");
                sb.append("The last remaining wolf yelps loudly and runs away with its tail between its legs.\n");
            }
        }
        else {
            sb.append("As soon as you nock your first arrow, two wolves jump at you!\n");
            sb.append("You loose your balance and fall to the ground.\n");
            sb.append("The wolf is on top of you. You hold it back for a while.\n");
            sb.append("Another wolf bites you in the leg! You lose strength momentarily.\n");
            sb.append("The wolf on top of you takes advantage and goes in for the kill.\n");
            sb.append("The wolves now have two bodies to feast on.\n");
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
            question = "Would you like to take the warm coat off the body?\n" +
                    "(Doing so will replace your current armor.)";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addTradeArmorButton("Yes.", new SplitPathEncounter(), Inventory.WARM_COAT);
            addProgressButton("No.", new SplitPathEncounter());
        }
    }
}
