package MyPackage;

import javax.swing.JApplet;
import javax.swing.JTextField;

public class FirstApplet extends JApplet {
	private JTextField txtHello;
	private JTextField txtHej;

	/**
	 * Create the applet.
	 */
	public FirstApplet() {
		getContentPane().setLayout(null);
		
		txtHello = new JTextField();
		txtHello.setText("hello");
		txtHello.setBounds(29, 58, 86, 20);
		getContentPane().add(txtHello);
		txtHello.setColumns(10);
		
		txtHej = new JTextField();
		txtHej.setText("hej");
		txtHej.setBounds(29, 127, 86, 20);
		getContentPane().add(txtHej);
		txtHej.setColumns(10);

	}

}
