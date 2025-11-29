import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE PATH OF THE AUREAL SANCTUARY");
        System.out.println("The world was once full of light, where wisdom and knowledge walked together along humankind. But the suns have dimmed, and the land is fading into shadow.");
        System.out.println("Ever since the Great Eclipse, civilizations fell and the world was torn apart. The only place untouched by the Eternal Night is the Aureal Sanctuary.");
        System.out.println("\nYour goal: cross the cursed land to reach that sanctuary.");
        System.out.println("But the path is dangerous. Monsters or Obstacles will try to block your way.");
        System.out.println("Every choice is a test of survival. Every step forward is one closer to the light.");

        System.out.println("--------------CHOOSE YOUR CHARACTER--------------");
        System.out.print("Enter your character name : ");
        String playerName = scanner.nextLine();
        System.out.println("1) Knight");
        System.out.println("2) Archer");
        System.out.println("3) Sorcerer");
        System.out.println("4) Thief");
        System.out.print("Choose the number of your character type : ");
        int typeChoice = scanner.nextInt();
        Character player;
        switch (typeChoice) {
            case 1 -> player = new Knight(playerName);
            case 2 -> player = new Archer(playerName);
            case 3 -> player = new Sorcerer(playerName);
            case 4 -> player = new Thief(playerName);
            default -> {
                System.out.println("Invalid number. Setting default character : Knight");
                player = new Knight(playerName);
            }
        }
        
        System.out.println("\n\nHello " + playerName + ". Thank you for being a brave " + player.getClass().getSimpleName());
        player.displayASCII();
        board.fillBoard(player);
        System.out.println("Welcome to Aureal :");
        board.displayBoard();
        System.out.println("Map Legend:");
        System.out.println("  P -> Player");
        System.out.println("  S -> Store");
        System.out.println("  M -> Monster");
        System.out.println("  O -> Obstacle");
        
        System.out.println("How to play on the keyboard:");
        System.out.println("  w -> move up");
        System.out.println("  s -> move down");
        System.out.println("  a -> move left");
        System.out.println("  d -> move right");
        System.out.println("\n  q -> open inventory\n");

        while ((player.getX() != board.getWidth()-1) || (player.getY() != board.getHeight()-1)) {
            
            int x = player.getX();
            int y = player.getY();

            Piece upPiece = null;
            Piece downPiece = null;
            Piece leftPiece = null;
            Piece rightPiece = null;
            if (x - 1 >= 0) upPiece = board.getMap()[x - 1][y];
            if (x + 1 < board.getHeight()) downPiece = board.getMap()[x + 1][y];
            if (y - 1 >= 0) leftPiece = board.getMap()[x][y - 1];  
            if (y + 1 < board.getWidth()) rightPiece = board.getMap()[x][y + 1];
            Piece[] neighbourPieces = {upPiece, downPiece, leftPiece, rightPiece};
            for (Piece neighbour : neighbourPieces) {
                String choose;
                if (neighbour instanceof Monster monster) {
                    System.out.println("MONSTER AHEAD");
                    System.out.print("Choose to fight (f) or run (r) : ");
                    choose = scanner.nextLine();
                    if (choose.equals("f")) player.attack(monster);
                    else if (choose.equals("r")) System.out.println("Run away!");
                }
                if (neighbour instanceof Obstacle obstacle) {
                    System.out.println("OBSTACLE AHEAD");
                    System.out.print("Choose to destroy (f) or continue walking (r) : ");
                    choose = scanner.nextLine();
                    if (choose.equals("f")) player.attack(obstacle);
                    if (obstacle.getLifePoints() == 0) {
                        neighbour = null;
                        continue;
                    }
                    else if (choose.equals("r")) System.out.println("Continue walking!");
                }
                if (neighbour instanceof Store store) {
                    System.out.println("STORE AHEAD");
                    System.out.println("Type (c) to check out it's equipment");
                    choose = scanner.nextLine();
                    
                    if (choose.equals("c")) {
                        while (!choose.equals("e")) {
                            store.displayEquipment();
                            System.out.println("Press 1 to buy Weapons or 2 to buy Potions");
                            choose = scanner.nextLine();
                            if (Integer.parseInt(choose) == 1 ) {
                                System.out.println("Press the number of the item to buy it");
                                choose = scanner.nextLine();
                                store.sellEquipment(Integer.parseInt(choose), "weapons", player);
                            }
                            else if (Integer.parseInt(choose) == 2 ) {
                                System.out.println("Press the number of the item to buy it");
                                choose = scanner.nextLine();
                                store.sellEquipment(Integer.parseInt(choose), "potions", player);
                            }
                            System.out.println("Press (e) to exit the store or another letter to continue buying");
                            choose = scanner.nextLine();
                        }
                    }
                }
            }

            String l = scanner.nextLine();
            if (l.equals("q")) player.displayInventory();
            player.movePlayer(board, l);
            board.displayBoard();
            
            if ((player.getX() == board.getWidth()-1) && (player.getY() == board.getHeight()-1)) {
                System.out.println("YOU WON ! The light of the Sanctuary shines for you, hero."); 
                break;
            }
            if (player.getLifePoints() < 0) {
                System.out.println("YOU LOST ! You will be remembered for your great effort."); 
                break;
            }
        }
        scanner.close();
    }
}
