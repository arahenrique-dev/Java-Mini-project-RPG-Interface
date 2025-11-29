public class Potion extends Equipment {
    protected int extraLifePoints;
    protected int potionCode;
    public Potion(String name, int price, int extraLifePoints, int potionCode) {
        super(name, price);
        this.extraLifePoints = extraLifePoints;
        this.potionCode = potionCode;
    };
    public int getExtraLifePoints() {return extraLifePoints;}
    public int getPotionCode() {return potionCode;}
}
