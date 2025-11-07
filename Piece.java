public abstract class Piece {
    protected int x, y;
    protected String representingLetter;

    public String getRepresentingLetter() {return representingLetter;}
    public void setRepresentingLetter(String l) {this.representingLetter = l;}
    public int getX() {return x;}
    public int getY() {return y;}
}
