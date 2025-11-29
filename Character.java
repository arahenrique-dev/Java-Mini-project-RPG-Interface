
import java.util.ArrayList;

public abstract class Character extends Destructible {
    
    protected int lifePoints;
    protected String name;
    protected int gold;
    protected int XP;
    protected int mana;
    protected int strength;
    protected int resistance;
    protected ArrayList<Weapon> weapons;
    protected ArrayList<Potion> potions;

    

    public Character(String nom) {
        lifePoints = 100;
        this.name = nom;
        gold = 50;
        XP = 0;
        mana = 0;
        weapons = new ArrayList<>();
        weapons.add(new Sword("Wood Sword", 5, 10));
        potions = new ArrayList<>();
        representingLetter = "P";
        x = 0;
        y = 0;
        strength = (int)(Math.random()*50);
        resistance = (int)(Math.random()*50);
    }


    public void displayInventory() {
        System.out.println("\n--------------INVENTORY--------------");
        System.out.println("Life Points : " + lifePoints);
        System.out.println("Gold : " + gold);
        System.out.println("\nWeapons : ");
        for (Weapon w : weapons) System.out.println(w.getName() + " | Attack power : " + w.getAttackPower());
        System.out.println("\nPotions : ");
        for (Potion p : potions) System.out.println(p.getName() + " | Extra life points : " + p.getExtraLifePoints());
        System.out.println("-------------------------------------");
    }

    public void attack(Destructible d) {
        if (d.getLifePoints() > 0) {
            d.reduceLifePoints((strength+weapons.get(0).getAttackPower()) / d.getResistance());
            XP += 5;
            System.out.println("You hitted !");
            System.out.println("Destructible life points : " + d.getLifePoints());
            if (d instanceof Monster monster) {
                double probabilityCounterAttack = Math.random();
                if (probabilityCounterAttack < 0.5) {
                    System.out.println("The monster attacked you !");
                    this.reduceLifePoints(monster.getStrength());
                    System.out.println("Player's life points : " + this.getLifePoints());
                }
            }       
        }
        else {
            d.setRepresentingLetter(".");
            System.out.println("It's been destroyed");
            System.out.println("You now have " + XP + " xp");
        }
    }

    public boolean movePlayer(Board b, String l) {
        int newX = x;
        int newY = y;
        Piece[][] map = b.getMap();
        switch (l) {
            case "w" -> newX--;
            case "s" -> newX++;
            case "a" -> newY--;
            case "d" -> newY++;
            default -> {
            
            }
        }
        if (newX < 0 || newX >= b.getHeight() || newY < 0 || newY >= b.getWidth()) {
            System.out.println("You can't move outside the map!");
            return false;
        }
        if (map[newX][newY] != null) {
            System.out.println("You can't move past this!");
            return false;
        }
        map[x][y] = null;
        x = newX;
        y = newY;
        map[x][y] = this;
        return true;
    }

    public void addWeapon(Weapon w) {weapons.add(w);}
    public void addPotion(Potion p) {potions.add(p);}
    public void addGold(int g) {this.gold += g;}
    public void addXP(int xp) {this.XP += xp;}
    public void addStrength(int s) {strength += s;}
    
    public String getName() {return name;}
    public int getGold() {return gold;}
    public abstract void displayASCII();

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }
    public ArrayList<Potion> getPotions() {
        return this.potions;
    }
    
    
}
