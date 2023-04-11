package story.introduction.kingdom;

import model.Inventory;
import model.AbstractEncounter;

final public class InstructionEncounter extends AbstractEncounter {

    public InstructionEncounter() {
        super();
    }

    @Override
    final protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("\"Path to the Princess\"!\n");
        sb.append("A game by the Booligans:\n");
        sb.append("Nicole Gouhin, Mohannad Lawal, Chaeyeon Park, Devin Peevy, & Paris Weber\n\n");
        sb.append("Over the course of the game, you will be presented with many choices.\n");
        sb.append("To make a choice, simply click the corresponding button.\n");
        sb.append("There will be opportunities to gain items throughout the game.\n");
        sb.append("As the game continues, there will be times when having a certain item can save your life.\n");
        sb.append("As you progress throughout the game, there are going to be many hidden dangers.\n");
        sb.append("Choose incorrectly, and that choice may be your last!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Please press the start button to begin the game. Good luck!";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Start.", new ChooseWeaponEncounter());
    }
}
