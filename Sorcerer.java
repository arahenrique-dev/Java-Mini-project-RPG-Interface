public class Sorcerer extends Character {
    public Sorcerer(String nom) {
        super(nom);
        super.mana = 70;
    }

    @Override
    public void displayASCII() {
        System.out.print("   /^\\\n");
        System.out.print("  / o \\\n");
        System.out.print(" /_____\\\n");
        System.out.print("  (   )\n");
        System.out.print("  / | \\\n");
        System.out.print(" *  |  *\n");
    }
}
