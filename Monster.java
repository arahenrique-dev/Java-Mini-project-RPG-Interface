public class Monster extends Destructible {
   private final int strength;
   public Monster() {
      super();
      strength = (int)(Math.random()*30 + 10);
      representingLetter = "M";
   }

   public int getStrength() {
        return strength;
   }
}
