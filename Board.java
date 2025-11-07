public final class Board {
    private final int w;
    private final int h;
    private final Piece[][] map;
    private final double MONSTER_SPAWN_RATE = 0.05;
    private final double OBSTACLE_SPAWN_RATE = 0.1;
    private final double STORE_SPAWN_RATE = 0.15;
    
    public Board(int w, int h) {
        this.w = w;
        this.h = h;
        map = new Piece[w][h];
    }

    public void fillBoard(Character c) {
        double spawnProbability;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j ++) {
                spawnProbability = Math.random();
                if (spawnProbability <= MONSTER_SPAWN_RATE) map[i][j] = new Monster();
                else if (spawnProbability > MONSTER_SPAWN_RATE && spawnProbability < OBSTACLE_SPAWN_RATE) map[i][j] = new Obstacle();
                else if (spawnProbability > OBSTACLE_SPAWN_RATE && spawnProbability < STORE_SPAWN_RATE) map[i][j] = new Store();
            }
        }
        map[0][0] = c;
        map[w-1][h-1] = null;
    }

    public void displayBoard() {
        //System.out.print("[ ");
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j ++) {
                if (map[i][j] == null) System.out.print("[   ]");
                else System.out.print("[ " + map[i][j].getRepresentingLetter() + " ]");
            }
            System.out.println();
        }
    }

    public int getWidth() {return w;}
    public int getHeight() {return h;}
    public Piece[][] getMap() {return map;}
 
}
