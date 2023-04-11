package story.keep.final_battle.fight;

import model.AbstractEncounter;
import story.keep.final_battle.fight.dodge.DodgeLeftEncounter;
import story.keep.final_battle.fight.dodge.DodgeRightEncounter;
import story.keep.final_battle.fight.dodge.JumpBackEncounter;

public final class RevealYourselfEncounter extends AbstractEncounter {

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You reveal yourself to the bandit chief.\n");
        sb.append("You see him clearly for the first time.\n");
        sb.append("He is big, and crazy looking.\n");
        sb.append("His face is covered in warpaint and he has a long scar running down his left eye.\n");
        sb.append("He wears fur armor, made of many pelts of powerful beasts.\n");
        sb.append("His helmet is made of a mountain lion's head.\n");
        sb.append("Equipped on his back was the biggest warhammer you've ever seen!\n");
        sb.append("You wonder how any man could swing such a hammer.\n");
        sb.append("You draw your weapon and prepare for battle.\n");
        sb.append("The bandit chief lets out an ominous laugh.\n");
        sb.append("\n");

        sb.append("The bandit chief pulls out his giant warhammer, and snarls at you menacingly.\n");
        sb.append("He swings his hammer at you.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which way do you dodge?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Dodge left!", new DodgeLeftEncounter());
        addProgressButton("Dodge right!", new DodgeRightEncounter());
        addProgressButton("Jump back!", new JumpBackEncounter());
    }
}
