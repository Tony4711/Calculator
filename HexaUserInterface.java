import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class HexaUserInterface extends UserInterface implements ActionListener {

	protected CalcEngine hexCalc;

	public HexaUserInterface(CalcEngine engine) {
		super(engine);
		addHexInterface();
	}

	private void addHexInterface() {

		addButton(buttonPanel, "F");
		addButton(buttonPanel, "E");
		addButton(buttonPanel, "D");
		buttonPanel.add(new JLabel(" "));

		addButton(buttonPanel, "C");
		addButton(buttonPanel, "B");
		addButton(buttonPanel, "A");
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		int[] hexNumber = { 10, 11, 12, 13, 14, 15 };

		if (command.equals("0") || command.equals("1") || command.equals("2") || command.equals("3")
				|| command.equals("4") || command.equals("5") || command.equals("6") || command.equals("7")
				|| command.equals("8") || command.equals("9")) {
			int number = Integer.parseInt(command);
			calc.numberPressed(number);

		} else if (command.equals("A") || command.equals("B") || command.equals("C") || command.equals("D")
				|| command.equals("E") || command.equals("F")) {
			int hex = 0;
			switch (command) {
			case "A":
				hex = hexNumber[0];
				break;
			case "B":
				hex = hexNumber[1];
				break;
			case "C":
				hex = hexNumber[2];
				break;
			case "D":
				hex = hexNumber[3];
				break;
			case "E":
				hex = hexNumber[4];
				break;
			case "F":
				hex = hexNumber[5];
				break;
			}
			calc.numberPressed(hex);
		}else if (command.equals("*"))
			calc.multi();
		else if (command.equals("+"))
			calc.plus();
		else if (command.equals("-"))
			calc.minus();
		else if (command.equals("="))
			calc.equals();
		else if (command.equals("c"))
			calc.clear();
		else if (command.equals("?"))
			showInfo();

		redisplay();
	}
	
	public void redisplay() {
		if(calc.getDisplayValue() >=0) {
		String hex = (Integer.toHexString(calc.getDisplayValue())).toUpperCase();
		display.setText("" + hex);
		}
		else
			display.setText("" + calc.getDisplayValue());
			
		
		
	}
	

}
