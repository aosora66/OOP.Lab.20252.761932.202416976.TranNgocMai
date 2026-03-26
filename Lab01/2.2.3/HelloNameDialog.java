import javax.swing.*;

public class HelloNameDialog {
    static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Please enter your name: ");
        JOptionPane.showMessageDialog(null, "Hi " + result + " !");
    }
}
