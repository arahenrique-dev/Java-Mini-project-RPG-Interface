public class Axe extends Weapon {
    public Axe(String name, int price, int attackPower) {
        super(name, price, attackPower);
    }
    @Override
    public void asciiArt() {
        System.out.print("  |\\\n");
        System.out.print("  ||\\\n");
        System.out.print("  |||====>\n");
        System.out.print("  ||/\n");
        System.out.print("  |/\n\n");
    }
}
