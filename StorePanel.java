import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class StorePanel {
    private static JDialog d;
    private Character player;

    public StorePanel(Store store, Character player) {
        this.player = player;
        d = new JDialog((Frame) null, "Store", true);
        d.setLayout(new FlowLayout());
        d.add(new JLabel("Welcome to the market! Feel free to buy any of our products"));
        
        d.add(new JLabel("Your current gold : " + player.getGold()));

        int choice = 0;
        ButtonGroup itemChoiceGroup = new ButtonGroup();
        JPanel weapons = new JPanel();
        weapons.add(new JLabel("Weapons : "));
        for (Weapon weapon : store.getWeapons()) {
            JPanel weaponItem = new JPanel();
            JRadioButton rWeapon = new JRadioButton(new ImageIcon("assets/" + weapon.getClass().getSimpleName().toLowerCase() + ".png"));
            itemChoiceGroup.add(rWeapon);
            rWeapon.setActionCommand(""  + choice);
            choice++;

            weaponItem.add(rWeapon);
            weaponItem.add(new JLabel(weapon.getName() + " | Price: " + weapon.getPrice() + "Golds"));
            weapons.add(weaponItem);
        }
        d.add(weapons);

        JPanel potions = new JPanel();
        potions.add(new JLabel("Potions : "));
        for (Potion potion : store.getPotions()) {
            JPanel potionItem = new JPanel();
            JRadioButton rPotion = new JRadioButton(new ImageIcon("assets/potion" + potion.getPotionCode() + ".png"));
            itemChoiceGroup.add(rPotion);
            rPotion.setActionCommand(""  + choice);
            choice++;

            potionItem.add(rPotion);
            potionItem.add(new JLabel(potion.getName() + " | Price: " + potion.getPrice() + "Golds"));
            potions.add(potionItem);
        }
        d.add(potions);

        JButton b = new JButton("BUY");
        b.addActionListener(e -> {
                switch (itemChoiceGroup.getSelection().getActionCommand()) {
                    case "0" -> store.sellEquipment(0, "weapons", player);
                    case "1" -> store.sellEquipment(1, "weapons", player);
                    case "2" -> store.sellEquipment(2, "weapons", player);
                    case "3" -> store.sellEquipment(3, "weapons", player);
                    case "4" -> store.sellEquipment(0, "potions", player);
                    case "5" -> store.sellEquipment(1, "potions", player);
                    case "6" -> store.sellEquipment(2, "potions", player);
                    case "7" -> store.sellEquipment(3, "potions", player);
                    default -> {
                        System.out.println("Invalid number. Buying default weapon : sword");
                        store.sellEquipment(3, "weapons", player);
                    }
                }
                d.setVisible(false);
        });
        d.add(b);

        d.setSize(384,407);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }
    
}
