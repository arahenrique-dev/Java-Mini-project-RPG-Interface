
import java.util.ArrayList;

public class Store extends Piece {
    private ArrayList<Weapon> weapons;
    private ArrayList<Potion> potions;

   
    public Store() {
        representingLetter = "S";
        weapons = new ArrayList<>();
        potions = new ArrayList<>();

        weapons.add(new Axe("Woodburning Axe", ((int)(Math.random()*20)), ((int)(Math.random()*30))));
        weapons.add(new Bow("Windpiercer Bow",((int)(Math.random()*20)), ((int)(Math.random()*30))));
        weapons.add(new Hammer("Stone Breaker Hammer",((int)(Math.random()*20)), ((int)(Math.random()*30))));
        weapons.add(new Sword("Shadow Piercing Sword", ((int)(Math.random()*20)), ((int)(Math.random()*30))));

        String[] potionNames = {"Shining Elixir", "Life Tonic", "Moonlight Nectar", "Shadow Veil Essence"};
        int i = 0;
        for (String potionName : potionNames) {
            int randomExtraLifePointsValue = (int)(Math.random()*40);
            int randomPrice = (int)(Math.random()*10);
            potions.add(new Potion(potionName, randomPrice, randomExtraLifePointsValue, i));
            i++;
        }
    }
    public void displayEquipment() {
        System.out.println("Welcome to the store !");
        System.out.println("\nWeapons :");
        for (Weapon weapon : weapons) {
            System.out.println(weapons.indexOf(weapon) + " -> " + weapon.getName() + " | Price : " + weapon.getPrice());
        }
        System.out.println("\nPotions :");
        for (Potion potion : potions) {
            System.out.println(potions.indexOf(potion)+ " -> " + potion.getName() + " | Price : " + potion.getPrice());
        }
    }

    public void sellEquipment(int choice, String collection, Character player) {
        if (collection.equals("weapons")) {
            if (choice < 0 || choice >= weapons.size()) System.out.println("Invalid value");
                Weapon product = weapons.get(choice);
                if (player.getGold() >= product.getPrice()) {
                    player.weapons.add(product);
                    player.addStrength(product.getAttackPower());
                    player.addGold(-product.getPrice());
                    System.out.println("Current gold amount : " + player.getGold());
                    this.weapons.remove(product);
                }
                else System.out.println("Too expensive. Not enough gold to buy " + product.getName());
        }
        if (collection.equals("potions")) {
            if (choice < 0 || choice >= potions.size()) System.out.println("Invalid value");
                Potion product = potions.get(choice);
                if (player.getGold() >= product.getPrice()) {
                    player.potions.add(product);
                    player.addGold(-product.getPrice());
                    System.out.println("Current gold amount : " + player.getGold());
                    this.potions.remove(product);
                }
                else System.out.println("Too expensive. Not enough gold to buy " + product.getName());
        }
        player.addXP(10);
    }
    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }
    public ArrayList<Potion> getPotions() {
        return this.potions;
    }
}
