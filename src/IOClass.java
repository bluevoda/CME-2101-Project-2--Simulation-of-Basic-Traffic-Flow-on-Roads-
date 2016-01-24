import java.io.*;
import java.util.ArrayList;
public class IOClass {
	
	/*
	IOClass(final Map m) {
		ReadNodes(m);
		ReadCars(m);
	}*/

	public static void ReadNodes(Map m, boolean isIzmir) {
		String line = null;
		int connectioncount = 0;
		ArrayList<String> NodeConnections = new ArrayList<String>();

		try {
			String path ;
			if (isIzmir)
			{
				path = "RoadMap_Izmir.txt";
			}
			else
			{
				path = "RoadMap.txt";
			}
			BufferedReader br = new BufferedReader(new FileReader(new File(path))); //Openning TextFile of Nodes
			while ((line = br.readLine()) != null) {
				String temp[] = line.split(" ");
				String key = temp[0];
				Node a = new Node (key);//Creating a new node
				m.addNode(a);//adding a new node
				NodeConnections.add(temp[1]);
				connectioncount++;//holding other connection details for later
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < connectioncount; i++) {
			String temp[] = NodeConnections.get(i).split(","); 

			String obj = "0";

			if (!(temp[0].equals(obj)));
			{
				m.getNodebyIndex(i).SetNodeE(m.getNodebyName(temp[0]));
				
			}
			if (!temp[1].equals(obj));
			{
				m.getNodebyIndex(i).SetNodeS(m.getNodebyName(temp[1]));
			}
			if (!(temp[2].equals(obj)));
			{
				m.getNodebyIndex(i).SetNodeW(m.getNodebyName(temp[2]));
			}
			if (!(temp[3].equals(obj)));
			{
				m.getNodebyIndex(i).SetNodeN(m.getNodebyName(temp[3]));
			}
		}
	}
	public static void ReadCars(Map m, boolean isIzmir)
	{
		String line = null;
		try {
			String path ;
			if (isIzmir)
			{
				path = "Vehicles_Izmir.txt";
			}
			else
			{
				path = "Vehicles.txt";
			}
			
			BufferedReader br = new BufferedReader(new FileReader(new File(path))); //Openning TextFile of Nodes
			while ((line = br.readLine()) != null) {
				String temp[] = line.split(" ");
				if (temp.length == 2 )
				{
					Car c = new Car (temp[0]);
					c.setCurrentNode(m.getNodebyName(temp[1]));
					m.getNodebyName(temp[1]).addVehicle(c);
					c.getCurrentnode().setCarSize(c.getCurrentnode().getCarSize() + 1);
					m.availableCars.add(c);
				}
				else
				{
					Ambulance a =new Ambulance(temp[0], temp[1]);
					a.setCurrentnode(m.getNodebyName(temp[2]));
					a.destinationNode = m.getNodebyName(temp[3]);
					a.rootNode = m.getNodebyName(temp[2]);
					m.getNodebyName(temp[2]).addVehicle(a);
//					a.getCurrentnode().setCarSize(a.getCurrentnode().getCarSize() + 1);  // simdilik kullanýlmayacak aktif (time = 5) oldugu zaman eklenemsi lazým
					m.availableAmbulances.add(a);
					a.ambulanceShortestPath();

					// It will be written to its Node.

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
	






}