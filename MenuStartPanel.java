
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.*;

public class MenuStartPanel {
    private static JDialog d;
    private Character player;

    public MenuStartPanel() {
        JFrame f = new JFrame();
        d = new JDialog(f, "Welcome to The Path Of The Aureal Sanctuary ", true);
        d.setLayout(new FlowLayout());
        d.add(new JLabel("Let's create your character"));
        
        //Choisir nom
        d.add(new JLabel("Choose a character name: "));
        JTextField playerNameTextField = new JTextField();
        playerNameTextField.setColumns(10);
        d.add(playerNameTextField);
        
        //Choisir cast
        d.add(new JLabel("Choose your class: "));
        JPanel castChoicePanel = new JPanel();
        ButtonGroup castChoiceGroup = new ButtonGroup();
        JRadioButton rKnight = new JRadioButton(new ImageIcon("assets/knight.png"));
        JRadioButton rArcher = new JRadioButton(new ImageIcon("assets/archer.png"));
        JRadioButton rSorcerer = new JRadioButton(new ImageIcon("assets/sorcerer.png"));
        JRadioButton rThief = new JRadioButton(new ImageIcon("assets/thief.png"));
        castChoiceGroup.add(rKnight);
        castChoiceGroup.add(rArcher);
        castChoiceGroup.add(rSorcerer);
        castChoiceGroup.add(rThief);

        rKnight.setActionCommand("knight");
        rArcher.setActionCommand("archer");
        rSorcerer.setActionCommand("sorcerer");
        rThief.setActionCommand("thief");

        castChoicePanel.add(rKnight);
        castChoicePanel.add(rArcher);
        castChoicePanel.add(rSorcerer);
        castChoicePanel.add(rThief);
        d.add(castChoicePanel);

        //Visualiser magasin et acheter armes
        Store store = new Store();
        d.add(new JLabel("Choose your weapon: "));
        JPanel weaponStorePanel = new JPanel();
        ButtonGroup weaponChoiceGroup = new ButtonGroup();
        JRadioButton rSword = new JRadioButton(new ImageIcon("assets/sword.png"));
        JRadioButton rAxe = new JRadioButton(new ImageIcon("assets/axe.png"));
        JRadioButton rHammer = new JRadioButton(new ImageIcon("assets/hammer.png"));
        JRadioButton rBow = new JRadioButton(new ImageIcon("assets/Bow.png"));
        weaponChoiceGroup.add(rSword);
        weaponChoiceGroup.add(rAxe);
        weaponChoiceGroup.add(rHammer);
        weaponChoiceGroup.add(rBow);

        rSword.setActionCommand("sword");
        rAxe.setActionCommand("axe");
        rHammer.setActionCommand("hammer");
        rBow.setActionCommand("bow");

        weaponStorePanel.add(rSword);
        weaponStorePanel.add(rAxe);
        weaponStorePanel.add(rHammer);
        weaponStorePanel.add(rBow);
        d.add(weaponStorePanel);
        
        //demarrer jeux
        d.add(new JLabel("Are you ready ?"));
        JButton b = new JButton("START");
        b.addActionListener(e -> {
                String playerName = playerNameTextField.getText();
                String castChoiceString = castChoiceGroup.getSelection().getActionCommand();
                switch (castChoiceString) {
                    case "knight" -> player = new Knight(playerName);
                    case "archer" -> player = new Archer(playerName);
                    case "sorcerer" -> player = new Sorcerer(playerName);
                    case "thief" -> player = new Thief(playerName);
                    default -> {
                        System.out.println("Invalid number. Setting default character : Knight");
                        player = new Knight(playerName);
                    }
                }
                switch (weaponChoiceGroup.getSelection().getActionCommand()) {
                    case "axe" -> store.sellEquipment(0, "weapons", player);
                    case "bow" -> store.sellEquipment(1, "weapons", player);
                    case "hammer" -> store.sellEquipment(2, "weapons", player);
                    case "sword" -> store.sellEquipment(3, "weapons", player);
                    default -> {
                        System.out.println("Invalid number. Setting default weapon : sword");
                        store.sellEquipment(3, "weapons", player);
                    }
                }
                d.setVisible(false);
        });
        d.add(b);
        d.setSize(384,407);
        d.setVisible(true);
        d.setLocationRelativeTo(null);

        b.setFocusable(true);
        b.requestFocusInWindow();
    }

    public Character getPlayer() {
        return this.player;
    }

    public JPanel displayStore() {
        JPanel storePanel = new JPanel();
        Store store = new Store();
        ArrayList<Weapon> weapons = store.getWeapons();
        
        for (Weapon w : weapons) {
            //storePanel.add(J)
        }

        return storePanel;
    }
}