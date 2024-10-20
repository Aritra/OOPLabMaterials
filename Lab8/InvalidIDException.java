import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InvalidIDException extends Exception{
    public InvalidIDException(JFrame frame){
        super("Invalid ID");
        JOptionPane.showMessageDialog(frame, "Invalid ID!",
               "Error", JOptionPane.ERROR_MESSAGE);
    }
}
