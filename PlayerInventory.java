import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerInventory {
    private static JDialog d;
    private Character player;

    public PlayerInventory(Character player) {
        d = new JDialog((Frame) null, "Inventory", true);
        d.setLayout(new FlowLayout());
        d.add(new JLabel("Your Inventory"));
        
        d.add(new JLabel("Gold : " + player.getGold()));
        JPanel weapons = new JPanel();
        weapons.add(new JLabel("Weapons : "));
        for (Weapon weapon : player.getWeapons()) {
            JPanel weaponItem = new JPanel();
            weaponItem.add(new JLabel(new ImageIcon("assets/" + weapon.getClass().getSimpleName().toLowerCase() + ".png")));
            weaponItem.add(new JLabel(weapon.getName()));
            weapons.add(weaponItem);
        }
        d.add(weapons);

        JPanel potions = new JPanel();
        potions.add(new JLabel("Potions : "));
        for (Potion potion : player.getPotions()) {
            JPanel potionItem = new JPanel();
            potionItem.add(new JLabel(new ImageIcon("assets/potion" + potion.getPotionCode() + ".png")));
            potionItem.add(new JLabel(potion.getName()));
            potions.add(potionItem);
        }
        d.add(potions);

        d.setSize(384,407);
        d.setLocationRelativeTo(null);
        d.setVisible(true);

    }
    
}
