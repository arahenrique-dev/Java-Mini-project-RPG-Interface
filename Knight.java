public class Knight extends Character {
    public Knight(String nom) {
        super(nom);
        super.mana = 30;
    }

    @Override
    public void displayASCII() {
        System.out.print("  /| ________________\n");
        System.out.print("O|===|* >________________>\n");
        System.out.print("  \\|\n");
        System.out.print("   |\n");
        System.out.print("  / \\\n\n");
    }
}
