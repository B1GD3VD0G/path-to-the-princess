package story.river.canoe.river_monster;

import model.AbstractEncounter;

public final class RiverMonsterEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You continue rowing the canoe along the river. You are having a splendid time!\n");
        sb.append("All of a sudden, you are thrashed into an area of extreme rapids.\n");
        sb.append("You see whirlpools ahead and monstrous waves. Where did that come from?\n");
        sb.append("At this point, you are stuck in the rapids. You must navigate through them.\n");
        sb.append("You try to steer clear of a massive whirlpool ahead of you when a giant,\n");
        sb.append("snake looking monster emerges from the water.\n");
        sb.append("The monster does not look happy to see you riding through his territory.\n");
        sb.append("He was the one causing the rapids.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How will you deal with this monster?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Fight the monster from your boat.", new MonsterBoatFightEncounter());
        addProgressButton("Navigate around the monster.", new RowAroundMonsterEncounter());
        addProgressButton("Hop out of the boat and swim to shore.", new SwimToShoreEncounter());
        addProgressButton("Try to reason with the monster.", new ReasonWithMonsterEncounter());
    }
}
