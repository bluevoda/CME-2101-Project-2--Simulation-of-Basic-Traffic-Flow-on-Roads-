import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.TexturePaint;
import java.util.ArrayList;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Project2Frame {

	static public ArrayList <String> DebugLogs = new ArrayList<String>();
	static public ArrayList <Node> NodeID = new ArrayList<Node>();
	static public ArrayList <JTextField> NodeTexts = new ArrayList<JTextField>(); //Stores Textfield To Change it later
	private JFrame frame;
	private JList<Object> list;
	public Map m ; 
	public boolean isRandom ;
	public Project2Frame(boolean isHeuristic2, boolean isIzmir) {
		initialize(isIzmir);
		isRandom = isHeuristic2;
		
	}
	public void addJunc(Node node, int posx, int posy)
	{ 
		Panel panel = new Panel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(posx, posy, 100, 70);
		frame.getContentPane().add(panel);
		JTextField txtA;
		NodeID.add(node);
		DebugLogs.add(posx + " "+posy);
		
		JTextField txtCars;
		txtCars = new JTextField();
		txtCars.setEditable(false);
		txtCars.setHorizontalAlignment(SwingConstants.CENTER);
		txtCars.setText("Cars = 4");
		panel.add(txtCars);
		NodeTexts.add(txtCars);
		txtCars.setColumns(10); 
		
		txtA = new JTextField();
		txtA.setEditable(false);
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setText("Name = " + node.key);
		panel.add(txtA);
		txtA.setColumns(10);
		
		
	
	}
	public int debugcount = 0;
	public void ButtonClick() //WHERE AMAZING HAPPENS
	{
		if(m.isGameEnded())
		{
			finishGame();
		}
		else
		{
		m.NextDay(isRandom);
		updateMap();
		list.setListData(Map.tablearr);
		debugcount ++;
		m.StatFiller();
		}
		
		
		
	}
	
	
	public void updateMap()
	{
		for (int i = 0; i < NodeID.size(); i++) {
			NodeTexts.get(i).setText("Cars = " +  NodeID.get(i).vehicles.size());
		}
		//frame.revalidate();
	}
	
	
	public void addLeftRoad(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setEditable(false);
		road.setText("\u2190");
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx - 25, posy + 25, 20, 20);
		frame.getContentPane().add(road);
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	public void addRightRoad(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setEditable(false);
		road.setText("\u2192");
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx + 105,posy +  25, 20, 20);
		frame.getContentPane().add(road);
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	public void addRLRoadtoLeft(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setEditable(false);
		road.setText("\u2194");
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx - 25, posy + 25, 20, 20);
		frame.getContentPane().add(road);
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	public void addRLRoadtoRight(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setEditable(false);
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx + 105, posy+25, 20, 20);
		frame.getContentPane().add(road);
		road.setText("\u2194");
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	public void addDownRoad(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setText(" \u2193");
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx + 40,posy + 75, 20, 20);
		frame.getContentPane().add(road);
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	public void addUpRoad(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setEditable(false);
		road.setText("\u2191");
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx + 40,posy - 25, 20, 20);
		frame.getContentPane().add(road);
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	public void addUDRoadtoDown(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setEditable(false);
		road.setText("\u2195");
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx + 40,posy + 75, 20, 20);
		frame.getContentPane().add(road);
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	public void addUDRoadtoUp(String name, int posx, int posy)
	{
		JTextPane road = new JTextPane();
		road.setEditable(false);
		road.setText("\u2195");
		road.setBackground(Color.LIGHT_GRAY);
		road.setBounds(posx + 40,posy - 25, 20, 20);
		frame.getContentPane().add(road);
		road.setFont(new Font("Tahoma", Font.PLAIN, 11));
	}

	public void PrintNodesAndRoads(Node a, int x, int y )
	{
		addJunc(a, x, y);
		a.isvisited = true;
		if (a.GetNodeE() != null)
		{
			if (a.GetNodeE().GetNodeW() != null)
			{
				addRLRoadtoRight("road", x, y);
			}
			else
			{
				addRightRoad("road", x, y);
			}
			if (a.GetNodeE().isvisited == false)
			{
			PrintNodesAndRoads(a.GetNodeE(), x + 130, y);
			}
		}
		if (a.GetNodeW() != null)
		{
			if (a.GetNodeW().GetNodeE() != null)
			{
				addRLRoadtoLeft("road", x, y);
			}
			else
			{
				addLeftRoad("road", x, y);
			}
			if (a.GetNodeW().isvisited == false)
			PrintNodesAndRoads(a.GetNodeW(), x - 130, y);
		}
		if (a.GetNodeN() != null)
		{
			if (a.GetNodeN().GetNodeS() != null)
			{
				addUDRoadtoUp("road", x, y);
			}
			else
			{
				addUpRoad("road", x, y);
			}
			if (a.GetNodeN().isvisited == false)
			PrintNodesAndRoads(a.GetNodeN(), x, y - 100);
		}
		if (a.GetNodeS() != null)
		{
			if (a.GetNodeS().GetNodeN() != null)
			{
				addUDRoadtoDown("road", x, y);
			}
			else
			{
				addDownRoad("road", x, y);
			}
			if (a.GetNodeS().isvisited == false)
			PrintNodesAndRoads(a.GetNodeS(), x , y + 100);
		}
		
	}
	public void PrintMissingValues()
	{
		for (int i = 0; i < m.nodes.size(); i++) {
			Node temp = m.nodes.get(i);
			boolean isExist = false; 
			for (int j = 0; j < NodeID.size(); j++) {
				if(NodeID.get(j).key.equals(temp.key))
				{
					isExist = true;
					break;
				}
			}
			if (!isExist)
			{
				if(m.nodes.get(i).GetNodeE() != null)
				{
					for (int j = 0; j < NodeID.size(); j++) {
						if(m.nodes.get(i).GetNodeE().key.equals(NodeID.get(j).key))
						{
							String [] positions = DebugLogs.get(j).split(" ");
							addJunc(m.nodes.get(i), Integer.parseInt(positions[0] )-130, Integer.parseInt(positions[1]));
							addRightRoad("road", Integer.parseInt(positions[0])-130, Integer.parseInt(positions[1]));
						}
					}
				}
				if(m.nodes.get(i).GetNodeW() != null)
				{
					for (int j = 0; j < NodeID.size(); j++) {
						if(m.nodes.get(i).GetNodeW().key.equals(NodeID.get(j).key))
						{
							String [] positions = DebugLogs.get(j).split(" ");
							addJunc(m.nodes.get(i), Integer.parseInt(positions[0] )+ 130, Integer.parseInt(positions[1]));
							addLeftRoad("road", Integer.parseInt(positions[0])+ 130, Integer.parseInt(positions[1]));
						}
					}
				}
				if(m.nodes.get(i).GetNodeS() != null)
				{
					for (int j = 0; j < NodeID.size(); j++) {
						if(m.nodes.get(i).GetNodeS().key.equals(NodeID.get(j).key))
						{
							String [] positions = DebugLogs.get(j).split(" ");
							addJunc(m.nodes.get(i), Integer.parseInt(positions[0]), Integer.parseInt(positions[1]) - 100);
							addDownRoad("road", Integer.parseInt(positions[0]), Integer.parseInt(positions[1]) - 100);
						}
					}
				}
				if(m.nodes.get(i).GetNodeN() != null)
				{
					for (int j = 0; j < NodeID.size(); j++) {
						if(m.nodes.get(i).GetNodeN().key.equals(NodeID.get(j).key))
						{
							String [] positions = DebugLogs.get(j).split(" ");
							addJunc(m.nodes.get(i), Integer.parseInt(positions[0]), Integer.parseInt(positions[1]) + 100);
							addUpRoad("road", Integer.parseInt(positions[0]), Integer.parseInt(positions[1]) + 100);
						}
					}
				}
			}
		}
	}
	private void initialize(boolean isIzmir) {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		m = new Map();
		IOClass.ReadNodes(m, isIzmir);
		IOClass.ReadCars(m, isIzmir);
		m.tableFiller();
		PrintNodesAndRoads(m.getNodebyIndex(0), 25, 25);
		PrintMissingValues();
		list = new JList<Object>(Map.tablearr);
		list.setBounds(530, 25, 130, 300);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Next Day");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ButtonClick();
			}
		});
		btnNewButton.setBounds(10, 430, 89, 23);
		frame.getContentPane().add(btnNewButton);
		updateMap();
		frame.setTitle("Traffic Simulator V2");
		System.out.println("asd");
	}
	public void finishGame()
	{
		try {
			StatsFrame frame2 = new StatsFrame(statsArray());/////////
			frame2.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String[] statsArray()
	{
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("Total Time Elapsed : " + m.time);
		alist.add("VISITED NODES STATS");
		for (int i = 0; i < m.nodes.size(); i++) {
			alist.add(m.nodes.get(i).key + " : " + m.nodes.get(i).stat_visits);
		}
		alist.add("WAITED VEHICLES STATS");
		for (int i = 0; i < m.availableCars.size(); i++) {
			alist.add(m.availableCars.get(i).keyname + " : " + m.availableCars.get(i).stat_wait);
		}
		for (int i = 0; i < m.availableAmbulances.size(); i++) {
			alist.add(m.availableAmbulances.get(i).keyname + " : " + m.availableAmbulances.get(i).stat_wait);
		}
		
		
		
		return  alist.toArray(new String [alist.size()]);
	}
}
