package story.introduction.dog;

import model.AbstractEncounter;
import model.Inventory;
import story.introduction.wolves.WolvesEncounter;

public final class DogFightEncounter extends AbstractEncounter {
    public DogFightEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("The dog snarls angrily at you.\n");

        if (inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("The dog leaps at you, and your bow is useless against him.\n");
            if (inventory.contains(Inventory.METAL_ARMOR)) {
                sb.append("The dog fails to tackle you in your metal armor.\n");
                sb.append("You use your heavy gauntlet to strike the dog in the skull.\n");
                sb.append("The dog falls lifeless at your feet.\n");
            }
            else { //has leather armor or shrouded robes
                sb.append("The dog tackles you.\n");
                sb.append("You try to overpower it but you fail.\n");
                sb.append("You bleed out and you die.\n");
                hasDied = true;
            }
        }
        else { //!hasBowAndArrow
            if (inventory.contains(Inventory.SWORD_AND_SHIELD)) {
                sb.append("The dog leaps at you, but you block his bite with your shield.\n");
                sb.append("You strike him as he stumbles, and he dies.\n");
            }
            else { // hasBattleAxe
                if (inventory.contains(Inventory.SHROUDED_ROBES)) {
                    sb.append("The dog leaps at you, and you are too slow to strike it.\n");
                    sb.append("Its fangs easily rip through your cloth robes.\n");
                    sb.append("You are able to smash the wolf, but you are bleeding out through your stomach.\n");
                    sb.append("You take five steps more down the road toward the princess before you collapse.\n");
                    hasDied = true;
                }
                else { //(hasMetalArmor || hasLeatherArmor) && battleaxe
                    sb.append("The dog leaps at you, and tries to bite your stomach.\n");
                    sb.append("Your thick armor protects you from the bite.\n");
                    sb.append("You manage to kick him off, and as he stumbles you smash him with your axe.\n");
                }
            }
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "You continue down the road toward the princess.";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Okay.", new WolvesEncounter());
        }
    }
}
