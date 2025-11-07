public class Sword extends Weapon {
    public Sword(String name, int price, int attackPower) {
        super(name, price, attackPower);
    }

    @Override
    public void asciiArt() {
        System.out.print("   ||\n");
        System.out.print("   ||\n");
        System.out.print("   ||\n");
        System.out.print("   ||\n");
        System.out.print("   ||\n");
        System.out.print("  /__\\\n");
        System.out.print("  \\__/\n\n");
    }
}
