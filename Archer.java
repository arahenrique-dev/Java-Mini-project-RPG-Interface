public class Archer extends Character {
    public Archer(String nom) {
        super(nom);
        super.mana = 50;
    }

    @Override
    public void displayASCII() {
        System.out.print("   \\\\\n");
        System.out.print("    \\\\\n");
        System.out.print("     ))======>\n");
        System.out.print("    //\n");
        System.out.print("   //\n");
        System.out.print("  //\n");
        System.out.print(" /_\\\n\n");
    }
}
