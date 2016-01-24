import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnRandomHeuristic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen frame = new StartScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void buttonpress()
	{
		boolean isIzmir = true;
		if(rdbtnNewRadioButton_1.isSelected())
		{
			isIzmir = false;
		}
		boolean isRandom = false;
		if(rdbtnRandomHeuristic.isSelected())
		{
			isRandom = true;
		}
		Project2Frame p = new Project2Frame(isRandom, isIzmir);
	}
	
	
	public StartScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(71, 64, 266, 33);
		contentPane.add(panel);
		
		ButtonGroup a = new ButtonGroup();
		
		rdbtnNewRadioButton_1 = new JRadioButton("Classic Map");
		rdbtnNewRadioButton_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		rdbtnNewRadioButton_1.setBackground(new Color(240, 230, 140));
		panel.add(rdbtnNewRadioButton_1);
		a.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setSelected(true);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Izmir Map");
		rdbtnNewRadioButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		rdbtnNewRadioButton.setBackground(new Color(240, 230, 140));
		panel.add(rdbtnNewRadioButton);
		a.add(rdbtnNewRadioButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setBounds(88, 11, 224, 42);
		textPane.setText("Choose A Map:");
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Choose A Heuristic");
		textPane_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
		textPane_1.setEditable(false);
		textPane_1.setBackground(SystemColor.menu);
		textPane_1.setBounds(88, 108, 224, 42);
		contentPane.add(textPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setBounds(69, 155, 268, 33);
		contentPane.add(panel_1);
		ButtonGroup b = new ButtonGroup();
	    rdbtnRandomHeuristic = new JRadioButton("Random Heuristic");
		rdbtnRandomHeuristic.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		rdbtnRandomHeuristic.setBackground(new Color(210, 180, 140));
		b.add(rdbtnRandomHeuristic);
		rdbtnRandomHeuristic.setSelected(true);
		panel_1.add(rdbtnRandomHeuristic);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Clockwise Heuristic");
		rdbtnNewRadioButton_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		rdbtnNewRadioButton_2.setBackground(new Color(210, 180, 140));
		b.add(rdbtnNewRadioButton_2);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonpress();
			}
		});
		btnStart.setBounds(335, 227, 89, 23);
		contentPane.add(btnStart);
		
		JTextPane txtpnMadeByEmre = new JTextPane();
		txtpnMadeByEmre.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		txtpnMadeByEmre.setBackground(SystemColor.menu);
		txtpnMadeByEmre.setEditable(false);
		txtpnMadeByEmre.setText("Made By Emre Hayirci , Ovunc Balam, Eren Sozen \u00A9 ");
		txtpnMadeByEmre.setBounds(10, 230, 327, 20);
		contentPane.add(txtpnMadeByEmre);
	}
}
