public abstract class Destructible extends Piece {
    private int lifePoints;
    private final int resistance;

    public Destructible(){
        lifePoints = 100;
        resistance = (int)(Math.random()*5) + 1;
    }
    
    public int getResistance() {return this.resistance;}
    public void reduceLifePoints(int val) {
        this.lifePoints -= val;
    }
    public int getLifePoints() {return lifePoints;}
}