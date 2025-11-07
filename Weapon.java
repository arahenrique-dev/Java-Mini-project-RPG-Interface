public abstract class Weapon extends Equipment {
    private final int attackPower;

    public Weapon(String name, int price, int attackPower) {
        super(name, price);
        this.attackPower = attackPower;
    }
    public abstract void asciiArt();
    public int getAttackPower() {return attackPower;}

}   