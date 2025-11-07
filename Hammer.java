public class Hammer extends Weapon {
    public Hammer(String name, int price, int attackPower) {
        super(name, price, attackPower);
    }
    @Override
    public void asciiArt() {
        System.out.print("  ____\n");
        System.out.print(" |____|\n");
        System.out.print("   ||\n");
        System.out.print("   ||\n");
        System.out.print("  /__\\\n\n");
    }
}
