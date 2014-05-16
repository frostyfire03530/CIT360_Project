package javafun;
import javax.swing.JOptionPane;
public class loops {


public static void main(String[] args) {
	
	
	
	String FeetString = JOptionPane.showInputDialog ( "Enter Value For Feet:");
	double Feet = Double.parseDouble(FeetString);
	
	double Meters = Feet * 0.305;
	JOptionPane.showMessageDialog (null, Feet + " Feet is " + Meters + " Meters." );
}
}