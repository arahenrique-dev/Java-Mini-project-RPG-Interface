public class Thief extends Character {
    public Thief(String nom) {
        super(nom);
    }

    @Override
    public void displayASCII() {
        System.out.print("   (\\_/)\n");
        System.out.print("  ( •_•)\n");
        System.out.print("  / >🗡\n");
        System.out.print(" /   \\\n\n");
    }
}
