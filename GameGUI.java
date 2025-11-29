import java.awt.Font;
import javax.swing.*;

public class GameGUI {
    public static void main(String[] args) {
        setGlobalFont(new Font("Papyrus", Font.BOLD, 18));
        JFrame window = new JFrame(" THE PATH OF THE AUREAL SANCTUARY");
        window.setSize(384,407);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        //Demarrage du jeu
        MenuStartPanel menuStart = new MenuStartPanel();
        Character player = menuStart.getPlayer();
        
        Board b = new Board();
        b.fillBoard(player);
        MapPanel mapPanel = new MapPanel(b, player);
        window.add(mapPanel);
        window.pack();
        window.setVisible(true);   
        SwingUtilities.invokeLater(() -> mapPanel.requestFocusInWindow());

        window.validate();
    }

    public static void setGlobalFont(Font font) {
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("CheckBox.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("List.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("MenuItem.font", font);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("OptionPane.buttonFont", font);
    }
    
}
