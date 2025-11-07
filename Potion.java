public class Potion extends Equipment {
    protected int extraLifePoints;
    public Potion(String name, int price, int extraLifePoints) {
        super(name, price);
        this.extraLifePoints = extraLifePoints;
    };
    public int getExtraLifePoints() {return extraLifePoints;}
}
