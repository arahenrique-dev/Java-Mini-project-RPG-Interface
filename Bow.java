public class Bow extends Weapon {
    public Bow(String name, int price, int attackPower) {
        super(name, price, attackPower);
    }
    @Override
    public void asciiArt() {
        System.out.print("  (\n");
        System.out.print("   )\\\n");
        System.out.print("  /__\\====>\n");
        System.out.print("   )/\n");
        System.out.print("  (\n");
    }
}
