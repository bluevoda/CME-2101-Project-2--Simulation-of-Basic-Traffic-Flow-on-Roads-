import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.plaf.synth.Region;

//import enigma.core.Enigma;


public class Map {
	private int NodeLenght = 0;
	public ArrayList<Node> nodes = new ArrayList<Node>(); //public olarak degisti UI için
	public ArrayList<Car> availableCars = new ArrayList<Car>();
	public ArrayList<Ambulance> availableAmbulances = new ArrayList<Ambulance>();
	public static int time = 0;
	
	public static String [] tablearr; //GUI TABLE
	boolean nullControl= false;

	
	public void addNode(Node node)
	{
		NodeLenght ++;
		nodes.add(node);
	}
	public Node getNodebyName(String Nodename)
	{
		for (int i = 0; i < NodeLenght; i++) {
			if (nodes.get(i).key.equals(Nodename))
			{
				return nodes.get(i);
			}
		}
		//System.out.println("False Node Gatheration");
		return null;
	}
	public Node getNodebyIndex(int index)
	{
		return nodes.get(index);
	}
	public boolean ambulanceActivite(){

		//TODO ambulance properties



		return true;
	}
	
	public void tableFiller()
	{
		tablearr = new String [nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			Node currentnode = nodes.get(i);
			String a = nodes.get(i).key;
			a = a + " :";
			for (int j = 0; j < currentnode.vehicles.size(); j++) {
				a = a + " " + currentnode.vehicles.get(j).keyname;
			}
			tablearr[i] = a;
		}
	}
	
	public void NextDay(boolean isRandom)
	{
		time ++;
		for (int i = 0; i < availableAmbulances.size(); i++) {
			availableAmbulances.get(i).NextMove(time);
		}
		for (int i = 0; i < availableCars.size(); i++) {
			if(isRandom)
			{
				availableCars.get(i).MoveLikeHeuristic2();
			}
			else
			{
				availableCars.get(i).MoveLikeHeuristic1();
			}
			
		}
		tableFiller();
	}
	public boolean isGameEnded()
	{
		boolean alfa = true;
		for (int i = 0; i < availableAmbulances.size(); i++) {
			if (!availableAmbulances.get(i).finish)
			{
				alfa = false;
			}
		}
		return alfa;
	}
	public void StatFiller()
	{
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).statwrite();
		}
	}
	
}