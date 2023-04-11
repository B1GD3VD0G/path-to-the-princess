package story.river.canoe.tunnel;

import model.AbstractEncounter;

public final class TunnelMonsterEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You enter the tunnel. It gets so dark almost instantly and you can't see anything.\n");
        sb.append("You stop rowing, letting the current of the river push you through.\n");
        sb.append("After a few minutes, you see a light up ahead.\n");
        sb.append("You feel relieved, you've almost made it through!\n");
        sb.append("\n");
        sb.append("As you approach the light, you realize it is not the light at the end of the tunnel.\n");
        sb.append("It is a light bulb hanging from the ceiling of the tunnel.\n");
        sb.append("You get right underneath it, and the river current stops.\n");
        sb.append("The light bulb flickers, then goes out.\n");
        sb.append("\n");
        sb.append("Something thuds into your boat. You hear what sounds like a rabid dog breathing " +
                "in your ear.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How do you react to the mysterious guest?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Hit it with your weapon!", new AttackTunnelMonsterEncounter());
        addProgressButton("Abandon the boat and try to swim to safety.", new TunnelSwimEncounter());
        addProgressButton("Sit still and stay quiet.", new StayQuietEncounter());
    }
}
