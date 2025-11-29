public abstract class Equipment {
    protected int price;
    protected String name;

    public Equipment(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {return price;} 
    public String getName() {return name;}

}
