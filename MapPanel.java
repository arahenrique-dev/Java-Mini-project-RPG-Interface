    import java.awt.*;
    import java.awt.event.KeyAdapter;
    import java.awt.event.KeyEvent;
    import javax.swing.*;

    public class MapPanel extends JPanel {
        private final Board board;
        private Character player;
        private final Image background;
        private final int tileSize = 32;

        public MapPanel(Board board, Character player) {
            
            this.board = board;
            this.player = player;
            System.out.println(board.getMap()[0][0]);
            this.background = new ImageIcon("assets/map.png").getImage();
            System.out.println(background.getWidth(null));
            setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));

            setFocusable(true);
            requestFocusInWindow();
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    String direction = switch(e.getKeyCode()) {
                        case KeyEvent.VK_W -> "w";
                        case KeyEvent.VK_S -> "s";
                        case KeyEvent.VK_A -> "a";
                        case KeyEvent.VK_D -> "d";
                        case KeyEvent.VK_Q -> "q";
                        default -> "";
                    };
                    if (direction.equals("q")) {
                        PlayerInventory inventory = new PlayerInventory(player);
                    }
                    else if (!direction.isEmpty()){
                        move(direction);
                        repaint();

                        //FENETRE FIN DU JEU
                        if ((player.getX() == board.getWidth()-1) && (player.getY() == board.getHeight()-1)) {
                            new WinLoseBox(true);
                        }
                        if (player.getLifePoints() <= 0 ) {
                            new WinLoseBox(false);
                        }
                    }
                }
            });
            setLayout(null); // allow manual positioning
            
            JButton upArrow = new JButton(new ImageIcon("assets/upArrow.png"));
            JButton downArrow = new JButton(new ImageIcon("assets/downArrow.png"));
            JButton leftArrow = new JButton(new ImageIcon("assets/leftArrow.png"));
            JButton rightArrow = new JButton(new ImageIcon("assets/rightArrow.png"));
            upArrow.setBounds(256, 416, 32, 32);
            downArrow.setBounds(256, 476, 32, 32);
            leftArrow.setBounds(224, 448, 32, 32);
            rightArrow.setBounds(288, 448, 32, 32);
            
            upArrow.addActionListener(e -> move("w"));
            downArrow.addActionListener(e -> move("s"));
            leftArrow.addActionListener(e -> move("a"));
            rightArrow.addActionListener(e -> move("d"));
            
            add(upArrow);
            add(downArrow);
            add(leftArrow);
            add(rightArrow);
        
            JLabel lifePointsLabel = new JLabel(player.getName() + "'s Life : ");
            JLabel lifePointsValueLabel = new JLabel("" + player.getLifePoints());
            lifePointsLabel.setBounds(64, 458, 208 - 64, 482 - 458);
            lifePointsValueLabel.setBounds(64, 485, 208 - 64, 492 - 478);
            add(lifePointsLabel);
            add(lifePointsValueLabel);

            
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(this.background, 0, 0, this);
            Piece[][] map = board.getMap();
            for (int x = 0; x < board.getWidth(); x++) {
                for (int y = 0; y < board.getHeight(); y++) {
                    Piece p = map[x][y];
                    if (p != null) {
                        g.drawImage(getClassIcon(map[x][y]), (y * tileSize) + tileSize, (x * tileSize) + (tileSize * 2 ), tileSize, tileSize, this);
                    }
                }
            }
            g.setColor(Color.RED);
            g.fillRect(64, 434, mapLifePointsWidth(player.getLifePoints(), (128-64)), 440-434);
        }

        public Image getClassIcon(Piece p) {
            return switch(p) {
                case Knight k -> new ImageIcon("assets/knight.png").getImage();
                case Archer a -> new ImageIcon("assets/archer.png").getImage();
                case Sorcerer s -> new ImageIcon("assets/sorcerer.png").getImage();
                case Thief t -> new ImageIcon("assets/thief.png").getImage();
                case Monster m -> new ImageIcon("assets/monster.png").getImage();
                case Obstacle o -> new ImageIcon("assets/obstacle.png").getImage();
                case Store sm -> new ImageIcon("assets/store.png").getImage();
                default -> null;
            };
        }

        private void move(String direction) {
            if (player.movePlayer(board, direction)) {
                repaint();
                
                this.requestFocusInWindow(); //pour faire marcher le clavier après appuyer sur les bouttons.
        
                if (player.getX() == board.getWidth() - 1 &&
                    player.getY() == board.getHeight() - 1) {
                    new WinLoseBox(true);
                }
                if (player.getLifePoints() <= 0) {
                    new WinLoseBox(false);
                }
                if (board.getMap()[player.getX()][player.getY()] instanceof Store store) {
                    new StorePanel(store, player);
                }

                Piece upPiece = null;
                Piece downPiece = null;
                Piece leftPiece = null;
                Piece rightPiece = null;

                int x = player.getX();
                int y = player.getY();

                if (x - 1 >= 0) upPiece = board.getMap()[x - 1][y];
                if (x + 1 < board.getHeight()) downPiece = board.getMap()[x + 1][y];
                if (y - 1 >= 0) leftPiece = board.getMap()[x][y - 1];
                if (y + 1 < board.getWidth()) rightPiece = board.getMap()[x][y + 1];

                Piece[] neighbourPieces = {upPiece, downPiece, leftPiece, rightPiece};
                for (Piece neighbour : neighbourPieces) {
                    if (neighbour instanceof Store store) {
                        SwingUtilities.invokeLater(() -> new StorePanel(store, player));

                    }
                }
            }
        }

        private int mapLifePointsWidth(int lifePoints, int maxWidth) {
            return lifePoints * maxWidth / 100;
        }
    }

