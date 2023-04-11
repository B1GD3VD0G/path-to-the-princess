package story.snowy_mountains.inn;

import model.AbstractInncounter;
import model.Inventory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class DrinkInncounter extends AbstractInncounter {

    public DrinkInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if (inventory.contains(Inventory.BREAD_LOAF)) {
            sb.append("The bread is hard and not very tasty.\n");
            sb.append("Your life in the castle has made you a bit harder to please, food wise.\n");
            sb.append("Still, it is sustenance. You feel your belly get full.\n");
            inventory.drop(Inventory.BREAD_LOAF);
        }
        else if (inventory.contains(Inventory.FRUIT_PIE)) {
            sb.append("You cut into the pie. It is still warm.\n");
            sb.append("You take a bite. It is much too sweet for your tastes.\n");
            sb.append("You still eat it. Your stomach feels full now.\n");
            inventory.drop(Inventory.FRUIT_PIE);
        }
        else {
            sb.append("The salmon is slightly overdone, and slightly under-seasoned.\n");
            sb.append("However, you scarf it all down and leave a clean plate.\n");
            sb.append("You feel full but very satisfied. You thank the barkeep for a good meal.\n");
            inventory.drop(Inventory.SALMON_DINNER);
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Barkeep: Now, fancy anything to drink?";
    }

    @Override
    protected void setChoices() {
        addPayButton("Order one mug of mead for 15 gold.", new ChatOptionInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost), 15);
        JButton button = new JButton("Order TWO mugs of mead for 30 gold.");
        // Only button in the game to make you drunk.
        // So we write it the long way.
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.pay(30);
                isDrunk = true;
                System.out.println(inventory);
                pcs.firePropertyChange(PROGRESS, inventory, new ChatOptionInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
            }
        });
        choices.addRear(button);
    }
}
