import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JList;

public class StatsFrame extends JFrame {

	private JPanel contentPane;
	public StatsFrame(String [] thingstowrite) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea txtrStats = new JTextArea();
		txtrStats.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		txtrStats.setBackground(SystemColor.menu);
		txtrStats.setEditable(false);
		txtrStats.setText("Stats");
		txtrStats.setBounds(210, 30, 80, 50);
		contentPane.add(txtrStats);
		
		JList list = new JList<Object>(thingstowrite);
		list.setBackground(SystemColor.menu);
		list.setBounds(100, 90, 300, 600);
		contentPane.add(list);
	}
}
