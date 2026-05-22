import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        String strNotification = "Sum: " + (num1+num2) + "\n" + "Difference: " + (num1-num2) + "\n" + "Product: " + (num1*num2) + "\n";
        if(num2 != 0) strNotification += "Quotient: " + (num1/num2);
        else strNotification += "Division by zero is not allowed.";
        JOptionPane.showMessageDialog(null, strNotification, "Calculate", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}