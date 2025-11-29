
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinLoseBox {
    private static JDialog j;

    public WinLoseBox(boolean win) {
        JDialog j = new JDialog((JFrame) null, win ? "YOU WON!" : "YOU LOST!", true);

        if (win) {
            j.add(new JLabel("Thank you for playing. The light of the Sanctuary shines for you, hero."));
        }
        else {
            j.add(new JLabel("Thank you for playing. You will be remembered for your great effort."));
        }
        
        j.setSize(400, 150);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }
}
