import java.util.ArrayList;
import java.util.Random;

public class Car extends Vehicle{ 
	
	
    public Car (String Name)
    {
        this.keyname = Name;
        lastNode = null;
    }
    public void setCurrentNode(Node a)  // get set Vehicle içinde??!
    {
    	if (lastNode == null)
    	{
    		lastNode = currentnode;
    	}
        this.currentnode = a;
    }
   
    
    public void setNextNode()
    {
        //Must be implemnted
    }
	public Node getLastNode() {
		return lastNode;
	}
	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}
    public void MoveLikeHeuristic1()
    {
    	boolean isPlaced = false;
    	if (currentnode.GetNodeE() != null && isPlaced == false)
    	{
    	 	if (lastNode == null || !currentnode.GetNodeE().key.equals(lastNode.key))
    	 	{
    	 		if(currentnode.GetNodeE().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeE().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeE();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	 	}
    	}
    	if (currentnode.GetNodeS() != null && isPlaced == false)
    	{
    	 	if (lastNode == null || !currentnode.GetNodeS().key.equals(lastNode.key))
    	 	{
    	 		if(currentnode.GetNodeS().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeS().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeS();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	 	}
    	}
    	if (currentnode.GetNodeW() != null && isPlaced == false)
    	{
    	 	if (lastNode == null || !currentnode.GetNodeW().key.equals(lastNode.key))
    	 	{
    	 		if(currentnode.GetNodeW().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeW().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeW();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	 	}
    	}
    	if (currentnode.GetNodeN() != null && isPlaced == false)
    	{
    	 	if (lastNode == null || !currentnode.GetNodeN().key.equals(lastNode.key))
    	 	{
    	 		if(currentnode.GetNodeN().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeN().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeN();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	 	}
    	}
    	if (currentnode.GetNodeE() != null && isPlaced == false)
    	{
    	 		if(currentnode.GetNodeE().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeE().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeE();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	}
    	if (currentnode.GetNodeS() != null && isPlaced == false)
    	{
    	 		if(currentnode.GetNodeS().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeS().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeS();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	}
    	if (currentnode.GetNodeW() != null && isPlaced == false)
    	{
    	 		if(currentnode.GetNodeW().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeW().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeW();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	}
    	if (currentnode.GetNodeN() != null && isPlaced == false)
    	{
    	 		if(currentnode.GetNodeN().getCarSize() != 4)
    	 		{
    	 			currentnode.removeVehicle(keyname);
    	 			currentnode.GetNodeN().addVehicle(this);;
    	 			lastNode = currentnode;
    	 			currentnode = currentnode.GetNodeN();
    	 			isPlaced = true;
    	 			return;
    	 		}
    	}
    	if (!isPlaced)
    	{
    		stat_wait ++;
    	}
    }
    public void MoveLikeHeuristic2()
    {
    	Random rnd = new Random();
    	ArrayList<Node> availableNodes = new ArrayList<Node>(); 
    	if (currentnode.GetNodeE() != null )
    	{
    	 	
    	 		if(currentnode.GetNodeE().getCarSize() != 4)
    	 		{
    	 				availableNodes.add(currentnode.GetNodeE());
    	 		}
    	 	
    	}
    	if (currentnode.GetNodeS() != null )
    	{
    	 	
    	 		if(currentnode.GetNodeS().getCarSize() != 4)
    	 		{
    	 			availableNodes.add(currentnode.GetNodeS());
    	 		}
    	 	
    	}
    	if (currentnode.GetNodeW() != null )
    	{
    	 		if(currentnode.GetNodeW().getCarSize() != 4)
    	 		{
    	 			availableNodes.add(currentnode.GetNodeW());
    	 		}
    	 	
    	}
    	if (currentnode.GetNodeN() != null)
    	{
    	 		if(currentnode.GetNodeN().getCarSize() != 4)
    	 		{
    	 			availableNodes.add(currentnode.GetNodeN());
    	 		}
    	 	
    	}
    	if(availableNodes.size() != 0)
    	{
    		int random = rnd.nextInt(availableNodes.size());
        	currentnode.removeVehicle(keyname);
    		availableNodes.get(random).addVehicle(this);
    		lastNode = currentnode;
    		currentnode = availableNodes.get(random);
    	}
    	else
    	{
    		stat_wait ++;
    	}
    }
}